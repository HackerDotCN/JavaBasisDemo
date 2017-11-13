package string;

/**
 * @desc:
 * @refer: http://blog.csdn.net/tiantiandjava/article/details/46309163   http://www.2cto.com/kf/201507/417691.html
 */

public class StringPoolTest {
    public static void main(String[] args) {
        String s0 = new String("abc");
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
        System.out.println(s1 == s2);
        System.out.println("\n");
        System.out.println(s0 == s1.intern());
        System.out.println(s0 == s2.intern());
        System.out.println(s1 == s2.intern());
    }

}