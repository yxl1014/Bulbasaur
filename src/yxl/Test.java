package yxl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[][] datas={
                {1,1,1,1,1},
                {1,2,2,2,1},
                {1,2,3,2,1},
                {1,2,2,2,1},
                {1,1,1,1,1}
        };
        List<Integer> integers = new Spiral_matrix(datas).displaySpiral_matrix();
        for(Integer i:integers){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
