//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        int N = arr.length;
        
        if (N == 0 || arr[0] == 0)
            return -1;
            
        int jumps = 0;
        int left = 0;
        int right = 0;
        
        while (right < N-1) {
            int farthest = 0;
            
            for (int i = left; i <= right; i++)
                farthest = Math.max(farthest, i + arr[i]);
            
            if (farthest <= right)
                return -1;
            
            left = right + 1;
            right = farthest;
            jumps++;
        }
        return jumps;
    }
}