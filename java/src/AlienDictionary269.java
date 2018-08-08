//269. Alien Dictionary
//        DescriptionHintsSubmissionsDiscussSolution
//        There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
//
//        Example 1:
//
//        Input:
//        [
//        "wrt",
//        "wrf",
//        "er",
//        "ett",
//        "rftt"
//        ]
//
//        Output: "wertf"
//        Example 2:
//
//        Input:
//        [
//        "z",
//        "x"
//        ]
//
//        Output: "zx"
//        Example 3:
//
//        Input:
//        [
//        "z",
//        "x",
//        "z"
//        ]
//
//        Output: ""
//
//        Explanation: The order is invalid, so return "".
//        Note:
//
//        You may assume all letters are in lowercase.
//        You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
//        If the order is invalid, return an empty string.
//        There may be multiple valid order of letters, return any one of them is fine.


import java.util.*;


//will there be invalid input?? AKA cycle in the graph????

public class AlienDictionary269 {
    public String alienOrder(String[] words) {
        List data = buildGraph(words);
        Map<Character, Integer> degrees = (Map) data.get(0);
        Set<Character> allNode = (Set) data.get(1);
        Map<Character, Set<Character>> graph = (Map) data.get(2);
        return topologySort(allNode, degrees, graph);
    }

    private List buildGraph(String[] words) {
        int n = words.length;
        Map<Character, Integer> degree = new HashMap();
        Set<Character> allNode = new HashSet();
        Map<Character, Set<Character>> graph = new HashMap();
        List ans = new ArrayList();
        if (n == 0) {
            ans.add(degree);
            ans.add(allNode);
            ans.add(graph);
            return ans;
        }
        for (char c : words[0].toCharArray()) {
            allNode.add(c);
        }
        for (int i = 1; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                allNode.add(c);
            }
            int j = 0;
            int l = words[i - 1].length();
            while (j < l) {
                char a = words[i - 1].charAt(j);
                char b = words[i].charAt(j);
                if (a != b) {
                    if (graph.containsKey(a)) {

                        if(!graph.get(a).contains(b)) {
                            graph.get(a).add(b);

                            if (degree.containsKey(b)) {
                                degree.put(b, degree.get(b) + 1);
                            } else {
                                degree.put(b, 1);
                            }
                        }

                    } else {
                        Set<Character> temp = new HashSet();
                        temp.add(b);
                        graph.put(a, temp);

                        if (degree.containsKey(b)) {
                            degree.put(b, degree.get(b) + 1);
                        } else {
                            degree.put(b, 1);
                        }
                    }


                    break;
                }
                j++;
            }


        }
        ans.add(degree);
        ans.add(allNode);
        ans.add(graph);
        return ans;
    }

    private String topologySort(Set<Character> allNode, Map<Character, Integer> degree, Map<Character, Set<Character>> graph) {
        if (allNode.isEmpty()) {
            return "";
        }
        Stack<Character> q = new Stack();
        for (Character c : allNode) {
            if (!degree.containsKey(c)) {
                q.add(c);

            }
        }
        List<Character> ans=new ArrayList();
        while (!q.isEmpty()) {
            Stack<Character> p = new Stack<>();
            while (!q.isEmpty()) {
                char cur = q.pop();
                allNode.remove(cur);
                ans.add(cur);
                if(graph.containsKey(cur)){
                    for(Character child:graph.get(cur)){
                        int newD= degree.get(child)-1;
                        if(newD==0){
                            degree.remove(newD);
                            p.add(child);
                        }else{
                            degree.put(child , newD);
                        }
                    }
                }
            }
            q=p;

        }
        if(allNode.isEmpty()){
            StringBuilder ansStr=new StringBuilder();
            for(Character c:ans){
                ansStr.append(c);
            }
            return ansStr.toString();
        }else{
            return "";
        }


    }


//
//    Input:
//            ["za","zb","ca","cb"]
//    Output:
//            ""
//    Expected:
//            "abzc"


    static public void main(String[] args){
        AlienDictionary269 test=new AlienDictionary269();
        String[] words={"za","zb","ca","cb"};
        String ans=test.alienOrder(words);
        System.out.println(ans);
    }

}
