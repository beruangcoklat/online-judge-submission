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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        
        val list = mutableListOf(root)
        val result = mutableListOf<List<Int>>()
        while (list.isNotEmpty()) {
            val row = mutableListOf<Int>()
            for (i in 0 until list.size) {
                val curr = list[0]!!
                list.removeAt(0)

                row.add(curr.`val`)

                curr.left?.let { list.add(it) }
                curr.right?.let { list.add(it) }
            }
            result.add(row)
        }
        return result
    }
}