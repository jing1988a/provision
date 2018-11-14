package eight_hundred_plus;
//There are N dominoes in a line, and we place each domino vertically upright.
//
//        In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
//
//
//
//        After each second, each domino that is falling to the left pushes the adjacent domino on the left.
//
//        Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
//
//        When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
//
//        For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
//
//        Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
//
//        Return a string representing the final state.
//
//        Example 1:
//
//        Input: ".L.R...LR..L.."
//        Output: "LL.RR.LLRRLL.."
//        Example 2:
//
//        Input: "RR.L"
//        Output: "RR.L"
//        Explanation: The first domino expends no additional force on the second domino.
//        Note:
//
//        0 <= N <= 10^5
//        String dominoes contains only 'L', 'R' and '.'
public class PushDominoes838 {
    public String pushDominoes(String dominoes) {
        int l=dominoes.length();
        int[] idxs=new int[l+2];
        char[] symbols=new char[l+2];
        idxs[0]=-1;
        symbols[0]='L';
        int cur=1;
        for(int i=0 ; i<l  ; i++){
            char c=dominoes.charAt(i);
            if(c!='.'){
                idxs[cur]=i;
                symbols[cur]=c;
                cur++;
            }
        }
        idxs[cur]=l;
        symbols[cur]='R';
        char[] ans=dominoes.toCharArray();
        cur++;
        for(int i=0 ; i<cur-1 ; i++){
            int lIdx=idxs[i];
            int rIdx=idxs[i+1];
            char lSymbol=symbols[i];
            char rSymbol=symbols[i+1];
            int start=lIdx+1;
            int end=rIdx-1;
            if(lSymbol==rSymbol){
                while(start<=end){
                    ans[start]=rSymbol;
                    ans[end]=rSymbol;
                    start++;
                    end--;
                }
            }else{
                if(lSymbol=='L'){
                    continue;
                }else{
                    while(start<end){
                        ans[start]=lSymbol;
                        ans[end]=rSymbol;
                        start++;
                        end--;
                    }
                }
            }
        }
        return String.valueOf(ans);



    }
    // public String pushDominoes(String dominoes) {
    //     String curState=dominoes;
    //     while(true){
    //         String nextState=getNextState(curState);
    //         if(nextState.equals(curState)){
    //             break;
    //         }
    //         curState=nextState;
    //     }
    //     return curState;
    // }
    // private String getNextState(String curState);
    // simulation  .this takes O(N^2) which is not good
}
