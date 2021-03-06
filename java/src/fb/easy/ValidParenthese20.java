package fb.easy;

import java.util.HashMap;
import java.util.Stack;

//
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Note that an empty string is also considered valid.
//
//        Example 1:
//
//        Input: "()"
//        Output: true
//        Example 2:
//
//        Input: "()[]{}"
//        Output: true
//        Example 3:
//
//        Input: "(]"
//        Output: false
//        Example 4:
//
//        Input: "([)]"
//        Output: false
//        Example 5:
//
//        Input: "{[]}"
//        Output: true
public class ValidParenthese20 {
    public boolean isValid(String s) {
        HashMap<Character , Character> pairMap=new HashMap<>();
        pairMap.put('}' , '{');
        pairMap.put(']' , '[');
        pairMap.put(')' , '(');
        String leftPair="([{";
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(leftPair.indexOf(c)!=-1){
                stack.push(c);
            }else{
                if (stack.isEmpty() || stack.pop()!=pairMap.get(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}
