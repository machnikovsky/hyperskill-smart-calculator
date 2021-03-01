import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        Pattern patternOne = Pattern.compile("\\b" + part, Pattern.CASE_INSENSITIVE);
        Pattern patternTwo = Pattern.compile(part + "\\b", Pattern.CASE_INSENSITIVE);

        Matcher matcherOne = patternOne.matcher(line);
        Matcher matcherTwo = patternTwo.matcher(line);

        if (matcherOne.find() || matcherTwo.find()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}