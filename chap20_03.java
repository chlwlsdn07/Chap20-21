//Stream 요소 처리 순서
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class chap20_03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");

        Stream<String> stream = list.stream();

        MyList s = stream.filter(item->{System.out.println("filter "+item);return true;})
        .map(item->{System.out.println("map "+item); return item+"MAP";})
        .collect(MyList::new, MyList::add, MyList::addAll);

        System.out.println(s);
    }

    static public class MyList{
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
            return "MyList [list="+list+"]";
        }
    }
}
