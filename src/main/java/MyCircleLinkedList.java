import java.awt.*;
import java.util.Arrays;

/**
 * Project name(项目名称)：算法_单循环链表的实现_链表的删除
 * Package(包名): PACKAGE_NAME
 * Class(类名): MyCircleLinkedList
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/16
 * Time(创建时间)： 11:17
 * Version(版本): 1.0
 * Description(描述)： 删除循环链表中指定位置的结点，并返回其值。
 */

@SuppressWarnings("all")
public class MyCircleLinkedList
{
    private Node head;//头结点, 不存数据
    private Node tail;//尾结点, 指向链表的最后一个节点
    private int size;

    public MyCircleLinkedList()
    {
        head = new Node(Integer.MIN_VALUE, null);
        head.next = head;
        tail = head;
        size = 0;
    }

    /**
     * 添加到链表尾部
     *
     * @param item
     */
    public void add(int item)
    {
        Node node = new Node(item, tail.next);
        tail.next = node;
        tail = node;
        ++size;
    }

    public void add(int item, int index)
    {
        if (size == 0 && index == 0)
        {
            Node node = new Node(item, head);
            node.next = head;
            head.next = node;
            tail = node;
            size++;
            return;
        }
        if (index < 0 || index > size)
        {
            System.out.println("异常！！！索引为" + index + "大小为" + size);
            Toolkit.getDefaultToolkit().beep();
            return;
        }
        if (index == size)
        {
            Node node = new Node(item, head);
            Node node1 = head;
            while (node1 != tail)
            {
                node1 = node1.next;
            }
            node.next = head;
            node1.next = node;
            tail = node;
            size++;
        }
        else
        {
            Node node = new Node(item, head);
            Node node1 = head;
            for (int i = 0; i < index; i++)
            {
                node1 = node1.next;
            }
            node.next = node1.next;
            node1.next = node;
            //tail = node;
            size++;
        }
    }

    /**
     * 遍历链表并输出元素
     */
    public void output()
    {
        Node node = head;
        node = node.next;
        System.out.println("数量：" + size);

        while (node != tail)
        {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.print(node.item);
         /*
        for (int i = 0; i < size; i++)
        {
            System.out.print(node.item + " ");
            node = node.next;
        }
        */
        System.out.println();
    }


    /**
     * 删除从头结点开始的第index个结点
     * index从0开始
     *
     * @param index
     * @return
     */
    public int remove(int index)
    {
        checkPosIndex(index);

        /********** Begin *********/
        if (index == size - 1)
        {
            Node node = head;
            while (node.next != tail)
            {
                node = node.next;
            }
            int result = node.next.item;
            node.next = head;
            tail = node;
            size--;
            return result;
        }
        else
        {
            Node node = head;
            for (int i = 0; i < index; i++)
            {
                node = node.next;
            }
            int result = node.next.item;
            node.next = node.next.next;
            size--;
            return result;
        }

        /********** End *********/
    }

    public int remove()
    {
        Node node = head;
        while (node.next != tail)
        {
            node = node.next;
        }
        int result = node.next.item;
        node.next = head;
        tail = node;
        size--;
        return result;
    }

    public int get(int index)
    {
        checkPosIndex(index);
        Node node = head;
        for (int i = 0; i < index; i++)
        {
            node = node.next;
        }
        return node.next.item;
    }

    public void sort()
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        int[] array = new int[size];
        Node node = head;
        node = node.next;
        for (int i = 0; i < size; i++)
        {
            array[i] = node.item;
            node = node.next;
        }
        /*
        for (int s : array)
        {
            System.out.print(s + " ");
        }
         */
        Arrays.sort(array);
        node = head;
        node = node.next;
        for (int i = 0; i < size; i++)
        {
            node.item = array[i];
            node = node.next;
        }
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("排序算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("排序算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("排序算法运行时间： " + final_runtime + "秒");
        }
        //------------------------------------------------------
    }

    public void sort_desc()
    {
        long startTime = System.nanoTime();   //获取开始时间
        int[] array = new int[size];
        Node node = head;
        node = node.next;
        for (int i = 0; i < size; i++)
        {
            array[i] = node.item;
            node = node.next;
        }
        /*
        for (int s : array)
        {
            System.out.print(s + " ");
        }
         */
        q_sort qSort = new q_sort();
        qSort.quickSort(array, 0, array.length - 1);
        node = head;
        node = node.next;
        for (int i = 0; i < size; i++)
        {
            node.item = array[i];
            node = node.next;
        }
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("排序算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("排序算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("排序算法运行时间： " + final_runtime + "秒");
        }
    }

    public boolean isEmpty()
    {
        return head.next == head;
    }

    public int size()
    {
        return size;
    }

    private void checkPosIndex(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    //结点内部类
    private static class Node
    {
        int item;
        Node next;

        Node(int item, Node next)
        {
            this.item = item;
            this.next = next;
        }
    }
}
