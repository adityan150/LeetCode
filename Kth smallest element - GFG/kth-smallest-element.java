//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        if (r - l + 1 < k)
            return Integer.MAX_VALUE;
            
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        
        while (l <= r && pq.size() < k)
            pq.offer(arr[l++]);
        
        while (l <= r) {
            int val = arr[l++];
            
            if (pq.peek() > val) {
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    } 
}
