// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
// You can only see the k numbers in the window. Each time the sliding window moves right by one position.
// Return the Array containing max of all sliding windows.

// Idea: Have double-ended queue containing at most k last indicies of elements, where the first value is index of the biggest element in current frame

class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val result = IntArray(n-k+1)

        val d = ArrayDeque<Int>()
        for (i in 0..nums.size-1) {
            if (d.isNotEmpty() && d.first()<=i-k) {
                d.removeFirst()
            }
            while (d.isNotEmpty() && nums[d.last()]<=nums[i]) {
                d.removeLast()
            }

            d.addLast(i)

            if (i>=k-1) {
                result[i-k+1] = nums[d.first()]
            }

        }
        return result
    }
}
