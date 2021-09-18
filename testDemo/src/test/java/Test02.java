import java.util.ArrayList;

public class Test02 {
    byte[] a = new byte[1024*100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> map = new ArrayList<>();
        while (true){
            map.add(new Test02());
            Thread.sleep(100);
        }
    }
}
