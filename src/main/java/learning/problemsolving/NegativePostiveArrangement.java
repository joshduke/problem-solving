package learning.problemsolving;

public class NegativePostiveArrangement {


    private int[] arrageNegativePositive(int[] inputArry) {

        int leftPointer = 0;
        int rightPointer = inputArry.length - 1;
        while(leftPointer <= rightPointer) {
            int tmpValue;
            if(inputArry[leftPointer] >= 0) {
                if(inputArry[rightPointer] < 0) { // Swap
                    tmpValue = inputArry[leftPointer];
                    inputArry[leftPointer] = inputArry[rightPointer];
                    inputArry[rightPointer] = tmpValue;
                    leftPointer++;
                    rightPointer--;
                } else { // positive
                    rightPointer--;
                }
            } else {
                leftPointer++;
            }

            /**
             * if left pointer is -ve, ignore (left++)
             * if right pointer is +ve, ignore (right--)
             *
             */
        }

        return inputArry;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        Integer[] inputNumbers = Arrays.stream(input.split(" "))
//                .map(inputValue -> Integer.parseInt(inputValue))
//                .toArray(Integer[]::new);
//        int[] intValues = new int[inputNumbers.length];
//        int index = 0;
//        for(Integer value : inputNumbers) {
//            intValues[index] = value.intValue();
//            index++;
//        }

        int [] inputTest = {-12, -11, -13, -5, -6, -7, -5, -3, -6};
        int[] arrangedArray = new NegativePostiveArrangement().arrageNegativePositive(inputTest);

        for(int arrayValue : arrangedArray) {
            System.out.print(arrayValue + "\t");
        }


    }


}
