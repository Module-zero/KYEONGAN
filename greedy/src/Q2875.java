import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2875 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] nmk = bf.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        int group = n/2;
        if( group < m){
            int tmp = (m-group) + (n%2);
            if(tmp >=  k){
                System.out.println(group);
            }
            else{
                int tmp2 = k - tmp;
                int intern = tmp2/3;
                if(tmp2 % 3 == 0){
                    System.out.println(group - intern);
                }
                else{
                    System.out.println(group - intern - 1);
                }
            }
        }
        else if(group == m){
            int tmp = k/3;
            if(k%3 == 0){
                System.out.println(group - tmp);
            }
            else{
                System.out.println(group - tmp - 1);
            }
        }
        else{
            int tmp = n - (m*2);
            if(tmp >= k){
                System.out.println(m);
            }
            else{
                int tmp2 = k - tmp;
                int intern = tmp2/3;
                if(tmp2%3 == 0){
                    System.out.println(m - intern);
                }
                else{
                    System.out.println(m - intern - 1);
                }
            }
        }
    }
}
//
