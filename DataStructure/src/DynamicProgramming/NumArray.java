package DynamicProgramming;

public class NumArray {
//    private int[] nums;
//    public NumArray(int[] nums) {
//        this.nums=nums;
//    }
//
//    public int sumRange(int left, int right) {
//        int sum=0;
//        for(int i =left;i<=right;i++){
//            sum+=nums[i];
//        }
//        return sum;
//    }

    /**
     * 303. Range Sum Query - Immutable (Easy)
     */

    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

    /**
     * 413. Arithmetic Slices (Medium)
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null||nums.length<3){return 0;}
        int n=nums.length;
        int[] dp=new int[n]; //
        int sum=0;
        for (int i=2;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1;
            }
        }
        for (int d : dp) {
            sum+=d;
        }
        return sum;
    }
}
