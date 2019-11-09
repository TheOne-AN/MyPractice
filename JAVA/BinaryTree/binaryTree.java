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
	 //将一个二叉搜索树转化为一个排序的双向链表
    //left指向根节点的前一个元素，right指向根节点的后一个元素
    //这就是一个双向的链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        //递归把左子树变成双向链表，返回这个链表的第一个节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        //找到左子树的尾结点，让尾结点和头结点相互指向
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        //循环结束leftTail指向左子树的最后一个节点
        //left可能是null
        if (left != null) {
            //和根节点相互指向
            pRootOfTree.left = leftTail;
            leftTail.right = pRootOfTree;
        }
        //递归构造右子树的双向链表
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        //返回链表的头结点
        return left == null ? pRootOfTree : left;
    }
    //根据一棵树的前序遍历结果和中序遍历结果构建二叉树
    private int index = 0; //记录访问到那个字符了
    public TreeNode buildTree(int[] preorder, int[] inorder) {
            index = 0;//每次构建之前置为0；
        return helpeBuildtree(preorder,inorder,0,inorder.length);
    }
    private TreeNode helpeBuildtree(int [] preorder,int[] inorder,
                                    int inorderLeft,int inorderRight) {
          //非法情况，这个子树没有中序遍历结果
        if (inorderLeft >= inorderRight) {
                return null;
            }
            //所要取得元素下标越界，返回
        if (index >= preorder.length) {
            return null;
        }
        //取出当前index下标对应的值，构造树
        TreeNode root = new TreeNode(preorder[index]);
        index++;//下标加一，取下一个元素的位置下标
        //找到该节点在中序遍历结果中的位置
        int pos = find(inorder,inorderLeft,inorderRight,root.val);
        root.left = helpeBuildtree(preorder,inorder,inorderLeft,pos);
        root.right = helpeBuildtree(preorder,inorder,pos+1,inorderRight);
        return root;
    }
    private int find(int[] inorder,int inorderLeft,int inorderRight,int val) {
        for (int i = inorderLeft; i < inorderRight; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
    //leetcode :606. 根据二叉树创建字符串
    //创建一StringBuilder对象用来存储字符串，apend方法用来添加字符
    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        //如果是空树，返回null
        if (t == null) {
            return null;
        }
        tree2strHelper(t);
        //因为根节点不需要括号，所以去点第一个元素和最后一个元素
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
    private void tree2strHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        //先序遍历完成递归
        stringBuilder.append("(");
        //访问当前节点
        stringBuilder.append(root.val);
        //访问左子树
        tree2strHelper(root.left);
        if (root.left == null && root.right!= null) {
            stringBuilder.append("()");
        }
        //访问右子树
        tree2strHelper(root.right);
        stringBuilder.append(")");
    }
    //非递归二叉树遍历
    //前序遍历
    public List<Integer> preorderTraversal2(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            //创建一个栈
            Stack<TreeNode> stack = new Stack<>();
            //将根节点入栈
            stack.push(root);
            while (!stack.isEmpty()) {
                //先出栈，然后将右子树和左子树入栈
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null ) {
                    stack.push(node.right);
                }
                if (node.left != null ) {
                    stack.push(node.left);
                }
            }
            return result;
    }
    //非递归中序遍历一颗二叉树
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result  = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            //cur不为null，就入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.pop();
            result.add(top.val);
            cur = top.right;
        }
        return result;
    }
    //非递归后序遍历二叉树
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //prve指向上次访问的节点
        TreeNode prve = null;
        while (true) {
            //把左子树统统入栈，栈顶为最左边的节点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            //将最左边的节点拿出来
            TreeNode top = stack.peek();
            //如果该节点的右子树为空，就可以将该节点元素添加到数组
            if (top.right == null || prve == top.right) {
                result.add(top.val);
                stack.pop();
                prve = top;
            }else {
                //右子树不为空，循环将右子树入栈
                cur = top.right;
            }
        }
        return result;
    }
}
