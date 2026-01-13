import java.util.*;
public class KhaiBaoLopHinhChuNhat {
    static class HinhChuNhat {
        int length, width;
        String color;

        HinhChuNhat(int length, int width, String color) {
            this.length = length;
            this.width = width;
            this.color = color;
        }

        int area() {
            return length * width;
        }

        int perimeter() {
            return 2 * (length + width);
        }

        String getColor() {
            String s = color.toLowerCase();
            return s.substring(0, 1).toUpperCase() + s.substring(1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int width = sc.nextInt();
        if(length <= 0 || width <= 0) {
            System.out.println("INVALID");
            return;
        }
        String color = sc.next();
        HinhChuNhat hcn = new HinhChuNhat(length, width, color);
        System.out.println(hcn.perimeter() + " " + hcn.area() + " " + hcn.getColor());
    }
}
