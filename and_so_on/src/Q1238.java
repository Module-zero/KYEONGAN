import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q1238 {
    static ArrayList<int[]>[] graph;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int x = Integer.parseInt(str[2]);

        graph = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i ++ ){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i ++){
            String[] strArr = bf.readLine().split(" ");
            int start = Integer.parseInt(strArr[0]);
            int end = Integer.parseInt(strArr[1]);
            int time = Integer.parseInt(strArr[2]);
            graph[start].add(new int[]{end,time});
        }
        int[] goX = new int[n+1];
        int[] goHome = new int[n+1];
        LinkedList<int[]>queue = new LinkedList<>();
        for(int i = 1 ; i <= n ;i ++){
            if(i == x)continue;
            goX[i] = bfs(i,x,new int[n+1],queue);
        }
        for(int i = 1 ; i <= n ;i ++){
            if(i == x)continue;
            goHome[i] = bfs(x,i,new int[n+1],queue);
        }
        int ans = 0;
        for(int i = 1 ; i <= n ; i ++){
            if(i == x)continue;
            ans = Math.max(goX[i]+goHome[i],ans);
        }
        System.out.println(ans-2);
    }
    public static int bfs(int start, int end, int[] check, LinkedList<int[]>queue){
        queue.add(new int[]{start,1});
        check[start] = 1;
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] target = queue.poll();
            int cur = target[0];
            int curTime = target[1];
            for(int i = 0 ; i < graph[cur].size(); i ++){
                int[] curIdx = graph[cur].get(i);
                int go = curIdx[0];
                int time = curIdx[1];
                if(check[go]!=0 && check[go] < time+curTime)continue;
                check[go] = time+curTime;
                if(go == end){
                    ans = Math.min(time+curTime,ans);
                }
                else {
                    queue.add(new int[]{go, time + curTime});
                }
            }
        }
        return ans;
    }
}
