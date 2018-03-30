#!/usr/bin/env python
import pika

connection = pika.BlockingConnection(pika.ConnectionParameters(host='127.0.0.1'))
channel = connection.channel()

channel.queue_declare(queue='hello')
channel.queue_declare(queue='hello2')

channel.basic_publish(exchange='',
                      routing_key='hello2',
                      body='Hello World2!')
print(" [x] Sent 'Hello World2!'")
connection.close()