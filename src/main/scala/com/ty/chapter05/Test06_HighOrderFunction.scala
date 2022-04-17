package com.ty.chapter05

/**
 * @author ty
 * @date 2022/4/17 11:26
 * @describe
 */
object Test06_HighOrderFunction {
  def main(args: Array[String]): Unit = {
    def function0(n: Int): Int = {
      printf("调用函数%s\n", "function0")
      n + 1
    }

    // 1、将函数作为值传递
    // 方式1
    val f1: Int => Int = function0
    println(f1(1))

    // 方式2
    val f2 = function0 _
    println(f2(2))

    // 2、函数作为函数的参数进行传递
    def function1(f: (Int, Int) => Int, a: Int, b: Int): Unit = {
      println("function1函数调用，结果为：" + f(a, b))
    }

    // 匿名函数传入
    function1((a, b) => a + b, 1, 2)

    // 3、函数可以作为返回值
    // 方式1，直接指明function2的返回值类型为：(Int, Int) => Int
    def function2(): (Int, Int) => Int = {
      def function3(a: Int, b: Int): Int = {
        a + b
      }

      // 直接将函数返回
      function3
    }

    // 得到函数function3的引用
    println(function2())
    // 调用function3
    println(function2()(1, 2))

    // 方式2，未直接指明function4的返回值类型为函数
    def function4() = {
      def function5(a: Int, b: Int): Int = {
        a + b
      }

      // 直接将函数返回
      function5 _
    }

    // 得到函数function5的引用
    println(function4())
    // 调用function5
    println(function4()(13, 15))
  }
}
