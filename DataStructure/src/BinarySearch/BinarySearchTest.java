package BinarySearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void testMySquare(){
        int input1 =4;
        int input2=8;
        int m=2;
        int output=BinarySearch.mySqurt(input1);
        assertEquals(m,output);
    }
    @Test
    public void testNextGreatestLetter(){
        char[] input = new char[]{'c','f','j'};
        char target = 'j';
        System.out.println(BinarySearch.nextGreatestLetter(input,target));
    }

    @Test
    public void testSingleNonDuplicate(){
        int[] input = new int[]{1,1,2,3,3,4,4,8,8};
        int[] input2 = new int[]{3,3,7,7,10,11,11};
        System.out.println(BinarySearch.singleNonDuplicate(input2));
    }



}
