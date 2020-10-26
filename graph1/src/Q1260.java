import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {
    static ArrayList<Integer>[] list ;
    static int vertex;
    static int edge;
    static int[] queue;
    static int front = 0;
    static int rear = 0;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] strings = bf.readLine().split(" ");
        vertex = Integer.parseInt(strings[0]);
        edge = Integer.parseInt(strings[1]);
        int start = Integer.parseInt(strings[2]);
        queue = new int[vertex+1];
        list = new ArrayList[vertex+1];
        for(int i = 0; i <= vertex ; i ++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int u = Integer.parseInt(tmp[0]);
            int v = Integer.parseInt(tmp[1]);
            list[u].add(v);
            list[v].add(u);
        }
        for(int i = 1; i < list.length;i++){
            Collections.sort(list[i]);
        }
        StringBuilder dfsString = new StringBuilder();
        dfs(start,new boolean[vertex+1],dfsString);
        System.out.println(dfsString);
        bfs(start,new boolean[vertex+1],new StringBuilder());
    }
    public static void bfs(int start,boolean[] check, StringBuilder sb){
        check[start] = true;
        queue[rear++] = start;
        while(rear > front){
            start = queue[front++];
            sb.append(start+" ");
            for(int i = 0 ; i < list[start].size(); i ++){
                if(!check[list[start].get(i)]){
                    queue[rear++] = list[start].get(i);
                    check[list[start].get(i)] = true;
                }
            }
        }
        System.out.println(sb);
    }
    public static void dfs (int start,boolean[]check, StringBuilder sb){
        if(check[start]){
            return;
        }
        check[start] = true;
        sb.append(start+" ");
        for (int i = 0; i < list[start].size(); i++) {
            if (!check[list[start].get(i)]) {
                dfs(list[start].get(i),check,sb);
            }
        }
    }
}
