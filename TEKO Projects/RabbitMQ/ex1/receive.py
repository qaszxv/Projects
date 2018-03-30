#!/usr/bin/env python
import pika

connection = pika.BlockingConnection(pika.ConnectionParameters(host='127.0.0.1'))
channel = connection.channel()

channel.queue_declare(queue='hello')
channel.queue_declare(queue='hello2')

def callback(ch, method, properties, body):
    print(" [x] Received %r" % body)

def callback2(ch, method, properties, body):
    print('This is callback 2')    
    print(" [x] Received %r" % body)

channel.basic_consume(callback,
                      queue='hello',
                      no_ack=True)

channel.basic_consume(callback2,
                      queue='hello2',
                      no_ack=True)

print(' [*] Waiting for messages. To exit press CTRL+C')
channel.start_consuming()