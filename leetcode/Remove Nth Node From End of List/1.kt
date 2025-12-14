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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var curr = head
        var length = 0
        while (curr != null) {
            length++
            curr = curr.next
        }
        curr = head

        val move = length - n
        if (move == 0) return curr?.next

        for (i in 0 until move - 1) {
            if (curr == null) break
            curr = curr.next
        }

        curr?.next = curr?.next?.next
        return head
    }
}