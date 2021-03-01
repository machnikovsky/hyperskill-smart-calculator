import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] variables = scan.nextLine().split(" ");
        BigInteger a = new BigInteger(variables[0]).negate();
        BigInteger b = new BigInteger(variables[1]);
        BigInteger c = new BigInteger(variables[2]);
        BigInteger d = new BigInteger(variables[3]);

        System.out.println(a.multiply(b).add(c).subtract(d));




    }
}