from nameko import rpc
import time

class GreetService(object): 
    name = 'greet_service'

    @rpc.rpc
    def greet(self, hello): 
        time.sleep(5)
        print(hello) 


