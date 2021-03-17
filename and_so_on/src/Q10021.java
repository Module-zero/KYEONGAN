import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q10021 {
    static int[] parent;
    static int[] weight;
    static class Node implements Comparable<Node>{
        int now,next,value;
        public Node(int now,int next, int value){
            this.now = now;
            this.next = next;
            this.value = value;
        }
        @Override
        public int compareTo(Node a){
            return this.value - a.value;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int C = Integer.parseInt(str[1]);
        parent = new int[N+1];
        weight = new int[N+1];
        for(int i = 1 ; i <= N ; i ++){
            parent[i] = i;
            weight[i] = 1;
        }
        int[][] list = new int[N+1][2];
        for(int i = 1 ; i <= N ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            list[i][0] = x;
            list[i][1] = y;
        }
        ArrayList<Node> nodeList = new ArrayList<>();
        for(int i = 1; i <= N; i ++){
            int[] target = list[i];
            for(int j = i+1 ; j <= N ; j ++){
                if(parent[j]!=j)continue;
                int[] cmp = list[j];
                int x = Math.abs(target[0] - cmp[0]);
                int y = Math.abs(target[1] - cmp[1]);
                x = x*x;
                y = y*y;
                if( x + y < C)continue;
                nodeList.add(new Node(i,j,x+y));
            }
        }
        Collections.sort(nodeList);
        int sum = 0 ;
        for(Node node : nodeList){
           if( union(node.now, node.next) ){
               sum += node.value;
           }
        }
        boolean success = true;
        for(int i = 1 ; i <= N ; i ++ ){
            if(parent[i]!= parent[1]){
                success = false;
                break;
            }
        }
        if(success) {
            System.out.println(sum);
        }
        else{
            System.out.println(-1);
        }
    }
    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y)
            return false;

        if( x > y)
            parent[x] = y;
        else
            parent[y] = x;
        return true;
    }
    public static int find(int x){
        if(parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }
}
