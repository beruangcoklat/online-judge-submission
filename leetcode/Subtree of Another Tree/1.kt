/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        return isSameTree(root, subRoot) ||
                root?.left?.let { isSubtree(it, subRoot) } ?: false ||
                root?.right?.let { isSubtree(it, subRoot) } ?: false
    }

    private fun isSameTree(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 == null && root2 == null) return true
        val isSameNode = if (root1 == null || root2 == null) false
        else root1.`val` == root2.`val`
        return isSameNode && isSameTree(root1?.left, root2?.left) && isSameTree(root1?.right, root2?.right)
    }
}