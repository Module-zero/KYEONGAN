import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2529 {
    static String[] strArr;
    static int MAX = 1;
    static int MIN = -1;
    static StringBuilder sb ;
    static boolean findMin;
    static boolean findMax;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        strArr = bf.readLine().split(" ");
        select(n,0,new boolean[10],new int[n+1],MAX);
        select(n,0,new boolean[10],new int[n+1],MIN);
        System.out.println(sb);
    }
    public static void select(int n,int cnt, boolean[] useNum,int[] answer,int find){
        if(cnt > n){
            if(check(answer,n)){
                for(int num : answer){
                    sb.append(num);
                }
                sb.append("\n");
                if(find == MIN){
                    findMin = true;
                }
                else{
                    findMax = true;
                }
            }
            return;
        }
        if(find == MIN) {
            for (int i = 0; i <= 9; i++) {
                if(findMin){
                    return;
                }
                if (!useNum[i]) {
                    useNum[i] = true;
                    answer[cnt] = i;
                    select(n, cnt + 1, useNum, answer,find);
                    useNum[i] = false;
                }
            }
        }
        else{
            for (int i = 9; i >= 0; i--) {
                if(findMax){
                    return;
                }
                if (!useNum[i]) {
                    useNum[i] = true;
                    answer[cnt] = i;
                    select(n, cnt + 1, useNum, answer, find);
                    useNum[i] = false;
                }
            }
        }
    }
    public static boolean check(int[] answer,int n){
        for(int i = 0 ; i < n ; i ++){
            if(strArr[i].equals("<") && answer[i] > answer[i+1]){
                return false;
            }
            if(strArr[i].equals(">") && answer[i] < answer[i+1]){
                return false;
            }
        }
        return true;
    }
}
