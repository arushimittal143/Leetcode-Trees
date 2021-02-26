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
    static int Index=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) { 
        int n=postorder.length;
        Index=n-1;
        return Tree(inorder,postorder,0,n-1);
    }
    public static TreeNode Tree(int in[],int post[],int is,int ie)
    {
        if(is>ie)
            return null;
        TreeNode node=new TreeNode(post[Index]);
        Index--;
        if(is==ie)
            return node;
        int iIndex = search(in, is, ie, node.val);
        node.right=Tree(in,post,iIndex+1,ie);
        node.left=Tree(in,post,is,iIndex-1);
        return node;
    }
     static int search(int arr[], int start, int end, int value)
     {
         int i;
      for(i=start;i<=end;i++)
        {
            if(arr[i]==value)
                break;
        }    
         return i;
     }
}
