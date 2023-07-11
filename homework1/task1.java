import java.util.Random;

// Дано целое число N из отрезка [1; 1000]. Также даны N целых чисел Ai из отрезка [1; 1000000]. 
// Требуется для каждого числа Ai вывести количество различных делителей этого числа. 
// В этой задаче несколько верных решений, попробуйте найти наиболее оптимальное. 
// Для полученного решения укажите сложность в О-нотации.

/**
 * task1
 */
public class task1 {

    public static void main(String[] args) {
        Random rnd = new Random();
        int N = rnd.nextInt(10);
        int[] arr = new int[N];
        int num, count;
        for (int i=0; i<N; i++) {
            arr[i] = rnd.nextInt(1_000);
        }
        for (int i=0; i<N; i++) {
            num = arr[i];
            count=0;
            for(int j=1; j<=num; j++) {
                if (num%j==0) count++;
            }
            System.out.printf("%d %d",num,count);
            System.out.println();
        }
    }
}