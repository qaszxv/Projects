from time import time

def timer(func): 
    def showTime(): 
        start = time()
        func()
        end = time()
        print(end - start)
        return (end - start)
    return showTime()

@timer
def test(): 
    print('Time to run the function: ')