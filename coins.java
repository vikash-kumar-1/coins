import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays( Long S[],int m,int n) {
        // If n is 0 then there is 1 solution  
        // (do not include any coin) 

        if (n == 0) 
            return 1; 
          
        // If n is less than 0 then no  
        // solution exists 
        if (n < 0) 
            return 0; 
      
        // If there are no coins and n  
        // is greater than 0, then no 
        // solution exist 
        if (m <=0 && n >= 1) 
            return 0; 
      
        // count is sum of solutions (i)  
        // including S[m-1] (ii) excluding S[m-1] 
        int val =  (int)(n-S[m-1]);
        return getWays( S, m - 1, n ) + getWays( S, m, val ); 

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] cTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        Long c[] = new Long[m];

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cTemp[i]);
            c[i]= cItem;
        }


        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(c, m,n);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
