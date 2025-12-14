/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reorderList(head: ListNode?): Unit {
        val nodes = mutableListOf<ListNode?>()
        var curr = head
        while (curr != null) {
            nodes.add(curr)
            curr = curr.next
        }
        var left = 0
        var right = nodes.size - 1
        while (left < right) {
            nodes[left]!!.next = nodes[right]
            nodes[right]!!.next = nodes[left + 1]
            left++
            right--
        }
        nodes[left]!!.next = null
    }
}