from py2neo import Relationship, Node, Graph

graph = Graph("http://neo4j:neo4j2@localhost:7474/db/data/")
#                   username:password@url

def createNode(words):
    print('Start creating node in database')
    year = ''
    for i, word in enumerate(words): 
        if i == 0:
            id = word
            print(id)
        elif i == 1: 
            label = word 
        elif i == 2: 
            type_id = word
        elif i == 3: 
            content = word
        elif i == 4:
            year = word
        else: 
            print('Invalid number of words in line using to create Node')

    if label == '':
        pass
    elif year != '':
        newNode = Node(label, id=id, type_id=type_id, content=content, year=year)
    else:
        newNode = Node(label, id=id, type_id=type_id, content=content)
    graph.create(newNode)
    return newNode

def getLabel(node): 
    #Convert the result to label from SetView
    labels = node.labels()
    labels = list(labels)
    for i in labels: 
        label = i
    #End of convertion, return the string label
    return label

def createRelationship(words): 
    print('Start creating relationship in database')
    for i, word in enumerate(words): 
        if i == 0:
            node1id = word
        elif i == 1: 
            node2id = word 
        elif i == 2: 
            weight = word
        else: 
            print('Invalid number of words in line using to create Relationship')
    node1 = graph.evaluate('MATCH (n) WHERE n.id=$id RETURN n', id = node1id)
    node2 = graph.evaluate('MATCH (n) WHERE n.id=$id RETURN n', id = node2id)
    label1 = getLabel(node1)
    label2 = getLabel(node2)

    if label1 == 'Topic' and label2 == 'Word':
        rel_type = 'Includes'   
        node1node2 = Relationship(node1, rel_type, node2, Phi_Weight=weight)
    elif label1 == 'Paper' and label2 == 'Topic':
        rel_type = 'BelongsTo'
        node1node2 = Relationship(node1, rel_type, node2, Theta_Weight=weight)
    elif label1 == 'Paper' and label2 == 'Venue':
        rel_type = 'Published'
        node1node2 = Relationship(node1, rel_type, node2, Year=weight)
    elif label1 == 'Author' and label2 == 'Paper':
        rel_type = 'Wrote'
        node1node2 = Relationship(node1, rel_type, node2)
    elif label1 == 'Paper' and label2 == 'Paper':
        rel_type = 'Cites'
        node1node2 = Relationship(node1, rel_type, node2)
    else: 
        print('Invalid label1 and label 2 - Hung Error')
        print(node1id + '  ' + node2id)
        return

    graph.create(node1node2)

def openFileAndWriteToDatabase(): 
    graph.run("MATCH (n) DETACH DELETE n")
    #Process file
    path = '/Users/hungle/Desktop/Python Projects/py2neo/files/data.txt'

    with open(path, 'r', encoding="utf-8") as f: 
        listLines = f.readlines()
    #with open(path) as f:
        
    #Remove whitespace characters like `\n` at the end of each line
    listLines = [x.strip() for x in listLines] 

    curr = ''
    for line in listLines:
        #print(line)
        words = line.split('#')
        for word in words: 
            if word == '*Vertices':
                curr = 'Vertices'
                break
            elif word == '*Arcs':
                curr = 'Arcs'
                break
        else: 
            if curr == 'Vertices': 
                createNode(words)
            elif curr == 'Arcs':
                createRelationship(words)    

openFileAndWriteToDatabase()    #Uncomment this line to delete all information in the db and rewrite them
