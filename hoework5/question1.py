#!/usr/bin/env python3

def move_robot(n):
#move the robot n times until its final position --> returns a list
    m = 1
    positions = [(0,0)]
    direction = "north"
    for i in range(n):
        #print("positions: " + positions)
        #print("m: " + str(m))
        #print("direction: " + direction)

        position = positions[-1]
        new = ()

        #print("position: " + str(position))
        
        if direction == "north":
            #increase the y number by m
            x = position[0]
            y = position[1] + m
            #position[1] = position[1] + m   -->b/c tuples are immutable
            new = (x,y)
            direction = "east"
        elif direction == "south":
            x = position[0]
            y = position[1] - m
            #position[1] = position[1] - m
            new = (x,y)
            direction = "west"
        elif direction == "east":
            x = position[0] + m
            y = position[1]
            #position[0] = position[0] + m
            new = (x,y)
            direction = "south"
        elif direction == "west":
            x = position[0] - m
            y = position[1]
            #position[0] = position[0] - m
            new = (x,y)
            direction = "north"
        
        m = m + 1

        #print("new position: " + str(new))
        positions.append(new)

    return positions

#testing...1 2 3
for v in move_robot(4):
    print(v)

for v in move_robot(0):
    print(v)

for v in move_robot(2):
    print(v)