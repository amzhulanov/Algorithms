package Acmp;

import java.io.*;

public class Task1 {

    public static void main(String[] args) throws IOException {
        double a = 0;
        double b = 0;
        int count = 0;

        File InputFile = new File("input.txt");
        FileReader fileReader = new FileReader(InputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String lineText;
        while (true) {
            try {
                lineText = bufferedReader.readLine();
                if (lineText != null || lineText != "") {
                    if (count == 0) {
                        a = Integer.parseInt(lineText);
                        count++;
                    } else {
                        b = Integer.parseInt(lineText);
                        break;
                    }
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
            if (a < b) {
                bufferedWriter.write("<");

            } else if (a > b) {
                bufferedWriter.write(">");

            } else {
                bufferedWriter.write("=");
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


