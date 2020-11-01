import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1991 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        int t = Integer.parseInt(bf.readLine());
        char[] tree = new char[(int)(Math.pow(2,t)+2)];
        for(int i = 1 ; i <= t; i ++){
            String[] strArr = bf.readLine().split(" ");
            int idx = search(tree,strArr[0].charAt(0));
            if(idx == -1){
                idx = i;
                tree[idx] = strArr[0].charAt(0);
            }
            tree[idx*2] = strArr[1].charAt(0);
            tree[(idx*2)+1] = strArr[2].charAt(0);
        }
        StringBuilder pre = new StringBuilder();
        StringBuilder ino = new StringBuilder();
        StringBuilder post = new StringBuilder();
        dfs(tree,1,pre,ino,post);
        System.out.println(pre);
        System.out.println(ino);
        System.out.println(post);
    }
    public static void dfs(char[] tree, int cnt, StringBuilder pre,StringBuilder ino,StringBuilder post){
        if(tree[cnt] == ' ' || tree[cnt] == '.'){
            return;
        }
        pre.append(tree[cnt]);
        dfs(tree,cnt*2,pre,ino,post);
        ino.append(tree[cnt]);
        dfs(tree,(cnt*2)+1,pre,ino,post);
        post.append(tree[cnt]);
    }
    public static int search(char[] chArr, char ch){
        for(int i = 0 ; i < chArr.length; i ++){
            if(chArr[i] == ch){
                return i;
            }
        }
        return -1;
    }
}
