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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var head: ListNode? = null
        var curr: ListNode? = null

        while (true) {
            var minIdx = -1
            var min: ListNode? = null
            for (i in lists.indices) {
                val list = lists[i] ?: continue
                if (min == null || list.`val` < min.`val`) {
                    minIdx = i
                    min = list
                }
            }
            if (min == null) break

            if (curr == null) {
                curr = min
                head = min
            } else {
                curr.next = min
                curr = min
            }
            lists[minIdx] = lists[minIdx]?.next
        }

        return head
    }
}