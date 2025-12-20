class Solution {
    val set = hashSetOf<Char>()
    fun lengthOfLongestSubstring(s: String): Int {
        var p1 = 0
        var p2 = 0
        var max = 0
        while (p2<s.length) {
            if (set.contains(s[p2])) {
                val pos = s.indexOf(s[p2], p1)
                set.removeAll(s.substring(p1, pos).toList())
                p1 = pos+1
                p2++
            } else {
                val len = p2-p1+1
                if (len>max)
                    max = len
                set.add(s[p2])
                p2++
            }
        }
        return max
    }
}
