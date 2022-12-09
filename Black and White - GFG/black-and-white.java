//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int N, int M) {
        if (N == 1 && N == M) return 0;
        
        long result = 0;
        int[] hor = { 1, 1, -1, -1, 2, 2, -2, -2};
        int[] ver = { 2, -2, 2, -2, 1, -1, 1, -1};
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int count = 1;
                
                for (int k = 0; k < 8; k++) {
                    int x = i + hor[k];
                    int y = j + ver[k];
                    
                    if (x >= 0 && x < N && y >= 0 && y < M)
                    count++;
                }
                result += (((long) N) * M)  - count;
                result %= 1000000007;
            }
        }
        return result;
    }
}