package LAB5;

import javafx.stage.Stage;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 11611423 李晨昊 on 2017/10/30.15:46
 */
public class Abracadabra {
    static LinkedList<Character> text;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder result = new StringBuilder("");
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int tl = input.nextInt();
            char[] text = input.next().toCharArray();
            int pl = input.nextInt();
            char[] pattern = input.next().toCharArray();

//            text = new LinkedList<>();
//            for (char elem : t) {
//                text.add(elem);
//            }

            int pi = 0;
            int ti = 0;
            int temp=ti-1;

            Stack<Integer> state = new Stack<>();
            Deque<Character> result_ = new LinkedBlockingDeque<>();

            int stateIndex = -1;
            int[] next = getNext(pattern, pl);
            while (pi < pl && ti < tl) {

                if (temp<ti){
                    result_.offerLast(text[ti]);
                    temp=ti;
                }

                if (pi == -1 || text[ti] == pattern[pi]) {
                    if (pi != -1) {
                        stateIndex++;
                    }
                    if (pi == pl - 1 && text[ti] == pattern[pi]) {
                        if (!state.empty()) {
                            stateIndex = state.peek();
                            pi = state.peek() + 1;
                            state.pop();
                        } else {
                            pi = 0;
                        }


                        for (int j = 0; j < pl; j++) {
                            result_.pollLast();
                        }

                        ti++;



                    } else {
                        pi++;
                        ti++;
                    }
                } else {

                    pi = next[pi];
                    state.push(stateIndex);
                    stateIndex = -1;
                }
            }

//            for (Character elem : text) {
//                result.append(elem);
//            }

            while (result_.peekFirst()!=null){
                result.append(result_.pollFirst());
            }

            result.append("\n");
        }
        System.out.print(result);
    }


    private static int[] getNext(char[] p, int pl) {
        int[] next = new int[pl];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pl - 1) {
            if (k == -1 || p[j] == p[k]) {
                j++;
                k++;
                next[j] = k;
            } else k = next[k];
        }
        return next;
    }
}
