from flask_restplus import fields
from rest_api_demo.api.restplus import api

pagination = api.model('A page of results', {
    'page': fields.Integer(description='Number of this page of results'),
    'pages': fields.Integer(description='Total number of pages of results'),
    'per_page': fields.Integer(description='Number of items per page of results'),
    'total': fields.Integer(description='Total number of results'),
})

message = api.model('Message', {
    'id': fields.Integer(readOnly=True, description='The unique identifier'),
    'msg': fields.String(readOnly=True, description='message content'),
    'tag': fields.String(required=True, description='tags included'),
})