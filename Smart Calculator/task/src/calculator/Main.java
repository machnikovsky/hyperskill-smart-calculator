package calculator;

import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> variableValues = new HashMap<>();

        while (true) {
            String choice = scan.nextLine();
            Deque<String> stack = new ArrayDeque<>();
            Deque<String> out = new ArrayDeque<>();
            Map<String, Integer> values = new HashMap<>();


            values.put("(", 0);
            values.put("+", 1);
            values.put("-", 1);
            values.put(")", 1);
            values.put("*", 2);
            values.put("/", 2);
            values.put("^", 3);


            if (choice.isEmpty()) {
                continue;
            }

            int first = 0;
            int second = 0;
            for (String s : choice.split("")) {
                if(s.equals("(")) {
                    first++;
                } else if (s.equals(")")) {
                    second++;
                }
            }

            if (choice.matches("/.*")) {
                if (choice.equals("/exit")) {
                    break;
                } else if (choice.equals("/help")) {
                    System.out.println("help");
                    continue;
                } else {
                    System.out.println("Unknown command");
                    continue;
                }

            }

            if (choice.matches("[a-zA-Z]*\\s*?=\\s*?\\d*")) {
                String[] val = choice.split("\\s*?=\\s*?");
                variableValues.put(val[0], val[1].trim());
                continue;
            }

            if (choice.matches("[\\+-]?\\s*?\\d+") ) {
                System.out.println(choice.replaceAll("\\s+","").replaceAll("\\+", ""));
            } else if (!choice.matches(".*[\\+\\-\\*/(]") && first == second) {
                choice = replaceAll(choice);
                String[] arr = choice.split("\\s+");

                for (String w : arr) {
                    workWithStack(w, stack, out, values, variableValues);
                }
                while (!stack.isEmpty()) {
                    out.offer(stack.pollLast());
                }
                BigInteger result = workWithOut(out);
                System.out.println(result);

            }
            else {
                System.out.println("Invalid expression");
            }



        }
        System.out.println("Bye!");
    }

    public static String replaceAll(String choice) {
        choice = choice.replaceAll("--", "+");
        choice = choice.replaceAll("\\+-", "-");
        choice = choice.replaceAll("-\\+", "-");
        choice = choice.replaceAll("\\++", "+");
        choice = choice.replaceAll("\\+", " + ");
        choice = choice.replaceAll("-", " - ");
        choice = choice.replaceAll("\\*", " * ");
        choice = choice.replaceAll("/", " / ");
        choice = choice.replaceAll("\\(", " ( ");
        choice = choice.replaceAll("\\)", " ) ");

        return choice;
    }

    public static void workWithStack(String w, Deque<String> stack, Deque<String> out,
                                     Map<String, Integer> values, Map<String, String> variableValues) {
        if (w.matches("\\d+")) {
            out.offer(w);
        } else if (w.matches("[a-zA-Z]+")) {
            out.offer(variableValues.get(w));
        } else if (w.equals("(")) {
            stack.offer(w);
        } else if (w.equals(")")) {
            while (!stack.peekLast().equals("(")) {
                out.offer(stack.pollLast());
            }
            stack.pollLast();
        } else {
            if (stack.isEmpty()) {
                stack.offer(w);
            } else if (values.get(w) > values.get(stack.peekLast())) {
                stack.offer(w);
            } else {
                while (!stack.isEmpty() && values.get(w) <= values.get(stack.peekLast()) && !stack.peekLast().equals("(")) {
                    out.offer(stack.pollLast());

                }
                stack.offer(w);
            }
        }

    }

    public static BigInteger workWithOut(Deque<String> out) {
        Deque<BigInteger> result = new ArrayDeque<>();
        for (String s : out) {
            if (s.matches("\\d+")) {
                result.offer(new BigInteger(s));
            } else {
                BigInteger a = result.pollLast();
                BigInteger b = result.pollLast();
                switch (s) {
                    case "+":
                        result.offer(a.add(b));
                        break;
                    case "-":
                        result.offer(b.subtract(a));
                        break;
                    case "*":
                        result.offer(b.multiply(a));
                        break;
                    case "/":
                        result.offer(b.divide(a));
                        break;
                }
            }
        }
        return result.getFirst();
    }
}
