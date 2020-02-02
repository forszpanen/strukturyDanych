package dc;

public class FastPower {
    public static void main(String[] args) {
        int number = 3;
        int power = 23;
        long result = pow(number, power);
        System.out.println(result);
    }
    public static long pow(int number, int power) {
        System.out.println(power);
        if (power == 0)
            return 1;
        if (power % 2 == 1) {
            long x = pow(number, (power-1)/2);
            return number * x *x;
        }
        long x = pow(number, (power)/2);
        return number * x *x;
    }
}
