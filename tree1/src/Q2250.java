import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2250 {
    static int[] parents = new int[10001];
    static int[] left = new int[10001];
    static int[] right = new int[10001];
    static int[] deep ;
    static int[] widthS ;
    static int rear;
    static int t;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        t = Integer.parseInt(bf.readLine());
        rear = 1;
        deep = new int[t+2];
        widthS = new int[t+2];

        for(int i = 1 ; i <= t; i ++){
            String[] strArr = bf.readLine().split(" ");
            int parent = Integer.parseInt(strArr[0]);
            left[parent] = Integer.parseInt(strArr[1]);
            right[parent] = Integer.parseInt(strArr[2]);
            if(left[parent] != -1){
                parents[left[parent]] = parent;
            }
            if(right[parent] != -1){
                parents[right[parent]] = parent;
            }
        }

        int root = 0 ;
        for(int i = 1 ; i <= t; i ++){
            if(parents[i] == 0){
                root = i;
                break;
            }
        }
        dfs(root,1);
        int level = 0;
        int maxLevel = t;
        int maxWidth = 0;

        while(true){
            level ++;
            boolean flag = false;
            int width = 0;
            int minIdx = t;
            int maxIdx = 0;
            for(int i = 1 ; i <= t ; i ++){
                if(deep[i] == level){
                    minIdx = Math.min(minIdx,widthS[i]);
                    maxIdx = Math.max(maxIdx,widthS[i]);
                    flag = true;
                }
            }
            width = maxIdx - minIdx + 1;
            if(maxWidth < width){
                maxLevel = level;
                maxWidth = width;
            }
            if(!flag){
                break;
            }
        }
        System.out.println(maxLevel+" "+maxWidth);
    }
    public static void dfs(int root,int level){
        if(root == 0 || root == -1 ){
            return;
        }
        dfs(left[root],level+1);
        deep[root] = level;
        widthS[root] = rear++;
        dfs(right[root],level+1);
    }
}
