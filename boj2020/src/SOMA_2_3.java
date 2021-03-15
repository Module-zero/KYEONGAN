import java.util.*;
import java.io.*;
public class SOMA_2_3 {
    static int[][] map;
    static int n ;
    static int max;
    public static void main(String[]args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            String[] str = bf.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++){
                int tmp = Integer.parseInt(str[j]);
                map[i][j] = tmp;
            }
        }
        solved(0,n,0,n,0);
        System.out.println(max);
    }
    public static void solved(int i1, int i2, int j1, int j2,int sum){
        if( i1 == i2-1 && j1 == j2-1 ){
            max = Math.max(sum,max);
            return;
        }
        int midI = ((i2-i1)/2)+i1;
        int midJ = ((j2-j1)/2)+j1;
        if(i1 != midI) {
            solved(midI,i2,j1,j2, sum + calc(i1, midI, j1, j2));
            solved(i1, midI, j1, j2,sum+calc(midI,i2,j1,j2));
        }
        if(j1 != midJ) {
            solved(i1, i2, midJ, j2, sum + calc(i1, i2, j1, midJ));
            solved(i1, i2, j1, midJ, sum + calc(i1, i2, midJ, j2));
        }
    }
    public static int calc(int i1,int i2,int j1,int j2){
        int tmp = 0;
        for(int i = i1; i < i2; i ++){
            for(int j = j1 ; j < j2 ; j ++){
                tmp = Math.max(tmp,map[i][j]);
            }
        }

        return tmp;
    }
}
