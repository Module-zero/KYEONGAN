import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1707 {
    static ArrayList<Integer>[] list;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int k = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < k ; i ++){
            String[] strArr = bf.readLine().split(" ");
            int vertex = Integer.parseInt(strArr[0]);
            int edge = Integer.parseInt(strArr[1]);
            list = new ArrayList[vertex+1];
            for(int j = 0 ; j <= vertex ; j ++){
                list[j] = new ArrayList<>();
            }
            for(int j = 0 ; j < edge ; j ++){
                String[] tmp = bf.readLine().split(" ");
                int u = Integer.parseInt(tmp[0]);
                int v = Integer.parseInt(tmp[1]);
                list[u].add(v);
                list[v].add(u);
            }
            int[] check = new int[vertex+1];
            String answer  = "YES";
            for(int start = 1 ; start <= vertex ; start ++) {
                if(check[start] == 0) {
                    answer = dfs(start, check, 1, answer);
                }
            }
            System.out.println(answer);
        }
    }
    public static String dfs (int start,int[]check,int group,String answer){
        if(check[start] != 0 || answer.equals("NO")){
            if(check[start] != group){
                answer = "NO";
            }
            return answer;
        }
        check[start] = group;
        group *= -1;
        for (int i = 0; i < list[start].size(); i++) {
            if (check[list[start].get(i)] == 0) {
                answer = dfs(list[start].get(i),check,group, answer);
            }
            else{
                if(check[list[start].get(i)] != group){
                    answer = "NO";
                }
            }
        }
        return answer;
    }
}
