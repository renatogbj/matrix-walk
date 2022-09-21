package com.asml;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MatrixWalkTest {

    private MatrixWalk matrixWalk;

    @Before
    public void setUp() {
        this.matrixWalk = new MatrixWalk();
    }

    /**
     * This is the matrix provided in the assignment
     */
    @Test
    public void mustTraverseSquareMatrixInSpiralOrder() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        matrixWalk.spiral(matrix);
        var order = matrixWalk.getOrder();
        var expectedOrder = List.of(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10);
        assertEquals(expectedOrder, order);
    }

    // I chose to test if the solution would work on non-square matrices, hence the tests below

    @Test
    public void mustTraverseTallMatrixInSpiralOrder() {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
                { 10, 11, 12 }
        };
        matrixWalk.spiral(matrix);
        var order = matrixWalk.getOrder();
        var expectedOrder = List.of(1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8);
        assertEquals(expectedOrder, order);
    }

    @Test
    public void mustTraverseWideMatrixInSpiralOrder() {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        matrixWalk.spiral(matrix);
        var order = matrixWalk.getOrder();
        var expectedOrder = List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        assertEquals(expectedOrder, order);
    }

}
