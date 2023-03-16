//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        if (x.length() % 2 != 0)
            return false;
    
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char ch : x.toCharArray()) {
            if (ch == '(' || ch == '{' || ch =='[')
                stack.offerFirst(ch);
                
            else if (stack.isEmpty())
                return false;
            
            else {
                char temp = stack.getFirst();
                if ((temp == '(' && ch == ')') ||
                    (temp == '{' && ch == '}') ||
                    (temp == '[' && ch == ']'))
                    stack.removeFirst();
                
                else
                    return false;
            }
        }
        
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
