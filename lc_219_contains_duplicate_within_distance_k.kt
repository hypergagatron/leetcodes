// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

class Solution {
    val numCount = hashMapOf<Int,Boolean>()
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        var p1 = 0
        var p2 = 0

        if (k == 0)
            return false

        while (p2<nums.size) {
            val value = nums[p2]

            if (p2-p1 > k) {
                numCount.remove(nums[p1])
                p1++
            }

            if (numCount.containsKey(value)) 
                return true
            else 
                numCount[value] = true
            p2++
        }

        return false
    }
}
