package medium;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class CandidateCode {

    private int dim1,dim2;

    static class Node{
        int x,y,dist;
        Node(int x,int y,int dist)
        {
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }

    //adjacent rows
    int[] row = { -1, 0, 1, 0 };
    int[] col = { 0, 1, 0, -1 };


    boolean isValidCubicle(int i, int j)
    {
        return (i >= 0 && i <= dim1 - 1) &&
                (j >= 0 && j <= dim2 - 1);
    }


    boolean isDistanceNotCalculated(int i, int j, char[][] matrix,
                   int[][] output)
    {
        return output[i][j] == -1;
    }


    void findDistance(char[][] matrix)
    {
        int[][] output = new int[matrix.length][];
        Queue<Node> q = new LinkedList<>();
        int managerRow=0;

        // Add manager's cubicle to queue
        for(int i = 0; i < matrix.length; i++)
        {
            dim1= matrix.length;
            dim2=matrix[i].length;
            output[i]=new int[matrix[i].length];
            for(int j = 0; j < matrix[i].length; j++)
            {

                // Initialize each cell as -1
                output[i][j] = -1;

                if (matrix[i][j] == 'M')
                {
                    managerRow=i;
                    q.add(new Node(i, j, 0));
                    output[i][j] = 0;
                }
            }
        }
        int minDistance=0;

        while (!q.isEmpty())
        {


            Node curr = q.peek();
            int x = curr.x;
            int y = curr.y;
            int dist = curr.dist;

            // Do for each adjacent cell
            for (int i = 0; i < 4; i++)
            {

                // If adjacent cell is valid, has
                // path and not visited yet,
                // en-queue it.
                if (isValidCubicle(x + row[i], y + col[i]))
                {
                    if (isDistanceNotCalculated(x + row[i], y + col[i],
                            matrix, output))
                    {
                        if(matrix[x + row[i]][ y + col[i]]==' ')
                            dist=dist+2;
                        if(matrix[x + row[i]][ y + col[i]]=='V') {
                            if(x + row[i]==managerRow)
                            {
                                System.out.println(0);
                                return;
                            }
                            System.out.println(dist);
                            return;
                        }
                        //same row
                        output[x + row[i]][y + col[i]] = x==i? dist: dist + 1;
                        q.add(new Node(x + row[i],
                                y + col[i],
                                dist + 1));
                    }
                }
            }


            q.poll();
        }

        // Print output matrix
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String []args)
    {
        char[][] cubicleMatrix;

        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        cubicleMatrix = new char[n][];
        for (int i=0;i<=n;i++) {
            String input = sc.nextLine();
            if(i!=0)
            cubicleMatrix[i-1] = input.toCharArray();
        }

        CandidateCode minDistance =
                new CandidateCode();

        minDistance.findDistance(cubicleMatrix);
    }

}
