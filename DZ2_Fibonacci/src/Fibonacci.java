import java.util.Observable;

/**
 * Created by Андрей on 26.01.2016.
 */
public class Fibonacci {
    public static int calculateFibonacciElement(int number) {
        if (number <= 0) {
            return -1;
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        return calculateFibonacciElement(number - 1) + calculateFibonacciElement(number - 2);
    }
    Observable
}