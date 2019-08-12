### 排序算法

#### Example
[Example类](https://github.com/SunDDD/Sort/blob/master/src/com/algorithms/sort/Example.java)为模板类，
不实现具体排序功能，但是提供了如判断数组是否有序，提供测试数据等功能，同时提供了less方法和exch方法实现了
两个元素之间的判断大小以及交换数组元素的功能，提高了代码的可读性，之后的所有排序算法均继承了该类。

本排序算法由参考了
> 算法（第四版）

该书提供了一个工具类实现标准输入、输出、可视化工具等，下载地址为[algs4.jar](http://www.crits.site/download/algs4.jar)，
运行代码时需要将jar包导入到工作空间中，IDEA可参考本人博客[IDEA配置](http://www.crits.site/2018/07/02/IDEA配置/)

任何实现了Comparable接口的数组都可以通过使用Example类的子排序类进行排序，
常用的数据类型如String,Integer等都已经实现了Comparable接口。
自定义的类如需使用排序算法，只需要实现Comparable接口即可，如以下的Date类
```code
public class Date implements Comparable<Date>{

    private final int day;
    private final int month;
    private final int year;

    public Date(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public int compareTo(Date that) {
        if (this.year > that.year) return +1;
        if (this.year < that.year) return -1;
        if (this.month > that.month) return +1;
        if (this.month < that.month) return -1;
        if (this.day > that.day) return +1;
        if (this.day < that.day) return -1;
        return 0;
    }
    
}
```
Example类的主函数提供了一个测试方法，可以在在其中更换排序方法如Selection.sort(), Merge.sort()等，检验算法的正确性，

---

#### 选择排序
首先介绍最简单的排序：选择排序，该排序的工作方法是: 
找到数组中最小的元素，放在第一位，接着找到第二小的元素放在第二位，以此类推，直到数组最后一位
为止。具体实现方法也很简单，在外层循环中进行从第一位到最后一位的遍历，之后在内层循环中找到剩下
元素中最小值，并与未排序的第一位进行交换。实现方法为：
[SelectionSort类](https://github.com/SunDDD/Sort/blob/master/src/com/algorithms/sort/selection/SelectionSort.java)中的sort方法. <br>

##### 时间按复杂度
对于长度为N的数组，易得选择排序大约需要N²/2次比较和N次交换，所以时间复杂度为O(N²)

##### 算法特点
选择排序有两个鲜明的特点：
1. 运行时间和输入无关。根据选择排序的原理，可以很清楚的得到每次扫描不能为下一次扫描提供任何信息
即任何长度相同的数组比较次数都是一样的，一个已经有序或者主键都相同的数组排序时间与完全随机的数组
排序时间相同。
2. 数据移动最少。根据实现方法可知，选择排序的数据交换次数与数组的大小是线性关系，即对于长度为N的数组
使用选择排序进行排序，交换次数为N，这个性质是其他的排序算法不能不具备的。

##### 算法可视化
以下是20个元素的样本交换示意图，同时该图像的实现过程也在SelectionSort类的主函数中给出。
其中红色为两个元素即将进行交换，粉色该元素与自己进行交换，灰色为未参与交换，但需要注意的是
灰色元素参与了比较。
<div align="center">
    <img src="image/selection.gif" width=50% height=50%/>
</div>

