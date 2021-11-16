import java.util.Random;
import java.util.Scanner;

/**
 * Project name(项目名称)：算法_单循环链表的实现_链表的删除
 * Package(包名): PACKAGE_NAME
 * Class(类名): test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/16
 * Time(创建时间)： 12:42
 * Version(版本): 1.0
 * Description(描述)： 生成随机数
 */

public class test1
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
        System.out.print("数量：");
        int sum;
        Scanner input = new Scanner(System.in);
        sum = input.nextInt();
        for (int i = 0; i < sum; i++)
        {
            System.out.print(getIntRandom(100, 999) + " ");
        }
    }
}
