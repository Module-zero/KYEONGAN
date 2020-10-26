import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Q2667 {
    static int[][] apart;
    static int n ;
    static  LinkedHashMap<Integer,Integer> cnt;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        apart = new int[n][n];
        cnt = new LinkedHashMap<>();
        for(int i = 0 ; i < n ; i ++){
            String[] strArr = bf.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++){
                apart[i][j] = Integer.parseInt(strArr[i]);
            }
        }
        int group = 2;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                dfs(i,j,group);
            }
        }
    }
    public static void dfs(int i,int j,int group){
        if(i >= n || j >= n ||(apart[i][j] != 1)){
            return;
        }
        apart[i][j] = group;
        if(cnt.get(group) == null){
            cnt.put(group,1);
        }
        else{
            cnt.put(group,cnt.get(group)+1);
        }
        dfs(i,j+1,group);
        dfs(i+1,j,group);
    }
}
