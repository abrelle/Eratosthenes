public class NumberSeeder {

    private static boolean [] arrayOfNumbers;
    private int lastPrime = 1;

    public NumberSeeder(boolean [] arrayOfNumbers){
        NumberSeeder.arrayOfNumbers = arrayOfNumbers;
    }

    public int getLastPrime() {
        return lastPrime;
    }

    public synchronized int getNextPrime(){
        for(int i = lastPrime + 1; i < Math.sqrt(arrayOfNumbers.length); ++i){
            if(arrayOfNumbers[i]){
                lastPrime = i;
                return i;
            }

        }
        return -1;
    }
}
