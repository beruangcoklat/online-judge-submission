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
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        inorder(root)
        return list[k - 1] ?: 0
    }

    val list = mutableListOf<Int>()
    fun inorder(root: TreeNode?) {
        if (root == null) return
        inorder(root.left)
        list.add(root.`val`)
        inorder(root.right)   
    }
}