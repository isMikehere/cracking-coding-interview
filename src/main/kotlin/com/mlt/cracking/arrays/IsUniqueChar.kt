package com.mlt.cracking.arrays


/**
 *  Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
 */
class IsUniqueChar {
    fun version1(strings: String): Boolean {
        val arr = BooleanArray(128) { false }
        strings.toCharArray().forEach {
            if (arr[it.toInt()]) {
                return false
            } else {
                arr[it.toInt()] = true
            }
        }
        return true
    }

    fun version2(strings: String): Boolean {
        return strings.toSortedSet().size == strings.length
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            with(IsUniqueChar()) {
                println(version1("123"))
                println(version1("122"))
                println(version2("123"))
                println(version2("122"))
            }
        }
    }
}
