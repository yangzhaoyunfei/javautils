import java.util.Scanner;

public class StringReverseTest {


    public void test() {
        System.out.print("请输入一个字符串：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println();
        String reversedStrByArray = new StringReverse(str).reverseByArray();
        System.out.println("对应反转字符串为[Array]：" + reversedStrByArray);
        String reversedStrByStack = new StringReverse(str).reverseByStack();
        System.out.println("对应反转字符串为[Stack]：" + reversedStrByStack);
        String reversedStrBySort = new StringReverse(str).reverseBySort();
        System.out.println("对应反转字符串为[逆序遍历]：" + reversedStrBySort);
        String reversedStrByBit = new StringReverse(str).reverseByBit();
        System.out.println("对应反转字符串为[位运算]：" + reversedStrByBit);
        String reversedStrByRecursive = new StringReverse(str).reverseByRecursive(str);
        System.out.println("对应反转字符串为[递归]：" + reversedStrByRecursive);
    }

    public static void main(String[] args) {
        new StringReverseTest().test();
    }

}
