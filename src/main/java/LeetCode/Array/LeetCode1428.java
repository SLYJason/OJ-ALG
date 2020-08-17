package LeetCode.Array;

import java.util.LinkedList;
import java.util.List;

public class LeetCode1428 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);
        int currRow = 0, currCol = cols-1;
        int index = currCol;
        while(currRow < rows && currCol >=0) {
            if(binaryMatrix.get(currRow, currCol) == 1) {
                index = currCol;
                currCol--;
            } else {
                currRow++;
            }
        }
        return index == currCol ? -1 : index;
    }
}

class BinaryMatrix {
    private int[][] matrix;
    private int rows;
    private int cols;
    public BinaryMatrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }
    public List<Integer> dimensions() {
        List<Integer> dimensions = new LinkedList<>();
        dimensions.add(rows);
        dimensions.add(cols);
        return dimensions;
    }

    public int get(int row, int col) {
        return matrix[row][col];
    }
}
