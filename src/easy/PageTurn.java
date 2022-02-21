package easy;

import java.io.*;

class Result12 {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        // Write your code here
        if(p==1 || p==n)
            return 0;
        int diff1=n-p,diff2=p-1;

        if(diff1==1 && n%2==0)
            return 1;
        else if(diff1==1)
            return 0;
        else if(diff2==1)
            return 1;
        else if(diff1 < diff2)
            return diff1/2;
        else if(diff2 < diff1)
            return diff2/2 + (diff2 %2);
        else
        {
            return diff1/2;
        }


    }

}

public class PageTurn {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result12.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
