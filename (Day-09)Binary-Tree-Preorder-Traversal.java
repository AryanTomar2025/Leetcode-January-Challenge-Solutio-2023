class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> preorderList = new ArrayList<>();
        helper(root , preorderList);
        return preorderList;
    }
    public void helper(TreeNode node , ArrayList<Integer>preorderList){
        if(node== null)return ;

        preorderList.add(node.val);
        helper(node.left,preorderList);
        helper(node.right,preorderList);
    }
}
