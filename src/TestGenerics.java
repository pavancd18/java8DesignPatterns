//import java.util.ArrayList;
//import java.util.List;
//
//public class TestGenerics {
//
//    public static void main(String[] args) {
//        List<? extends Number> foo1 = new ArrayList<Number>();  // Number "extends" Number (in this context)
//        List<? extends Number> foo2 = new ArrayList<Integer>(); // Integer extends Number
//        List<? extends Number> foo3 = new ArrayList<Double>();  // Double extends Number
//
//        print(foo1);
//    }
//
//    private static void print(List<? extends Number> list) {
//        list.add(Integer.valueOf(1));
//    }
//}
