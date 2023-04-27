from . import db
from flask_login import UserMixin
from datetime import datetime

#fare classe Scooter e RentedScooter, serivrà func per data corrente

class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    email = db.Column(db.String(150), unique=True)
    password = db.Column(db.String(150))
    first_name = db.Column(db.String(150))
    last_name = db.Column(db.String(150))
    cards = db.relationship('Card')
    rented_scooters = db.relationship('Rent')

class Card(db.Model, UserMixin):
    card_number = db.Column(db.String(16), primary_key=True)
    card_type = db.Column(db.String(150))
    first_name = db.Column(db.String(150))
    last_name = db.Column(db.String(150))
    valid_thru = db.Column(db.String(10))
    cvc = db.String(3)
    user_id = db.Column(db.Integer, db.ForeignKey('user.id'))

class Scooter(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    pos_lat = db.Column(db.Float)
    pos_lng = db.Column(db.Float)
    rented_scooters = db.relationship('Rent')

class Rent(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    rent_date = db.Column(db.String(10))
    user_id = db.Column(db.Integer, db.ForeignKey('user.id'))
    scooter_id = db.Column(db.Integer, db.ForeignKey('scooter.id'))
