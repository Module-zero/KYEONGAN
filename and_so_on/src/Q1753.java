import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1753 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        int V = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);
        int K = Integer.parseInt(bf.readLine());

        ArrayList<int[]>[] graph = new ArrayList[V+1];
        for(int i = 0 ; i <= V ; i ++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < E ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int u = Integer.parseInt(tmp[0]);
            int v = Integer.parseInt(tmp[1]);
            int w = Integer.parseInt(tmp[2]);
            graph[u].add(new int[]{v,w});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        queue.add(new int[]{K,0});
        Map<Integer,Integer> check = new HashMap<>();
        check.put(K,0);
        while(!queue.isEmpty()){
            int[] target = queue.poll();
            int idx = target[0];
            int sum = target[1];
            for(int[] i : graph[idx]){
                int cur = i[0];
                int curCnt = i[1];
                int val = Integer.MAX_VALUE ;
                if(check.containsKey(cur)){
                    val = check.get(cur);
                }
                if(val > sum+curCnt) {
                    check.put(cur, sum + curCnt);
                    queue.add(new int[]{cur, sum + curCnt});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= V; i ++){
            if(check.containsKey(i)){
                sb.append(check.get(i)).append("\n");
            }
            else{
                sb.append("INF").append("\n");
            }
        }
        System.out.println(sb);
    }
}
