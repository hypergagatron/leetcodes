class Solution {

    enum class Action {
        BUY, SELL
    }

    var sellMap = hashMapOf<Int,Long>()
    var buyMap = hashMapOf<Int, Long>()
    var neutralSellMap = hashMapOf<Int, Long>()
    var neutralBuyMap = hashMapOf<Int, Long>()
    lateinit var n: IntArray
    var fee: Int = 0

    fun buy(k: Int) : Long {
        if (buyMap.containsKey(k)) {
            return buyMap[k]!!
        } else if (k == n.size-1) {
            buyMap[k] = -n[k].toLong()
            return -n[k].toLong()
        } else {
            val result = -n[k].toLong() + Math.max(neutral(k+1, Action.BUY), sell(k+1))
            buyMap[k] = result
            return result
        }
    }

    fun sell(k: Int) : Long {
        if (sellMap.containsKey(k)) {
            return sellMap[k]!!
        } else if (k == n.size-1) {
            sellMap[k] = n[k].toLong()-fee
            return n[k].toLong()-fee
        } else {
            val result = n[k].toLong()-fee + Math.max(neutral(k+1, Action.SELL), buy(k+1))
            sellMap[k] = result
            return result
        }
    }

    fun neutral(k: Int, a: Action): Long {
        if (a == Action.SELL) {
            if (neutralSellMap.containsKey(k)) {
                return neutralSellMap[k]!!
            } else if (k == n.size-1) {
                neutralSellMap[k] = 0
                return 0
            } else {
                val result = Math.max(neutral(k+1, a), buy(k+1))
                neutralSellMap[k] = result
                return result
            }
        } else {
       if (neutralBuyMap.containsKey(k)) {
                return neutralBuyMap[k]!!
            } else if (k == n.size-1) {
                neutralBuyMap[k] = 0
                return 0
            } else {
                val result = Math.max(neutral(k+1, a), sell(k+1))
                neutralBuyMap[k] = result
                return result
            }
        }
    }

    fun maxProfit(array: IntArray, f: Int): Int {
        n = array
        fee = f
        return Math.max(buy(0), neutral(0, Action.SELL)).toInt()
    }
}
