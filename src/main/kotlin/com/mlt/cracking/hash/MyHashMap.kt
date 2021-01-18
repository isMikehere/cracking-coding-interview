import java.util.LinkedList

class Bucket {
    private val pairs: MutableList<Pair<Int, Int>>
    operator fun get(key: Int): Int {
        for (pair in pairs) {
            if (pair.first == key) {
                return pair.second
            }
        }
        return -1
    }


    fun update(key: Int, value: Int) {
        var found = false
        loops@ for (pair in pairs) {
            if (pair.first == key) {
                found = true
                if (pair.first == key) {
                    pairs. remove(pair).also { pairs.add(pair.copy(second = value)) }
                }
                break@loops
            }
        }
        if (!found) {
            pairs.add(Pair(key, value))
        }
    }

    fun remove(key: Int) {
        pairs.removeIf { it.first == key }
    }

    init {
        pairs = LinkedList()
    }
}

class MyHashMap() {

    /** Initialize your data structure here. */
    private val bucketSize = 256
    private val buckets: MutableList<Bucket> = MutableList(bucketSize) { Bucket() }

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        this.buckets[key % bucketSize].update(key, value)
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        return this.buckets[key % bucketSize][key]
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        this.buckets[key % bucketSize].remove(key)
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
