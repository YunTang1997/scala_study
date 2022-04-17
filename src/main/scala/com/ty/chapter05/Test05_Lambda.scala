package com.ty.chapter05

/**
 * @author ty
 * @date 2022/4/17 9:34
 * @describe 匿名函数的基本用法
 */
object Test05_Lambda {
  def main(args: Array[String]): Unit = {
    // 用法1，将匿名函数直接赋给一个变量
    val fun = (name: String) => {
      println(name)
    }
    fun("Tom")
    println("========================")

    // 用法2，直接将匿名函数作为参数传给另外一个函数，注意函数参数的写法：String => Unit
    def function0(fun: String => Unit): Unit = {
      fun("Alice")
    }

    // 将fun函数作为参数转入function0函数
    function0(fun)
    println("========================")

    // 将整个匿名函数作为参数传入function0函数
    function0((name: String) => {
      println(name)
    })

    println("======匿名函数至简原则=====")
    //（1）参数的类型可以省略，会根据形参进行自动的推导
    function0((name) => {
      println(name)
    })

    println("========================")

    //（2）类型省略之后，发现只有一个参数，则圆括号可以省略；其他情况：没有参数和参数超过1的永远不能省略圆括号
    function0(name => {
      println(name)
    })

    println("========================")

    //（3）匿名函数如果只有一行，则大括号也可以省略
    function0(name => println(name))

    println("========================")

    //（4）如果参数只出现一次，则参数省略且后面参数可以用_代替
    function0(println(_))

    println("========================")

    //（5) 如果可以推断出，当传入的println是一个函数体，而不是调用语句，则可以直接省略_
    function0(println)

    println("======二元函数=====")
    // 定义一个二元函数
    def dualFunctionOneAndTwo(fun: (Int, Int) => Int): Int = {
      fun(1, 2)
    }

    val f1 = (a: Int, b: Int) => a + b
    val f2 = (a: Int, b: Int) => a - b

    // 调用
    println(dualFunctionOneAndTwo(f1))
    println(dualFunctionOneAndTwo(f2))
    println(dualFunctionOneAndTwo((a, b) => a + b))
    println(dualFunctionOneAndTwo((a, b) => a - b))
    // 使用_代替变量，注意入参变量的顺序不能变
    println(dualFunctionOneAndTwo(_ + _))
    // 代表a - b
    println(dualFunctionOneAndTwo(_ - _))
    // 代表b - a
    println(dualFunctionOneAndTwo(-_ + _))
  }
}
