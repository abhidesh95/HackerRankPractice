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

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int subSetCount=0;
        Map<Integer,Integer> modulus=new ConcurrentHashMap<>();
        for (Integer integer : s) {
            Integer exObject = integer % k;
            Integer count = modulus.get(exObject);
            modulus.put(exObject, count == null ? 1 : count + 1);
        }
        //count 0 only once
            Integer countOfZero=modulus.get(0);
            if( countOfZero != null)
                subSetCount++;

        for(int i=1;i<k;i++)
        {
            Integer intInMap=modulus.get(i);
            if(intInMap == null || intInMap==0)
                continue;
            if(i*2==k)
                subSetCount++;
            else{
                //get compliment
                Integer compInMap=modulus.get(k-i);
                if(compInMap==null)
                subSetCount +=intInMap;
                else{
                    subSetCount += Math.max(intInMap,compInMap);
                    modulus.put(k-i,0);
                }
            }
        }
    return subSetCount;

    }

}

public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
