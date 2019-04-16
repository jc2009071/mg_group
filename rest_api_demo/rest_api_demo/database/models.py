# The examples in this file come from the Flask-SQLAlchemy documentation
# For more information take a look at:
# http://flask-sqlalchemy.pocoo.org/2.1/quickstart/#simple-relationships

from datetime import datetime

from rest_api_demo.database import db




class Message(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    msg = db.Column(db.String(50))
    tag = db.Column(db.String(50))

    def __init__(self, msg, tag):
        self.msg = msg
        self.tag = tag

    def __repr__(self):
        return '<Message %r>' % self.msg

class Credential(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    key = db.Column(db.String(36))
    shared_secret = db.Column(db.String(50))

    def __init__(self, key, shared_secret):
        self.key = key
        self.shared_secret = shared_secret

    def __repr__(self):
        return '<Credential %r>' % self.key