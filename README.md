# Number Of Islands

The idea is to use DFS to traverse all the neighboring cells from a cell. If the cell represents water we will just return otherwise If the cell represents a land, then we will mark it water and traverse its neighbour. This way we will be able to traverse the entire island.

### When we can only move horizontally (left, right) and vertically (top, down)
![When we can move to only right left](right-left-top-down.PNG?raw=true "Title")


### When we can move horizontally (left, right), vertically (top, down) and diagonally (top-right, bottom-left, bottom-right, top-left)
![When we can move to only right left and diagonally](right-left-top-down-diagonal.PNG?raw=true "Title")
