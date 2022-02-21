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

class Result5 {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        // Write your code here
        char[] chars=w.toCharArray();
        int n=chars.length;
        int smallCharIndex=0, nextSmallChar=0,endIndex;
        for(endIndex=n-1;endIndex>0;endIndex--)
        {
            if(chars[endIndex]>chars[endIndex-1]) {
                smallCharIndex = endIndex - 1;
                nextSmallChar=endIndex;
                break;
            }
        }
        if(endIndex==0)
            return "no answer";
        int firstSmallChar=chars[smallCharIndex];
        for(int i=endIndex+1;i<n;i++)
        {
            if(chars[i]>firstSmallChar && chars[i]<chars[nextSmallChar])
                nextSmallChar=i;

        }

        swap(chars,smallCharIndex,nextSmallChar);

        Arrays.sort(chars,smallCharIndex+1,n);

        return new String(chars);

    }


   static void  swap(char[] arr, int i, int j)
    {
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }

}

public class BiggerGreater {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test"));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result5.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
