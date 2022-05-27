package yxl;

import java.util.ArrayList;
import java.util.List;

public class Spiral_matrix {
    private int[][] matrix;

    public Spiral_matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public List<Integer> displaySpiral_matrix() {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int h = matrix.length;// hang
        int l = matrix[0].length;// lie
        int z = 0;
        int s = 0;
        int y = l - 1;
        int x = h - 1;
        while (z <= y && s <= x) {
            for (int i = z; i <= y; i++) {
                order.add(matrix[s][i]);
            }
            for (int i = s + 1; i <= x; i++) {
                order.add(matrix[i][y]);
            }
            if (z < y && s < x) {
                for (int i = y - 1; i > z; i--) {
                    order.add(matrix[x][i]);
                }
                for (int i = x - 1; i > s; i--) {
                    order.add(matrix[i][z]);
                }
            }
            z++;
            y--;
            s++;
            x--;
        }
        return order;
    }
}
