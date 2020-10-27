import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q2667 {
    static int[][] apart;
    static int n ;
    static ArrayList<Integer> cnt;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        apart = new int[n][n];
        cnt = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            char[] strArr = bf.readLine().toCharArray();
            for(int j = 0 ; j < n ; j ++){
                apart[i][j] = strArr[j]-'0';
            }
        }
        int group = 2;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                if(apart[i][j] == 1){
                    dfs(i,j,group++);
                }
            }
        }
        Collections.sort(cnt);
        System.out.println(group-2);
        for(int num : cnt){
            System.out.println(num);
        }
    }
    public static void dfs(int i,int j,int group){
        if(i < 0 || j < 0 || i >= n || j >= n ||(apart[i][j] != 1)){
            return;
        }
        apart[i][j] = group;
        if(cnt.size() == group-2){
            cnt.add(group-2,1);
        }
        else{
            cnt.add(group-2,cnt.remove(group-2)+1);
        }
        dfs(i,j+1,group);
        dfs(i+1,j,group);
        dfs(i-1,j,group);
        dfs(i,j-1,group);
    }
}
