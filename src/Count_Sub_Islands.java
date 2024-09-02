/*
You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.



Example 1:

Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
Output: 3
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
Example 2:


Input: grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
Output: 2
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are two sub-islands.

 */

import java.util.Arrays;

public class Count_Sub_Islands {
    int row, column;
    boolean isSubIsland;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        System.out.println("First Grid");
        for(int[] row : grid1){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Second grid");
        for(int[] row : grid2){
            System.out.println(Arrays.toString(row));
        }

        row = grid1.length;
        column = grid1[0].length;
        
        int subIslands = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(grid2[i][j] == 1){
                    isSubIsland = true;
                    dfs(grid1, grid2, i, j);

                    if(isSubIsland){
                        subIslands++;
                    }
                }
            }
        }

        return subIslands;
    }
    public void dfs(int[][] grid1, int[][] grid2, int i, int j){
        if(i < 0 || j < 0 || i == row || j == column || grid2[i][j] == 0) return;

        if(grid1[i][j] != grid2[i][j]){
            isSubIsland = false;
        }

        grid2[i][j] = 0;

        dfs(grid1, grid2, i + 1, j); //down
        dfs(grid1, grid2, i - 1, j); //up
        dfs(grid1, grid2, i, j + 1); //right
        dfs(grid1, grid2, i, j - 1); //left
        
        
    }
}
