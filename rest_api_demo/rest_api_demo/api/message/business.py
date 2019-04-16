from rest_api_demo.database import db
from rest_api_demo.database.models import Message

def create_message(data):
    msg = data.get('msg')
    tag = data.get('tag')
    post = Message(msg, tag)
    db.session.add(post)
    db.session.commit()