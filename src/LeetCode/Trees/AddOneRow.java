package Trees;


import static Trees.KthSmallestElement.print;

public class AddOneRow {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode rL = new TreeNode(2);
        TreeNode rR = new TreeNode(6);
        TreeNode rLL = new TreeNode(3);
        TreeNode rLR = new TreeNode(1);
        TreeNode rRL = new TreeNode(5);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.left = rRL;
        print(root);
        System.out.println();
        int val = 1;
        int depth = 1;
//        TreeNode answer =  addOneRow(root,val,depth);
        TreeNode answer =  addOneRowBetter(root,val,depth);
        print(answer);
    }
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null){
            return null;
        }
        else if(depth==1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        else if(depth==2){
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode node1 = new TreeNode(val);
            TreeNode node2 = new TreeNode(val);
            root.left = node1;
            root.right = node2;
            node1.left = left;
            node2.right = right;
            return root;
        }
        else{
        root.left = addOneRow(root.left,val,depth-1);
        root.right = addOneRow(root.right,val,depth-1);
        }
        return root;
    }
    public static TreeNode addOneRowBetter(TreeNode root, int val, int depth) {
        if(root==null){
            return null;
        }
        else if(depth==1){
            return new TreeNode(val,root,null);
        }
        else if(depth==2){
            root.left = new TreeNode(val,root.left,null);
            root.right = new TreeNode(val,null,root.right);
            return root;
        }
        else{
            root.left = addOneRow(root.left,val,depth-1);
            root.right = addOneRow(root.right,val,depth-1);
        }
        return root;
    }
}
