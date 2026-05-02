// 54. Spiral Matrix
// Given an m x n matrix, return all elements of the matrix in spiral order.

 

// Example 1:


// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]
// Example 2:


// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int srow =0, scol =0 , erow = m-1, ecol =n-1;
        List<Integer> result = new ArrayList<>();
        while(srow<=erow &&scol<=ecol ){
            for(int j = scol;j<=ecol;j++){
                result.add(matrix[srow][j]);
            }
            for(int i = srow+1;i<=erow;i++){
                result.add(matrix[i][ecol]);
            }
            for(int j= ecol-1;j>=scol;j--){
                if(srow==erow){
                    break;
                }
                result.add(matrix[erow][j]);
            }
            for(int i = erow-1;i>=srow+1;i--){
                if(scol==ecol){
                    break;
                }
                result.add(matrix[i][scol]);

            }
            srow++;
            scol++;
            erow--;
            ecol--;
        }return result;
    }
}