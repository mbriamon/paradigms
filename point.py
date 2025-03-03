#!/usr/bin/env python3

import math

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def print(self):
        print(f'({self.x}, {self.y})')
def distance(p1, p2):
    return math.sqrt((p2.x-p1.x) ** 2 + (p2.y-p1.y) ** 2)

#testing... 1 2 3
p1 = Point(3, 7)
p2 = Point(-1, -2)
p1.print()
p2.print()
distance1 = distance(p1, p2)
print(f'Distance: {distance1}')