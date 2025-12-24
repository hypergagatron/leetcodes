class Solution {
    fun atMostNGivenDigitSet(digits: Array<String>, n: Int): Int {
        val nDigits = n.toString().toCharArray()
        val digs = digits.map{ it[0] }.joinToString("").toCharArray()

        val ds = digits.size
        
        var s1 = 0.0
        for (i in 1..nDigits.size-1) {
            s1+=Math.pow(ds.toDouble(), i.toDouble())
        }

        var s2 = 0.0
        for (i in 0..nDigits.size-1) {
            val sc = smallerCount(digs, nDigits[i])
            if (nDigits.size == 1) {
                s2+=smallerOrEqualCount(digs, nDigits[0]).toDouble()
            } else if (i == nDigits.size-1) {
                s2+=smallerOrEqualCount(digs, nDigits[i]).toDouble()
            }else {
                s2+= sc*Math.pow(ds.toDouble(), (nDigits.size-i-1).toDouble())
            }

            if (!digs.contains(nDigits[i])) {
                break
            } 
        }

        return s1.toInt()+s2.toInt()
    }

    fun smallerCount(digits: CharArray, d: Char): Int {
        var count = 0
        for (i in 0..digits.size-1) {
            if (digits[i]<d) {
                count++
            }
        }
        return count
    }

        fun smallerOrEqualCount(digits: CharArray, d: Char): Int {
        var count = 0
        for (i in 0..digits.size-1) {
            if (digits[i]<=d) {
                count++
            }
        }
        return count
    }

}
