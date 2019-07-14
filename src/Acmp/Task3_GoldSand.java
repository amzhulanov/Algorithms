package Acmp;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task3_GoldSand {
    public static void main(String[] args) throws IOException {
        ArrayList<Byte> cost = new ArrayList<>();
        ArrayList<Byte> weight = new ArrayList<>();

        File InputFile = new File("input.txt");
        FileReader fileReader = new FileReader(InputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String lineText;
        while (true) {
            try {
                lineText = bufferedReader.readLine();
                if (lineText != null && lineText != "") {
                    String[] parts = lineText.split(" ", 6);
                    for (int i = 0; i < 6; i++) {
                        if (i < 3) {
                            cost.add(Byte.parseByte(parts[i]));
                        } else {
                            weight.add(Byte.parseByte(parts[i]));
                        }
                    }
                } else {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bufferedReader.close();
        Collections.sort(cost, new ArrayComparator());
        Collections.sort(weight, new ArrayComparator());

        long sum = 0;
        for (int n = 0; n < cost.size(); n++) {
            sum = sum + cost.get(n) * weight.get(n);

        }
        try {
            File OutputFile = new File("output.txt");
            FileWriter fileWriter = new FileWriter(OutputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String s = String.valueOf(sum);
            bufferedWriter.write(s);
            bufferedWriter.close();
        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }

}

class ArrayComparator implements Comparator<Byte> {
    public int compare(Byte a, Byte b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }

    }
}