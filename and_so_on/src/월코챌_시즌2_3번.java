import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 월코챌_시즌2_3번 {
    static ArrayList<Integer>[] list ;
    static long[] value;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = bf.readLine().split(" ");
        int n = str1.length;
        int[] a = new int[n];
        for(int i = 0 ; i < n ; i ++){
            a[i] = Integer.parseInt(str1[i]);
        }
        int[][] edges = new int[n-1][2];
        for(int i = 0 ; i < n-1 ; i ++){
            String[] tmp = bf.readLine().split(" ");
            edges[i][0] = Integer.parseInt(tmp[0]);
            edges[i][1] = Integer.parseInt(tmp[1]);
        }

        solution(a, edges);
    }
    public static long solution(int[] a, int[][] edges) {
        long answer ;
        int aLen = a.length;
        value = new long[aLen];
        for(int i = 0 ; i < aLen; i ++){
            value[i] = a[i];
        }
        list = new ArrayList[aLen];
        init(list);
        int eLen = edges.length;
        for(int i = 0 ; i < eLen ; i ++){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        answer = DFS(0,0);
        return value[0] == 0 ? answer : -1;
    }

    public static long DFS(int now, int root){
        long res = 0;
        int len = list[now].size();
        for(int i = 0 ; i < len; i ++){
            int num = list[now].get(i);
            if(num == root)continue;
            res += DFS(num,now);
        }
        value[root] += value[now];
        return res + Math.abs(value[now]);
    }

    public static void init(ArrayList<Integer>[] list){
        int len = list.length;
        for(int i = 0 ; i < len ; i ++){
            list[i] = new ArrayList<>();
        }
    }

}
