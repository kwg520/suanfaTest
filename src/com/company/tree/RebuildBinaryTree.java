package com.company.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RebuildBinaryTree {


    public static void main(String[] args) {

    }


    static Map<Integer,Integer> inorderMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i <inorder.length ; i++) {
             inorderMap.put(inorder[i],i);
        }
        return  buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

    private static TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if(preLeft > preRight || inLeft >inRight){
            return null ;
        }
        int rooValue = preorder[preLeft];
        TreeNode root = new TreeNode(rooValue);
        int pIndex = inorderMap.get(rooValue);
        root.left = buildTree(preorder,preLeft+1,preLeft + pIndex - inLeft, inorder,inLeft,pIndex-1);
        root.right = buildTree(preorder,preLeft+pIndex-inLeft+1,preRight,inorder,pIndex+1,inRight);
        return root ;

    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
