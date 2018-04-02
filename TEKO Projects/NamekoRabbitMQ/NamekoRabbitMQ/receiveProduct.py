from kombu import Exchange, Queue
from nameko.messaging import Publisher, consume
from nameko.rpc import rpc
from nameko.testing.services import worker_factory
import json
import requests 
from requests.exceptions import ConnectionError
from json import JSONDecodeError

receiveProduct_queue = Queue('receiveQueue')

class TestService(object):
    name = 'test'

    send_mail = Publisher(queue=receiveProduct_queue)

    @rpc    #For simple test in nameko shell
    def send(self, msg):
        self.send_mail(msg, routing_key='receiveQueue')
        return "test service Nameko!"

class ReceiveProduct(object):
    name = 'receiveProduct'

    @consume(receiveProduct_queue)
    def receive(self, msg):
        #Check if msg is a string
        if not isinstance(msg, str):
            print('Message is not a string!')
            return msg

        #Parse string to json, than save to Elasticsearch
        try: 
            payload = json.loads(msg)
        except JSONDecodeError as e: 
            print(e)
            return msg

        print("Send `{}` to Elasticsearch".format(payload['name']))
            
        url = 'http://localhost:9200/store/hammer'
        try: 
            res = requests.post(url, json=payload)
        except ConnectionError as e: 
            print(e)
            r = "No response"
            print('Cannot connect to Elasticsearch')

        return payload

def test_receive_product(): 
    service = worker_factory(ReceiveProduct)
    test_msg = json.loads('{"name": "Alex"}')
    assert service.receive('{"name": "Alex"}') == test_msg
    assert service.receive('this') == 'this'
    assert service.receive(5) == 5
    assert service.receive(-1) == -1

test_receive_product()




