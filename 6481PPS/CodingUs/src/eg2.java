import java.util.Random;

public class eg2{
    public static void main(String[] args) {
        Random r = new Random();
        int k=r.nextInt(65536);

        System.out.println(Integer.toBinaryString(k));
    }
}