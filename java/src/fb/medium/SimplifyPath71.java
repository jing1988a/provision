package fb.medium;//Given an absolute path for a file (Unix-style), simplify it.
//
//        For example,
//        path = "/home/", => "/home"
//        path = "/a/./b/../../c/", => "/c"
//
//        Corner Cases:
//
//        Did you consider the case where path = "/../"?
//        In this case, you should return "/".
//        Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//        In this case, you should ignore redundant slashes and return ""/home/foo".


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath71 {
    public String simplifyPath(String path) {
        String[] paths=formatPath(path);
        Stack<String> stack=new Stack<>();
        for(String p:paths){
            if(p.equals(".")){continue;}
            if(p.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(p);
            }
        }
//        List<String> temp=new ArrayList<>(stack);

        return "/"+String.join("/" , stack);
    }

    private String[] formatPath(String path){
        String[] temp=path.split("/");
        List<String> ans=new ArrayList<>();
        for(String s:temp){
            if(s.length()>0){
                ans.add(s);
            }

        }
        return ans.toArray(new String[0]);
    }
}
