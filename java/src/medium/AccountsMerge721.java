package medium;//Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
//
//        Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
//
//        After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
//
//        Example 1:
//        Input:
//        accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
//        Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//        Explanation:
//        The first and third John's are the same person as they have the common email "johnsmith@mail.com".
//        The second John and Mary are different people as none of their email addresses are used by other accounts.
//        We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
//        ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
//        Note:
//
//        The length of accounts will be in the range [1, 1000].
//        The length of accounts[i] will be in the range [1, 10].
//        The length of accounts[i][j] will be in the range [1, 30].


import java.util.*;

public class AccountsMerge721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Union1 u=new Union1();
        HashMap<String , String> emailNameDict=new HashMap<>();
        for(List<String> a:accounts){
            String name=a.get(0);
            String email1=a.get(1);
            emailNameDict.put(email1 , name);
            String p1=u.findP(email1);
            int i=2;
            while(i<a.size()){
                String email=a.get(i);  //注意
                emailNameDict.put(email , name);  //注意
                String p=u.findP(email);
                u.unionP(p , p1);
                i++;
            }
        }
        HashMap<String , List<String>> parentEmailsDict=u.getParentEmailsDict();
        List<List<String>> ans=new ArrayList<>();
        for(String parent : parentEmailsDict.keySet()){
            List<String> emails= parentEmailsDict.get(parent);
            Collections.sort(emails);
            emails.add(0 , emailNameDict.get(parent));
            ans.add(emails);
        }
        return ans;

    }



//    Input:
//            [["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],["David","David4@m.co","David5@m.co"],["David","David2@m.co","David3@m.co"],["David","David1@m.co","David2@m.co"]]
//    Output:
//            [["David","David4@m.co","David5@m.co"],["David","David0@m.co","David1@m.co","David2@m.co"],["David","David3@m.co"]]
//    Expected:
//            [["David","David0@m.co","David1@m.co","David2@m.co","David3@m.co","David4@m.co","David5@m.co"]]
//
//


    static public void main(String args[]){
        List<List<String>> accounts=new ArrayList<>();
        accounts.add(Arrays.asList("David","David0@m.co","David1@m.co"));
        accounts.add(Arrays.asList("David","David3@m.co","David4@m.co"));
        accounts.add(Arrays.asList("David","David4@m.co","David5@m.co"));
        accounts.add(Arrays.asList("David","David2@m.co","David3@m.co"));
        accounts.add(Arrays.asList("David","David1@m.co","David2@m.co"));
        AccountsMerge721 test=new AccountsMerge721();
        test.accountsMerge(accounts);
    }






    class Union1{
        HashMap<String , String> dict=new HashMap<>();
        public String findP(String  v){
            if(!this.dict.containsKey(v)){
                this.dict.put(v, v);
            }
            if(this.dict.get(v)==v){
                return v;
            }
            String p=findP(this.dict.get(v));
            this.dict.put(v , p);
            return p;

        }
        public void unionP(String pa , String pb){
            if(pa.equals(pb)){
                return;
            }
            this.dict.put(pa , pb);
        }
        public HashMap<String , List<String >>  getParentEmailsDict(){
            HashMap<String , List<String>> ans=new HashMap<>();
            for(String v:this.dict.keySet()){
                String p=findP(v);  //  这里要注意
                if(!ans.containsKey(p)){
                    List<String> temp=new ArrayList<>();
                    temp.add(v);
                    ans.put(p , temp);
                }else{
                    ans.get(p).add(v);
                }
            }
            return ans;
        }
    }
}


