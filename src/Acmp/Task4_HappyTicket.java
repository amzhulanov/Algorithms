package Acmp;

import java.io.*;

public class Task4_HappyTicket {
    public static void main(String[] args) {
        byte[] buf = new byte[6];
        int aSum = 0;
        int bSum = 0;
        try (FileInputStream in = new FileInputStream("input.txt")) {
            int count = in.read(buf);
            for (int i = 0; i < count; i++) {
                if (i < count / 2) {
                    aSum = aSum + Character.getNumericValue(((char) buf[i]));
                } else {
                    bSum = bSum + Character.getNumericValue(((char) buf[i]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File OutputFile = new File("output.txt");
            FileWriter fileWriter = new FileWriter(OutputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if (aSum == bSum) {
                bufferedWriter.write("YES");
            } else {
                bufferedWriter.write("NO");
            }
            bufferedWriter.close();
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}
