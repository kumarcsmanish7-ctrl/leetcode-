// 1914. Cyclically Rotating a Grid
// You are given an m x n integer matrix grid​​​, where m and n are both even integers, and an integer k.

// The matrix is composed of several layers, which is shown in the below image, where each color is its own layer:



// A cyclic rotation of the matrix is done by cyclically rotating each layer in the matrix. To cyclically rotate a layer once, each element in the layer will take the place of the adjacent element in the counter-clockwise direction. An example rotation is shown below:


// Return the matrix after applying k cyclic rotations to it.

 

// Example 1:


// Input: grid = [[40,10],[30,20]], k = 1
// Output: [[10,20],[40,30]]
// Explanation: The figures above represent the grid at every state.
// Example 2:


// Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
// Output: [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
// Explanation: The figures above represent the grid at every state.
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 2 <= m, n <= 50
// Both m and n are even integers.
// 1 <= grid[i][j] <= 5000
// 1 <= k <= 109
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int r1 =0,r2=m-1,c1=0,c2=n-1;
        while(r1<r2&&c1<c2){
            int total = (r2-r1)*2+(c2-c1)*2;
            int shift = k%total;
            int ring[] = new int[total];
            int idx =0;
            for(int i=c1;i<c2;i++){
                ring[idx++]= grid[r1][i];
            }
            for(int i=r1;i<r2;i++){
                ring[idx++]=grid[i][c2];
            }
            for(int i = c2;i>c1;i--){
                ring[idx++]=grid[r2][i];
            }
            for(int i =r2;i>r1;i--){
                ring[idx++]=grid[i][c1];
            }
            reverse(ring, 0, shift-1);
            reverse(ring,shift,total-1);
            reverse(ring,0,total-1);

            idx=0;
            for(int i=c1;i<c2;i++){
                grid[r1][i]=ring[idx++] ;
            }
            for(int i=r1;i<r2;i++){
                grid[i][c2]=ring[idx++];
            }
            for(int i = c2;i>c1;i--){
                grid[r2][i]=ring[idx++];
            }
            for(int i =r2;i>r1;i--){
               grid[i][c1]= ring[idx++];
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return grid;
        
    }
    void reverse(int arr[],int l, int r){
        while(l<r){
            int temp = arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
}