/* You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the 
integers in the range [1, m * n]. Go through each index i in arr starting from index 0 and paint the cell in mat 
containing the integer arr[i]. Return the smallest index i at which either a row or a column will be completely 
painted in mat. 
* Eg 1 : array = [1,3,4,2]            matrix = [[1,4],[2,3]]                Output = 2 
* Eg 2 : array = [2,8,7,4,1,3,5,6,9]  matrix = [[3,2,5],[1,4,6],[8,7,9]]    Output = 3 
*/
import java.util.*;
public class PaintedRow
{
      public int FirstCompleteIndex(int array[], int matrix[][])
      {
            HashMap<Integer, int[]> mapping = new HashMap<Integer, int[]>();  //* HashMap -> O(N x M)
            for(int i = 0; i < matrix.length; i++)     //! Grid Traversal -> O(N x M)
            {
                  for(int j = 0; j < matrix[0].length; j++)
                        mapping.put(matrix[i][j], new int[]{i, j});
            }
            Vector<Integer> IncompleteRows = new Vector<Integer>();      //* Vector Rows -> O(N)
            Vector<Integer> IncompleteColumns = new Vector<Integer>();   //* Vector Column -> O(M)
            int rows = matrix.length, cols = matrix[0].length, index = 0;
            for(int i = array.length - 1; i >= 0; i--)       //! Traversal -> O(N + M)
            {
                  int coordinates[] = mapping.get(array[i]);     // Extracting Coordinates...
                  if(!IncompleteRows.contains(coordinates[0]))    // Checking HashMap for X coordinate...
                  {
                        IncompleteRows.add(coordinates[0]);
                        rows--; index++;
                  }
                  if(!IncompleteColumns.contains(coordinates[1]))    // Checking HashMap for Y coordinate...
                  {
                        IncompleteColumns.add(coordinates[1]);
                        cols--; index++;
                  }
                  if((rows == 1) || (cols == 1))    // If a row or column is left...
                        break;     // Run out of the loop...
            }
            return index;
      }
      public static void main(String args[])
      {
            //? Test Case I 
            int array[] = {1,3,4,2};
            int matrix[][] = {{1,4}, {2,3}};
            //? Test Case II 
            int array1[] = {2,8,7,4,1,3,5,6,9};
            int matrix1[][] = {{3,2,5}, {1,4,6}, {8,7,9}};
            PaintedRow paintedRow = new PaintedRow();        // Object creation...
            System.out.println("The First Complete Index (Ist Test Case): "+paintedRow.FirstCompleteIndex
            (array, matrix));
            System.out.println("The First Complete Index (IInd Test Case): "+paintedRow.FirstCompleteIndex
            (array1, matrix1));
      }
}



//! Time Complexity -> O(N x M)
//* Space Complexity -> O(N x M)