from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from os import path
from flask_login import LoginManager

db = SQLAlchemy()
DB_NAME = "database.fb"

#inizializzazione dell'applicazione Flask
def create_app():
    app = Flask(__name__)
    app.config['SECRET_KEY'] = 'bfdkwfgfbsjgfsbd'
    app.config['SQLALCHEMY_DATABASE_URI'] = f'sqlite:///{DB_NAME}'
    db.init_app(app)

    from .views import views
    from .auth import auth

    app.register_blueprint(views, url_prefix='/') #nb, / è nessun prefisso
    app.register_blueprint(auth, url_prefix='/')

    from .models import User, Card, Scooter, Rent

    create_database(app)

    login_manager = LoginManager()
    login_manager.login_view = 'auth.login'
    login_manager.init_app(app)

    @login_manager.user_loader
    def load_user(id):
        return User.query.get(int(id))

    return app

#controlla se esiste già il db, in caso contrario lo crea
def create_database(app):
    if not path.exists('website/' + DB_NAME):
        db.create_all(app=app)
