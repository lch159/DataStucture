
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
            String line;
            StringBuffer content = new StringBuffer();

            while ((line = br.readLine()) != null) {
                content.append(line);
                content.append("\r");
            }

            char[] arrayContent = new String(content).toCharArray();
            StringBuffer newContent = new StringBuffer();

            for (char anArrayContent : arrayContent) {
                if (isCJK(anArrayContent)) {
                    newContent.append("-");
                    newContent.append(anArrayContent);
                    newContent.append("-");
                } else if (isChinesePunctuation(anArrayContent)) {
                    newContent.append("-");
                } else newContent.append(anArrayContent);
            }

            String stringContent = new String(newContent).replaceAll("[\\v\\t\\n\\r]", "-");
            stringTokenizer = new StringTokenizer(stringContent, " ~,!@#$%^&*()_+{}:\\\".;/[]=-<>?");

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


    public static boolean isCJK(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_COMPATIBILITY
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT
                || ub == Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT
                || ub == Character.UnicodeBlock.CJK_STROKES
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D
                || ub == Character.UnicodeBlock.HIRAGANA
                || ub == Character.UnicodeBlock.KATAKANA
                || ub == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO
                || ub == Character.UnicodeBlock.HANGUL_JAMO
                || ub == Character.UnicodeBlock.HANGUL_JAMO_EXTENDED_B
                || ub == Character.UnicodeBlock.HANGUL_JAMO_EXTENDED_A
                || ub == Character.UnicodeBlock.HANGUL_SYLLABLES;
    }

    public static boolean isChinesePunctuation(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS;
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