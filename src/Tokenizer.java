import java.io.*;
import java.util.*;

/**
 * Created by 李晨昊 on 2017/9/18.
 */
public class Tokenizer {

    private static StringTokenizer stringTokenizer;
    private static boolean change;
    private static String line;
    private static BufferedReader br;
    private static File filename;
    private static InputStreamReader reader;
    private static String pathname;


    public static void main(String[] args) {
        try {
            pathname = "c:\\users\\29516\\Desktop\\test.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            filename = new File(pathname); // 要读取以上路径的input。txt文件
            reader = new InputStreamReader(new FileInputStream(filename), "UTF-8"); // 建立一个输入流对象reader
            br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            line = "";
            readNextLine();

            while ((line=br.readLine()) != null) {
                change=false;

                while (stringTokenizer.hasMoreTokens()) {
                    System.out.println(nextToken().toLowerCase());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loading this file failed");
        }

    }

    private static void readNextLine() {
        try {
            line = br.readLine();
            stringTokenizer = new StringTokenizer(line, " ~,!@#$%^&*()_+{}:\\\".;/[]=-<>?！￥…（）—：”《》？·，。；’【】|、");
            change = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean isChangedLine() {
        return change;
    }

    private static String nextToken() {
        String nextT = stringTokenizer.nextToken();

        if (!stringTokenizer.hasMoreTokens()) {
            readNextLine();
        }
//        System.out.println("1111"+stringTokenizer.hasMoreTokens());
        if (nextT.contains("'")) {
//            System.out.println("2222"+stringTokenizer.hasMoreTokens());
            if (isChangedLine()){
//                System.out.println("has changed +++++++");
//                System.out.println("changed line-------"+stringTokenizer.nextToken());
//                nextT=stringTokenizer.nextToken();
//                return nextT;
            }
            String[] subStringTokenizer;
            subStringTokenizer = nextT.split("'");



            int size = subStringTokenizer.length;
            if (size==0)
            {
                return stringTokenizer.nextToken();
            }
            else if (size == 1) {
                nextT = subStringTokenizer[0];
            } else if (size >= 2) {
                for (int i = 0; i < size - 1; i++) {
                    if (!Objects.equals(subStringTokenizer[i], "") && !Objects.equals(subStringTokenizer[i + 1], "")) {
                        return subStringTokenizer[i] + "'" + subStringTokenizer[i + 1];
                    }
                }
                for (String elem : subStringTokenizer) {
                    if (!Objects.equals(elem, ""))
                        return elem;
                }
            }
        }
        return nextT;
    }
}
