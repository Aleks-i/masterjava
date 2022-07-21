package ru.javaops.masterjava.matrix;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * gkislin
 * 03.07.2016
 */
public class MatrixUtil {

    // TODO implement parallel multiplication matrixA*matrixB
    public static int[][] concurrentMultiply(int[][] matrixA, int[][] matrixB, ExecutorService executor) throws InterruptedException, ExecutionException {
        final int matrixSize = matrixA.length;
        final int[][] matrixC = new int[matrixSize][matrixSize];

        return getMultiplyMatrixVarA(matrixA, matrixB, matrixC, matrixSize, executor);
    }

    // TODO optimize by https://habrahabr.ru/post/114797/
    public static int[][] singleThreadMultiply(int[][] matrixA, int[][] matrixB) {
        final int matrixSize = matrixA.length;
        final int[][] matrixC = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            calcRows(i, matrixA, matrixB, matrixC);
        }

        return matrixC;
    }

    public static int[][] create(int size) {
        int[][] matrix = new int[size][size];
        Random rn = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rn.nextInt(10);
            }
        }
        return matrix;
    }

    public static boolean compare(int[][] matrixA, int[][] matrixB) {
        final int matrixSize = matrixA.length;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] getMultiplyMatrixVarA(int[][] matrixA, int[][] matrixB, int[][] matrixC,
                                                 int matrixSize, ExecutorService executor) {
        final CompletionService<Void> completionService = new ExecutorCompletionService<>(executor);
        final ArrayList<Future<Void>> futures = new ArrayList<>();

        for (int i = 0; i < matrixSize; i++) {
            final int finalI = i;
            futures.add(completionService.submit(() -> calcRows(finalI, matrixA, matrixB, matrixC), null));
        }

        while (!futures.isEmpty()) {
            futures.remove(completionService.poll());
        }
        return matrixC;
    }

    private static void calcRows(int rowNum, int[][] matrixA, int[][] matrixB, int[][] matrixC) {

        final int matrixSize = matrixA.length;
        int[] bColumn = new int[matrixSize];

        for (int j = 0; j < matrixSize; j++) {
            bColumn[j] = matrixB[j][rowNum];
        }

        for (int j = 0; j < matrixSize; j++) {

            int sum = 0;
            int[] aRow = matrixA[j];
            for (int k = 0; k < matrixSize; k++) {
                sum += aRow[k] * bColumn[k];
            }
            matrixC[rowNum][j] = sum;
        }
    }
}