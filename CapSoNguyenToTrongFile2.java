import java.util.*;
import java.io.*;
public class CapSoNguyenToTrongFile2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        int n = 1000000;
        boolean[] a = new boolean[n];
        for(int i = 2; i<=n;i++) a[i] = true;
        for(int i = 2; i*i <= n; i++){
            if(a[i]){
                for(int j = i*i; j<=n; j+=i){
                    a[i] = false;
                }
            }
        }
        ObjectInputStream o1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream o2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a1 = (ArrayList<Integer>) o1.readObject();
        ArrayList<Integer> a2 = (ArrayList<Integer>) o2.readObject();
        TreeSet<Integer> x = new TreeSet<>(a1);
        for(int i : x) {
            if(a[i] && a[n-i] && i < (n-i) && a1.contains(n-i) && !a2.contains(i) && !a2.contains(n-i)){
                System.out.println(i + " " + (n-i));
            }
        }
    }
}
