package DailyPractice;

import org.junit.Test;

import java.util.*;

public class DailyPractice35 {
    //hash table / heap

    /**
     * 1657. Determine if Two Strings Are Close
     * @param word1
     * @param word2
     * @return
     */
    public boolean closeStrings(String word1, String word2) {
        // 1. judge if these two strings contain all the same char
        // 2. judge if the number of char in these two strings are same
        boolean judge1=false,judge2=true;
        int n1= word1.length(),n2=word2.length();
        if(n1!=n2) return false;
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        HashSet<Character> set1= new HashSet<>();
        HashSet<Character> set2 = new HashSet();
        for(int i=0;i<n1;i++ ){
            set1.add(word1.charAt(i));
            arr1[word1.charAt(i)-'a']+=1;
        }
        for(int i=0;i<n2;i++ ){
            set2.add(word2.charAt(i));
            arr2[word2.charAt(i)-'a']+=1;
        }
        if(set1.containsAll(set2)&&set2.containsAll(set1)){
            judge1=true;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<26;i++){
            if (arr1[i]!=arr2[i]){
                judge2=false;
            }
        }
        return judge2&&judge1;
    }

    @Test
    public void testCloseStrings(){
        System.out.println(closeStrings(
                "aaabbbbccddeeeeefffff",
                "aaaaabbcccdddeeeeffff"));
//        Set<Integer> set1 =  new HashSet<>(Arrays.asList(1,2,3));
//        Set<Integer> set2 =  new HashSet<>(Arrays.asList(1,2,3));
//        System.out.println(set1.containsAll(set2));
    }


    /**
     * 451. Sort Characters By Frequency
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        // hash map+heap
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            int tmp = map.getOrDefault(c,0)+1;
            map.put(c,tmp);
        }
        PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        queue.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            Map.Entry<Character,Integer> e= queue.poll();
            int tmp = e.getValue();
            while(tmp--!=0){
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }

//  writ comparator for treemap
    Map treeMap = new TreeMap<>(new Comparator<Map.Entry<String, String>>(){

        public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2 )
        {
            if (o1.getKey().length() > o2.getKey().length()) {
                return 1;
            }
            if (o1.getKey().length() > o2.getKey().length()) {
                return -1;
            }
            return o1.getKey().compareTo(o2.getKey());
        }

    });

    /**
     * 973. K Closest Points to Origin
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {

        // here we use heap
        // we can also use quick selection
        PriorityQueue<Map.Entry<int[],Integer>> queue = new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
        for(int[] point:points){
            int dis = point[0]*point[0]+point[1]*point[1];
            HashMap<int[],Integer> tmp = new HashMap<>();
            tmp.put(point,dis);
            queue.addAll(tmp.entrySet());
        }
        int[][] ret = new int[k][2];
        for(int i=0;i<k;i++){
            ret[i] = queue.poll().getKey();
        }
        return ret;
    }

    /**
     * 6. Zigzag Conversion
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        // one zigzag is numRows+numRows-2
        // cut the string to n zigzag  (n=s.length()/zigzag)
        // the gap is a constant for each new row
        if(numRows==1) return s;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int zigzag = numRows*2-2; // number of chars at each set

        for(int currentRow =0;currentRow<numRows;currentRow++){
            int index = currentRow;

            while(index<n){
                sb.append(s.charAt(index));

                // if it is not the first or last row the gap is different
                if(currentRow!=0&&currentRow!=numRows-1){
                    int charInBetween = zigzag-2*currentRow;
                    int secondIndex = index+charInBetween;

                    if(secondIndex<n){
                        sb.append(s.charAt(secondIndex));
                    }
                }
                index+=zigzag;  // jump to next set
            }
        }
        return sb.toString();

    }

    /**
     * 938. Range Sum of BST
     * @param root
     * @param low
     * @param high
     * @return
     */

// BST , for one node, its left node smaller than this, right node bigger than this
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int ret=0;
        if(root.val<=high && root.val>=low){
            ret+=root.val+rangeSumBST(root.right,low,high)+rangeSumBST(root.left,low,high);
        }
        if(root.val<low){
            ret+=rangeSumBST(root.right,low,high);
        }
        if(root.val>high){
            ret+=rangeSumBST(root.left,low,high);
        }
        return ret;
    }

    /**
     * 872. Leaf-Similar Trees
     * @param root1
     * @param root2
     * @return
     */


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = findLeaf(root1);
        List<Integer> list2 = findLeaf(root2);
        int n1=list1.size(),n2=list2.size();
        if(n1!=n2) return false;
        for(int i=0;i<n1;i++){
            if(list1.get(i)!=list2.get(i)) return false;
        }
        return true;



    }
    private List<Integer> findLeaf(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        if(root.left==null&&root.right==null){
            list.add(root.val);
        }
        list.addAll(findLeaf(root.left));
        list.addAll(findLeaf(root.right));
        return list;
    }


    /**
     * 1026. Maximum Difference Between Node and Ancestor
     * @param root
     * @return
     */

    // dfs

    public int maxAncestorDiff(TreeNode root) {
        if (root== null) return 0;
        int ret = dfs(root,root.val,root.val);
        return  ret;
    }
    private int dfs(TreeNode root,int max,int min){
        if(root==null) return 0;
        max = Math.max(max,root.val);
        min = Math.min(min,root.val);
        int l = dfs(root.left,max,min);
        int r = dfs(root.right,max,min);
        return Math.max(max-min,Math.max(l,r));
    }


}
