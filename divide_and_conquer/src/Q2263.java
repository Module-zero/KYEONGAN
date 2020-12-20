import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2263 {

    static int[] postOrder;
    static int[] position;
    static StringBuilder sb ;
    static int n;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        n = Integer.parseInt(bf.readLine());
        int[] inOrder = new int[n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < n ; i ++){
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        postOrder = new int[n+1];
        position = new int[n+1];
        for(int i = 0 ; i < n ; i ++){
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < n ; i ++){
            position[inOrder[i]] = i;
        }
        sb = new StringBuilder();
        printPre(0,n-1,0,n-1);
        System.out.println(sb);
    }
    public static void printPre(int in_start,int in_end,int pos_start,int pos_end){
        if(in_start > in_end || pos_start > pos_end){
            return;
        }
        int root = postOrder[pos_end];
        sb.append(root+" ");
        int inPos = position[root];

        int left = inPos - in_start;

        printPre(in_start,inPos-1,pos_start,pos_start+left-1);
        printPre(inPos+1,in_end,left+pos_start,pos_end-1);
    }
}
