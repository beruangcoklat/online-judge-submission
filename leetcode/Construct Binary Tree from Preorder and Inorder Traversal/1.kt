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
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null

        val root = TreeNode(preorder[0])

        val rootIdxInInorder = inorder.indexOf(preorder[0])
        val leftSubTree = inorder.slice(0 until rootIdxInInorder)
        val rightSubTree = inorder.slice(rootIdxInInorder + 1 until preorder.size)

        root.left = buildTree(preorder.filter { leftSubTree.contains(it) }.toIntArray(), leftSubTree.toIntArray())
        root.right = buildTree(preorder.filter { rightSubTree.contains(it) }.toIntArray(), rightSubTree.toIntArray())
        return root
    }
}