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
        var fast = head
        var slow = head
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        var prev: ListNode? = null
        var curr = slow
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }

        var left = head
        var right = prev
        while (left != null && right != null) {
            val nextLeft = left.next
            val nextRight = right.next

            left.next = right
            right.next = nextLeft

            left = nextLeft
            right = nextRight
        }
        left?.next = null
    }
}