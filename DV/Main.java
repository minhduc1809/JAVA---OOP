import loaidv.*;
import animals.Animals;
public class Main {
    public static void main(String[] args) {
        Animals[] animals = new Animals[2];
        animals[0] = new dog("Dog", 5);
        animals[1] = new cat("Cat", 3);
        for(int i=0; i<animals.length; i++) {
            animals[i].run(animals[i]);
        }
    }
}
