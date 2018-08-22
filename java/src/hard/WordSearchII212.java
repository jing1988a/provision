package hard;//Given a 2D board and a list of words from the dictionary, find all words in the board.
//
//        Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
//
//        Example:
//
//        Input:
//        words = ["oath","pea","eat","rain"] and board =
//        [
//        ['o','a','a','n'],
//        ['e','t','a','e'],
//        ['i','h','k','r'],
//        ['i','f','l','v']
//        ]
//
//        Output: ["eat","oath"]


import java.util.*;

public class WordSearchII212 {
    //    public List<String> findWords(char[][] board, String[] words) {
//
//        List<String> ans=new ArrayList();
//        int n=board.length;
//        if(n==0){return ans;}
//        int m=board[0].length;
//        if(m==0){return ans;}
//        Set<String> wordSet=new HashSet(Arrays.asList(words));
//        for(String w:wordSet){
//            check(board , w , ans  ,  0  , w.length() , n , m);
//
//        }
//        return ans;
//    }
//    private void check(char[][] board , String w , List<String> ans , int idx , int l , int n , int m){
//        if(l==0){return;}
//        for(int i=0 ; i<n ; i++){
//            for(int j=0 ; j<m ; j++){
//                if(board[i][j]==w.charAt(0)){
//                    boolean[][] visited=new boolean[n][m];
//
//                    if(dfs(board , w , 0 , i , j, l , n , m , visited)){
//                        ans.add(w);
//                        return;
//                    }
//                }
//            }
//        }
//
//    }
//
//    private boolean dfs(char[][] board , String w , int idx , int i , int j ,int l , int n , int m  , boolean[][] visited){
//        if(idx==(l-1)){
//            return true;
//        }
//        visited[i][j]=true;
//        int[][] directions={{1, 0}, {-1 , 0} , {0 , -1} , {0 , 1}};
//        for(int[] d:directions){
//            int nextI=i+d[0];
//            int nextJ=j+d[1];
//            if(nextI>=0&&nextI<n&&nextJ>=0&&nextJ<m&&visited[nextI][nextJ]==false&&board[nextI][nextJ]==w.charAt(idx+1)){
//                if(dfs(board , w,   idx+1 , nextI , nextJ , l , n , m  , visited)){
//                    return true;
//                }
//            }
//        }
//        visited[i][j]=false; //重要 不然出bug
//        return false;
//
//    }
//
//    static public void main(String[] args){
//        WordSearchII212 test=new WordSearchII212();
//        char[][] board={{'a','b','c'}, {'a','e','d'},{'a','f','g'}};
//        String[] word={"eaabcdgfa"};
//        List<String> ans=test.findWords(board , word);
//        System.out.println(ans);
//    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();
        for (String w : words) {
            t.addWord(w);
        }
        int n = board.length;
        int m = board[0].length;
        List<String> ans = new ArrayList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] visited = new boolean[n][m];
                Node node = t.root;
                dfs(board, i, j, node, ans, visited, t, n, m);
            }
        }
        return ans;

    }

    private void dfs(char[][] board, int i, int j, Node node, List<String> ans, boolean[][] visited, Trie t, int n, int m) {
        if (!node.children.containsKey(board[i][j])) {
            return;
        }
        node = node.children.get(board[i][j]);
        visited[i][j] = true;
        if (node.isEnd) {
            ans.add(node.word);
            t.delete(node.word);
        }
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] d : direction) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                dfs(board, x, y, node, ans, visited, t, n, m);
            }
        }
        visited[i][j] = false;

    }


    class Trie {
        Node root=new Node();

        public void addWord(String word) {
            Node cur = this.root;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Node());
                }
                cur = cur.children.get(c);
            }
            cur.isEnd = true;
            cur.word = word;
        }

        public void delete(String w) {
            Node cur = this.root;
            Stack<List> stack = new Stack();
            for (char c : w.toCharArray()) {
                List temp = new ArrayList();
                temp.add(c);
                temp.add(cur);
                cur = cur.children.get(c);
            }
            cur.isEnd = false;
            cur.word = null;
            if (cur.children.isEmpty()) {
                while (!stack.isEmpty()) {
                    List e = stack.pop();
                    char c = (char) e.get(0);
                    Node n = (Node) e.get(1);
                    n.children.remove(c);
                    if(!n.children.isEmpty()){
                        break;
                    }
                }

            }
        }

    }

    class Node {
        boolean isEnd = false;
        String word = null;
        Map<Character, Node> children = new HashMap();
    }

}


//Input: [["a","b","c"],
//        ["a","e","d"],
//        ["a","f","g"]]
//
//        ["abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"]
//        Output:
//        ["befa","abcdefg","gfedcbaaa"]
//        Expected:
//        ["abcdefg","befa","eaabcdgfa","gfedcbaaa"]