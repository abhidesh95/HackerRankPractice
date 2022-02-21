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

class Result12 {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        // Write your code here
        if(n==1)
            return grid;
        List<String> allSet=grid.stream().map(i->i.replaceAll(".","O")).collect(toList());
        if(n%2==0)
            return allSet;
        n/=2;
        for(int i=0;i<(n+1)%2+1;i++)
        {
            grid=alternateState(grid,allSet);
        }
        return grid;

    }

    public static List<String> alternateState(List<String> grid,List<String> newGrid)
    {
        int[] rows={0,0,0,1,-1};
        int[] cols={0,-1,1,0,0};
        String [][] strings=grid.stream().map(u -> u.split("")).toArray(String[][]::new);
        String [][] newStrings=newGrid.stream().map(u -> u.split("")).toArray(String[][]::new);
        for(int i=0;i<strings.length;i++)
        {
            for(int j=0;j<strings[i].length;j++)
            {
                if("O".equals(strings[i][j]))
                {
                    for(int x=0;x<rows.length;x++)
                    {
                        int xIndex=i+rows[x];
                        int yIndex=j+cols[x];
                        if(xIndex<strings.length && xIndex>=0 && yIndex>=0 && yIndex<strings[i].length)
                        newStrings[xIndex][yIndex]=".";
                    }
                }
            }
        }
       return Arrays.stream(newStrings).map(str-> String.join("", str)).collect(toList());
    }

}

public class Bomberman {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result12.bomberMan(n, grid);

        bufferedWriter.write(
                String.join("\n", result)
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
