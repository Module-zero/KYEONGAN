import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Q1717 {
    static int[] parent;
    static int[] rank;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        StringBuilder sb = new StringBuilder();
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 1 ; i <= n; i ++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int i = 0 ; i < m ; i ++){
            String[] command = bf.readLine().split(" ");
            int c = Integer.parseInt(command[0]);
            int a = Integer.parseInt(command[1]);
            int b = Integer.parseInt(command[2]);
            if( c == 0 ){
                union(a,b);
            }
            else{
                if(a == b || find(a) == find(b)){
                    sb.append("YES\n");
                }
                else{
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }
    static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
    static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if( x == y)
            return;
        if(rank[x] > rank[y]){
            parent[y] = x;
            rank[x] += rank[y];
        }
        else{
            parent[x] = y;
            rank[y] = x;
        }
    }
}
