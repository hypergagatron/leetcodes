// Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target.
// If there is no such subarray, return 0 instead.

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {

        var p1 = 0
        var p2 = 0
        var currentSum = 0
        var minL = Int.MAX_VALUE

        while (p2<nums.size) { 
            currentSum+=nums[p2]
            while (currentSum-nums[p1]>=target) {
                currentSum-=nums[p1]
                p1++
            }
            if (currentSum >= target && (p2-p1+1) < minL) {
                minL = p2 - p1+1
            }
            p2++
        }
        return if (minL<Int.MAX_VALUE) minL else 0
    }
}
