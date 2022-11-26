package JavaFundamental;

import java.io.*;

//文件读写
public class ExceptionExercise {
    public static void main(String[] args) {
        String line;
        try (
                BufferedReader br = new BufferedReader(new FileReader("src/JavaFundamental/testInput.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/JavaFundamental/testOutput.txt"))
        ) {
            while ((line = br.readLine()) != null) {
                System.out.println("line => " + line);
                bw.write("copy: " + line + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            System.out.println("IOException in try block => " + e.getMessage());
        }
    }
}
