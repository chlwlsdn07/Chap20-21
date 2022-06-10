// 동시 수행 적용 예제
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class chap21_05 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> callableA = ()->{
            return new chap21_04().processA();
        };
        Callable<Integer> callableB = ()->{
            return new chap21_04().processB();
        };

        Future<Integer> FutureA = executor.submit(callableA);
        Future<Integer> FutureB = executor.submit(callableB);

        Integer sum = null;
        try {
            Integer a = FutureA.get();
            Integer b = FutureB.get();
            sum = a+b;

        }catch (InterruptedException | ExecutionException e){
            throw new RuntimeException(e);
        }
        System.out.println("sum :"+sum);
        long duration = System.currentTimeMillis()-start;
        System.out.println("time :"+duration);
      }
    
    }
    

