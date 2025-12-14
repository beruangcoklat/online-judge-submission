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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var list1 = list1
        var list2 = list2
        var head: ListNode? = null
        var curr: ListNode? = null

        while (list1 != null && list2 != null) {
            val min = if (list1.`val` < list2.`val`) {
                val result = list1
                list1 = list1.next
                result
            } else {
                val result = list2
                list2 = list2.next
                result
            }

            if (curr != null) {
                curr.next = min
                curr = min
            } else {
                head = min
                curr = min
            }
        }

        var remaining = list1 ?: list2
        while (remaining != null) {
            val min = remaining
            if (curr != null) {
                curr.next = min
                curr = min
            } else {
                head = min
                curr = min
            }
            remaining = remaining.next
        }
        return head
    }
}