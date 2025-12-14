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
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null
        val root = TreeNode(preorder[0])
        root.left = bstFromPreorder(preorder.filter { it < preorder[0] }.toIntArray())
        root.right = bstFromPreorder(preorder.filter { it > preorder[0] }.toIntArray())
        return root
    }
}