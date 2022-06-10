// Stream을 사용한 Max 구하기
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class chap20_01 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(Integer.valueOf(100));
        list.add(Integer.valueOf(101));
        list.add(Integer.valueOf(99));

        Stream<Integer> stream = list.stream();
        Optional<Integer> optional = stream.max(Comparator.naturalOrder());

        if(optional.isPresent()) {
            System.out.println(optional.get());
        }
        
    }
}