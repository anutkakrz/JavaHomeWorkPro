package org.example.java240409;

public class Matrix {

    public static void main(String[] args) {
        int[][] matrix = {{2, 3, 5, 6, 9},
                          {4, 7, 8, 11, 13},
                         {14, 19, 25, 26, 27},
                         {15, 21, 28, 33, 36},
                         {24, 29, 44, 55, 66}};
        int num = 0;//
//        System.out.println(numInMatrix(matrix, 100));
        System.out.println(numInMatrix1(matrix, 24));


    }
    public static boolean numInMatrix (int[][] matrix, int num){
       boolean numberInMatrix = false;
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = matrix.length-1; j >0 ; j--) {
                while (num > matrix[i][j]){
                    i++;
                }while (num < matrix[i][j]) {
                    j--;
                }if (num == matrix[i][j]) {
                    numberInMatrix = true;
                    break;
                }
            }break;
        }return numberInMatrix;
    }
    public static boolean numInMatrix1 (int[][] matrix, int findMe){
        int count = 0;

        for (int i = 0; i < matrix.length ; i++) {
            if (matrix[i][matrix[i].length-1]<findMe){
                count++;
                continue;
            }
            for (int j = matrix[i].length-1; j >=0; j--) {
                count++;
                if (matrix[i][j]==findMe){
                    System.out.println(count);
                    return true;}
                if (matrix[i][j]<findMe) {
                    j++;
                    i++;
                }
            }
        }
        System.out.println(count);
        return false;
    }
}