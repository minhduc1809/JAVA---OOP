import java.util.*;
import java.io.*;
public class SoKhacNhauTrongFile3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException{
        ObjectInputStream x = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList <Integer> a = (ArrayList<Integer>) x.readObject();
        Map<Integer,Integer> b = new HashMap();
        for(int i:a){
            if(!b.containsKey(i)){
                b.put(i,1);
            }
            else{
                b.put(i,b.get(i)+1);
            }
        }
        for(Map.Entry<Integer,Integer> i : b.entrySet()){
            System.out.println(i.getKey() + " " + i.getValue());
        }
    }
}
