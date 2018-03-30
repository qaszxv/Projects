from flask import Flask
from flask_restful import Resource, Api
from flask_restful.reqparse import RequestParser

app = Flask(__name__)   #Create a flask app and wrap it in app
api = Api(app, prefix='/api/v1')    #All urls will be prefixed by /api/v1

users = [
    {"email": "hungle1abc", "name": "Hung Le", "id": 1}
]

subscriber_request_parser = RequestParser(bundle_errors=True)
subscriber_request_parser.add_argument("name", type=str, required=True, help="Name has to be valid string")
subscriber_request_parser.add_argument("email", required=True)
subscriber_request_parser.add_argument("id", type=int, required=True, help="Please enter valid integer as ID")


class HelloWorld(Resource): #Hello Resource extends Resource 
    def get(self):  #Defind what GET will do 
        return {'hello': 'world'}

class SubscriberCollection(Resource): 
    def get(self): 
        return {"msg": "All Subscribers"}

    def post(self):
        args = subscriber_request_parser.parse_args()
        users.append(args)
        return {"msg": "Subscriber added", "subscriber_data": args}

class Subscriber(Resource): 
    def get(self, id): 
            return {"msg": "Details about user id {}".format(id)}

    def put(self, id): 
        return {"msg": "Update user id {}".format(id)}

    def delete(self, id): 
        return {"msg": "Delete user id {}". format(id)}

api.add_resource(HelloWorld, '/')   #Add the resource to our API
api.add_resource(SubscriberCollection, '/subscribers')
api.add_resource(Subscriber, '/subscribers/<int:id>')

if __name__ == '__main__': 
    app.run(debug=True)








