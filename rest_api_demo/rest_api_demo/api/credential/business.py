from rest_api_demo.database import db
from rest_api_demo.database.models import Credential

def create_credential(data):
    key = data.get('key')
    shared_secret = data.get('shared_secret')
    post = Credential(key, shared_secret)
    db.session.add(post)
    db.session.commit()