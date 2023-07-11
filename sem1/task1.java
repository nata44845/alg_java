// Необходимо написать алгоритм, считающий сумму всех чисел
// от 1 до N. Согласно свойствам линейной сложности,
// количество итераций цикла будет линейно изменяться
// относительно изменения размера N.

/**
 * task1
 */
public class task1 {

    public static int Sum(int N){ //= O(1) + O(N)*O(1)+O(1) = O(N)
        int sum=0; //O(1)
        for (int i=1; i<=N; i++) {//O(N)
            sum +=i; //O(1)
        }  
        return sum; // O(1)
    }
    public static void main(String[] args) {
      
        System.out.println(Sum(10));
    }
    
}