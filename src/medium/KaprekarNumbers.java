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

class Result7 {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        boolean numFound=false;
        for(int i=p; i<=q;i++)
        {
            if(i==77778)
                i=i-1+1;
            if(isKaprekar(i)) {
                numFound=true;
                System.out.print(i);
                if(i!=q)
                    System.out.print(" ");
            }
        }
        if(!numFound)
            System.out.print("INVALID RANGE");

    }

    public static boolean isKaprekar(int num)
    {
        int digits=Integer.toString(num).length();
        long sqr=(long)num * (long)num;
        long den= (long) Math.pow(10,digits);
        int left= (int) (sqr/den);
        int right= (int) (sqr%den);
        return left +right ==num;
    }

}

public class KaprekarNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result7.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}

