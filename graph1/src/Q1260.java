import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Q1260 {
    static ArrayList<Integer>[] list;
    static int vertex;
    static int edge;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strings = bf.readLine().split(" ");
        vertex = Integer.parseInt(strings[0]);
        edge = Integer.parseInt(strings[1]);
        int start = Integer.parseInt(strings[2]);

        list = new ArrayList[vertex+1];
        for(int i = 1; i <= vertex ; i ++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int u = Integer.parseInt(tmp[0]);
            int v = Integer.parseInt(tmp[1]);
            list[u].add(v);
            list[v].add(u);
         }
        dfs(start,new boolean[vertex+1],0,new int[vertex]);
        System.out.println("");
        bfs(start,new boolean[vertex+1],1);
    }
    public static void dfs(int start,boolean[] check, int cnt, int[] answer){
        answer[cnt] = start;
        check[start] = true;
        if(cnt >= edge){
            for(int i = 0 ; i <= edge; i ++){
                System.out.print(answer[i]+ " ");
            }
            return;
        }
        int min = Integer.MAX_VALUE;
        for(int target : list[start]){
            if(min > target){
                if(!check[target]){
                    min = target;
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return;
        }
        dfs(min,check,cnt+1,answer);
    }
    public static void bfs (int start,boolean[]check, int cnt){
        if(!check[start]){
            System.out.print(start+" ");
            check[start] = true;
        }
        if(cnt >= vertex){
            return;
        }
        int[] queue = new int[list[start].size()];
        for(int i = 0 ; i < list[start].size() ; i ++){
            queue[i] = list[start].get(i);
        }
        Arrays.sort(queue);
        for(int qu : queue){
            if(!check[qu]){
                System.out.print(qu+" ");
                check[qu] = true;
                cnt++;
            }
        }
        for(int i = 0 ; i < queue.length ;i++){
            bfs(queue[i],check,cnt+1);
        }
    }
}
