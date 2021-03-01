import java.util.Scanner;

class RemoveExtraSpacesProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "\\s+";

        System.out.println(text.replaceAll(regex, " "));

        // write your code here
    }
}