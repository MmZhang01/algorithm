package Greedy;

import java.util.Arrays;

/**
 * 保证每次的结果都是局部最优
 * making the locally optimal choice at each stage
 */

public class Greedy {

    public static int findContentChildren(int[] grid, int[] size){
        if (grid == null || size == null) { return 0;}
        Arrays.sort(grid);
        Arrays.sort(size);
        int gri=0,siz=0;
        while(gri<grid.length && siz<size.length){
            if(grid[gri]<= size[siz]){
                gri++;
            }
            siz++;
        }
        return gri;
    }


}
