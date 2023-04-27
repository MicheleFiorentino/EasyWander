from flask import Blueprint, render_template, redirect, url_for, request, flash
from flask_login import login_required, current_user
from datetime import datetime
from .models import Card
from . import db

#questo file è una blueprint della nostra applicazione, cioè ha un
#insieme di percorsi al suo interno

views = Blueprint('views', __name__)

@views.route('/')
def home():
    if not current_user.is_authenticated:
        return render_template("welcome.html")
    return render_template("home.html", user=current_user)

@views.route('credit')
@login_required
def credit():
    return render_template("credit.html")

@views.route('wallet')
@login_required
def wallet():
    return render_template("wallet/wallet.html", user=current_user)

@views.route('addCard', methods=['GET','POST'])
@login_required
def add_card():
    if request.method == 'POST':
        card_type = request.form.get('cardType')
        first_name = request.form.get('firstName')
        last_name = request.form.get('lastName')
        card_number = request.form.get('cardNumber')
        valid_thru = request.form.get('expirationDate')
        cvc = request.form.get('cvc')

        card = Card.query.filter_by(card_number=card_number).first()
        if card:
            flash('Card already assigned.', category='error')
        elif len(card_number) != 16:
            flash('The card must have 16 digits.', category='error')
        else:
            new_card = Card(card_type=card_type, card_number=card_number, first_name=first_name,last_name=last_name, valid_thru=valid_thru, cvc=cvc, user_id=current_user.id)
            db.session.add(new_card)
            db.session.commit()
            flash('Card Added!', category='success')

    return render_template("wallet/addCard.html")

@views.route('infoCard')
@login_required
def infoCard():
    return render_template("wallet/infoCard.html", user=current_user)

@views.route('account')
@login_required
def account():
    return render_template("account.html", user=current_user)

@views.route('history')
@login_required
def history():
    return render_template("history.html", user=current_user)