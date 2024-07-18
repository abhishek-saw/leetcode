package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode889_ConstructFromPrePost {
    public static void main(String[] args) {
        int[] preorder  = {1,2,4,5,3,6,7};
        int[] postorder = {4,5,2,6,7,3,1};
        printBT(constructFromPrePost(preorder,postorder));
    }

    private static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }

    private static TreeNode construct(int[] preorder, int startPre, int endPre, int[] postorder, int startPost , int endPost) {
        if(startPre>endPre ||startPost >endPost){
            return null;
        }
        TreeNode root = new TreeNode(preorder[startPre]);
        if(startPre==endPre){
            return root;
        }
        int index = startPost;
        while(index<endPost){
            if(preorder[startPre+1]==postorder[index]){
                break;
            }
            index++;
        }
        root.left =  construct(preorder,startPre+1,startPre+1+index-startPost,
                postorder,startPost,index);
        root.right =  construct(preorder,startPre+1+index-startPost+1,endPre,
                postorder,index+1,endPost-1);
        return root;
    }
}
