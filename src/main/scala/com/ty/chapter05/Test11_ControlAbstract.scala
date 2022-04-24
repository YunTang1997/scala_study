package com.ty.chapter05

/**
 * @author ty
 * @date 2022/4/24 19:49
 * @describe 通过控制抽象实现while关键字的功能
 */
object Test11_ControlAbstract {

  def main(args: Array[String]): Unit = {

    /**
     * 传值参数就是指：一般来说将某一个值通过形参传入一个函数
     * “控制抽象”是指可以将”代码块“作为函数的参数传入，并且在函数体中每使用到表示代码块的变量，整个代码块的逻辑就会重新执行一次（也可以称之为传名参数）
     * 通过控制抽象以及闭包特性实现while关键字的功能
     * 入参condition: => Boolean表示，myWhile函数入参的是一个返回值为Boolean类型的代码块
     * (=> Unit) => Unit表示：myWhile函数返回值是一个入参为“=> Unit”类型返回值为Unit类型的函数
     * @param condition 控制while执行的条件
     * @return
     */
    def myWhile(condition: => Boolean): (=> Unit) => Unit = {
      def doLoop(operation: => Unit): Unit = {
        if (condition) {
          operation
          // 递归调用（柯里化的形式调用）
          myWhile(condition)(operation)
        }
      }

      doLoop
    }

    var n: Int = 10
    myWhile(n >= 1)({
      println(n)
      n -= 1
    })

    println("=========================")
    // 通过匿名函数优化结构
    def myWhile2(condition: => Boolean): (=> Unit) => Unit = {
      operation => {
        if (condition) {
          operation
          myWhile2(condition)(operation)
        }
      }
    }

    n = 10
    myWhile2(n >= 1)({
      println(n)
      n -= 1
    })

    println("=========================")
    // 通过柯里化优化结构
    // 验证是否为“尾递归”的注解
    @scala.annotation.tailrec
    def myFunction3(condition: =>Boolean)(operation: => Unit): Unit = {
      if (condition) {
        operation
        myFunction3(condition) (operation)
      }
    }

    n = 10
    myFunction3(n >= 1)({
      println(n)
      n -= 1
    })

  }
}
