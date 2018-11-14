package fb.medium;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Given an input string , reverse the string word by word.
//
//        Example:
//
//        Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//        Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
//        Note:
//
//        A word is defined as a sequence of non-space characters.
//        The input string does not contain leading or trailing spaces.
//        The words are always separated by a single space.
//        Follow up: Could you do it in-place without allocating extra space?
public class ReverseWordsinStringII186 {
    public void reverseWords(char[] str) {
        int l=str.length;
        reverse(str , 0 , l-1);
        int pre=0;
        for(int i=0 ; i<l ;  i++){
            if(str[i]==' '){
                reverse(str , pre , i-1);
                pre=i+1;
            }
        }
        reverse(str , pre , l-1);
    }
    private void reverse(char[] str , int start , int end){
        while(start<end){
            char temp=str[end];
            str[end]=str[start];
            str[start]=temp;
            start++;
            end--;

        }
    }





    public void reverseWordsExtra(char[] str) {
        List<String> sList=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        for(char c:str){
            if(c==' '){
                sList.add(temp.toString());
                sList.add(" ");
                temp.delete(0 , temp.length());
            }else{
                temp.append(c);
            }

        }
        sList.add(temp.toString());
        Collections.reverse(sList);
        int i=0;
        for(String s:sList){
            for(char c:s.toCharArray()){
                str[i]=c;
                i++;
            }
        }
    }
}
