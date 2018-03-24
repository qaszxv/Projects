import tkinter as tk
from tkinter import ttk


class Interface(tk.Frame):
    def __init__(self, parent, controller, *args, **kwargs): 
        tk.Frame.__init__(self, parent, *args, **kwargs, background='bisque') 

        self.controller = controller

        self.pack(fill='both', expand=True)

        self.grid_columnconfigure(0, weight=1) 
        self.grid_columnconfigure(1, weight=2)
        self.grid_columnconfigure(2, weight=1)
        self.grid_rowconfigure(0, weight=1)
        self.grid_propagate(False) 

        #Start UI of left container
        self.leftContainer = tk.Frame(self)
        self.leftContainer.configure(background='green')
        self.leftContainer.grid(row=0, column=0, sticky='nsew')
        self.leftContainer.grid_propagate(False)

        for i in range(21): 
            self.leftContainer.grid_rowconfigure(i, weight=1)
        self.leftContainer.grid_columnconfigure(0, weight = 1)
            #Finish grid out the left container layout 

        #Start UI of NodeID
        i = 0   #Initialize dynamically i to make it easier to add more widgets in ramdom order later
        nodeID = ttk.Label(self.leftContainer, text='Node ID:')
        nodeID.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        self.nodeIDEntry_text = tk.IntVar()
        nodeIDEntry = tk.Entry(self.leftContainer, textvariable=self.nodeIDEntry_text)
        nodeIDEntry.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        visOutNode = tk.Button(self.leftContainer, text='Visualize Out Node(s)', command=self.controller.visOutNode)
        visOutNode.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        visInNode = tk.Button(self.leftContainer, text='Visualize In Node(s)', command=self.controller.visInNode)
        visInNode.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        visInOutNode = tk.Button(self.leftContainer, text='Visualize In Out Node(s)', command=self.controller.visInOutNode)
        visInOutNode.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        inDegCent = tk.Button(self.leftContainer, text='In Degree Centrality', command=self.controller.inDegCent)
        inDegCent.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        closeCent = tk.Button(self.leftContainer, text='Closeness Centrality', command=self.controller.closeCent)
        closeCent.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        btwnCent = tk.Button(self.leftContainer, text='Betweenness Centrality', command=self.controller.btwnCent)
        btwnCent.grid(row=i, column=0, sticky='nswe')
        i = i + 1
            #End UI of NodeID
        #Start UI of AuthorID
        nodeID = ttk.Label(self.leftContainer, text='Author ID:')
        nodeID.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        self.authorIDEntry_text = tk.IntVar()
        authorIDEntry = tk.Entry(self.leftContainer, textvariable=self.authorIDEntry_text)
        authorIDEntry.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        findCoAuthor = tk.Button(self.leftContainer, text='Find Co-Author(s)', command=self.controller.findCoAuthor)
        findCoAuthor.grid(row=i, column=0, sticky='nswe')
        i = i + 1
            #End UI of AuthorID
        #Start UI of PaperID
        paperID = ttk.Label(self.leftContainer, text='Paper ID:')
        paperID.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        self.paperIDEntry_text = tk.IntVar()
        paperIDEntry = tk.Entry(self.leftContainer, textvariable=self.paperIDEntry_text)
        paperIDEntry.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        findRef = tk.Button(self.leftContainer, text='Find Reference(s)', command=self.controller.findRef)
        findRef.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        findTopic = tk.Button(self.leftContainer, text='Find Topic', command=self.controller.findTopic)
        findTopic.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        findAuthors = tk.Button(self.leftContainer, text='Find Author(s)', command=self.controller.findAuthors)
        findAuthors.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        findVenue = tk.Button(self.leftContainer, text='Find Venue', command=self.controller.findVenue)
        findVenue.grid(row=i, column=0, sticky='nswe')
        i = i + 1
            #End UI of PaperID
        #Start UI of TopicID
        topicID = ttk.Label(self.leftContainer, text='Topic ID:')
        topicID.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        self.topicIDEntry_text = tk.IntVar()
        topicIDEntry = tk.Entry(self.leftContainer, textvariable=self.topicIDEntry_text)
        topicIDEntry.grid(row=i, column=0, sticky='nswe')
        i = i + 1

        findWords = tk.Button(self.leftContainer, text='Find Words', command=self.controller.findWords)
        findWords.grid(row=i, column=0, sticky='nswe')
        i = i + 1
            #End UI of Topic
        #Exit button
        exitButton = tk.Button(self.leftContainer, text='Exit', command=self.controller.exitButton)
        exitButton.grid(row=i, column=0, sticky='nswe')
        
        ####
        print('+++')

        #Start UI of middle container
        self.middleContainer = tk.Frame(self)
        self.middleContainer.configure(background='white')
        self.middleContainer.grid(row=0, column=1, sticky='nsew')
        self.middleContainer.grid_propagate(False)

        self.middleContainer.grid_rowconfigure(0, weight=9)
        self.middleContainer.grid_rowconfigure(1, weight=1)
        self.middleContainer.grid_columnconfigure(0, weight = 1)

        #self.text = tk.Text(self.middleContainer)
        #self.text.grid(row=0, column=0, sticky='nswe')
            #Finish grid out the middle container layout 
        

        
        #Start UI of right container
        # self.rightContainer = tk.Frame(self)
        # #self.rightContainer.configure(background='bisque')
        # self.rightContainer.grid(row=0, column=2, sticky='nsew')
        # #self.rightContainer.grid_propagate(False)
        
        self.rightContainer = tk.Frame(self)
        self.rightContainer.configure(background='green')
        self.rightContainer.grid(row=0, column=2, sticky='nsew')
        self.rightContainer.grid_propagate(False)

        self.rightContainer.grid_rowconfigure(0, weight=1)
        self.rightContainer.grid_columnconfigure(0, weight = 1)

        self.text = tk.Text(self.rightContainer, bg='bisque')
        self.text.grid(row=0, column=0, sticky='nswe')
            #Finish grid out the right container layout 
    
    def getNodeIDEntry_text(self): 
        return self.nodeIDEntry_text.get()

    def getAuthorIDEntry_text(self): 
        return self.authorIDEntry_text.get()

    def getPaperIDEntry_text(self): 
        return self.paperIDEntry_text.get()

    def getTopicIDEntry_text(self): 
        return self.topicIDEntry_text.get()

    def insertText(self, text): 
        self.text.delete('1.0', tk.END)
        self.text.insert('1.0', text)

    def displayGraph(self, title): 
        # visOutNode = tk.Button(self.rightContainer, text='Visualize Out Node', command=self.controller.visOutNode)
        # visOutNode.grid(row=0, column=0, sticky='nswe')
        import matplotlib.pyplot as plt 
        from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg, NavigationToolbar2TkAgg
        from matplotlib.figure import Figure

        fig = plt.figure(1)
        plt.title(title)
        canvas = FigureCanvasTkAgg(fig, master=self.middleContainer)
        canvas.draw()
        canvas.get_tk_widget().grid(row=0, column=0, sticky='nswe')

        toolbar = NavigationToolbar2TkAgg(canvas, self.middleContainer)
        toolbar.grid(row=1, column=0)
        toolbar.update()

    def clearFigure(self): 
        import matplotlib.pyplot as plt 
        plt.clf()

##### the below code is for the testing purpose only

# class Controller: 
#     pass

# def main():
#     root = tk.Tk()
#     root.title('Hello Penguins')
#     root.grid_columnconfigure(0, weight = 1)
#     root.grid_rowconfigure(0, weight = 1)

#     controller = Controller()
#     interface = Interface(root, controller)
#     interface.grid(row=0, column=0, sticky='nsew')
#     interface.grid_propagate(False)
    
#     root.minsize(700, 700)
#     root.mainloop()  
 
# if __name__ == '__main__':
#     main()  