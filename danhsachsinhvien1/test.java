package danhsachsinhvien1;
import java.util.*;
import java.io.*;
import java.text.*;
public class test{
    public static void main(String[] args)throws Exception {
        ObjectInputStream x = new ObjectInputStream(new FileInputStream("SV.in"));
        ArrayList<SinhVien> a = (ArrayList<SinhVien>) x.readObject();
        for(SinhVien i : a){
            System.out.println(i.toString());
        }
    }
}
