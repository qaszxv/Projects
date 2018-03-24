import tkinter as tk
from tkinter import ttk
from pyView import Interface
from pyModel import Model


class Controller: 
    def __init__(self, parent, *args, **kwargs): 
        parent.grid_columnconfigure(0, weight = 1)
        parent.grid_rowconfigure(0, weight = 1)

        self.parent = parent

        self.interface = Interface(parent, self)

        self.interface.grid(row=0, column=0, sticky='nsew')
        self.interface.grid_propagate(False)

        self.model = Model()
        
    def visOutNode(self): 
        self.interface.clearFigure()
        nodeID = self.interface.getNodeIDEntry_text()
        self.model.visOutNode(nodeID)
        text = self.model.getText()
        self.interface.insertText(text)
        self.interface.displayGraph('Visualize Out Nodes')

    def visInNode(self): 
        self.interface.clearFigure()
        nodeID = self.interface.getNodeIDEntry_text()
        self.model.visInNode(nodeID)
        text = self.model.getText()
        self.interface.insertText(text)
        self.interface.displayGraph('Visualize In Nodes')

    def visInOutNode(self): 
        self.interface.clearFigure()
        nodeID = self.interface.getNodeIDEntry_text()
        self.model.visInOutNode(nodeID)
        text = self.model.getText()
        self.interface.insertText(text)
        self.interface.displayGraph('Visualize In Out Nodes')

    def inDegCent(self):
        nodeID = self.interface.getNodeIDEntry_text()
        self.interface.insertText('Running...')
        self.model.inDegCent(nodeID)
        text = self.model.getText()
        self.interface.insertText(text)

    def closeCent(self):
        nodeID = self.interface.getNodeIDEntry_text()
        self.model.closeCent(nodeID)
        text = self.model.getText()
        self.interface.insertText(text)

    def btwnCent(self): 
        nodeID = self.interface.getNodeIDEntry_text()      
        print(nodeID)
        self.model.btwnCent(nodeID)
        text = self.model.getText()
        self.interface.insertText(text)

    def findCoAuthor(self): 
        nodeID = self.interface.getAuthorIDEntry_text()
        self.model.findCoAuthor(nodeID)
        text = self.model.getText()
        self.interface.insertText(text)
        self.interface.displayGraph('Find Co-Author')

    def findRef(self):
        nodeID = self.interface.getPaperIDEntry_text()
        self.model.findRef(nodeID)
        text = self.model.getText()
        self.interface.insertText(text)
        self.interface.displayGraph('Find References')

    def findTopic(self):
        nodeID = self.interface.getPaperIDEntry_text()
        self.model.findTopic(nodeID)
        text = self.model.getText()
        self.interface.insertText(text)
        self.interface.displayGraph('Find Topic')

    def findAuthors(self):
        nodeID = self.interface.getPaperIDEntry_text()
        self.model.findAuthors(nodeID)
        text = self.model.getText()
        self.interface.insertText(text)
        self.interface.displayGraph('Find Author(s)')

    def findVenue(self):
        nodeID = self.interface.getPaperIDEntry_text()
        self.model.findVenue(nodeID)
        text = self.model.getText()
        self.interface.insertText(text)
        self.interface.displayGraph('Find Venue')

    def findWords(self):
        nodeID = self.interface.getTopicIDEntry_text()
        self.model.findWords(nodeID)
        text = self.model.getText()
        self.interface.insertText(text)
        self.interface.displayGraph('Find Words')

    def exitButton(self):
        self.parent.quit()     # stops mainloop
        self.parent.destroy() 
    
    
def main():
    root = tk.Tk()
    root.title('Visualization of Graph Database')

    app = Controller(root)
    
    root.minsize(1200, 700)
    root.mainloop()  
 
if __name__ == '__main__':
    main()  

