package com.ty.chapter05

/**
 * @author ty
 * @date 2022/4/24 22:56
 * @describe scala中的懒加载，有点类似于之前的“传名参数”，函数返回值被声明为lazy时，函数的执行将被推迟，直到首次取值，该函数才会被执行，对应的函数被称为“惰性函数”
 */
object Test12_Lazy {
  def main(args: Array[String]): Unit = {
    lazy val res: Int = sum(11, 22)
    println("1、函数被调用")
    // 初次调用会执行sum函数，res相当于sum(11, 22)
    println("2、res: " + res)
    // 再次调用则不会再次执行sum函数了，直接会使用之前调用之后的结果值
    println("4、res: " + res)

    // 运行结果
    /*
    1、函数被调用
    3、sum函数被调用
    2、res: 33
    4、res: 33
    */
  }

  def sum(i: Int, j: Int): Int = {
    println("3、sum函数被调用")
    i + j
  }
}
