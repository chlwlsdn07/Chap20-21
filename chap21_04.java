import java.util.Random;

public class chap21_04 {
    private Random random = new Random();

    public Integer processA() {
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        int rNum = random.nextInt(10);
        System.out.println(rNum);
        return rNum;
    }

    public Integer processB() {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        int rNum = random.nextInt(10);
        System.out.println(rNum);
        return rNum;
    }
}
