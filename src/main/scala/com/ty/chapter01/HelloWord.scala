package com.ty.chapter01

/**
 * @author ty
 * @date 2022/4/8 19:48
 * @describe 声明一个单例对象HelloWord（伴生对象）
 */

// object，关键字，声明一个单例对象（伴生对象）
object HelloWord {

  /*
    main方法：从外部可以直接调用执行的方法
    def 方法名称(参数名称: 参数类型[泛型]): 函数返回值类型 = {方法体}
   */
  def main(args: Array[String]): Unit = {
    println("hello word")
    System.out.println("run java in scala")
  }
}
