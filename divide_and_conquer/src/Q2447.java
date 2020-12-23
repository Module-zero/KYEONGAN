import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q2447 {
    static int n ;
    static char[][] star ;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        star = new char[n][n];
        divide(0,0,n,n,n);
        StringBuilder sb = new StringBuilder();
        for(char[] ii : star){
            for(char i : ii){
                if( i =='*') {
                    sb.append(i);
                }
                else{
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void divide(int startI, int startJ,int endI,int endJ, int size){
        if(size == 3){
            for(int i = startI ; i < startI+3 ; i ++){
                for(int j = startJ ; j < startJ+3; j++){
                    if(i == startI+1 && j == startJ+1)continue;
                    star[i][j] = '*';
                }
            }
            return;
        }
        else{
            int midI = startI + size / 3;
            int midJ = startJ + size / 3;
            for(int i = startI; i < endI; i+=(size/3)){
                for(int j = startJ ; j < endJ; j +=(size/3)){
                    if(midI == i &&  midJ == j )continue;
                    divide(i, j, i + size / 3, j + size / 3, size / 3);
                }
            }
        }
    }
}
