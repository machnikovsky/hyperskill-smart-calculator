import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rulesOne = ".{12,}";
        String rulesTwo = ".*[0-9].*";
        String rulesThree = ".*[A-Z].*";
        String rulesFour = ".*[a-z].*";

        String password = scan.nextLine();

        if (password.matches(rulesOne) && password.matches(rulesTwo) &&
                password.matches(rulesThree) && password.matches(rulesFour)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}