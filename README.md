# Number Of Islands

The idea is to use DFS to traverse all the cells one by one, and then recursively traversing all the neighboring cells from each cell. 

If the cell represents water we will just return 0; otherwise If the cell represents a land, then we will mark it water (so that we don't traverse that cell again) and then traverse its neighbours. 

This way we will be able to traverse the one entire island and at the end we return 1.

```
    public static int numIslands(char[][] grid) {
        // To handle null or empty grid input
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int rows = grid.length;
        int columns = grid[0].length;
        int islands = 0;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(grid[i][j] == '1'){
                    islands += traverseIsland(grid, i, j);
                }
            }
        }
        return islands;
        
    }
```

### When we can only move horizontally (left, right) and vertically (top, down)
![When we can move to only right left](right-left-top-down.PNG?raw=true "Title")


### When we can move horizontally (left, right), vertically (top, down) and diagonally (top-right, bottom-left, bottom-right, top-left)
![When we can move to only right left and diagonally](right-left-top-down-diagonal.PNG?raw=true "Title")
