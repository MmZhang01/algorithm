package BinarySearch;


import org.junit.Test;

/**
 * 每次查找后，对集合折半，时间复杂度为 O(logN)
 * 注意判断边界值  循环条件  退出循环时指针的状态
 *
 * l=-1,r=N
 * while l+1!=r
 *      m = (l+r)/2
 *      if IsBlue(m)
 *          l=m
 *      else
 *          r=m
 * return l or r
 *
 * 以上将区域分为蓝红两块   初始下表为 -1 和  N
 * 循环过程中，红蓝区域逐渐靠近，直到l+1=r
 */

public class BinarySearch {
//    public int binarySearch(int[] nums,int key){
//        int l =0,h=nums.length-1;
//        while (l<=h){            //l>h时退出循环
//            int m = l+(h-l)/2;  // 避免溢出 compare to (l+h)/2
//            if(nums[m]==key){
//                return m;
//            }else if (nums[m]>key){
//                h=m-1;
//            }else{
//                l=m+1;
//            }
//        }
//        return -1;   //没找到
//    }
    /*
    * 变种，如果存在相同的key，返回最左侧的一个。
    * */
    public static int binarySearch(int[] nums, int key) {
        int l = 0, h = nums.length;
        while (l < h) {  //可能存在l=h 无法退出循环..l=h时退出循环
            int m = l + (h - l) / 2;
            if (nums[m] >= key) {  // 出现等于的情况，还须进行循环，判断是否为最左侧
                h = m;    // m下标需再次进入循环判断
            } else {
                l = m + 1;
            }
        }
        return l;    //key应该在的位置

    }

    /**
     * 69. Sqrt(x) (Easy)
     */
    public static int mySqurt(int x){
//        if(x<=1){
//            return x;
//        }
//        int l =1, h=x;
//        while(l<=h){
//            int mid = l+(h-l)/2;
//            if(x/mid==mid){
//                return mid;
//            }else if(x/mid<mid){
//                h=mid-1;
//            }else {
//                l=mid+1;
//            }
//        }return h;
        int l =0,r=x;
        while(l+1!=r){
            int m = (l+r)/2;
            if(x/m>=m){
                l=m;
            }else{
                r=m;
            }
        }
        return l;
    }



    /**
     * 744. Find Smallest Letter Greater Than Target (Easy)
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        int l =-1,r=letters.length;
        while(l+1!=r){
            int m = l+(r-l)/2;
            if(letters[m]<=target){
                l=m;
            }else r=m;
        }
        return r==letters.length?letters[0]:letters[r];
    }

    /**
     * 540. Single Element in a Sorted Array (Medium)
     */
    public static int singleNonDuplicate(int[] nums) {
        int l = -1, r =nums.length;
        while(l+1!=r){
            int m = l+(r-l)/2;
            if(m%2==0){
                if(m==nums.length-1) return nums[m];
                if(nums[m]==nums[m+1]) {
                    l = m;
                }else r=m;
            }
            if(m%2==1){
                if(nums[m]==nums[m-1]){
                    l=m;
                } else r=m;
            }

        }
        return nums[r];
    }

}

