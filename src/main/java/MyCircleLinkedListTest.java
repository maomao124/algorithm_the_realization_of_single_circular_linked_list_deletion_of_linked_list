import java.util.Scanner;

/**
 * Project name(项目名称)：算法_单循环链表的实现_链表的删除
 * Package(包名): PACKAGE_NAME
 * Class(类名): MyCircleLinkedListTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/16
 * Time(创建时间)： 11:18
 * Version(版本): 1.0
 * Description(描述)：
 * 预期输入：2 0 5 1 1
 * 预期输出：
 * <p>
 * 0
 * 2
 * 5
 * 1
 * 1
 */

public class MyCircleLinkedListTest
{
    public static void main(String[] args)
    {
        MyCircleLinkedList list = new MyCircleLinkedList();
        /*
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int item = in.nextInt();
            list.add(item);
        }
        System.out.println(list.remove(1));
        list.output();
*/
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(12);
        list.add(8);
        list.add(9);
        list.output();
        System.out.println(list.remove(6));
        list.output();
        System.out.println(list.remove());
        list.output();
        list.sort();
        list.output();
        list.sort_desc();
        list.output();
        System.out.println(list.get(5));
    }
}
