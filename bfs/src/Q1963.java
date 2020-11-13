import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q1963 {
    static boolean[] prime = new boolean[10000];
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int t = Integer.parseInt(bf.readLine());

        int[] numArr = {1000,100,10,1};
        makeprime();
        StringBuilder sb = new StringBuilder();
        for(int kk = 0 ; kk < t ; kk ++){
            String[] strArr = bf.readLine().split(" ");
            LinkedList<int[]> queue = new LinkedList<>();
            int[] numContainer = new int[4];
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            if(a == b){
                sb.append(0+"\n");
                continue;
            }
            queue.add(new int[]{a,0});
            boolean[] check = new boolean[10000];
            check[a] = true;
            int answer = 0 ;
            boolean arrive = false;
            while(!queue.isEmpty()){
                int[] idx = queue.remove();
                int num = idx[0];
                int cnt = idx[1];
                for(int i = 0 ; i < 4; i ++){
                    numContainer[0] = num/1000;
                    numContainer[1] = (num%1000)/100;
                    numContainer[2] = (num%100)/10;
                    numContainer[3] = num%10;
                    for(int j = 0 ; j <= 9 ; j++){
                        if((i == 0 && j == 0))continue;
                        if(j == numContainer[i])continue;
                        int tmpNum = 0;
                        for(int k = 0 ; k < 4; k ++){
                            if(k == i){
                                tmpNum+=j*numArr[i];
                            }
                            else{
                                tmpNum+=(numContainer[k]*numArr[k]);
                            }
                        }
                        if(check[tmpNum] || prime[tmpNum])continue;
                        check[tmpNum] = true;
                        if(tmpNum == b){
                            arrive = true;
                            answer = cnt+1;
                            continue;
                        }
                        queue.add(new int[] {tmpNum,cnt+1});
                    }
                }
            }
            if(arrive){
                sb.append(answer+"\n");
            }
            else{
                sb.append("Impossible\n");
            }
        }
        System.out.println(sb);
    }
    public static void makeprime(){
        prime[0] = true;
        prime[1] = true;
        for(int i = 2 ; i <= 10000/2 ; i ++){
            if(prime[i])continue;
            int cnt = i;
            while(cnt+i < 10000){
                prime[cnt+=i] = true;
            }
        }
    }
}
