package com.ty.chapter06

/**
 * @author ty
 * @date 2022/4/28 22:27
 * @describe scala中的构造器分为“主构造器”以及“辅助构造器”，辅助构造器必须直接或间接的方式调用主构造器，辅助构造器可以重载
 */
object Test05_Constructor {
  def main(args: Array[String]): Unit = {
    // 创建Student1对象
    val student1: Student1 = new Student1("Tom", 24)
    // 调用普通方法
    student1.Student1()

    /*
    运行结果：
    调用主构造器
    name = Tom, age = 0
    调用间接构造器1
    name = Tom, age = 24
    调用间接构造器2
    调用和类同名的普通方法
     */
  }
}

/**
 * 主构造器就是class+类名+(参数列表)、
 * 如果参数列表为空，则()可以省略
 */
class Student1() {

  var name: String = _
  var age: Int = _

  /**
   * 定义间接构造器1
   * @param name 参数name
   */
  def this(name: String) {
    // 直接调用主构造器
    this()
    this.name = name
    println(s"name = ${name}, age = ${age}")
    println("调用间接构造器1")
  }

  /**
   * 间接构造器重载
   * @param name 参数name
   * @param age 参数age
   */
  def this(name: String, age: Int) {
    // 间接调用主构造器
    this(name)
    this.age = age
    println(s"name = ${name}, age = ${age}")
    println("调用间接构造器2")
  }

  def Student1(): Unit = {
    println("调用和类同名的普通方法")
  }

  println("调用主构造器")
}
