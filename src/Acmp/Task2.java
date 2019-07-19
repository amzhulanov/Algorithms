package Acmp;

import java.io.*;

public class Task2 {

    public static void main(String[] args) throws IOException {
        int[] sum = new int[2];
        sum[0] = 0;
        sum[1] = 0;

        File InputFile = new File("input.txt");
        FileReader fileReader = new FileReader(InputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String lineText;
        while (true) {
            try {
                lineText = bufferedReader.readLine();
                if (lineText != null && lineText != "") {
                    String[] parts = lineText.split(" ", 2);
                    for (int i = 0; i < 2; i++) {
                        sum[i] = sum[i] + Integer.parseInt(parts[i]);
                    }
                } else {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bufferedReader.close();
        try {
            File OutputFile = new File("output.txt");
            FileWriter fileWriter = new FileWriter(OutputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if (sum[0] > sum[1]) {
                bufferedWriter.write("1");

            } else if (sum[0] < sum[1]) {
                bufferedWriter.write("2");

            } else {
                bufferedWriter.write("DRAW");
            }
            bufferedWriter.close();
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}
