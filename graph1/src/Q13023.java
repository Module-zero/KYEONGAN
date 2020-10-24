import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q13023 {
    static int n;
    static int m;
    static boolean flag;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        n = Integer.parseInt(strArr[0]);
        m = Integer.parseInt(strArr[1]);
        ArrayList<Integer>[] list = new ArrayList[n];
        for(int i = 0 ; i < n ; i ++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int f = Integer.parseInt(tmp[0]);
            int t = Integer.parseInt(tmp[1]);
            if(list[f] == null || list[t]== null){
                list[f] = new ArrayList<>();
                list[t] = new ArrayList<>();
            }
            list[f].add(t);
            list[t].add(f);
        }
        for(int i = 0 ; i < n ; i ++){
            ArrayList<Integer>[] tmp = list.clone();
            dfs(tmp,i,0,new boolean[n]);
            if(flag)break;
        }
        if(flag){
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
    public static void dfs(ArrayList<Integer>[] list, int f,int cnt,boolean[] check){
        if(cnt == 4){
            flag = true;
            return;
        }
        if(list[f] == null || list[f].isEmpty()){
            return;
        }
        check[f] = true;
        for(int i = 0 ; i < list[f].size() ; i ++){
            int next = list[f].get(i);
            if(!check[next]) {
                check[next] = true;
                dfs(list, next, cnt + 1, check);
                check[next] = false;
            }
        }
    }
}
