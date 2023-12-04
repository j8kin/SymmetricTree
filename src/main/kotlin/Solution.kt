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
    private fun path(left: TreeNode?, right: TreeNode?): Boolean {
       when {
           (left != null && right != null) -> {
               if (left.`val` != right.`val`) {
                   return false
               }
               val ok = path(left.left,right.right)
               if (!ok) {
                   return false
               }
               return path(left.right,right.left)
           }
           (left == null && right == null) -> {
                return true
           }
           else -> return false
       }
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return path(root.left, root.right)
    }
}