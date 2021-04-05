import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q18223 {
    static int V;
    static int E;
    static int P;
    static ArrayList<int[]>[] list;
    public static void main(String[]args )throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        V = Integer.parseInt(init[0]);
        E = Integer.parseInt(init[1]);
        P = Integer.parseInt(init[2]);
        list = new ArrayList[V+1];
        for(int i = 1 ; i <= V ; i ++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < E ; i ++) {
            String[] tmp = bf.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);
            list[a].add(new int[]{b,c});
            list[b].add(new int[]{a,c});
        }
        if(P == 1 || dijkstra()){
            System.out.println("SAVE HIM");
        }
        else{
            System.out.println("GOOD BYE");
        }
    }
    public static boolean dijkstra(){
        int start = 1;
        int[] dp = new int[V+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start,0,-1});
        boolean good = false;
        while(!pq.isEmpty()){
            int[] idx = pq.poll();
            int current = idx[0];
            int curDis = idx[1];
            if(dp[current] < curDis) continue;
            for(int[] l : list[current]){
                int save = idx[2];
                int next = l[0];
                int nextDis = curDis + l[1];
                if(nextDis <= dp[next]){
                    if(save == 1 && next == V){
                        good = true;
                    }
                    dp[next] = nextDis;
                    if(next == P){
                        save = 1;
                    }
                    pq.add(new int[]{next,nextDis,save});
                }
            }
        }
        return good;
    }
}
