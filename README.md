# Number Of Islands 
## https://leetcode.com/problems/number-of-islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

```
Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3
```

## Approach 1 : DFS

The idea is to use DFS to traverse all the cells one by one, and while traversing each cell, recursively traversing all the neighbouring cells from that cell.

If the cell represents water we will immediately return; otherwise If the cell represents a land, then we will mark it water (so that we don't traverse that cell again) and then traverse all its neighbours.

This way we will be able to traverse the one entire island.

### Case 1 : When we can only move horizontally (left, right) and vertically (top, down)
e.g. below 10*10 matrix have total 9 islands (note that we can only move horizontally, vertically and not diagonally)
![When we can move to only right left](right-left-top-down.PNG?raw=true "Title")

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
                    islands++;
                    traverseIsland(grid, i, j);
                }
            }
        }
        return islands;
        
    }
```

```java
public static void traverseIsland(char[][] grid, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length ||
                grid[row][column] == '0'){
            return;
        }
        //Setting the land to '0'
        grid[row][column] = '0';
    
        traverseIsland(grid, row, column+1); // right cell
        traverseIsland(grid, row, column-1); // left cell
        traverseIsland(grid, row+1, column); // bottom cell
        traverseIsland(grid, row-1, column); // top cell
}
```


**One very important thing to note is in the `traverseIsland` method we are setting the current cell to '0' 
`grid[row][column] = '0';` before traversing its neighbours, If we do that after calling the `traverseIsland` on the neighbouring cells, it can result in infinite recursion and that will result in `StackOverflowError`**


### Case 2 : When we can move horizontally (left, right), vertically (top, down) and diagonally (top-right, bottom-left, bottom-right, top-left)

```java
  public static void traverseIsland(char[][] grid, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length ||
                grid[row][column] == '0'){
            return;
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
 }
```
e.g. below 10*10 matrix have total 5 islands (since we can move horizontally, vertically and diagonally)
![When we can move horizontally, vertically and diagonally](right-left-top-down-diagonal.PNG?raw=true "Title")


## Complexity Analysis : DFS Approach
```
Time complexity : O(M×N) where M is the number of rows and N is the number of columns.

Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
```

## Approach 2 : BFS 

```java
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int islands = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{0, 1} , {0, -1} , {-1, 0} , {1, 0}};
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = '0';
                    islands++;
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()) {
                        int[] pos = q.remove();
                        for(int[] direction : directions) {
                            int row = pos[0] + direction[0];
                            int col = pos[1] + direction[1];
                            if(row >= 0 && row < grid.length && col >= 0 
                               && col < grid[0].length && grid[row][col] == '1' ) {
                                q.add(new int[]{row, col});
                                grid[row][col] = '0';
                            }
                        }
                    }
                }
            }
        }
       return islands; 
    }
}
```

## References :
1. https://www.youtube.com/watch?v=o8S2bO3pmO4

2. https://www.youtube.com/watch?v=HS7t2i9ldmE
