package DailyPractice;

import org.junit.Test;

public class DailyPractice8 {
    @Test
    public static void main(String[] args){
        int i=0,j=0;
//        while(i<10){
//            i++;
//            ++j;
//            System.out.println("i="+i);
//            System.out.println("j="+j);
//        }
        for(i=0;i<10;){
            int a=i++;
            int b=++i;
            System.out.println("a="+a);
            System.out.println("b="+b);
        }

    }

}
