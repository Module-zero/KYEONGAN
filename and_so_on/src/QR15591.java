import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class QR15591 {
    static int[] parent;
    static int[] weight;
    static class Usado implements Comparable<Usado>{
        int p,q,r;
        public Usado(int p, int q, int r){
            this.p = p;
            this.q = q;
            this.r = r;
        }
        @Override
        public int compareTo(Usado u){
            return u.r - this.r;
        }
    }
    static class Query implements Comparable<Query>{
        int idx,k,v;

        public Query(int idx, int k, int v){
            this.idx = idx;
            this.k = k;
            this.v = v;
        }

        @Override
        public int compareTo(Query q){
            return q.k - this.k;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        int N = Integer.parseInt(init[0]);
        int Q = Integer.parseInt(init[1]);
        ArrayList<Usado> node = new ArrayList<>();
        ArrayList<Query> query = new ArrayList<>();
        for(int i = 1 ; i < N ; i ++){
            String[] str = bf.readLine().split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);
            int r = Integer.parseInt(str[2]);
            node.add(new Usado(p,q,r));
        }
        Collections.sort(node);
        for(int i = 0 ; i < Q ; i ++){
            String[] str = bf.readLine().split(" ");
            int k = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            query.add(new Query(i,k,v));
        }
        Collections.sort(query);
        parent = new int[N+1];
        weight = new int[N+1];
        for(int i = 1 ; i <= N ; i ++){
            weight[i] = 1;
            parent[i] = i;
        }
        int[] result= new int[Q];
        int cnt = 0;
        for(Query q : query){
            int k = q.k;
            int v = q.v;
            int index = q.idx;
            while(cnt < node.size() && node.get(cnt).r >= k){
                Usado u = node.get(cnt);
                union(u.p,u.q);
                cnt ++;
            }
            v = find(v);
            result[index] = weight[v] - 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int r : result){
            sb.append(r).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        weight[y] += weight[x];
        parent[x] = y;
    }

    public static int find(int x){
        if(parent[x] == x ){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
