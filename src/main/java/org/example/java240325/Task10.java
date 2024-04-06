package org.example.java240325;

public class Task10 {
    //    Найдите сумму элементов массива, которые находятся между первым и
//    последним положительными элементами.
    public static void main(String[] args) {
        int[] array = {-11, -11,2 , 3,4, 5, 6, 1, -1};
        System.out.println(getSumBetweenPositiveElem(array));
    }

    public static int getSumBetweenPositiveElem(int[] array) {
        int firstPositiveIndex =0;
        int lastPositiveIndex =0;
        boolean firstPosInd = false;
        boolean lastPosInd = false;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                firstPositiveIndex = i;
                if (firstPositiveIndex >= 0) {
                    firstPosInd = true;
                    break;
                }
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > 0) {
                lastPositiveIndex = i;
                if (lastPositiveIndex >= 0) {
                    lastPosInd = true;
                    break;
                }
            }
        }
        for (int i = firstPositiveIndex +1 ; i < lastPositiveIndex ; i++) {
            if (firstPosInd == true || lastPosInd == true) {
                sum += array[firstPositiveIndex+1];
                firstPositiveIndex++;
            }
        }
        return sum;
    }
}
