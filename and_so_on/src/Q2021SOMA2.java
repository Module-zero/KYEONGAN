import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2021SOMA2 {
    static int p;
    static int n;
    static int h;
    static ArrayList<Integer>[] list;
    static int res;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().split(" ");
        p = Integer.parseInt(str[0]);
        n = Integer.parseInt(str[1]);
        h = Integer.parseInt(str[2]);
        list = new ArrayList[p+1];
        for(int i = 1; i <= p ; i ++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            if(b > h)continue;
            list[a].add(b);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= p ; i ++) {
            res = 0;
            select(0,0,list[i].size(),i);
            sb.append(i).append(" ").append(res*1000).append("\n");
        }
        System.out.println(sb);
    }
    public static void select(int ans, int index, int max,int target){
        if(ans > h){
            return ;
        }
        if(index >= max){
            if(ans > res){
                res = ans;
            }
            return;
        }
        select(ans+list[target].get(index),index+1,max,target);
        select(ans,index+1,max,target);
    }
}
