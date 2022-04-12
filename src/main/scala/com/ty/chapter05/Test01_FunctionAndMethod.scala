package com.ty.chapter05

/**
 * @author ty
 * @date 2022/4/12 22:30
 * @describe scala中的函数与方法
 */
object Test01_FunctionAndMethod {

  def main(args: Array[String]): Unit = {
    // 定义函数
    def sayHello(name: String): Unit = {
      println("hello, " + name)
    }

    // 调用函数，同一个Object或者Class中可以定义同名函数火方法
    // 如果存在同名的函数（方法），则需要看具体定义域决定调用的哪一个函数（方法）
    sayHello("tom")

    // 调用方法：类名.方法名(参数)
    Test01_FunctionAndMethod.sayHello("alice")
  }

  // 定义方法，方法一般定义在Object以及Class中，不会定义在函数中
  def sayHello(name: String): Unit = {
    println("hello, " + name)
  }
}
