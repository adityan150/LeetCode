//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        boolean[] vis = new boolean[V];
        int c1 = 0;
        int c2 = 0;
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                c1++;
                dfs(adj, vis, i);
            }
        }
        
        Arrays.fill(vis, false);
        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                c2++;
                dfs(adj, vis, i);
            }
        }
        
        return (c2 > c1)? 1: 0;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int u) {
        vis[u] = true;
        
        for (int v : adj.get(u)) {
            if (!vis[v])
            dfs(adj, vis, v);
        }
    }
}