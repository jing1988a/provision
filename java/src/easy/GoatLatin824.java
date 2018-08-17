package easy;//A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
//
//        We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
//
//        The rules of Goat Latin are as follows:
//
//        If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
//        For example, the word 'apple' becomes 'applema'.
//
//        If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
//        For example, the word "goat" becomes "oatgma".
//
//        Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
//        For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
//        Return the final sentence representing the conversion from S to Goat Latin.
//
//
//
//        Example 1:
//
//        Input: "I speak Goat Latin"
//        Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
//        Example 2:
//
//        Input: "The quick brown fox jumped over the lazy dog"
//        Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
//
//
//        Notes:
//
//        S contains only uppercase, lowercase and spaces. Exactly one space between each word.
//        1 <= S.length <= 150.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoatLatin824 {

    private String[] myToArray(String S) {

        String[] ans = S.trim().split(" ");
        List<String> ans2 = new ArrayList<>();
        for (String s : ans) {
//            System.out.println(s);
            if (s.length() > 0) {
                ans2.add(s);
            }
        }
        return ans2.toArray(new String[0]);
    }

    public String toGoatLatin(String S) {
        String[] sArray = myToArray(S);
        List<String> ansList = new ArrayList<>();
        int l = sArray.length;
        if (l == 0) {
            return "";
        }
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < l; i++) {
            String curS = sArray[i];
            StringBuilder temp = new StringBuilder();
            if (vowels.indexOf(curS.charAt(0)) != -1) {
                temp.append(curS);
            } else {
                temp.append(curS.substring(1));
                temp.append(curS.charAt(0));
            }
            temp.append("ma");
            StringBuilder paddingA = new StringBuilder();
            for (int j = 0; j < i + 1; j++) {
                paddingA.append('a');
            }
            temp.append(paddingA);
            ansList.add(temp.toString());
        }

//        StringBuilder realAns = new StringBuilder();
//        for (String s : ansList) {
//            realAns.append(s);
//            realAns.append(' ');
//        }
//        realAns.deleteCharAt(realAns.length() - 1);
//        return realAns.toString();
        return String.join(" " , ansList); // 就是上面的简化一下啦

    }


//    static public void main(String[] args) {
//        GoatLatin824 test = new GoatLatin824();
//
//        System.out.println(test.toGoatLatin(" a     c"));
//
//    }


}
