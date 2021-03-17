import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q15591 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        int N = Integer.parseInt(init[0]);
        int Q = Integer.parseInt(init[1]);
        ArrayList<int[]>[] list = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++){
            list[i] = new ArrayList<>();
        }
        for(int i = 1 ; i < N ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int p = Integer.parseInt(tmp[0]);
            int q = Integer.parseInt(tmp[1]);
            int r = Integer.parseInt(tmp[2]);
            list[p].add(new int[]{q,r});
            list[q].add(new int[]{p,r});
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < Q ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int k = Integer.parseInt(tmp[0]);
            int v = Integer.parseInt(tmp[1]);
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(v);
            boolean[] check = new boolean[N+1];
            check[v] = true;
            int cnt = 0 ;
            while(!queue.isEmpty()){
                int cur = queue.remove();
                for(int[] l : list[cur]){
                    if(check[l[0]] || l[1] < k)continue;
                    check[l[0]] = true;
                    cnt ++;
                    queue.add(l[0]);
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
