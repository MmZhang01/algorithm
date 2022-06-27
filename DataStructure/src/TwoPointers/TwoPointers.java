package TwoPointers;

public class TwoPointers {

    public int[] TwoSum(int[] numbers, int target){
        if (numbers == null){return null;}
        int i =0;
        int j = numbers.length-1;
        while (i<j){
            if (numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }
            else if (numbers[i]+numbers[j]< target){
                i++;
            }
            else {
                j--;
            }
        }
        return null;
    }

    public boolean judgeSquareSum(int target){
        if (target < 0){return false;}

        int i = 0, j =(int)Math.sqrt(target);
        while(i<j){
            int powSum = i*i+j*j;
            if (powSum==target){
                return true;
            }else if (powSum<target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }


}
