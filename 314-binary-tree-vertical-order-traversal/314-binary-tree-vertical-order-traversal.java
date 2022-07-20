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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if (root == null) {
            return ans;
        }
        
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        Map<Integer, ArrayList> colTable = new HashMap();
        int colIndex = 0;
        queue.offer(new Pair(root, colIndex));
        colTable.put(colIndex, new ArrayList<Integer>());
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            colIndex = p.getValue();
            
            if (root != null) {
                if (!colTable.containsKey(colIndex)) {
                    colTable.put(colIndex, new ArrayList<Integer>());
                }
                colTable.get(colIndex).add(root.val);
                
                queue.offer(new Pair(root.left, colIndex - 1));
                queue.offer(new Pair(root.right, colIndex + 1));
            }
        }
        
        List<Integer> sortedKeys = new ArrayList<Integer>(colTable.keySet());
        Collections.sort(sortedKeys);
        for (int col: sortedKeys) {
            ans.add(colTable.get(col));
        }
        
        return ans;
        
    }
}