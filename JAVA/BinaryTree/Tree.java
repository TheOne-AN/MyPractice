import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    //二叉树前序遍历leetcode144

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ret.add(root.val);
        ret.addAll(preorderTraversal(root.left));
        ret.addAll(preorderTraversal(root.right));
        return ret;
    }
    //二叉树中序遍历leetcode94
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ret.addAll(inorderTraversal(root.left));
        ret.add(root.val);
        ret.addAll(inorderTraversal(root.right));
        return ret;
    }
    //二叉树后序遍历lletcode145
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ret.addAll(postorderTraversal(root.left));
        ret.addAll(postorderTraversal(root.right));
        ret.add(root.val);
        return ret;
    }
    //判断两棵树是否相同LeetCode100
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return  false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    //判断t是不是s的子树LeetCode572
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return isSameTree(s,t);
        }
        boolean ret = false;
        if (!ret) {
            ret = isSubtree(s.left,t);
        }
        if (!ret) {
            ret = isSubtree(s.right,t);
        }
        return ret;
    }
    //二叉树的最大深度LeetCode104
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1+Math.max(left,right);
    }
    //判断一棵树是不是平衡二叉树LeetCode110
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    //判断一棵树是不是对称二叉树LeetCode101
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left,TreeNode right) {
        if (left == null && right ==null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
    //按层遍历二叉树LeetCode102
    //创建一个表用来存每层的数据
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return list;
        }
        //构造辅助函数从0层开始遍历
        helper(root,0);
        return list;
    }
    private void helpercoverage(TreeNode root,int level) {
        if (level == list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        if (root.left != null) {
            helpercoverage(root.left,level+1);
        }
        if (root.right != null) {
            helpercoverage(root.right,level+1);
        }
    }
    //二叉树的最近公共祖先LeetCode236
    //不会
    TreeNode ancestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findAncestor(root,p,q);
        return ancestor;
    }
    private boolean findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = findAncestor(root.left,p,q)?1:0;
        int right = findAncestor(root.right,p,q)?1:0;
        int mid = (root == p || root == q)?1:0;
        if (left + right + mid >= 2) {
            ancestor = root;
        }
        return (right + left + mid) > 0;
    }
    //将一个二叉搜索树转化为排序的双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null ||(pRootOfTree.left == null
                && pRootOfTree.right ==null)) {
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right !=  null) {
            leftTail = leftTail.right;
        }
        if (leftTail != null) {
            pRootOfTree.left = leftTail;
            leftTail.right = pRootOfTree;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left == null ? pRootOfTree : left;
    }
}
