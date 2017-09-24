import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by 李晨昊 on 2017/9/18.
 */
public class Tokenizer {
    public static void main(String[] args) {
        try {


            String pathname = "c:\\users\\LLLLLLch\\Desktop\\dickens.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";

            String setSeparator = "-";
            Map<String, List> mapList = new HashMap<>();

            int i = 0;
            while ((line = br.readLine()) != null) {
//                String[] words = line.split(";|:|!|\"|,|\'|.");
                System.out.println(line);
//                for (String word : words) {
//                    System.out.print(word + "\n");
//                }
//                List<String> listWord = Arrays.asList(words);
//                mapList.put("list" + i, listWord);
//                i++;
               line = br.readLine();
                break;
            }
        }catch (Exception e) {
                e.printStackTrace();
                System.out.println("文件读取失败");
            }
//            for (Map.Entry<String, List> mapping : mapList.entrySet()) {
//            for (Object list : mapping.getValue()) {
//                System.out.println(list);
//            }
//
//        }

    }
}
