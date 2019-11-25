# Number Of Islands

The idea is to use DFS to traverse all the cells one by one, and then recursively traversing all the neighboring cells from each cell. 

If the cell represents water we will just return 0; otherwise If the cell represents a land, then we will mark it water (so that we don't traverse that cell again) and then traverse its neighbours. 

This way we will be able to traverse the one entire island and at the end we return 1 for one single island.

```java
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

```java
public static int traverseIsland(char[][] grid, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length ||
                grid[row][column] == '0'){
            return 0;
        }
        //Setting the land to '0'
        grid[row][column] = '0';
    
        traverseIsland(grid, row, column+1); // right cell
        traverseIsland(grid, row, column-1); // left cell
        traverseIsland(grid, row+1, column); // bottom cell
        traverseIsland(grid, row-1, column); // top cell
        
        
        return 1;
    }
```

### Case 1 : When we can only move horizontally (left, right) and vertically (top, down)
e.g. below matrix have total 9 islands (note that we can only move horizontally, vertically and not diagonally)
![When we can move to only right left](right-left-top-down.PNG?raw=true "Title")


### When we can move horizontally (left, right), vertically (top, down) and diagonally (top-right, bottom-left, bottom-right, top-left)

```java
  public static int traverseIsland(char[][] grid, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length ||
                grid[row][column] == '0'){
            return 0;
        }
        //Setting the land to '0'
        grid[row][column] = '0';
    
        traverseIsland(grid, row, column+1); // right cell
        traverseIsland(grid, row, column-1); // left cell
        traverseIsland(grid, row+1, column); // top cell
        traverseIsland(grid, row-1, column); // bottom cell
        
        traverseIsland(grid, row-1, column+1); // diagonally : top-right cell
        traverseIsland(grid, row+1, column-1); // diagonally : bottom-left cell
        traverseIsland(grid, row+1, column+1); // diagonally : bottom-right cell
        traverseIsland(grid, row-1, column-1); // diagonally : top-left cell
        
        
        return 1;
    }
```
e.g. below matrix have total 5 islands (since we can move horizontally, vertically and diagonally)
![When we can move to only right left and diagonally](right-left-top-down-diagonal.PNG?raw=true "Title")
