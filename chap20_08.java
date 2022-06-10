// 스트림 병렬처리 예제
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class chap20_08 {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "orange"};
        List<String> list = new ArrayList<>(Arrays.asList(array));

        ForkJoinPool myPool = new ForkJoinPool(5);

        try {
            myPool.submit(()->{list.parallelStream().forEach(item->System.out.println(item));}).get();
        }catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
