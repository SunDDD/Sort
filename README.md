### 排序算法

#### Example
所有排序算法都继承自[Example类](https://github.com/SunDDD/Sort/blob/master/src/com/algorithms/sort/example/Example.java)
该类实现了less方法和exch方式，使任何实现了Comparable接口的数组都可以通过使用Example类的子排序类进行排序
常用的数据类型如String,Integer等都已经实现了Comparable接口

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

    public static void main(String[] args) {
        Date date1 = new Date(2009,10,15);
        Date date2 = new Date(2009,11,16);
        System.out.println(date1.compareTo(date2));
    }
}
```

---

