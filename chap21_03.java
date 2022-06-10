// 스레드 풀 예제
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.management.RuntimeErrorException;

public class chap21_03 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
        final Random random = new Random();

        for(int i=0; i<100; i++){
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Runnable worker = ()->{
            Integer intNum = null;
            try {
                intNum = queue.take();
                Thread.sleep(random.nextInt(1000));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(intNum.toString());
        };
        for(int i=0; i<100; i++){
            executor.execute(worker);
        }

        executor.shutdown();
        while(!executor.isTerminated()){

        }
    }
}
