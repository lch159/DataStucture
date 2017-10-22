import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;


public class LanguageGuesser {
    private static Map<String, LinkedList<String>> LanguagesContent;
    private static Map<String, Integer> LanguagesWordsNums;
    private static String fileName;


    public static void main(String[] args) {

        LinkedList<String> fileContents;
        String stop_words_dir;

        try {
            stop_words_dir = getStopWordsDir(args);
            File dir = new File(stop_words_dir);
            checkFile(dir);
            FindLanguageFile(dir);
            fileContents = getFileContents(fileName);
            String type = getLanguageType(fileContents);
            System.out.println(type);
        } catch (MyException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    private static  String getStopWordsDir(String[] args) throws MyException{
        Properties properties = new Properties();
        BufferedReader bufferedReader = null;
        LanguagesContent = new HashMap<>();
        LanguagesWordsNums = new HashMap<>();
        fileName = args[0];

        if (!new File("language.cnf").exists())
            throw new MyException("Can not find the language.cnf file.");
        try {
            bufferedReader = new BufferedReader(new FileReader("language.cnf"));
        } catch (FileNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        }
        try {
            properties.load(bufferedReader);
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return properties.getProperty("stop_words_dir");
    }

    private static void checkFile(File file) throws MyException {
        if (!file.exists()) {
            throw new MyException("The " + file + " is not exist");
        } else if (!file.canRead()) {
            throw new MyException("Can not read the " + file);
        } else if (!file.canExecute()) {
            throw new MyException("Can not execute the " + file);
        } else if (!file.isDirectory()) {
            throw new MyException("The " + file + " is not a directory.");
        }
    }

    private static String getLanguageType(LinkedList<String> fileContents) throws MyException {
        int sum = 0;
        for (String word : fileContents) {
            for (Map.Entry<String, LinkedList<String>> Language : LanguagesContent.entrySet()) {
                if (Language.getValue().contains(word)) {
                    Integer nums = LanguagesWordsNums.get(Language.getKey());
                    LanguagesWordsNums.put(Language.getKey(), ++nums);
                    sum++;
                }
            }
        }
        if (sum == 0) {
            throw new MyException("Can not identity the language in which the file is written. File Name:" + fileName);
        }
        String maxLanguageName = "";
        Integer maxLanguage = 0;
        for (Map.Entry<String, Integer> elem : LanguagesWordsNums.entrySet()) {
            if (elem.getValue() > maxLanguage) {
                maxLanguageName = elem.getKey();
                maxLanguage = elem.getValue();
            }
        }
        return maxLanguageName;
    }

    private static void FindLanguageFile(File file) throws MyException {
        File[] fileLists = file.listFiles();
        if (fileLists != null) {
            for (File fileList : fileLists) {
                if (fileList.isDirectory()) {
                    FindLanguageFile(fileList);
                } else if (fileList.isFile()) {
                    if (fileList.getName().trim().toLowerCase().endsWith(".txt")) {
                        String fileName = fileList.getName().substring(0, fileList.getName().length() - 4);
                        try {
                            LanguagesContent.put(fileName, getFileContents(fileList.getAbsolutePath()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        LanguagesWordsNums.put(fileName, 0);
                    }
                }
            }
            if (LanguagesContent.size() == 0 || LanguagesWordsNums.size() == 0) {
                throw new MyException("There is not .txt type file in such the directory " + file);
            }
        } else {
            throw new MyException("There is not file in such the directory " + file);
        }
    }

    private static LinkedList<String> getFileContents(String filePath) throws MyException {
        Tokenizer tokenizer = null;
        try {
            tokenizer= new Tokenizer(filePath);
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }

        String word;
        LinkedList<String> words = new LinkedList<>();
        if (tokenizer != null) {
            while ((word = tokenizer.nextToken()) != null) {
                words.add(word);
            }
        }else {
            throw new MyException("The file " + fileName + " is empty");
        }
        return words;
    }

    public static class MyException extends Exception {
        MyException(String msg) {
            super(msg);
        }
    }
}
