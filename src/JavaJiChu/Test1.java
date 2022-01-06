package JavaJiChu;

public class Test1 {
    public static void main(String[] args) {
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);    // false
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);   // true
    }
}
/**
 * new Integer(123) 与 Integer.valueOf(123) 的区别在于：
 * new Integer(123) 每次都会新建一个对象；
 * Integer.valueOf(123) 会使用缓存池中的对象，多次调用会取得同一个对象的引用。
 * 在 Java 8 中，Integer 缓存池的大小默认为 -128~127。
 * */
