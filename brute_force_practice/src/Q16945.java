import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q16945 {
    static int[]A ;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        A = new int[9];
        int cnt = 0 ;
        for(int i = 0 ; i < 3 ; i ++){
            String[] str = bf.readLine().split(" ");
            for(int j = 0 ; j < 3 ; j ++){
                A[cnt++] = Integer.parseInt(str[j]);
            }
        }
        solve(new int [9],0,new boolean[10]);
        System.out.println(ans);
    }
    public static void solve(int[] answer,int select,boolean[] check){
        if(select >= 9 ){
            int tmp = calc(answer);
            if(same(answer)){
                if(ans > tmp){
                    ans = tmp;
                }
            }
            return;
        }
        for(int i = 1; i <= 9 ; i ++){
            if(check[i])continue;
            answer[select] = i;
            check[i] = true;
            solve(answer,select+1,check);
            check[i] = false;
        }
    }
    public static int calc(int[] answer){
        int res = 0 ;
        for(int i = 0 ; i < 9 ; i ++){
            res += Math.abs(A[i]-answer[i]);
        }
        return res;
    }
    public static boolean same(int[] answer){
        if(answer[0]+answer[1]+answer[2] != 15)
            return false;
        if(answer[3]+answer[4]+answer[5] != 15)
            return false;
        if(answer[6]+answer[7]+answer[8] != 15)
            return false;
        if(answer[0]+answer[3]+answer[6] != 15)
            return false;
        if(answer[1]+answer[4]+answer[7] != 15)
            return false;
        if(answer[2]+answer[5]+answer[8] != 15)
            return false;
        if(answer[0]+answer[4]+answer[8] != 15)
            return false;
        if(answer[2]+answer[4]+answer[6] != 15)
            return false;
        return true;
    }
}
