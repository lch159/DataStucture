import java.io.*;
import java.util.*;

public class Tokenizer {
    private static StringTokenizer stringTokenizer;

    public Tokenizer(String pathname) {
        BufferedReader br = null;

        try {
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
            br = new BufferedReader(reader);
            String line = "";
            StringBuffer content = new StringBuffer();

            while ((line = br.readLine()) != null) {
                content.append(line);
                content.append("\r");
            }

            String stringContent = new String(content);
            stringContent = stringContent.replaceAll("[\\v\\t\\n\\r]", "-");
            stringTokenizer = new StringTokenizer(stringContent, " ~,!@#$%^&*()_+{}:\\\".;/[]=-<>?！￥…（）—：”《》？·，。；’【】|、");

        } catch (FileNotFoundException e) {
            System.err.println("Can not find the file");
        } catch (IOException e) {
            System.err.println("No such file or directory");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Loading this file failed");
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String nextToken() {
        String nextT = null;
        if (stringTokenizer.hasMoreTokens()) {
            nextT = stringTokenizer.nextToken();

            if (nextT.contains("'")) {

                String[] subStringTokenizer;
                subStringTokenizer = nextT.split("'");

                int size = subStringTokenizer.length;
                if (size == 0)
                    return nextToken();
                else if (size == 1)
                    nextT = subStringTokenizer[0];
                else if (size >= 2) {
                    for (int i = 0; i < size - 1; i++)
                        if (!Objects.equals(subStringTokenizer[i], "") && !Objects.equals(subStringTokenizer[i + 1], ""))
                            return subStringTokenizer[i] + "'" + subStringTokenizer[i + 1];

                    for (String elem : subStringTokenizer)
                        if (!Objects.equals(elem, ""))
                            return elem;
                }
            }
        }

        return nextT != null ? nextT.toLowerCase() : null;
    }
}
