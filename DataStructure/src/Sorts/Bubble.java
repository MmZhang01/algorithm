package Sorts;

public class Bubble<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean isSorted = false;
        for (int i = N-1; i >0 && !isSorted; i--) {
            isSorted=true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j+1],nums[j])) {
                    swap(nums,j,j+1);
                    isSorted=false; // 如果此条命令未运行，表明排序已完成，循环终止
                }
            }
        }
    }
}
