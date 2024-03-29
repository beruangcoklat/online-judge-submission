/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getIntersectionNode(headA, headB *ListNode) *ListNode {
	mark := map[*ListNode]struct{}{}

	for headA != nil {
		mark[headA] = struct{}{}
		headA = headA.Next
	}

	for headB != nil {
		_, ok := mark[headB]
		if ok {
			return headB
		}
		headB = headB.Next
	}

	return nil
}
