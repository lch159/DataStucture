import java.util.*;

public class BracketsMatching {
    public static void main(String[] args) {
        Map<Character, Integer> brackets = new HashMap<>();

        brackets.put('(', 1);
        brackets.put('[', 2);
        brackets.put('{', 3);
        brackets.put(')', -1);
        brackets.put(']', -2);
        brackets.put('}', -3);
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            String s = input.next();
            int sum = 0;
            int lastValue = 0;
            int index = 0;
            boolean flag = false;
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < n; j++) {
                char curChar = s.charAt(j);
                int curValue = brackets.get(curChar);
                stack.push(curChar);
                if (curValue < 0) {
                    if (lastValue + curValue == 0) {
                        flag = true;
                        stack.pop();
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
                sum += curValue;
                if (!stack.isEmpty())
                lastValue = brackets.get(stack.peek());

            }
            if (sum == 0 && flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
