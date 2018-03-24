from py2neo import Relationship, Node, Graph
import networkx as nx
import copy

class Model(): 
    def __init__(self): 
        self.graph = Graph("http://neo4j:neo4j2@localhost:7474/db/data/")
        self.list_of_nodes = []
        self.g = nx.DiGraph()
        self.fullGraph = nx.DiGraph()

        self.text = ""

    def addNode(self, node): 
        labels = list(node.labels())
        
        for k in labels: 
            label = k   #This return the node's label

        print(label)
        id = node['id']
        content = node['content']
        type_id = node['type_id']
        print(node)
        print('{} ++ {} ++ {}'.format(id, content, type(type_id)))

        print('start addnode')
        self.g.add_node(id, type_id=type_id, content=content, label=label)
        print('end addnode')

        self.text = self.text + "NodeID: " + id + "    Label: " + label + "\n"

        #New attribute for the graph
        #this_node = nx.draw_networkx_nodes(g, pos, node_color=the_color)
        #nx.draw_networkx_labels(g, pos)
        #this_node.set_edgecolor('black')
    
    def addRelation(self, start_node, end_node): 
        print('Start adding relation')
        if start_node not in self.list_of_nodes: 
            self.addNode(start_node)
            self.list_of_nodes.append(start_node)

        if end_node not in self.list_of_nodes: 
            self.addNode(end_node)
            self.list_of_nodes.append(end_node)

        start_node_id = start_node['id']
        end_node_id = end_node['id']
        self.g.add_edge(start_node_id, end_node_id)
        print('{} and {}'.format(start_node_id, end_node_id))

    def drawAllNodesAndRelsWithColour(self): 
        print('Draw or not?')
        color_map = {'Topic': '#2980b9', 'Paper': '#2ecc71', 'Venue': '#e74c3c', 'Author': '#d35400', 'Word': '#7f8c8d'}
        pos = nx.spring_layout(self.g)
        for node in self.g: 
            print(self.g.node[node])

        the_nodes = nx.draw_networkx_nodes(self.g, pos, node_color=[color_map[self.g.node[node]['label']] for node in self.g])
        nx.draw_networkx_edges(self.g, pos)
        nx.draw_networkx_labels(self.g, pos)
        #the_nodes.set_edgecolor('black')

    def getQuery(self, query): 
        nodesList = self.graph.run(query).data()    #A list of dictionaries
        print(nodesList)
        for a_line in nodesList:  #A dictionary
            for the_type, node in a_line.items(): 
                print(node)
                print(the_type)
                if the_type == 'n1' or the_type == 'n2' or the_type == 'n3':   #This line to check this is a node
                    print('This is a node')
                    if node in self.list_of_nodes: 
                        print('Duplicated node')
                    else: 
                        self.addNode(node)
                        self.list_of_nodes.append(node)
                elif the_type == 'r1' or the_type == 'r2':
                    print('This is a relationship')
                    rel = node
                    print(rel)
                    start_node = rel.start_node()
                    end_node = rel.end_node()
                    self.addRelation(start_node, end_node)
                    print('***')
                else: 
                    print('This is not a node nor relationship')
                    print(node)
                    print(the_type)

        print('Start of err')
        self.drawAllNodesAndRelsWithColour()

    def visOutNode(self, nodeID): 
        self.g.clear() 
        self.text = ""
        self.list_of_nodes = []
        query = 'match (n1)-[r1]->(n2) where n1.id = "' + str(nodeID) + '" return n1, r1'
        print(query)
        self.getQuery(query)
        print(self.text)

    def visInNode(self, nodeID): 
        self.g.clear() 
        self.text = ""
        self.list_of_nodes = []
        query = 'match (n1)<-[r1]-(n2) where n1.id = "' + str(nodeID) + '" return n1, r1'
        print(query)
        self.getQuery(query)
        print(self.text)

    def visInOutNode(self, nodeID): 
        self.g.clear() 
        self.text = ""
        self.list_of_nodes = []
        query = 'match (n1)-[r1]-(n2) where n1.id = "' + str(nodeID) + '" return n1, r1'
        print(query)
        self.getQuery(query)
        print(self.text)

    def inDegCent(self, nodeID): 
        if not self.fullGraph.nodes():
            self.getQuery('match (n1)-[r1]->(n2) return n1, r1')
            self.fullGraph = copy.deepcopy(self.g)

        inDegCent = nx.in_degree_centrality(self.fullGraph)
        self.text = "Node ID: " + str(nodeID) + "  \nIn Degree Centrality: " + str(inDegCent[str(nodeID)])

    def closeCent(self, nodeID): 
        if not self.fullGraph.nodes():
            self.getQuery('match (n1)-[r1]->(n2) return n1, r1')
            self.fullGraph = copy.deepcopy(self.g)
        #btwnCent_approx = nx.betweenness_centrality(self.g, normalized=True, endpoints=True, k = 100)  #Calculate using approximation
        closeCent = nx.closeness_centrality(self.fullGraph)
        self.text = "Node ID: " + str(nodeID) + "  \nCloseness Centrality: " + str(closeCent[str(nodeID)])

    def btwnCent(self, nodeID): 
        if not self.fullGraph.nodes():
            self.getQuery('match (n1)-[r1]->(n2) return n1, r1')
            self.fullGraph = copy.deepcopy(self.g)

        #btwnCent_approx = nx.betweenness_centrality(self.g, normalized=True, endpoints=True, k = 100)  #Calculate using approximation
        btwnCent = nx.betweenness_centrality(self.fullGraph, normalized=True, endpoints=True)
        self.text = "Node ID: " + str(nodeID) + "  \nBetweenness Centrality: " + str(btwnCent[str(nodeID)])

    def findCoAuthor(self, nodeID): 
        self.g.clear() 
        self.text = ""
        self.list_of_nodes = []
        query = 'match (n1:Author)-[r1:Wrote]->(n2:Paper)<-[r2:Wrote]-(n3:Author) where n1.id = "' + str(nodeID) + '" return n1, r1, n2, r2, n3'
        print(query)
        self.getQuery(query)
        print(self.text)

    def findRef(self, nodeID): 
        self.g.clear() 
        self.text = ""
        self.list_of_nodes = []
        query = 'match (n1:Paper)-[r1:Cites]->(n2:Paper) where n1.id = "' + str(nodeID) + '" return n1, r1'
        print(query)
        self.getQuery(query)
        print(self.text)

    def findTopic(self, nodeID): 
        self.g.clear() 
        self.text = ""
        self.list_of_nodes = []
        query = 'match (n1:Paper)-[r1:BelongsTo]->(n2:Topic) where n1.id = "' + str(nodeID) + '" return n1, r1'
        print(query)
        self.getQuery(query)
        print(self.text)

    def findAuthors(self, nodeID): 
        print('a')
        self.g.clear() 
        self.text = ""
        self.list_of_nodes = []
        query = 'match (n1:Paper)<-[r1:Wrote]-(n2:Author) where n1.id = "' + str(nodeID) + '" return n1, r1, n2'
        print(query)
        self.getQuery(query)
        print(self.text)

    def findVenue(self, nodeID): 
        self.g.clear() 
        self.text = ""
        self.list_of_nodes = []
        query = 'match (n1:Paper)-[r1:Published]-(n2:Venue) where n1.id = "' + str(nodeID) + '" return n1, r1, n2'
        print(query)
        self.getQuery(query)
        print(self.text)

    def findWords(self, nodeID): 
        print('a')
        self.g.clear() 
        self.text = ""
        self.list_of_nodes = []
        query = 'match (n1:Topic)-[r1:Includes]->(n2:Word) where n1.id = "' + str(nodeID) + '" return n1, r1, n2'
        print(query)
        self.getQuery(query)
        print(self.text)

    def getText(self): 
        return self.text

    # def displayGraph(self): 
    #     import matplotlib.pyplot as plt 
    #     plt.show(block=False)
#obj = Model()
#obj.visOutNode(52)



