package com.ty.chapter05

/**
 * @author ty
 * @date 2022/4/17 15:16
 * @describe
 */
object Test08_Practice {
  def main(args: Array[String]): Unit = {
    /*
    练习 1：定义一个匿名函数，并将它作为值赋给变量fun。函数有三个参数，类型分别为：Int，String，Char，返回值类型为：Boolean。
    要求调用函数fun(0, “”, ‘0’)，得到返回值为false，其它情况均返回true。
     */
    val fun: (Int, String, Char) => Boolean = (i: Int, s: String, c: Char) => if (i == 0 && s == "" && c == '0') false else true
    println(fun(0, "", '0'))
    println(fun(0, "aa", '2'))

    println("=========================")

    /*
    练习2：定义一个函数func，它接收一个Int类型的参数，返回一个函数（记作f1）。
    它返回的函数f1，接收一个String类型的参数，同样返回一个函数（记作f2）。函数f2接
    收一个Char类型的参数，返回一个Boolean的值。要求调用函数func(0) (“”) (‘0’)得到返回值为false，其它情况均返回true。
     */
    def func(i: Int): String => (Char => Boolean) = {
      def f1(s: String): Char => Boolean = {
        def f2(c: Char): Boolean = {
          if (i == 0 && s == "" && c == '0') false else true
        }

        f2
      }

      f1
    }

    println(func(0)("")('0'))
    println(func(0)("aa")('2'))

    println("=========================")

    // 将上述函数改写为匿名函数形式
    def func_new(i: Int): String => (Char => Boolean) = s => c => if (i == 0 && s == "" && c == '0') false else true
    println(func_new(0)("")('0'))
    println(func_new(0)("aa")('2'))

    println("=========================")

    // 函数的柯里化
    def fun1(i: Int)(s: String)(c: Char): Boolean = {
      if (i == 0 && s == "" && c == '0') false else true
    }

    println(fun1(0)("")('0'))
    println(fun1(0)("aa")('2'))
  }
}
