/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
         public TreeNode buildBT(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, HashMap<Integer, Integer> inorderIndexMap) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootVal = root.val;
        int i = inorderIndexMap.get(rootVal); // Optimized with map lookup
        int leftSize = i - inStart;
        int rightSize = inEnd - i;

        root.left = buildBT(inorder, postorder, inStart, i - 1, postStart, postStart + leftSize - 1, inorderIndexMap);
        root.right = buildBT(inorder, postorder, i + 1, inEnd, postEnd - rightSize, postEnd - 1, inorderIndexMap);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildBT(inorder, postorder, 0, n - 1, 0, n - 1, inorderIndexMap);
    }
}