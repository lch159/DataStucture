import java.util.Scanner;

/**
 * Created by 11611423 李晨昊 on 2017/11/25.21:27
 */
public class findTestData {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        StringBuilder sBuilder = new StringBuilder("\n");

        while (scanner.hasNext()) {
            sBuilder.append(scanner.nextLine() + "\n");
        }

        scanner.close();
        throw new Exception(sBuilder.toString());
    }
}
