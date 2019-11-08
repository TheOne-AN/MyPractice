package BinaryTree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x)
     { val = x; }
 }
public class binaryTree {
    //返回一个二叉树的先序遍历结果
    public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            //先序遍历，先访问根节点
            result.add(root.val);
            //递归遍历根节点的左子树，插入result
            result.addAll(preorderTraversal(root.left));
            //递归遍历根节点的右子树，插入result
            result.addAll(preorderTraversal(root.right));
            return result;
    }
    //返回一个二叉树的中序遍历结果
    public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return  result;
            }
            //中序遍历，先遍历左子树
            result.addAll(inorderTraversal(root.left));
            //访问根节点
            result.add(root.val);
            //遍历访问右子树
            result.addAll(inorderTraversal(root.right));
            return result;
    }
    //返回后序遍历访问结果
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //先遍历访问左子树
        result.addAll(postorderTraversal(root.left));
        //遍历访问右子树
        result.addAll(postorderTraversal(root.right));
        //访问根节点
        result.add(root.val);
        return result;
    }
    //检查两个树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //判断两个树是否相同
        //1.判断根节点是否相同 2.判断左子树是否相同 3.判断右子树是否相同
        //若两个树都为null，返回true
        if (p == null && q == null) {
            return true;
        }
        //如果两个树中有一个不为空，返回false
        if (p == null || q == null) {
            return false;
        }
        //比较根节点是否相同
        if(p.val != q.val ) {
            return false;
        }
        //递归比较左子树和右子树，返回结果
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    //判断t树是不是s树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //思路：
        //s和t是不是相等  s.left是否包含t  s.right是否包含t
        //若两个都为null,则s包含t
        if (s == null && t == null) {
            return true;
        }
        //如果有一个不为空，返回false
        if (s == null || t == null) {
            return false;
        }
        //两个都不为null，按顺序遍历比较
        boolean ret = false;

        if ( s.val == t.val) {
            ret = isSameTree(s,t);
        }
        //判断s.left是否包含t
        if (!ret) {
            ret = isSubtree(s.left,t);
        }
        //判断s.right是否包含t
        if (!ret) {
            ret = isSubtree(s.right,t);
        }
        return ret;
    }
    //求一颗二叉树的最大深度
    public int maxDepth(TreeNode root) {
        //树的深度 = root + MAX(左子树深度，右子树深度)
        //         = 1 + MAX(左子树深度，右子树深度)
        //1.如果root == null 返回0
        if (root == null) {
            return 0;
        }
        //2.只有根节点，则深度是1
        if (root.left == null && root.right == null) {
            return 1;
        }
        //3.左右子树不全为null
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1+Math.max(leftDepth,rightDepth);
    }
    //判断一棵树是不是平衡二叉树
    //平衡二叉树 ：左右子树深度之差的绝对值<= 1
    public boolean isBalanced(TreeNode root) {
        //如果根节点为空或者只有根节点，则返回true
        if (root == null ||
                (root.left == null && root.right == null)) {
            return true;
        }
        //求左右子树的高度，判断高度差的绝对值>1返回false
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth)>1) {
            return false;
        }
        //递归判断左右子树是不是平衡二叉树
        return isBalanced(root.left) && isBalanced(root.right);
    }
    //判断一棵树是不是对称二叉树
    //对称二叉树： 左子树是右子树的镜像
    public boolean isSymmetric(TreeNode root) {
        //如果root == null ，返回true
        if (root == null) {
            return true;
        }
        //判断左子树和右子树是不是镜像关系
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode left ,TreeNode right) {
        //1.如果左右子树都为null，返回true
        if (left == null && right == null) {
            return true;
        }
        //2.一个为空，一个不为空，返回false
        if (left == null || right == null) {
            return false;
        }
        //3.两个都不为空，判断递归判断是否为镜像
        // a.如果根节点值不相同直接返回false
        if (left.val != right.val) {
            return false;
        }
        // b.递归判断左右子树是否为镜像
        return isMirror(left.left,right.right) &&isMirror(left.right,right.left);
    }
    //按层遍历二叉树
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        //创建一个表，用来存每层的元素；
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        //递归遍历每层？
    }
	   //按层遍历二叉树
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            if (node.left!= null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
    //按层遍历二叉树，并把每一层都存在一个表中
    private List<List<Integer>> result = new ArrayList<>();//创建一个表，用来存每层的数据
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        //构造辅助函数从第0层开始遍历二叉树
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root,int level) {
        if (level == result.size()) {
            //到达第level层还没有对应的数组，则需创建一个数组
            result.add(new ArrayList<>());
        }
        //访问根节点，将val放入数组
        result.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left,level+1);
        }
        if (root.right != null) {
            helper(root.right,level+1);
        }
    }
    //找到结点p和q的最近公共祖先
    private TreeNode ancestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findAncestor(root,p,q);
        return ancestor;
    }
    private boolean findAncestor(TreeNode root,TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        //在左子树中寻找p或q
        int left = findAncestor(root.left,p,q) ? 1:0;
        //在右子树中找p或q
        int right = findAncestor(root.right,p,q)?1:0;
        //当根节点为p或q
        int mid = (root == p || root == q) ?1:0;
        //如果left+mid+right >= 2，则证明root就是p和q的最近公共结点
        if (left+right+mid >= 2 ) {
            ancestor = root;
        }
        return (left+mid+right)> 0;
    }
}
