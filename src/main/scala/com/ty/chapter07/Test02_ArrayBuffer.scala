package com.ty.chapter07

import scala.collection.mutable.ArrayBuffer

/**
 * @author tangyun
 * @date 2022/5/6 7:40 下午
 */
object Test02_ArrayBuffer {
  def main(args: Array[String]): Unit = {
    // 1、创建ArrayBuffer，不指定ArrayBuffer的初始大小，scala会默认创建一个大小为16的空数组
    val arr01: ArrayBuffer[Int] = new ArrayBuffer[Int]()
    // 通过伴生对象的apply方法创建ArrayBuffer
    val arr02 = ArrayBuffer(11, 22, 33)

    // 2、输出元素
    println(arr02.mkString("_"))

    // 3、ArrayBuffer数组的元素遍历方法参考Array

    // 4、ArrayBuffer元素的添加方法和Array略有不同，ArrayBuffer采用的是 +=（+=:、append、prepend、insert）的方法，该方法会将添加元素之后的数组引用返回
    // += 表示"向后"追加
    arr01 += 99
    println(arr01.mkString("_"))

    // +=: 表示"向前"追加
    100 +=: arr01
    println(arr01.mkString("_"))

    // append、prepend、insert（对于可变数组建议用这三个方法添加元素）
    arr01.append(101) // 向后追加
    arr01.prepend(102) // 向前追加
    arr01.insert(0, 103) // 指定索引位置添加
    println(arr01.mkString("_"))

    /*arr01.appendAll() // 向后追加一个数组
    arr01.prependAll() // 向前追加一个数组
    arr01.insertAll() // 指定索引， 直接追加一个数组*/

    arr01.remove(101) // 删除数组中的指定索引的元素
    arr01.remove(0, 3) // 从指定索引开始，连续删除多少个数

    arr01 -= 99 // 删除数组中的指定元素

    // 5、可变数组与不可变数组之间的转换
    val arr03: ArrayBuffer[Int] = ArrayBuffer(22, 33, 44)
    // 5.1、可变数组转不可变数组
    val array = arr03.toArray

    val arr04: Array[Int] = Array(11, 22)
    // 5.2、不可变数组转可变数组
    val buffer = arr04.toBuffer
  }
}
