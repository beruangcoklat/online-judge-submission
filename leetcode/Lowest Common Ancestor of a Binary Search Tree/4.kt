/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null

        p!!
        q!!
        val max = p.`val`.coerceAtLeast(q.`val`)
        val min = p.`val`.coerceAtMost(q.`val`)

        if (root.`val` in (min..max)) {
            return root
        }

        lowestCommonAncestor(root.left, p, q)?.let { return it }
        lowestCommonAncestor(root.right, p, q)?.let { return it }
        return null
    }
}