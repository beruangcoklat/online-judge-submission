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
    fun isValidBST(root: TreeNode?): Boolean {
        return check(root, null, null)
    }

    private fun check(root: TreeNode?, min: Int?, max: Int?): Boolean {
        if (root == null) return true
        if (min != null && root.`val` <= min) return false
        if (max != null && root.`val` >= max) return false
        return check(root.left, min, root.`val`) && check(root.right, root.`val`, max)
    }
}