// JDk의 기능을 사용한 합
import java.util.ArrayList;
import java.util.List;

public class chap20_05 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int sum = list.stream()
            .mapToInt((item)->item.intValue())
            .sum();
        System.out.println(sum);
    }
}
