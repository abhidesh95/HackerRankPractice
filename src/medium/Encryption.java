package medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here
        String trimmed= s.trim();
        double sqrt=Math.sqrt(trimmed.length());
        int row= (int) Math.floor(sqrt);
        int col= (int) Math.ceil(sqrt);
        if(row * col < trimmed.length())
            row++;
        StringBuilder stringBuilder=new StringBuilder();

        for(int i=0;i<col;i++)
        {
            for(int c=i;c<trimmed.length();c+=col)
                stringBuilder.append(trimmed.charAt(c));
            if(i+1!=col)
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();

    }

}

public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test"));

        String s = bufferedReader.readLine();

        String result = Result2.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
