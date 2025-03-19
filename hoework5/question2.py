#! /usr/bin env python3
import sys
from collections import deque


class Node:
    def __init__(self, value, left, right):
        self.value = value
        self.left = left
        self.right = right 

    def __str__(self):
        return self.value


def traverse(root):
    #traverses tree starting from root node --> returns a list of visited nodes
    #BFS! but changes direction at each level

    if not root:
        return []

    direction = "left"    #direction is going left or right, switches with every level
    visited = []        #list of all visited nodes to return at end
    frontier = deque([root])

    while frontier:
        level_size = len(frontier)
        level_nodes = []

        for _ in range(level_size):
            node = frontier.popleft()
            level_nodes.append(node)

            if node.left:
                frontier.append(node.left)
            if node.right:
                frontier.append(node.right)

        if direction == "left":
            visited.extend(reversed(level_nodes))

        else:
            visited.extend(level_nodes)

        direction = "right" if direction == "left" else "left"

    return visited

 
#do we need to build tree first?

#testing...1 2 3 
e = Node("E", None, None)
d = Node("D", None, None)
c = Node("C", d, e)
b = Node("B", None, None)
root = Node("A", b, c)
for v in traverse(root):
	print(v)
print()

gg = Node("G", None, None)
f = Node("F", None, None)
e = Node("E", None, None)
d = Node("D", None, None)
c = Node("C", f, gg)
b = Node("B", d, e)
root = Node("A", b, c)
for v in traverse(root):
	print(v)
print()

node9 = Node("Node9", None, None)
node10 = Node("Node10", None, None)
node7 = Node("Node7", None, None)
node8 = Node("Node8", node9, node10)
node5 = Node("Node5", None, None) 
node6 = Node("Node6", node7, node8)
node3 = Node("Node3", None, None)  
node4 = Node("Node4", node5, node6)
node1 = Node("Node1", node3, node4)
node2 = Node("Node2", None, None)  
root = Node("Root", node1, node2)
for v in traverse(root):
	print(v)