// Написать алгоритм поиска простых чисел (делятся только на себя и
// на 1) в диапазоне от 1 до N. В алгоритме будет использоваться
// вложенный for, что явно говорит о квадратичной сложности, на этом
// стоит акцентировать внимание

public class task2 {
    public static void Simple(int N){ //= O(1) + O(N)*O(1)+O(1) = O(N)
        boolean simple;
        for (int i=2; i<=N; i++) {
            simple = true;
            for (int j=2; j*j<=i; j++){
                if (i%j == 0) {
                    simple = false; 
                    break;
                }
            }
            if (simple) System.out.printf("%d ",i);
        }  
    }
    public static void main(String[] args) {
        Simple(100);
    }
}
