// 3629. Minimum Jumps to Reach End via Prime Teleportation
// You are given an integer array nums of length n.

// You start at index 0, and your goal is to reach index n - 1.

// From any index i, you may perform one of the following operations:

// Adjacent Step: Jump to index i + 1 or i - 1, if the index is within bounds.
// Prime Teleportation: If nums[i] is a prime number p, you may instantly jump to any index j != i such that nums[j] % p == 0.
// Return the minimum number of jumps required to reach index n - 1.

 

// Example 1:

// Input: nums = [1,2,4,6]

// Output: 2

// Explanation:

// One optimal sequence of jumps is:

// Start at index i = 0. Take an adjacent step to index 1.
// At index i = 1, nums[1] = 2 is a prime number. Therefore, we teleport to index i = 3 as nums[3] = 6 is divisible by 2.
// Thus, the answer is 2.

// Example 2:

// Input: nums = [2,3,4,7,9]

// Output: 2

// Explanation:

// One optimal sequence of jumps is:

// Start at index i = 0. Take an adjacent step to index i = 1.
// At index i = 1, nums[1] = 3 is a prime number. Therefore, we teleport to index i = 4 since nums[4] = 9 is divisible by 3.
// Thus, the answer is 2.
import java.util.*;

class Solution {
    boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        int max = -1;

        for (int i = 0; i < n; i++) {
            hmap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            max = Math.max(max, nums[i]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            List<Integer> nextjumps = new ArrayList<>();

            if (curr - 1 >= 0) nextjumps.add(curr - 1);
            if (curr + 1 < n) nextjumps.add(curr + 1);

            if (isPrime(nums[curr])) {
                int p = nums[curr];
                for (int mul = p; mul <= max; mul += p) {
                    if (hmap.containsKey(mul)) {
                        nextjumps.addAll(hmap.get(mul));
                        hmap.remove(mul);
                    }
                }
            }

            for (int next : nextjumps) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    dist[next] = dist[curr] + 1;
                    if (next == n - 1) return dist[next];
                    q.add(next);
                }
            }
        }

        return dist[n - 1];
    }
}