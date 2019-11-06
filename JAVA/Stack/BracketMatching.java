package Stack;

import java.util.Stack;

public class BracketMatching {
    public static void main(String[] args){
        BracketMatching S = new BracketMatching();
        boolean ret = S.isValid("}");
        System.out.println(ret);
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //左括号入栈
            if (ch == '(' || ch == '{'|| ch == '['){
                stack.push(ch);
                continue;
            }
            //不是左括号，栈为空，返回false
            if (stack.isEmpty()) {
                return false;
            }
            //右括号，出栈，取出栈顶元素
            char top = stack.pop();
            //检查栈顶元素和当前元素是否匹配
            if (top == '('&& ch == ')') {
                continue;
            }
            if (top == '{'&& ch == '}') {
                continue;
            }
            if (top == '['&& ch == ']' ){
                continue;
            }
            //没有匹配到，返回false
            return false;
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
