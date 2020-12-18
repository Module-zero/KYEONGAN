import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1780 {
    static int one = 0 ;
    static int zero = 0;
    static int minus = 0;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int size = Integer.parseInt(bf.readLine());
        int[][] paper = new int[size+1][size+1];
        StringTokenizer st;
        for(int i = 1  ; i <= size; i ++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 1 ; j <= size ; j ++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sort(paper,1,1,1,size,size);
        System.out.print(minus+"\n"+zero+"\n"+one);
    }
    public static void sort(int[][] paper,int startI, int startJ,int start,int end, int size){ // 1,9,3
        boolean arrive = search(startI,startJ,size,paper);
        if(arrive){
            switch (paper[startI][startJ]){
                case 1:
                    one++;
                    break;
                case 0:
                    zero++;
                    break;
                default:
                    minus++;
                    break;
            }
        }
        else{
            int tmpSize = (size-start+1)/3;
            if(tmpSize != 0) {
                for(int i = startI ; i < startI+size; i+=tmpSize){
                    for(int j = startJ ; j < startJ+size ; j+=tmpSize){
                        sort(paper, i,j,start,end,tmpSize);
                    }
                }

            }
        }
    }
    public static boolean search(int startX, int startY, int size, int[][] paper){
        for(int i = startX; i < startX+size ; i ++){
            for(int j = startY ; j < startY+size ; j++){
                if(paper[startX][startY] != paper[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
