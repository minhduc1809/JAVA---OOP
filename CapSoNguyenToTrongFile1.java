import java.util.*;
import java.io.*;
public class CapSoNguyenToTrongFile1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        boolean[] Ar = new boolean[1000007];
        Ar[0] = false;
        Ar[1] = false;
        for(int i = 2; i<=1000000; i++) Ar[i] = true;
        for(int i = 2; i*i <= 1000000; i++){
            if(Ar[i]==true){
                for(int j = i*i; j <= 1000000; j+=i){
                    Ar[j] = false;
                }
            }
        }
        int n = 1000000;
        ObjectInputStream o1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream o2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a1 = (ArrayList<Integer>) o1.readObject();
        ArrayList<Integer> a2 = (ArrayList<Integer>) o2.readObject();
        HashSet<Integer> x = new HashSet<>(a1);
        for(int i : x){
            if(Ar[i] && Ar[n-i] && a2.contains(n-i) && (n-i)>i){
                System.out.println(i + " " + (n-i));
            }
        }
    }
}
