# 哈希表

## 哈希算法
 * 哈希函数：

        1）直接定址法：即自身函数（H（key）= key,或 H（key）= a x Key+b）
        2) 数字分析法：即key已知的情况下，对key作分析，取key中非重复属性去计算。
        3）平方取中法：key平方后取中间几位。
        4）折叠法：将关键字分割成位数相同的几部分，然后取这几部分的叠加和
        5）除留余数法：取关键字某个不大于哈希表表长m的数p后除得的余数作为哈希地址
        6）随机数法：
        
  * 哈希函数的选择需要考虑的因素


        1）计算哈希函数所需时间
        2）关键字的长度
        3）哈希表的大小
        4）关键字的分布情况
        5）记录的查找频率
    
    平均查找长度
    
        1）开放定址法：
            线性探测法:用线性函数进行
            二次探测法：用二次函数进行
            随机探测法：用伪随机数进行
        2）再哈希法：用不同的哈希函数再次计算地址
        3）链地址法：即将同义词的记录存储在同一线性链表中
        4）公共溢出区法：即将产生冲突的的都存放在一个公共溢出区内