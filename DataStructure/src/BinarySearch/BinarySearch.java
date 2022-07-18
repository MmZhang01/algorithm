package BinarySearch;


/**
 * 每次查找后，对集合折半，时间复杂度为 O(logN)
 * 注意判断边界值  循环条件  退出循环时指针的状态
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
        if(x<=1){
            return x;
        }
        int l =1, h=x;
        while(l<=h){
            int mid = l+(h-l)/2;
            int sqr= mid*mid;
            if(sqr==x){
                return mid;
            }else if(sqr>x){
                h=mid-1;
            }else {
                l=mid+1;
            }
        }return h;
    }

    /**
     * 744. Find Smallest Letter Greater Than Target (Easy)
     */


}

