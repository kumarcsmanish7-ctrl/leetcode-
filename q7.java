// 53. Maximum Subarray
// Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
 

//O(n) time complexity , O(1)space complexity
class q7Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=0;
        int cursum=0;
        for(int num: nums){
            cursum = Math.max(cursum+num,num);
            maxsum = Math.max(maxsum , cursum);

        }
        return maxsum ; 
    }
}


// not recommended O(nlogn)time , O(logn)space 
// using divide and conquer O(nlogn) 

// class q7 {
//     public int maxSubArray(int[] nums) {
//         return helper(nums, 0, nums.length - 1);
//     }

//     private int helper(int[] nums, int left, int right) {
//         if (left == right) return nums[left];  // base case

//         int mid = left + (right - left) / 2;

//         int leftMax = helper(nums, left, mid);
//         int rightMax = helper(nums, mid + 1, right);
//         int crossMax = maxCrossingSum(nums, left, mid, right);

//         return Math.max(Math.max(leftMax, rightMax), crossMax);
//     }

//     private int maxCrossingSum(int[] nums, int left, int mid, int right) {
//         int sum = 0;
//         int leftSum = Integer.MIN_VALUE;

//         // go left from mid
//         for (int i = mid; i >= left; i--) {
//             sum += nums[i];
//             leftSum = Math.max(leftSum, sum);
//         }

//         sum = 0;
//         int rightSum = Integer.MIN_VALUE;

//         // go right from mid+1
//         for (int i = mid + 1; i <= right; i++) {
//             sum += nums[i];
//             rightSum = Math.max(rightSum, sum);
//         }

//         return leftSum + rightSum;
//     }
// }
