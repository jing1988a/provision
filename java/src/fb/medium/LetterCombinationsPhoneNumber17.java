package fb.medium;//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
//        A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//        Example:
//
//        Input: "23"
//        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//self.int_str = [[], [], ['a', 'b', 'c'], ['d', 'e', 'f'], ['g', 'h', 'i'], ['j', 'k', 'l'], ['m', 'n', 'o'],
//        ['p', 'q', 'r', 's'], ['t', 'u', 'v'], ['w', 'x', 'y', 'z']]

// question will input string contains 1 or 0 ?????


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsPhoneNumber17 {
    public List<String> letterCombinations(String digits) {
        HashMap<Character , char[]> digitToChar=new HashMap<>();
        digitToChar.put('2' , new char[] {'a' , 'b' , 'c'});
        digitToChar.put('3' , new char[] {'d' , 'e' , 'f'});
        digitToChar.put('4' , new char[] {'g' , 'h' , 'i'});
        digitToChar.put('5' , new char[] {'j' , 'k' , 'l'});
        digitToChar.put('6' , new char[] {'m' , 'n' , 'o'});
        digitToChar.put('7' , new char[] {'p' , 'q' , 'r' , 's'});
        digitToChar.put('8' , new char[] {'t' , 'u' , 'v'});
        digitToChar.put('9' , new char[] {'w' , 'x' , 'y' , 'z'});
        int l=digits.length();
        List<String> ans=new ArrayList<>();
        if(l==0){return ans;}
        dfs(digits , 0 ,  l , new StringBuilder() , ans , digitToChar);
        return ans;
    }
    private void dfs(String digits , int idx , int l , StringBuilder candidate , List<String> ans , HashMap<Character , char[]> digitToChar){
        if(idx==l){
            ans.add(candidate.toString());
            return;
        }
        for(char c:digitToChar.get(digits.charAt(idx))){
            candidate.append(c);
            dfs(digits , idx+1 , l , candidate , ans , digitToChar );
            candidate.deleteCharAt(candidate.length()-1);
        }

    }
}
