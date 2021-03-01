import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rules = "\\s*\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}\\s*";
        String ip = scan.nextLine();
        boolean checker = true;
        if (ip.matches(rules)) {
            String[] Array = ip.split("\\.");
            for (String w : Array) {
                if (Integer.parseInt(w) > 255 || Integer.parseInt(w) < 0) {
                    checker = false;
                }
            }
        } else {
            checker = false;
        }

        System.out.println(checker ? "YES" : "NO");
    }
}