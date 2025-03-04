#!/usr/bin/env python3

import math 

class Point: 
    #constructor 
    def __init__(self, x, y):
        self.x = x
        self.y = y
    #operations 
    def print(self):
        print(f'({self.x},{self.y})')

    @staticmethod
    def distance(p1, p2):
        return  math.sqrt(((p2.x - p1.x) * (p2.x - p1.x)) + ((p2.y - p1.y) * (p2.y - p1.y)))
    

    def distOrigin(self):
        return  math.sqrt(self.x ** 2 + self.y ** 2) 
    
    #special methods >, >=, ==, <, <=

    def __gt__(self, point):
        return self.distOrigin() > point.distOrigin()
    
    def __ge_(self, point):
        return self.distOrigin() >= point.distOrigin()
    
    def __eq__(self, point):
        return self.distOrigin() == point.distOrigin()
    
    def __lt__(self, point):
        return self.distOrigin() < point.distOrigin()
    
    def __le__(self, point):
        return self.distOrigin() <= point.distOrigin()


#testing... 1 2 3  
p1 = Point(2, 3)
p2 = Point(-3, 1)
p3 = Point(-2, -3)
print(p1 > p2) # prints True because p1 is more distant to the origin than p2
print(p1 == p2) # prints False because p1 and p2 are not equally distant to the origin 
print(p1 < p2) # prints False because p1 is not closer to the origin as compared to p2
print(p1 == p3) # prints True  because p1 and p3 are equally distant to the origin