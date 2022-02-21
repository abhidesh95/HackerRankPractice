package medium;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int y, int x, List<List<Integer>> obstacles) {
        // Write your code here
        AtomicInteger up= new AtomicInteger(n - y);
        AtomicInteger down= new AtomicInteger(y - 1);
        AtomicInteger left = new AtomicInteger(x - 1);
        AtomicInteger right= new AtomicInteger(n - x);
        AtomicInteger upLeft= new AtomicInteger(Math.min(left.get(), up.get()));
        AtomicInteger downLeft= new AtomicInteger(Math.min(left.get(), down.get()));
        AtomicInteger upRight= new AtomicInteger(Math.min(right.get(), up.get()));
        AtomicInteger downRight= new AtomicInteger(Math.min(right.get(), down.get()));
        obstacles.parallelStream().forEach(list1->
        {
            int o_y=list1.get(0);
            int o_x=list1.get(1);
            //in left
            if(o_y==y && o_x < x)
            {
                if(x-o_x-1 < left.get()) {
                    left.set(x - o_x-1);
                }
            }
            //in right
            if(o_y==y && o_x > x)
            {
                if(o_x-x-1 < right.get()) {
                    right.set(o_x - x - 1);
                }
            }
            //up
            if(o_x==x && o_y > y)
            {
                if(o_y-y-1 < up.get()) {
                    up.set(o_y - y - 1);
                }
            }
            //down
            if(o_x==x && o_y < y)
            {
                if(y-o_y-1 < down.get()) {
                    down.set(y-o_y - 1);
                }
            }
            //upleft
            if(o_y>y && o_x <x)
            {
                if(o_y-y==x-o_x)
                    if(o_y-y-1 < upLeft.get())
                        upLeft.set(o_y - y - 1);
            }
            //upright
            if(o_y>y && o_x >x)
            {
                if(o_y-y==o_x-x)
                    if(o_y-y-1 < upRight.get())
                        upRight.set(o_y - y - 1);
            }
            //downLeft
            if(o_y<y && o_x <x)
            {
                if(y-o_y==x-o_x)
                    if(x-o_x-1 < downLeft.get())
                        downLeft.set(x-o_x-1);
            }
            //downRight
            if(o_y<y && o_x >x)
            {
                if(y-o_y==o_x-x)
                    if(o_x-x-1 < downRight.get())
                        downRight.set(o_x - x - 1);
            }
        });

        return up.get() + down.get() + left.get() + right.get()+upRight.get()+upLeft.get()+downLeft.get()+downRight.get();

    }

}

public class QueensAttack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result1.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
