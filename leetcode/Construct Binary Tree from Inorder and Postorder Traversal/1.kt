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
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (postorder.isEmpty()) return null

        val root = TreeNode(postorder[postorder.size - 1])

        val rootIdxInInorder = inorder.indexOf(postorder[postorder.size - 1])
        val leftSubTree = inorder.slice(0 until rootIdxInInorder)
        val rightSubTree = inorder.slice(rootIdxInInorder + 1 until postorder.size)

        root.left = buildTree(leftSubTree.toIntArray(), postorder.filter { leftSubTree.contains(it) }.toIntArray())
        root.right = buildTree(rightSubTree.toIntArray(), postorder.filter { rightSubTree.contains(it) }.toIntArray())
        return root
    }
}