import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        Pattern javaPattern = Pattern.compile("program", Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(stringWithNumbers);

        while (matcher.find()) {
            System.out.print(matcher.start() + " ");
            int i = matcher.start();
            String[] arr = stringWithNumbers.split("");
            while (arr[i].matches("\\w")) {
                System.out.print(arr[i]);
                i++;
            }
            System.out.println();
        }
    }
}