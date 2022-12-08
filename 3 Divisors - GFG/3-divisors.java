//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        ArrayList<Integer> result = new ArrayList<>();
        
        for (Long N : query) {
            int limit = (int) Math.sqrt(N);
            boolean[] isPrime = new boolean[limit+1];
            Arrays.fill(isPrime, true);
            
            int i = 2;
            while (i <= limit) {
                if (isPrime[i]) {
                    long m = i;
                    
                    while (m * i <= limit) {
                        isPrime[(int) (m * i)] = false;
                        m++;
                    }
                }
                i++;
            }
            
            int count = 0;
            for (int j = 2; j <= limit; j++) {
                if (isPrime[j]) count++;
            }
            result.add(count);
        }
        
        return result;
    }
}