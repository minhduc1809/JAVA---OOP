import java.util.*;
import java.io.*;

public class HopVaGiaoCuaHaiFileVanBan {
    class WordSet{
        private Set<String> set;
        WordSet(String file) throws FileNotFoundException{
            set = new TreeSet<>();
            Scanner x = new Scanner(file);
            while(x.hasNext()){
                String s = x.nextLine();
                String[] t = s.split("\\s+");
                for(String i : t){
                    set.add(i.toLowerCase());
                }
            }
            x.close();
        }
        public String union(WordSet other){
            Set<String> x = new TreeSet<>(this.set);
            x.addAll(other.set);
            return String.join(" ",x);
        }
        private String intersection(WordSet other){
            Set<String> x = new TreeSet<>(this.set);
            x.retainAll(other.set);
            return String.join(" ",x);            
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
