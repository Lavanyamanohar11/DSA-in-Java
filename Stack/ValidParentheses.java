// https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else{
                if(st.isEmpty()) return false;
                int top = st.pop();
                if((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{'))
                    continue;
                return false;
            }
        }
        return st.isEmpty();
    }
}
