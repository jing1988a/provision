package fb.hard;///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */
//public class Codec {
//    int start=0;
//    int end=0;
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if(root==null){return "#";}
//        return String.valueOf(root.val)+","+serialize(root.left)+","+serialize(root.right);
//
//
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if(data==null || data.length()==0 || data.charAt(0)=='#'){return null;}
//        String[] dArray=data.split(",");
//        TreeNode root=new TreeNode(Integer.valueOf(dArray[0]) );
//        this.start=1;
//        this.end=dArray.length;
//        root.left=recur(dArray);
//        root.right=recur(dArray);
//        return root;
//    }
//    private TreeNode recur(String[] dArray){
//        if(this.start>=this.end || dArray[this.start].equals("#")){  //'#' is wrong because it is a char
//            this.start++;
//            return null;
//        }
//        TreeNode root=new TreeNode(Integer.valueOf(dArray[this.start]) );
//        this.start++;
//        root.left=recur(dArray);
//        root.right=recur(dArray);
//        return root;
//
//
//    }
//
//}
//Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
//        Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
//        Example:
//
//        You may serialize the following tree:
//
//        1
//        / \
//        2   3
//        / \
//        4   5
//
//        as "[1,2,3,null,null,4,5]"
//        Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//
//        Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
//





import java.util.ArrayList;
import java.util.List;

public class SerializeandDeserializeBinaryTree297 {
    // Encodes a tree to a single string.
    int start=0;
    int end=0;
    public String serialize(TreeNode root) {
        if(root==null){return "#";}
        String l=serialize(root.left);
        String r=serialize(root.right);
        return String.valueOf(root.val)+","+l+","+r;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dList=data.split(",");
        int l=dList.length;
        if(l==0 || dList[0]=="#"){return null;}
        TreeNode root=new TreeNode(Integer.parseInt(dList[0]));
        this.start=1;
        this.end=l-1;
        root.left=recur(dList);
        root.right=recur(dList);
        return root;
    }

    private TreeNode recur(String[] dList){
        if(this.start>this.end || dList[this.start].equals("#")){ //   =='#' is wrong because it is a char
            this.start++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(dList[this.start]));
        this.start++;
        root.left=recur(dList);
        root.right=recur(dList);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }

}
