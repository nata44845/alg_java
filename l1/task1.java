import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * task1
 */
public class task1 {

    public static int fib(int position, AtomicInteger counter){
        counter.incrementAndGet();
        if (position == 1) return 0;
        if (position == 2) return 1;
        return fib(position-1,counter)+fib(position-2,counter);
    }

    public static List<Integer> findSimple(int number) {
        int counter=0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i<= number; i++) {
            boolean simple = true;
            for (int j = 2; j<i; j++) {
                counter++;
                if (i%j==0) {
                    simple=false;
                    break;
                }
            }
            if (simple) result.add(i);
        }
        System.out.println("Counter = "+counter);
        return result;
    }

    public static List<Integer> findDiv(int number) {
        int counter=0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i<= number; i++) {
            counter++;
            if (number%i==0) result.add(i);
        }
        System.out.println("Counter = "+counter);
        return result;
    }
    public static void main(String[] args) {
    //     List<Integer> ad = findDiv(1000);
    //     for (Integer item:ad){
    //         System.out.println(item);
    //     }
        AtomicInteger counter = new AtomicInteger(0);
        int result = fib(11,counter);
        System.out.println(result);
        System.out.println(counter);

    }
}