/**
Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
*/

class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        var map = hashMapOf<String, Int>()
        var heap = PriorityQueue<Pair<String, Int>>(
            compareByDescending { p: Pair<String, Int> -> p.second }.thenBy { it.first }
        ) 
        for (w in words) {
            if (map.containsKey(w)) {
                map[w] = map[w]!!+1
            } else {
                map[w] = 1
            }
        }

        for (e in map) {
            heap.add(Pair(e.key, e.value))

        }
        val result = mutableListOf<String>()
        for (i in 0..k-1) {
            result.add(heap.poll().first)
        }
        return result
    }
}
