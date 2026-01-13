package danhsachsinhvien1;
import java.util.*;
import java.io.*;
import java.text.*;
class SinhVien implements Serializable{
        private String ma,ten,lop;
        private Date ngaysinh;
        private float gpa;
        SinhVien(int id, String ten, String lop, Date ngaysinh, float gpa){
            this.ma = String.format("B20DCCN%03d",id);
            this.ten = ten;
            this.lop = lop;
            this.ngaysinh = ngaysinh;
            this.gpa = gpa;
        }
        public String toString(){
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            return this.ma + " " + this.ten + " " + this.lop + " " + f.format(this.ngaysinh) + " " + String.format(Locale.US,"%.2f",this.gpa);
        }
    }
public class DanhSachSinhVienTrongFileNhiPhan{
    public static void main(String[] args)throws Exception {
        ObjectInputStream x = new ObjectInputStream(new FileInputStream("SV.in"));
        ArrayList<SinhVien> a = (ArrayList<SinhVien>) x.readObject();
        for(SinhVien i : a){
            System.out.println(i);
        }
    }
}