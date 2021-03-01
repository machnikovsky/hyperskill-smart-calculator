import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        Pattern javaPattern = Pattern.compile("password[:]?\\s*?\\w+\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(stringWithNumbers);
        int counter = 0;

        while (matcher.find()) {
            String[] word;
            if(matcher.group().contains(":")) {
                word = matcher.group().split(":");
                System.out.println(word[1].trim());
            } else {
                word = matcher.group().split("\\s+");
                System.out.println(word[1]);
            }

            counter++;
        }
        if (counter == 0) {
            System.out.println("No passwords found.");
        }

    }
}
