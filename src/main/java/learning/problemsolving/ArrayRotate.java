package learning.problemsolving;

public class ArrayRotate {

    public static void main(String[] args) {
        int[] inputValues = {0, 4, 5, 7, 10};

        System.out.print("Left Array Rotate -->");
        for (int value : new ArrayRotate().leftArrayRotate(inputValues, 3)) {
            System.out.print(value + "\t");
        }
        System.out.print("\n");
        System.out.print("Right` Array Rotate -->");
        for (int value : new ArrayRotate().rightArrayRotate(inputValues, 3)) {
            System.out.print(value + "\t");
        }
    }

    private int[] leftArrayRotate(int[] inputArry, int degree) {
        int k = degree % inputArry.length;
        reverseArrayInPlace(inputArry, 0, k-1);
        reverseArrayInPlace(inputArry, k, inputArry.length - 1);
        reverseArrayInPlace(inputArry, 0, inputArry.length - 1);
        return inputArry;
    }

    private int[] rightArrayRotate(int[] inputArry, int degree) {
        int k = degree % inputArry.length;
        reverseArrayInPlace(inputArry, 0, inputArry.length - 1);
        reverseArrayInPlace(inputArry, 0, k-1);
        reverseArrayInPlace(inputArry, k, inputArry.length - 1);
        return inputArry;
    }

    private int[] reverseArrayInPlace(int[] arr, int start, int end) {
        int temp;
        int leftPointer = start;
        int rightPointer = end;
        while(leftPointer < rightPointer) {
            temp = arr[leftPointer];
            arr[leftPointer] = arr[rightPointer];
            arr[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
        return  arr;
    }

}
