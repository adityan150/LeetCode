class Solution {
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        
        // we have m-1 Downs and n-1 Rights
        // no. of ways to arrange = [(m-1)+(n-1)]! /m-1! * n-1!
        // instead of finding factorial, multiply and divide at the same time
        
        // (m * m+1 * m+2 * ... (m-1)+(n-1)) / 1 * 2 * 3 .... * n-1
        // m-1 m-2 m-3 .... 2 1 : divided by m-1!] 
        if (n > m) {        // if n is greater, swap
            int temp = n;
            n = m;
            m = temp;
        }
        
        long res = 1;
        int j = 1;
        for (int i = m; i <= m+n-2; i++, j++) {
            res *= i;
            res /= j;
        }
        return (int)res;
    }
}