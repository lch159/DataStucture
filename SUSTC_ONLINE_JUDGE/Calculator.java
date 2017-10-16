
import java.util.*;
import java.util.stream.Collectors;

public class Calculator {
    private static final Map<Character, Integer> basic = new HashMap<>();

    static {
        basic.put('-', 1);
        basic.put('+', 1);
        basic.put('*', 2);
        basic.put('/', 2);
        basic.put('^', 3);
        basic.put('(', 0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {

            String s = toSuffix(input.next());
            System.out.println(dealEquation(s));
        }
    }

    private static String toSuffix(String infix) {
        List<String> queue = new ArrayList<>();
        List<Character> stack = new ArrayList<>();

        char[] charArr = infix.trim().toCharArray();
        String standard = "*/+-()^";
        char ch;
        int len = 0;
        for (int i = 0; i < charArr.length; i++) {

            ch = charArr[i];
            if (Character.isDigit(ch)) {
                len++;
            } else if (Character.isLetter(ch)) {
                len++;
            } else if (ch == '.') {
                len++;
            } else if (Character.isSpaceChar(ch)) {
                if (len > 0) {
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len, i)));
                    len = 0;
                }
                continue;
            } else if (standard.indexOf(ch) != -1) {
                if (len > 0) {
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len, i)));
                    len = 0;
                }
                if (ch == '(') {
                    stack.add(ch);
                    continue;
                }
                if (!stack.isEmpty()) {
                    int size = stack.size() - 1;
                    boolean flag = false;
                    while (size >= 0 && ch == ')' && stack.get(size) != '(') {
                        queue.add(String.valueOf(stack.remove(size)));
                        size--;
                        flag = true;
                    }
                    while (size >= 0 && !flag && basic.get(stack.get(size)) >= basic.get(ch)) {
                        queue.add(String.valueOf(stack.remove(size)));
                        size--;
                    }
                }
                if (ch != ')') {
                    stack.add(ch);
                } else {
                    stack.remove(stack.size() - 1);
                }
            }
            if (i == charArr.length - 1) {
                if (len > 0) {
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len + 1, i + 1)));
                }
                int size = stack.size() - 1;
                while (size >= 0) {
                    queue.add(String.valueOf(stack.remove(size)));
                    size--;
                }
            }

        }
        return queue.stream().collect(Collectors.joining(","));
    }


    private static String dealEquation(String equation) {
        String[] arr = equation.split(",");
        List<String> list = new ArrayList<>();

        for (String anArr : arr) {
            int size = list.size();
            switch (anArr) {
                case "+":
                    int a = Integer.parseInt(list.remove(size - 2)) + Integer.parseInt(list.remove(size - 2));
                    list.add(String.valueOf(a));
                    break;
                case "-":
                    int b = Integer.parseInt(list.remove(size - 2)) - Integer.parseInt(list.remove(size - 2));
                    list.add(String.valueOf(b));
                    break;
                case "*":
                    int c = Integer.parseInt(list.remove(size - 2)) * Integer.parseInt(list.remove(size - 2));
                    list.add(String.valueOf(c));
                    break;
                case "/":
                    int d = Integer.parseInt(list.remove(size - 2)) / Integer.parseInt(list.remove(size - 2));
                    list.add(String.valueOf(d));
                    break;
                case "^":
                    int e = (int) Math.pow(Integer.parseInt(list.remove(size - 2)), Integer.parseInt(list.remove(size - 2)));
                    list.add(String.valueOf(e));
                    break;
                default:
                    list.add(anArr);
                    break;
            }
        }
        return list.size() == 1 ? list.get(0) : "运算失败";
    }
}