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
        for(char[] ii : star){
            for(char i : ii){
                System.out.print(i);
            }
            System.out.println(" ");
        }
    }
    public static void divide(int startI, int startJ,int endI,int endJ, int size){
        if(size == 1){
            star[startI][startJ] = '*';
           return;
        }
        else{
            int midI = startI + size / 3;
            int midJ = startJ + size / 3;
            for(int i = startI; i < endI; i++){
                for(int j = startJ ; j < endJ; j ++){
                    if(midI <= i && i < midI+size/3 && midJ <= j && j < midJ+size/3){
                        star[startI][startJ] = ' ';
                    }
                    else{
                        if(i+size/3< n && j+size/3 < n) {
                            divide(i, j, i + size / 3, j + size / 3, size / 3);
                        }
                    }
                }
            }
        }
    }
}
