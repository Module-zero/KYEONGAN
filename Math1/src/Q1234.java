import java.io.*;

public class Q1234 {
    static long[][][][] memo;
    static long[][] factorial;
    public static void main(String []args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        int N = Integer.parseInt(init[0]);
        int R = Integer.parseInt(init[1]);
        int G = Integer.parseInt(init[2]);
        int B = Integer.parseInt(init[3]);
        memo = new long[11][101][101][101];
        factorial = new long[11][11];
        factorial[0][0] = 1;
        factorial[0][1] = 1;
        int sum = 0;
        for(int i = 1 ; i <= N ; i ++){
            sum += i;
        }
        if( sum <= R + G + B){
            memo[N][R][G][B] += solve(N,R,G,B,1);
        }
        System.out.println(memo[N][R][G][B]);
        return;
    }
    public static long solve(int N, int R, int G, int B, int level){
        if(R < 0 || G < 0 || B < 0) return 0;
        if(level > N){
            return 1;
        }
        if(memo[level][R][G][B] == 0){
            memo[level][R][G][B] += solve(N,R-level,G,B,level+1);
            memo[level][R][G][B] += solve(N,R,G-level,B,level+1);
            memo[level][R][G][B] += solve(N,R,G,B-level,level+1);
            if(level % 2 == 0 ){
                int tmp = level / 2 ;
                factorial[level][tmp] = getFactorial(level, tmp,2);
                memo[level][R][G][B] += factorial[level][tmp] * solve(N,R-tmp,G-tmp,B,level+1);
                memo[level][R][G][B] += factorial[level][tmp] * solve(N,R-tmp,G,B-tmp,level+1);
                memo[level][R][G][B] += factorial[level][tmp] * solve(N,R,G-tmp,B-tmp,level+1);
            }
            if( level %  3 == 0){
                int tmp = level / 3;
                factorial[level][tmp] = getFactorial(level, tmp,3);
                memo[level][R][G][B] += factorial[level][tmp] * solve(N,R-tmp,G-tmp,B-tmp,level+1);
            }
        }
        return memo[level][R][G][B];
    }
    public static long getFactorial(int n, int piece, int d){
        long res = 1;
        for(int i = 1 ; i <= n ; i ++){
            res *= i;
        }
        for(int j = 0 ; j < d ; j ++) {
            for (int i = 1; i <= piece; i++) {
                res = res / i;
            }
        }
        return res;
    }
}
