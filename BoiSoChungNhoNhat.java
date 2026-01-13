import java.math.BigInteger;
import java.util.*;
public class BoiSoChungNhoNhat {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        while(t>0){
            t--;
            BigInteger a = new BigInteger(in.nextLine());
            BigInteger b = new BigInteger(in.nextLine());
            BigInteger x = a.multiply(b);
            BigInteger y = a.gcd(b);
            System.out.println(x.divide(y));
        }
    }
}
