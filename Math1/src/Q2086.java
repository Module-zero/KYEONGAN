import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2086 {
    static long s;
    static long e;
    static long MOD = 1000000000;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        s = Long.parseLong(init[0]);
        e = Long.parseLong(init[1]);

        long[][] matrix = {{1,1},{1,0}};
        long[][] matrixE;
        long[][] matrixS;
        long eValue = 0;
        long sValue = 0;
        matrixE = power(matrix, e+2);
        matrixS = power(matrix, s+1);
        e = matrixE[0][1] -1;
        s = matrixS[0][1] -1;
        System.out.println((e-s+MOD)%MOD);
    }
    public static long[][] power(long[][] matrix,long m){

        long[][] tmp ;
        if( m == 1){
            tmp = matrix;
        }
        else if( m % 2 == 0 ){
            long[][] res = power(matrix,m/2);
            tmp = oper(res,res);
        }
        else{
            tmp = oper(power(matrix,m-1),matrix);
        }
        return tmp;
    }
    public static long[][] oper(long[][] a, long[][] b){
        long[][] ret = new long[2][2];
        for(int i = 0 ; i < 2 ; i ++){
            for(int j = 0 ; j < 2 ; j ++){
                ret[i][j] = (((a[i][0])%MOD * (b[0][j])%MOD)%MOD + ((a[i][1])%MOD * (b[1][j])%MOD)%MOD)%MOD;
            }
        }
        return ret;
    }
}
