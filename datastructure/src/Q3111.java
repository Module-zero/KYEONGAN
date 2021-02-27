import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q3111 {
    static char[] str;
    static char[] target;
    static char[] leftStack = new char[300001];
    static int ln = 0 ;
    static char[] rightStack = new char[300001];
    static int rn = 0 ;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        str = bf.readLine().toCharArray();
        int n = str.length;
        target = bf.readLine().toCharArray();
        int left = 0 ;
        int right = target.length-1;
        boolean dirLeft = true;
        while(left <= right){
            if(dirLeft) {
                leftStack[ln++] = target[left++];
                if (ln >= n) {
                    boolean check = true;
                    for (int i = ln - n; i < ln; i++) {
                        if (leftStack[i] != str[n - (ln - i)]) {
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        dirLeft = false;
                        ln -= n;
                    }
                }
            }
            else{
                rightStack[rn++] = target[right--];
                if(rn >= n){
                    boolean check = true;
                    for(int i = rn - n ; i < rn ; i ++){
                        if(rightStack[i] != str[rn - i - 1]){
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        dirLeft = true;
                        rn -= n;
                    }
                }
            }
        }
        while(ln > 0 ){
            rightStack[rn++] = leftStack[--ln];
            if(rn >= n){
                boolean check = true;
                for(int i = rn - n ; i < rn ; i ++){
                    if(rightStack[i] != str[rn - i - 1]){
                        check = false;
                        break;
                    }
                }
                if(check){
                    rn -= n;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(rn > 0){
            sb.append(rightStack[--rn]);
        }
        System.out.println(sb);


    }

}
