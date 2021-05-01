import java.util.ArrayList;

public class SieveThread extends Thread {
    private String threadName;
    private static NumberSeeder numberSeeder;
    private static Sieve sieve;
    private ArrayList<Integer> nums = new ArrayList<>();

    public SieveThread(String name, NumberSeeder numberSeeder, Sieve sieve) {
        threadName = name;
        SieveThread.numberSeeder = numberSeeder;
        SieveThread.sieve = sieve;
    }

    public ArrayList<Integer> getNums() {
        return nums;
    }

    public String getThreadName() {
        return threadName;
    }

    public void run() {
        int number = numberSeeder.getNextPrime();
        while(number != -1){
            sieve.removeNumbers(number);
            //nums.add(number);
            number = numberSeeder.getNextPrime();
        }

    }
}
