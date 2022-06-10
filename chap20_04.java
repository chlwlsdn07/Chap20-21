// reduce를 사용한 합 구하기
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class chap20_04 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Stream<Integer> stream = list.stream();
        Integer result = stream.reduce(0, (a,b)->{System.out.println(a+ " "+b);return a+b;});
        System.out.println(result);


    }
}
