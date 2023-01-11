package AllTypes.Sort;

public class SortImpl {
    /**
     * 75. Sort Colors
     * @param nums
     */
    public void sortColors(int[] nums) {
        sort(nums,0,nums.length-1);
    }

    private void sort(int[] nums,int i,int j){
        if(j<=i) return;
        int m = partition(nums,i,j);
        sort(nums,i,m-1);
        sort(nums,m+1,j);
    }
    private int partition(int[] nums, int l ,int h){
        int i = l,j = h+1;
        int m = nums[l];
        while (true){
            while (less(m,nums[++i])&&i<h);
            while (less(nums[--j],m)&&j>l);
            if(i>=j) break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }
    private boolean less(int i,int j){
        if(i<j) return true;
        else return false;
    }
    private void swap(int[] nums, int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    /**
     * 215. Kth Largest Element in an Array
     * @param nums
     * @param k
     * @return
     */
    // quick selection  to quick search from an unordered array
    // binary search + partition
    public int findKthLargest(int[] nums, int k) {
        int l =-1,r = nums.length;
        while (l+1!=r){
            int m = partition(nums,l+1,r-1);
            if(m<k){
                l=m;
            }else r=m;
        }
        return nums[l];
    }
}
