package com.asml;

import java.util.ArrayList;
import java.util.List;

public class MatrixWalk {

    private final List<Integer> order = new ArrayList<>();

    public List<Integer> getOrder() {
        return order;
    }

    public void spiral(int[][] matrix) {
        // these variables are indices that delimiter the sides of the matrix
        // they increase/decrease when a row or column is traversed
        // virtually reducing the size of the matrix
        var topRow = 0;
        var leftCol = 0;
        var bottomRow = matrix.length;
        var rightCol = matrix[0].length;

        // stops when one side reaches the other
        while (topRow < bottomRow && leftCol < rightCol) {

            traverseForward(matrix, topRow, leftCol, rightCol);
            topRow++;

            traverseDownward(matrix, rightCol - 1, topRow, bottomRow);
            rightCol--;

            if (topRow < bottomRow) {
                traverseBackward(matrix, bottomRow - 1, rightCol - 1, leftCol);
                bottomRow--;
            }

            if (leftCol < rightCol) {
                traverseUpward(matrix, leftCol, bottomRow - 1, topRow);
                leftCol++;
            }
        }
    }

    private void traverseForward(int[][] matrix, int row, int from, int to) {
        for (int i = from; i < to; i++) {
            traverse(matrix[row][i]);
        }
    }

    private void traverseDownward(int[][] matrix, int col, int from, int to) {
        for (int i = from; i < to; i++) {
            traverse(matrix[i][col]);
        }
    }

    private void traverseBackward(int[][] matrix, int row, int from, int to) {
        for (int i = from; i >= to; i--) {
            traverse(matrix[row][i]);
        }
    }

    private void traverseUpward(int[][] matrix, int col, int from, int to) {
        for (int i = from; i >= to; i--) {
            traverse(matrix[i][col]);
        }
    }

    private void traverse(int value) {
        System.out.print(value + ", ");
        order.add(value);
    }

}
