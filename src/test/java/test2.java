import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Project name(项目名称)：算法_单循环链表的实现_链表的删除
 * Package(包名): PACKAGE_NAME
 * Class(类名): test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/16
 * Time(创建时间)： 12:47
 * Version(版本): 1.0
 * Description(描述)： 测试升序和降序的时间
 */

public class test2
{
    public static int getIntRandom(int min, int max)         //空间复杂度和时间复杂度更低
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static int getIntRandom1(int min, int max)          //获取int型的随机数
    {
        if (min > max)
        {
            min = max;
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args)
    {
        int sum;
        Scanner input = new Scanner(System.in);
        //控制台输入变量:sum
        int errCount = 0;
        while (true)
        {
            try
            {
                //min:0
                //max:10000000
                System.out.print("请输入总数：");
                sum = input.nextInt();
                if (sum >= 0 && sum <= 10000000)
                {
                    break;
                }
                else
                {
                    errCount++;
                    Toolkit.getDefaultToolkit().beep();
                    if (errCount > 10)
                    {
                        System.err.println("错误次数过多！！！退出");
                        System.exit(1);
                    }
                    System.out.println("输入的数据不在范围内! 范围：[0,10000000]");
                }
            }
            catch (Exception e)
            {
                errCount++;
                if (errCount > 5)
                {
                    Toolkit.getDefaultToolkit().beep();
                    System.err.println("错误次数过多！！！退出");
                    System.exit(1);
                }
                else
                {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("输入错误！！！请重新输入！");
                    input.nextLine();
                }
            }
        }
        MyCircleLinkedList list = new MyCircleLinkedList();
        MyCircleLinkedList list1 = new MyCircleLinkedList();
        for (int i = 0; i < sum; i++)
        {
            list.add(getIntRandom(100, 999));
            list1.add(getIntRandom(100, 999));
        }
        //list.output();
        //list1.output();
        //升序：排序算法是 Vladimir Yaroslavskiy、Jon Bentley 和 Joshua Bloch 的双枢轴快速排序。
        // 该算法在所有数据集上提供 O(n log(n)) 性能，并且通常比传统（单轴）快速排序实现更快。
        //降序：基本快速排序
        list.sort();
        list1.sort_desc();
        list.sort_desc();
        list1.sort();
    }
}
