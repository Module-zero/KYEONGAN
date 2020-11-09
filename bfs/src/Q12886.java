import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Q12886 {
    static class Comp{
        int a;
        int b;
        int c;
        public Comp(int a,int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static boolean[][][] check;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int stoneA = Integer.parseInt(strArr[0]);
        int stoneB = Integer.parseInt(strArr[1]);
        int stoneC = Integer.parseInt(strArr[2]);
        int sum = stoneA+stoneB+stoneC;
        if(sum%3 != 0){
            System.out.println(0);
            return;
        }
        check = new boolean[1501][1501][3];
        check[stoneA][stoneB][0] = true;
        check[stoneA][stoneC][1] = true;
        check[stoneB][stoneC][2] = true;
        LinkedList<Comp> queue = new LinkedList<>();
        queue.add(new Comp(stoneA,stoneB,stoneC));
        while(!queue.isEmpty()){
            Comp com = queue.remove();
            int a = com.a;
            int b = com.b;
            int c = com.c;
            if( a!= b) {
                if (a > b) {
                    int B = b + b;
                    int A = a - b;
                    if (!check[A][B][0]) {
                        check[A][B][0] = true;
                        queue.add(new Comp(A, B, c));
                    }
                } else {
                    int A = a + a;
                    int B = b - a;
                    if (!check[A][B][0]) {
                        check[A][B][0] = true;
                        queue.add(new Comp(A, B, c));
                    }
                }
            }
            if(a != c) {
                if (a > c) {
                    int A = a - c;
                    int C = c + c;
                    if (!check[A][C][1]) {
                        check[A][C][1] = true;
                        queue.add(new Comp(A, b, C));
                    }
                } else {
                    int A = a + a;
                    int C = c - a;
                    if (!check[A][C][1]) {
                        check[A][C][1] = true;
                        queue.add(new Comp(A, b, C));
                    }
                }
            }
            if( b != c) {
                if (b > c) {
                    int B = b - c;
                    int C = c + c;
                    if (!check[B][C][2]) {
                        check[B][C][2] = true;
                        queue.add(new Comp(a, B, C));
                    }
                } else {
                    int C = c - b;
                    int B = b + b;
                    if (!check[B][C][2]) {
                        check[B][C][2] = true;
                        queue.add(new Comp(a, B, C));
                    }
                }
            }
        }
        for(int i = 0 ; i < 3 ; i ++){
            if(!check[sum/3][sum/3][i]){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
