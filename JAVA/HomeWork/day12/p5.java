package day12;

import java.util.Stack;
//leetcode 150 逆波兰表达式求值
public class p5 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop()+stack.pop());
            }else if (s.equals("-")) {
                stack.push(-stack.pop()+stack.pop());
            }else if (s.equals("*")) {
                stack.push(stack.pop()*stack.pop());
            }else if (s.equals("/")) {
                int tmp = stack.pop();
                stack.push(stack.pop() / tmp);
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
