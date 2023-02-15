//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<Integer> factorial(int N){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        
        for (int i = 2; i <= N; i++){
            multiply(list, i, 0, 0);
        }
        Collections.reverse(list);
        return list;
    }
    void multiply(ArrayList<Integer> list, int num, int carry, int index) {
        if (index >= list.size()) {
            while (carry > 0) {
                list.add(carry%10);
                carry /= 10;
            }
            return;
        }
        
        int prod = list.get(index) * num;
        carry += prod;
        list.set(index, carry%10);
        
        multiply(list, num, carry/10, index+1);
    }
}