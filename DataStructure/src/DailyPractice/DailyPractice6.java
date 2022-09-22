package DailyPractice;

public class DailyPractice6 {
    /**
     * 985. Sum of Even Numbers After Queries
     * @param nums
     * @param queries
     * @return
     */
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int S = 0;
        for (int num : nums) {
            if(num%2==0){
                S+=num;
            }
        }
        int[] ret = new int[n];
        for(int i =0;i<n;i++){
            int var = queries[i][0],index=queries[i][1];
            if(nums[index]%2==0){
                S-=nums[index];
            }
            if((nums[index]+var)%2==0){
                S+=nums[index]+var;
            }
            nums[index]+=var;
            ret[i] = S;
        }
        return ret;
    }
}
