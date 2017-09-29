import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by 李晨昊 on 2017/9/18.
 */
public class Tokenizer {

    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) {
        try {
            String pathname = "c:\\users\\LLLLLLch\\Desktop\\dickens.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename),"UTF-8"); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";

            while ((line = br.readLine()) != null) {
                stringTokenizer = new StringTokenizer(line, " ~,!@#$%^&*()_+{}:\\\".;/[]=-<>?！￥…（）—：”《》？·，。；’【】|、");
                while (stringTokenizer.hasMoreTokens()) {
                    System.out.println(nextToken().toLowerCase());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loading this file failed");
        }

    }

    private static String nextToken() {
        String nextT = stringTokenizer.nextToken();

        if (nextT.contains("'")) {
            String[] subStringTokenizer;
            if (nextT.equals("'")) {
                if (stringTokenizer.hasMoreElements())
                    return nextToken();
            }
            subStringTokenizer = nextT.split("'");
            int size = subStringTokenizer.length;

            if (size <= 0) {

                return nextToken();
            } else if (size == 1) {
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
