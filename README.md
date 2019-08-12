# 排序算法

##Example
所有排序算法都继承自[Example类](https://github.com/SunDDD/Sort/blob/master/src/com/algorithms/sort/example/Example.java)
该类实现了less方法和exch方式，使任何实现了Comparable接口的数组都可以通过使用Example类的子排序类进行排序
常用的数据类型如String,Integer等都已经实现了Comparable接口

自定义的类如需使用排序算法，只要类似如下的Date类实现Comparable接口接口即可
