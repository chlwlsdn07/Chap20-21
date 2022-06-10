import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class chap20_07 {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "orange"};
        List<String> list = new ArrayList<>(Arrays.asList(array));
        
        list.stream().forEach(item->System.out.println(item));
    }
}
