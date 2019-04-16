import logging

from flask import request
from flask_restplus import Resource
from rest_api_demo.api.message.business import create_message
from rest_api_demo.api.message.serializers import message
from rest_api_demo.api.restplus import api
from rest_api_demo.database.models import Message

log = logging.getLogger(__name__)

ns = api.namespace('Message', description='Operations for Type Message')

@ns.route('/')
class MessageCollection(Resource):

    @api.response(201, 'Message successfully created.')
    @api.expect(message)
    def post(self):
        """
        Creates a new Message.
        """
        data = request.json
        result = create_message(data)
        return "Done", 200

@ns.route('/<int:id>')
class MessageItem(Resource):
    @api.marshal_list_with(message)
    def get(self, id):
        """
        Returns Message by ID.
        """
        return Message.query.filter(Message.id == id).all()

@ns.route('/<string:tag>')
class MessageItem(Resource):
    @api.marshal_list_with(message)
    def get(self, tag):
        """
        Returns Message by tag.
        """
        return Message.query.filter(Message.tag == tag).all()

