import java.util.Arrays;

public class ThreadController {
    static NumberSeeder numberSeeder;
    static Sieve sieve;


    public static void main(String[] args) {
        int number = 2;
        int threads = 1;
        if (args.length > 0) {
            try {
                number = Integer.parseInt(args[0]);
                threads = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Arguments must be an integers.");
                System.exit(1);
            }
        }
        sieve = new Sieve(number);
        numberSeeder = new NumberSeeder(sieve.getArrayOfNumbers());
        SieveThread [] sieveThreads = new SieveThread[threads];
        final long startTime = System.currentTimeMillis();

        for(int i = 0; i < threads; ++i){
            sieveThreads[i] = new SieveThread(String.valueOf(i+1), numberSeeder, sieve);
            sieveThreads[i].start();
        }
        try{
            for(int i = 0; i < threads; ++i){
                sieveThreads[i].join();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
//        for(int i = 0; i < threads; ++i){
//            System.out.println(sieveThreads[i].getThreadName() + " " + sieveThreads[i].getNums());
//        }
        final long endTime = System.currentTimeMillis();
       // sieve.printNumbers();
        System.out.println("Number of primes is " + sieve.getNumPrimes());
        System.out.println("Total execution time: " + (endTime - startTime)/1000f);
    }
}
