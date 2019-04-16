import logging

from flask import request
from flask_restplus import Resource
from rest_api_demo.api.credential.business import create_credential
from rest_api_demo.api.credential.serializers import credential
from rest_api_demo.api.restplus import api
from rest_api_demo.database.models import Credential

log = logging.getLogger(__name__)

ns = api.namespace('Credential', description='Operations for Type Credential')

@ns.route('/')
class CredentialCollection(Resource):

    @api.marshal_list_with(credential)
    def get(self):
        """
        Returns list of Credential.
        """
        credentials = Credential.query.all()
        return credentials

    @api.response(201, 'Credential successfully created.')
    @api.expect(credential)
    def put(self):
        """
        Creates a new Credential.
        """
        data = request.json
        create_credential(data)
        return None, 204