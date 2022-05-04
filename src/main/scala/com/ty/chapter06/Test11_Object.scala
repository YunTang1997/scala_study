package com.ty.chapter06

/**
 * @author ty
 * @date 2022/5/4 10:46
 * @describe 伴生对象
 */
object Test11_Object {
  def main(args: Array[String]): Unit = {
    // 通过伴生对象中的newStudent方法创建Student11对象
    var student1: Student11 = Student11.newStudent("Tom", 15)
    student1.info()

    var student2: Student11 = Student11.apply("alice", 18)
    student2.info()
    // 省略apply方法名
    var student3: Student11 = Student11("alice", 18)
    student3.info()
  }
}

/**
 * 定义Student11类，并将主构造器定义为私有，这样将无法通过new的方式创建Student11对象
 * @param name 属性name
 * @param age 属性age
 */
class Student11 private(var name: String, var age: Int) {
  def info(): Unit = {
    println(s"student11:(${name} ${age} ${Student11.stu_no})")
  }
}

/**
 * Student11类的伴生对象，所有Student11中的“静态元素”均可定义在该伴生对象中
 * 在在使用属性或者方法时，使用Student11.属性（方法）
 * 伴生类和伴生对象必须同名，两者之间没有“秘密”可言，均可相互访问所有的属性或者方法
 */
object Student11 {

  val stu_no: String = "No.1"

  /**
   * 由于Student11主构造器私有化，则可以在伴生对象中定义一个创建Student11对象的方法，类似于java中的单例模式
   * @param name 属性name
   * @param age 属性age
   * @return
   */
  def newStudent(name: String, age: Int): Student11 = new Student11(name, age)

  /**
   * 伴生对象中有一个特殊的apply方法，通过该方法创建对象时，apply方法名可以省略
   * @param name 属性name
   * @param age 属性age
   * @return
   */
  def apply(name: String, age: Int): Student11 = new Student11(name, age)
}
