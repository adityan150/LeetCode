//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int N, int S) 
    {
        //1. find all possible sub arrays and compare sums. O(N2) O(1)
        //2. two pointer. O(N) O(1)
        if (arr.length == 0 || S == 0)
            return new ArrayList<Integer>(Arrays.asList(-1));

        int l = 0;
        int r = 0;
        int curSum = 0;
        
        while (l <= r && r < N) {
            curSum += arr[r];
            
            while (curSum > S)
                curSum -= arr[l++];
            
            if (curSum == S)
                return new ArrayList<Integer>(Arrays.asList(l+1, r+1));
            
            r++;
        }
        return new ArrayList<Integer>(Arrays.asList(-1));
    }
}