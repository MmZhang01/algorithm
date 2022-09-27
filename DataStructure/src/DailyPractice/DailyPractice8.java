package DailyPractice;

import org.junit.Test;

public class DailyPractice8 {
    /**
     * 838. Push Dominoes
     */
    public String pushDominoes(String dominoes) {
        /*
	In this approach, you just need to find sections like this
	X .   .   .   . X
	i                j
	Where X can be 'R' or 'L' and in between there can be as many dots
	Now,
	- you know the length of mid part
	- If char[i] == char[j] == 'R', means all go towards right (R)
	-  char[i]  == char[j] == 'L', means all go towards Left (L)
	-  If char[i] = 'L' and char[j] = 'R', means middle part is not affected so they remain '.'
	-  If char[i] = 'R' and char[j] = 'L', then it will affect the middle part.
	   The middle_part/2 close to i will be affected by 'R' and middle_part/2 close to j will be
	   effected by 'L'  and the last mid point (middle_part%2) will be unaffected due to equal
	   force from left and right so it remains '.'
           */
        dominoes= 'L' + dominoes + 'R';
        StringBuilder ret = new StringBuilder();
        for(int i=0,j=1;j<dominoes.length();j++){
            if(dominoes.charAt(j)=='.') continue;
            int middle = j-i-1;
            if (i>0) ret.append(dominoes.charAt(i));
            if(dominoes.charAt(i) == dominoes.charAt(j)){
                for(int k =0;k<middle;k++){
                    ret.append(dominoes.charAt(i));
                }
            }else if(dominoes.charAt(i)=='L'&&dominoes.charAt(j)=='R'){
                for(int k=0;k<middle;k++){
                    ret.append('.');
                }
            }else{
                if(middle%2==1){
                    for(int k=0;k<middle/2;k++){
                        ret.append(dominoes.charAt(i));
                    }
                    ret.append('.');
                    for(int k=0;k<middle/2;k++){
                        ret.append(dominoes.charAt(j));
                    }
                }else{
                    for(int k=0;k<middle/2;k++){
                        ret.append(dominoes.charAt(i));
                    }
                    for(int k=0;k<middle/2;k++){
                        ret.append(dominoes.charAt(j));
                    }
                }
            }
            i=j;
        }
        return new String(ret);
    }

    /**
     * 70. Climbing Stairs
     * @param n
     * @return
     */
    /*
    dynamic programming
     */
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        if(n<2) return dp[n];
        for (int i=2;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    @Test
    public void testClimbStairs(){
        System.out.println(climbStairs(3));
    }
}
