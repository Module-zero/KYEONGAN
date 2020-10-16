package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q14500 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] sizeArr = bf.readLine().split(" ");
        int n = Integer.parseInt(sizeArr[0]);
        int m =Integer.parseInt(sizeArr[1]);

        int[][] paper = new int[n][m];
        for(int i = 0 ; i < n ; i ++){
            String[] tmpArr = bf.readLine().split(" ");
            for(int j = 0 ; j < m ; j++){
                paper[i][j] = Integer.parseInt(tmpArr[j]);
            }
        }
        int tmp ;

        int max = putFigure(paper,new int[]{0,0}, new int[]{0,1},new int[]{1,1},new int[]{1,0}); // ㅁ

        max =  (tmp = putFigure(paper,new int[]{1,0}, new int[]{1,1}, new int[]{1,2}, new int[]{0,1})) > max ? tmp : max ; // ㅗ
        max =  (tmp = putFigure(paper,new int[]{0,0}, new int[]{1,1}, new int[]{0,2}, new int[]{0,1})) > max ? tmp : max ; // ㅜ
        max =  (tmp = putFigure(paper,new int[]{0,0}, new int[]{1,0}, new int[]{2,0}, new int[]{1,1})) > max ? tmp : max ; // ㅏ
        max =  (tmp = putFigure(paper,new int[]{1,0}, new int[]{2,1}, new int[]{1,1}, new int[]{0,1})) > max ? tmp : max ; // ㅓ

        max =  (tmp = putFigure(paper,new int[]{0,0}, new int[]{1,2}, new int[]{0,2}, new int[]{0,1})) > max ? tmp : max ; // ㄱ
        max =  (tmp = putFigure(paper,new int[]{2,0}, new int[]{2,1}, new int[]{1,1}, new int[]{0,1})) > max ? tmp : max ; //
        max =  (tmp = putFigure(paper,new int[]{0,0}, new int[]{1,0}, new int[]{1,1}, new int[]{1,2})) > max ? tmp : max ; // ㄴ
        max =  (tmp = putFigure(paper,new int[]{0,0}, new int[]{1,0}, new int[]{2,0}, new int[]{0,1})) > max ? tmp : max ; //

        max =  (tmp = putFigure(paper,new int[]{0,0}, new int[]{1,0}, new int[]{0,2}, new int[]{0,1})) > max ? tmp : max ; // reverseㄱ
        max =  (tmp = putFigure(paper,new int[]{0,0}, new int[]{0,1}, new int[]{1,1}, new int[]{2,1})) > max ? tmp : max ; //
        max =  (tmp = putFigure(paper,new int[]{1,0}, new int[]{1,1}, new int[]{1,2}, new int[]{0,2})) > max ? tmp : max ; // ㄴ
        max =  (tmp = putFigure(paper,new int[]{0,0}, new int[]{1,0}, new int[]{2,0}, new int[]{2,1})) > max ? tmp : max ;

        max =  (tmp = putFigure(paper,new int[]{1,0}, new int[]{2,0}, new int[]{1,1}, new int[]{0,1})) > max ? tmp : max ; // n
        max =  (tmp = putFigure(paper,new int[]{0,0}, new int[]{0,1}, new int[]{1,1}, new int[]{1,2})) > max ? tmp : max ; // spin n
        max =  (tmp = putFigure(paper,new int[]{0,0}, new int[]{1,0}, new int[]{2,1}, new int[]{1,1})) > max ? tmp : max ; // reverse n
        max =  (tmp = putFigure(paper,new int[]{1,0}, new int[]{1,1}, new int[]{0,1}, new int[]{0,2})) > max ? tmp : max ; // spin reverse n

        max =  (tmp = putFigure(paper,new int[]{0,0}, new int[]{0,1}, new int[]{0,2}, new int[]{0,3})) > max ? tmp : max ; // ㅡ
        max =  (tmp = putFigure(paper,new int[]{0,0}, new int[]{1,0}, new int[]{2,0}, new int[]{3,0})) > max ? tmp : max ; // |
        System.out.println(max);
    }
    public static int putFigure(int[][] paper, int[] a, int[] b, int[] c, int[] d){
        int maxHeight = paper.length - maxNum(a[0],b[0],c[0],d[0]);
        int maxWidth = paper[0].length - maxNum(a[1],a[1],c[1],d[1]);
        int answer = 0 ;
        for(int i = 0 ; i < maxHeight ; i++){
            for(int j = 0 ; j < maxWidth ; j ++){
                int sum = paper[a[0]+i][a[1]+j]+paper[b[0]+i][b[1]+j]+paper[c[0]+i][c[1]+j]+paper[d[0]+i][d[1]+j];
                answer = sum > answer ? sum : answer;
            }
        }
        return answer;
    }
    public static int maxNum(int a, int b, int c, int d){
        int max = a;
        max = max > b ? max : b;
        max = max > c ? max : c;
        return max > d ? max : d;
    }
}
