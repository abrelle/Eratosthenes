public class Sieve {
    private static boolean[] arrayOfNumbers;
    private final int upperBound;

    public Sieve(int upperBound) {
        this.upperBound = upperBound;
        arrayOfNumbers = new boolean[upperBound];

        for (int i = 0; i < upperBound; ++i) {
            arrayOfNumbers[i] = i >= 2;
        }
    }

    public void removeNumbers(int index) {
        for (int j = (int) Math.pow(index, 2); j < upperBound; j += index) {
            arrayOfNumbers[j] = false;
        }
    }

    public boolean[] getArrayOfNumbers() {
        return arrayOfNumbers;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void printNumbers(){
        for(int i = 2; i < arrayOfNumbers.length; ++i){
            if(arrayOfNumbers[i]){
                System.out.print(i + " ");
            }
        }
    }

    public int getNumPrimes(){
        int number = 0;
        for(int i = 2; i < arrayOfNumbers.length; ++i){
            if(arrayOfNumbers[i]){
                ++number;
            }
        }
        return number;
    }
}
