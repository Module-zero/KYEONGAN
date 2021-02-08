import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Q2606 {
    static int[] computer;
    static int[] rank ;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        computer = new int[n+1];
        rank = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            computer[i] = i;
            rank[i] = 1;
        }
        for(int i = 0 ; i < m ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            union(a,b);
        }
        int ans = 0;
        int find1 = find(1);
        for(int i = 2 ; i <= n ; i ++){
            if(find(i) == find1){
                ans ++;
            }
        }
        System.out.println(ans);
    }
    static int find(int a){
        if(a == computer[a])
            return a;
        else
            return computer[a] = find(computer[a]);
    }
    static void union(int x , int y){
        x = find(x);
        y = find(y);
        if(x == y)
            return ;
        if(rank[x] >= rank[y]){
            computer[y] = x;
            rank[x] += rank[y];
        }
        else{
            computer[x] = y;
            rank[y] += rank[x];
        }
    }
}
