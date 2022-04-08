package com.ty.chapter01

/**
 * @author ty
 * @date 2022/4/8 22:32
 * @describe 同时定义伴生类和伴生对象的时候，必须定义在同一个文件内
 */

/**
 * 伴生类，伴生类与伴生对象的属性是可以相互调用的
 * @param name 名称
 * @param age 年龄
 */
class Student(name: String, age: Int) {
  def printInfo(): Unit = {
    println("name: " + name + ", age: " + Student.school)
  }
}

/**
 * Student类的伴生对象，名称必须和class名称一样
 */
object Student {
  val school: String = "清华大学"

  // main方法需要定义在object伴生对象中
  def main(args: Array[String]): Unit = {
    val alice = new Student("alice", 20)
    val tom = new Student("tom",18)
    alice.printInfo()
    tom.printInfo()
  }
}
