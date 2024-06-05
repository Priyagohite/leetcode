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
         private HashMap<Integer, Integer> mp = new HashMap<>();

    public TreeNode construct(int[] preorder, int[] inorder, int l, int r, int[] idx) {
        if (l > r)
            return null;

        int rootVal = preorder[idx[0]];
        idx[0]++;
        int i = mp.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = construct(preorder, inorder, l, i - 1, idx);
        root.right = construct(preorder, inorder, i + 1, r, idx);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mp.clear();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            mp.put(inorder[i], i);
        }

        int[] idx = {0};
        return construct(preorder, inorder, 0, n - 1, idx);

    }
}