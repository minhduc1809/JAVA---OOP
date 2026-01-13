import java.util.Scanner;

public class Lietketohop1 {
        static int n, k, cnt=0;
    static void Try(int i, int in, int[] res){
        if(i==k){
            cnt++;
            for(int j=0; j<k; j++){
                System.out.printf("%d ",res[j]);
            }
            System.out.println("");
            return;
        }
        for(int u=in; u<=n-k+i+1 ; u++){
            res[i]=u;
            Try(i+1,u+1,res);
        }
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        k = sc.nextInt();
        int[] res = new int[k];
        Try(0,1,res);
        System.out.printf("Tong cong co %d to hop", cnt);
    }
}
