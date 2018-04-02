#!/usr/bin/env python
import json
import pika
import requests
from nameko.testing.services import worker_factory

class sendProductClient(object): 

    def __init__(self): 
        self.connection = pika.BlockingConnection(pika.ConnectionParameters(host='127.0.0.1'))
        self.channel = self.connection.channel()

    def sendProduct(self, msg): 

        msg_string = json.dumps(msg)

        self.channel.basic_publish(exchange='',
                              routing_key='receiveQueue',
                              body=msg_string)

        print(" [x] Sent 'Message for Nameko to listen!'")
        return msg

    def closeConnection(self): 
        self.connection.close()

msg = { "name": "Fäustel DIN6475 2000g Eschenstiel FORTIS",
        "staple-name": "Fortis Fäustel, mit Eschen-Stiel",
        "description": "Fäustel DIN 6475<br><br>Stahlgeschmiedet, Kopf schwarz lackiert, Bahnen poliert, doppelt geschweifter Eschenstiel mit ozeanblau lackiertem Handende. SP11968 SP11968",
        "preview_image": "faeustel-din6475-2000g-eschenstiel-fortis-21049292-0-JlHR5nOi-l.jpg",
        "categories": ["Fäustel","Handwerkzeug","Hammer","Fäustel"],
        "final_gross_price": 1149,"final_net_price": 1003,
        "url": "/handwerkzeug/fortis-faeustel-mit-eschen-stiel-SP11968",
        "manufacturer": "Fortis",
        "hammer_weight": 2000}

sendProductObject = sendProductClient()

print('Send message to queue name "receiveQueue"...')
sendProductObject.sendProduct(msg)
print('Send completed.')

sendProductObject.closeConnection()

