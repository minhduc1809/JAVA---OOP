import java.util.*;
import java.io.*;
class Word implements Comparable<Word> {
    String content;
    int count;
    Word(String content, int count) {
        this.content = content;
        this.count = count;
    }
    public int compareTo(Word other) {
        if (this.count != other.count) {
            return other.count - this.count;
        }
        return this.content.compareTo(other.content);
    }
    public String toString() {
        return content + " " + count;
    }
}

public class ThongKeCacTuKhacNhauTrongFile {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner x = new Scanner(new File("VANBAN.in"));
        int n = Integer.parseInt(x.nextLine());
        Map<String,Integer> dem = new HashMap<>();
        while(n-->0){
            String a = x.nextLine().toLowerCase();
            a = a.replaceAll("[;\\.\\/\\(\\)\\-\\!\\?\\,]"," ");
            String[] s=a.split("\\s+");
            for(String i : s){
                if(!i.isEmpty()){
                    dem.put(i,dem.getOrDefault(i, 0) + 1);  
                }
            }
        }
        List<Word> b = new ArrayList<>();
        for(Map.Entry<String,Integer> i : dem.entrySet()){
            b.add(new Word(i.getKey(),i.getValue()));
        }
        Collections.sort(b);
        for(Word i : b){
            System.out.println(i);
        }
    }
}