package Acmp;

import java.io.*;

public class Task5_ArithmeticProgression {

    public static void main(String[] args) throws FileNotFoundException {
        int a = 0;
        int b = 0;
        int c = 0;

        File InputFile = new File("input.txt");
        FileReader fileReader = new FileReader(InputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String lineText;
        try {
            lineText = bufferedReader.readLine();
            String[] parts = lineText.split(" ", 3);
            for (int i = 0; i < 3; i++) {
                a = Integer.parseInt(parts[0]);
                b = Integer.parseInt(parts[1]);
                c = Integer.parseInt(parts[2]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File OutputFile = new File("output.txt");
            FileWriter fileWriter = new FileWriter(OutputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(a + (c - 1) * (b - a)));
            bufferedWriter.close();
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }


}
