// 560. Subarray Sum Equals K
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

 

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:

// Input: nums = [1,2,3], k = 3
// Output: 2
 

// Constraints:

// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n =nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixsum[]=new int[nums.length];
        int result =0;
        prefixsum[0]=nums[0];
        for(int i =1;i<nums.length;i++ ){
            prefixsum[i]=prefixsum[i-1]+nums[i];            
        }
        for(int j=0;j<n;j++){//prefixsum frequency
            
            int val = prefixsum[j]-k;
            if(map.containsKey(val)){
                result+= map.get(val);
            }
            map.put(prefixsum[j],map.getOrDefault(prefixsum[j],0)+1);

        }
        return result;
    }
}