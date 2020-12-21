import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1074 {
    static long N ;
    static long r ;
    static long c ;
    static int[][] move = {{0,0},{0,1},{1,0},{1,1}};
    static long ans = 0;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        N = (long)Math.pow(2,Integer.parseInt(str[0]));
        r = Integer.parseInt(str[1]);
        c = Integer.parseInt(str[2]);

        zMove(0,0,N,N,N);
        System.out.println(ans);
    }
    public static void zMove(long startI,long startJ,long endI, long endJ, long size){
        if(size == 0)return;
        size = size/2;
        long area = size*size;
        long halfI = startI+size;
        long halfJ = startJ+size;
        if(startI <= r && r < halfI && startJ <= c && c< halfJ){
            zMove(startI,startJ,halfI,halfJ,size);
            return;
        }
        ans += area;
        if(startI <= r && r < halfI && halfJ <= c && c< endJ){
            zMove(startI,halfJ,halfI,endJ,size);
            return;
        }
        ans += area;
        if(halfI <= r && r < endI && startJ <= c && c< halfJ){
            zMove(halfI,startJ,endI,halfJ,size);
            return;
        }
        ans += area;
        if(halfI <= r && r < endI && halfJ <= c && c < endJ){
            zMove(halfI,halfJ,endI,endJ,size);
            return;
        }
    }
}
