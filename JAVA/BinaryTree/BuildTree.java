package BinaryTree;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class BuildTree {
    public static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode(char val) {
            this.val = val;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            TreeNode root = buildTree(line);
            inorder(root);
            System.out.println();
        }
    }
    //index用来标记字符的下标
    static int index = 0;
    public static TreeNode buildTree(String line) {
        index = 0;
        return creatTree(line);
    }
    //根据字符串构建一棵树
    private static TreeNode creatTree(String line) {
        char c = line.charAt(index);
        if (c == '#') {
            return null;
        }
        //递归创建左子树和右子树
        TreeNode root = new TreeNode(c);
        index++;
        root.left = creatTree(line);
        index++;
        root.right = creatTree(line);
        return root;
    }
    //中序遍历二叉树
    private static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
}
