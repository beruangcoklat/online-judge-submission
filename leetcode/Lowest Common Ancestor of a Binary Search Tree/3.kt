/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val parentMap: MutableMap<TreeNode, TreeNode?> = mutableMapOf()
        traverse(root, parentMap)

        val parents = mutableSetOf<Int>()
        var p = p
        while (p != null) {
            parents.add(p.`val`)
            p = parentMap[p]
        }

        var q = q
        while (q != null) {
            if (q.`val` in parents) return q
            q = parentMap[q]
        }

        return null
    }

    private fun traverse(root: TreeNode?, parentMap: MutableMap<TreeNode, TreeNode?>) {
        if (root == null) return

        root.left?.let { left ->
            parentMap[left] = root
        }
        root.right?.let { right ->
            parentMap[right] = root
        }
        traverse(root.left, parentMap)
        traverse(root.right, parentMap)
    }
}