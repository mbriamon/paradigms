#!/usr/bin env python3

import sys

def bfs_traversal(graph, initial_node):
    #return a list

    #create list to return
    visited = []
    
    #have queue to do BFS (first in first out)
    queue = [initial_node]

    #loop to go through as long as there is shit in queue
    while queue:
        #get the first thing from queue, and remove from queue
        node = queue.pop(0)
        #add that thing to the end of visited
        visited.append(node)
        #add the nodes that come from that thing to the queue
        queue.extend(graph[node])
        
    return visited
