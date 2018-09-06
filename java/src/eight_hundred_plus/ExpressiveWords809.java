package eight_hundred_plus;
//Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  Here, we have groups, of adjacent letters that are all the same character, and adjacent characters to the group are different.  A group is extended if that group is length 3 or more, so "e" and "o" would be extended in the first example, and "i" would be extended in the second example.  As another example, the groups of "abbcccaaaa" would be "a", "bb", "ccc", and "aaaa"; and "ccc" and "aaaa" are the extended groups of that string.
//
//        For some given string S, a query word is stretchy if it can be made to be equal to S by extending some groups.  Formally, we are allowed to repeatedly choose a group (as defined above) of characters c, and add some number of the same character c to it so that the length of the group is 3 or more.  Note that we cannot extend a group of size one like "h" to a group of size two like "hh" - all extensions must leave the group extended - ie., at least 3 characters long.
//
//        Given a list of query words, return the number of words that are stretchy.
//
//        Example:
//        Input:
//        S = "heeellooo"
//        words = ["hello", "hi", "helo"]
//        Output: 1
//        Explanation:
//        We can extend "e" and "o" in the word "hello" to get "heeellooo".
//        We can't extend "helo" to get "heeellooo" because the group "ll" is not extended.
//        Notes:
//
//        0 <= len(S) <= 100.
//        0 <= len(words) <= 100.
//        0 <= len(words[i]) <= 100.
//        S and all words in words consist only of lowercase letters
public class ExpressiveWords809 {
    public int expressiveWords(String S, String[] words) {
//        String newS=reduce(S);
        int ans=0;
        for(String w:words){
            if(isMatch(S , w)){
                ans++;
            }
        }
        return ans;
    }

//     private String reduce(String S ){
//         StringBuilder ans=new StringBuilder();
//         int count=1;
//         int l=S.length();
//         for(int i=1 ; i<l ; i++){
//             if(S.charAt(i)!=S.charAt(i-1)){
//                 if(count>=3){
//                     ans.append(S.charAt(i-1));
//                 }else{
//                     for(int t=0 ; t<count ; t++){
//                         ans.append(S.charAt(i-1));
//                     }
//                 }
//                 count=1;
//             }else{
//                 count++;
//             }
//         }
//         if(count>=3){
//             ans.append(S.charAt(l-1));
//         }else{
//             for(int t=0 ; t<count ; t++){
//                 ans.append(S.charAt(l-1));
//             }
//         }
//         return ans.toString();

    //     }
    private boolean isMatch(String str , String candidate){
        int ls=str.length();
        int lc=candidate.length();
        int startS=0;
        int startC=0;
        while(startS<ls &&startC<lc){
            char curS=str.charAt(startS);
            char curC=candidate.charAt(startC);
            int countS=0;
            int countC=0;
            if(curC!=curS){
                return false;
            }
            while(startS<ls && str.charAt(startS)==curS){
                startS++;
                countS++;
            }
            while(startC<lc && candidate.charAt(startC)==curC){
                startC++;
                countC++;
            }
            if(countS<countC || (countS>countC && countS==2 )){
                return false;
            }
        }
        return startS==ls && startC==lc;
    }
}
