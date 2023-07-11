import java.util.Date;

public class task4 {

    public static void test(){
        for (int n=10; n<= 50; n++)
        {
            Date start = new Date(); 
            fib(n);
            Date end = new Date(); 
            long time1 = end.getTime() - start.getTime();

            start = new Date(); 
            fib2(n);
            end = new Date(); 
            long time2 = end.getTime() - start.getTime();
            System.out.printf("N=%d, time1=%d, time2=%d",n, time1, time2);
            System.out.println();
        }

    }

    public static long fib(int n){
        if (n <=2 ) return 1;
        return fib(n-1)+ fib(n-2);
    }

    public static long fib2(int n){
        if (n <=2 ) return 1;
        long[] F = new long[n+1];
        F[1]=1;
        F[2]=1;
        for (int i=3; i<=n; i++)
            F[i]=F[i-1]+F[i-2];
        return F[n];
    }

    public static void main(String[] args) {
        test();
    }
}
