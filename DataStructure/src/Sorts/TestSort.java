package Sorts;

public class TestSort {

    public static void testsort(){
        Integer[] meng = new Integer[]{2,6,5,3,22,9,8};
//        String[] meng = new String[]{"2","6","5","3","22","9","8"};
//        Selection<Integer> ob1=new Selection<>();
//        Bubble<Integer> ob2 = new Bubble<>();
        Insertion<Integer> ob3 = new Insertion<>();
//        ob1.sort(meng);
//        ob2.sort(meng);
        ob3.sort(meng);
        for (int s : meng) {
            System.out.println(s);

        }
    }

    public static void main(String[] args){
        testsort();
    }



//    public static void main(String[] args){
//        int[] meng = new int[]{2,6,4,3,10,9,8};
//
//        Selection ob1=null;
//        System.out.println(ob1.sort(meng));
//
//    }
}
