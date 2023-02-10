package DailyPractice;

import org.junit.Test;

import java.util.*;

public class DailyPractice41 {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UF uf = new QuickUnionUF(26);
        int n = s1.length();
        for(int i=0;i<n;i++){
            uf.union(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        int n1=baseStr.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n1;i++){
            sb.append((char)(uf.find(baseStr.charAt(i)-'a')+'a'));
        }
        return sb.toString();

    }

    private abstract class UF {

        protected int[] id;

        public UF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public abstract int find(int p);

        public abstract void union(int p, int q);
    }
    private class QuickUnionUF extends UF {

        public QuickUnionUF(int N) {
            super(N);
        }


        @Override
        public int find(int p) {
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }


        @Override
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            // follow the lexicographic
            if (pRoot != qRoot) {
                if(pRoot<qRoot){
                    id[qRoot]=pRoot;
                }else id[pRoot] = qRoot;
            }
        }
    }

    /**
     * 491. Non-decreasing Subsequences
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ret = new HashSet<>();
        for(int i= 0;i<nums.length;i++){
            List<Integer> list1 = new ArrayList<>();
            list1.add(nums[i]);
            dfs(nums,i,ret,list1);
        }
        return new ArrayList<>(ret);

    }

    private void dfs(int[] nums, int idx,Set<List<Integer>> list,List<Integer> list1){
        int n = nums.length;
        if(idx>=n-1) return;
        for(int i =idx+1; i<n;i++){
            if(nums[i]>=nums[idx]){
                List<Integer> tmp  = new ArrayList<>(list1);
                tmp.add(nums[i]);
                list.add(tmp);
                dfs(nums,i,list,tmp);
            }
        }
    }

    /**
     * 93. Restore IP Addresses
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs1(result,"",s,0);
        return result;
    }

    private void dfs1(List<String> result, String path, String s, int k){
        if(s.isEmpty()|| k == 4 ){
            if(s.isEmpty()&& k==4) result.add(path.substring(1));
            return;
        }

        for(int i =1;i<=(s.charAt(0)=='0'?1:3)&& i<=s.length();i++){ // length of substr from 1 to 3 and avoid leading 0
            String part = s.substring(0,i);
            if(Integer.valueOf(part)<=255){
                dfs1(result,path+"."+part,s.substring(i),k+1);
            }
        }
    }


    // dfs
    // four thing to track
    // 1. result
    // 2. data that need to handle 
    // 3. current situation to deep research
    // 4. end judge
    @Test
    public void testRestoreIpAddresses(){
        System.out.println(restoreIpAddresses("25525511135"));
    }


    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs2(s,res,new ArrayList<>());
        return res;
    }

    private void dfs2(String s,List<List<String>> res, List<String> cur){
        if(s.equals("")){
            res.add(cur);
            return;
        }
        int n = s.length();
        if(n==1) {
            cur.add(s);
            res.add(cur);
            return;
        }
        for(int i = 1;i<=n;i++){
            if(isPalindrome(s.substring(0,i))){
                List<String> tmp = new ArrayList<>(cur);
                tmp.add(s.substring(0,i));
                dfs2(s.substring(i),res,tmp);
            }
        }
    }
    private boolean isPalindrome(String s){
        int n = s.length();
        int i=0,j=n-1;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void testPartition(){
        System.out.println(partition("aab"));
    }


    /**
     * 997. Find the Town Judge
     * @param n
     * @param trust
     * @return
     */
    public int findJudge(int n, int[][] trust) {
        // one could get max n-1 trust by other
        // find the one
        // if one trust other it could never get to n-1 trust
        // two person get nerver get to n-1 trust same time
        int[] count = new int[n+1];
        for(int[] t:trust){
            count[t[0]]--;// trust other
            count[t[1]]++;// trust by other
        }
        for(int i=1;i<=n;i++){
            if(count[i]==n-1) return i;
        }
        return -1;

    }

}
