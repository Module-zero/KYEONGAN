import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q18352{
    static int[] city;
    static ArrayList<Integer>[] data;
    static int N;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        N = Integer.parseInt(init[0]);
        int M = Integer.parseInt(init[1]);
        int K = Integer.parseInt(init[2]);
        int X = Integer.parseInt(init[3]);

        city = new int[N+1];
        data = new ArrayList[N+1];
        for(int i = 0 ; i <= N ;i ++){
            data[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < M ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            data[a].add(b);
        }
        dijkstra(K,X);
    }
    public static void dijkstra(int limit, int start){
        Arrays.fill(city,Integer.MAX_VALUE);
        city[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] idx = pq.poll();
            for(int i = 0 ; i < data[idx[0]].size(); i ++){
                int cur = data[idx[0]].get(i);
                if(idx[1]+1 >= city[cur]) continue;
                if(limit < idx[1] + 1)continue;
                city[cur] = idx[1]+1;
                pq.add(new int[]{cur,city[cur]});
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean find = false;
        for(int c  = 0 ; c < city.length ; c ++){
            if(city[c] == limit){
                sb.append(c).append("\n");
                find = true;
            }
        }
        if(find)
            System.out.println(sb.toString());
        else
            System.out.println("-1");
    }
}
