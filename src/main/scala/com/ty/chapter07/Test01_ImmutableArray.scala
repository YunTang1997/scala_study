package com.ty.chapter07

/**
 * @author tangyun
 * @date 2022/5/6 5:27 下午
 */
object Test01_ImmutableArray {
  def main(args: Array[String]): Unit = {
    // 1、创建Array的普通方式
    val arr01: Array[Int] = new Array[Int](5)
    // 2、通过Array的伴生对象中的apply方法创建，apply函数名可以省略
//    val arr02: Array[Int] = Array.apply(10, 20, 30, 40 ,50)
    val arr02: Array[Int] = Array(10, 20, 30, 40 ,50)

    // 3、array的值的获取，这里其实是调用的Array类本身的apply()方法
    println(arr01(0))
    // 4、array的赋值，这里其实是调用的Array类本身的update()方法
    arr01(0) = 20

    // 5、数组的遍历
    // 5.1、普通的遍历方式
    for (i <- 0 until arr02.length) {
      println(arr02(i))
    }

    println("=====================")
    // arr02.indices表示arr02数组中的索引，返回的是一个range
    for (i <- arr02.indices) {
      println(arr02(i))
    }

    println("=====================")
    // 5.2、增强for循环遍历元素
    for (elem <- arr02) {
      println(elem)
    }

    println("=====================")
    // 5.3、通过迭代器的方式遍历元素
    val iterator = arr02.iterator
    while (iterator.hasNext) {
      println(iterator.next())
    }

    println("=====================")
    // 6、调用foreach方法
    arr02.foreach((elem: Int) => println(elem))
    //    arr02.foreach( println )

    println("=====================")
    // 7、将数组中的元素转换为String输出
    println(arr02.mkString("_"))

    // 6、添加元素
    println("=====================")
    // 方法 :+ 表示将元素添加在数组末尾
    val newArr = arr02.:+(55) // 向不可变数组中添加元素，会返回新数组
    println(newArr.mkString("_"))

    // 方法 +: 表示将元素添加在数组首位
    val newArr2 = arr02.+:(66)
    println(newArr2.mkString("_"))

    // 上述添加元素的方法 . 可以省略
    val newArr3 = arr02 :+ 77
    println(newArr3.mkString("_"))
    // 注意 : 总是在靠近数组的一边，+ 总是在靠近要添加的元素的一边
    val newArr4 = 88 +: 99 +: arr02 :+ 56 :+ 34
    println(newArr4.mkString("_"))
  }
}
