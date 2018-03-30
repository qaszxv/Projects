class Shape(object): 

    def __init__(self): 
        print('This is a Shape')

class Rect(Shape): 
    def __init__(self): 
        print('This is a Reactangle')

    def prove(self): 
        print('This is the prove method of this Rectangle')

class Square(Shape): 
    def __init__(self): 
        print('This is a Square')

    def prove(self): 
        print('This is the prove method of this Rectangle')

class ShapeFactory(object):
    def getShape(self, theStr): 
        if theStr == 'Rect': 
            return Rect()
        elif theStr == 'Square': 
            return Square()
        else: 
            print('This is Unknown')

factory = ShapeFactory
a = factory.getShape(factory, 'Rect')
a.prove()

b = factory.getShape(factory, 'Square')
b.prove()