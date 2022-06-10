// flatMap() 예제
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class chap20_06 {
    public static void main(String[] args) {
        List<Set<String>> list = new ArrayList<Set<String>>();
        Set<String> set1 = new HashSet<String>();
        set1.add("1");
        set1.add("3");
        set1.add("5");

        Set<String> set2 = new HashSet<String>();
        set2.add("2");
        set2.add("4");
        set2.add("6");

        list.add(set1);
        list.add(set2);

        Stream<Set<String>> stream1 = list.stream();
        Stream<String> stream2 = stream1.flatMap(item->{System.out.println("f"+item); 
                        return item.stream();});
        MyList rList = stream2.collect(MyList::new, MyList::add, MyList::addAll);
        System.out.println(rList);


    }
    static public class MyList {
        List<String> list = new ArrayList<String>();
        public void add(String str) {
            System.out.println("add "+str);
            list.add(str);
        }
        public void addAll(MyList collector) {
            System.out.println("addAll "+collector.list.toString());
            list.addAll(collector.list);
        }
        @Override
        public String toString(){
            return "MyList [list=" + list + "]";
        }
    }
}
