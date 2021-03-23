import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Q1800 {
    static int N;
    static int P;
    static int K;
    static ArrayList<int[]>[] map ;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        N = Integer.parseInt(init[0]);
        P = Integer.parseInt(init[1]);
        K = Integer.parseInt(init[2]);

        map = new ArrayList[N+1];

        for(int i = 0 ; i <= N ; i ++){
            map[i] = new ArrayList<>();
        }
        int sum = 0;
        for(int i = 1 ; i <= P ; i ++){
            String[] str = bf.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            sum = Math.max(sum, cost);
            map[a].add(new int[]{b,cost});
            map[b].add(new int[]{a,cost});
        }
        int left = 0 ;
        int right = sum;
        boolean success = false;
        int ans = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if( dijkstra(mid) ) {
                success = true;
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid+1;
            }
        }
        if(success)
            System.out.println(ans);
        else
            System.out.println(-1);
    }
    public static boolean dijkstra(int limit){
        int[] dist = new int[N+1]; // start 에서 갈 수 있는 최소 거리 기록
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.add(new int[]{1,0}); // 시작인덱스, 사용한 무료 기회
        while(!pq.isEmpty()){
            int[] idx = pq.poll();
            int now = idx[0];
            int cost = idx[1];
            if(dist[now] < cost)continue;
            for(int[] i : map[now]){
                int next = i[0];
                int nextCost = cost;
                if(i[1] > limit){
                    nextCost ++;
                }
                if(dist[next] > nextCost) {
                    dist[next] = nextCost;
                    pq.add(new int[]{next, nextCost});
                }
            }
        }
        return dist[N] <= K;
    }
}
