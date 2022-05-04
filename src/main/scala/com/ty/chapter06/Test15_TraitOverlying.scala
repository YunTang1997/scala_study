package com.ty.chapter06

/**
 * @author ty
 * @date 2022/5/4 11:58
 * @describe 特质的叠加
 */
object Test15_TraitOverlying {

  def main(args: Array[String]): Unit = {
    val student: Student15 = new Student15
    student.increase() // talent increased

    val myBall: MyBall = new MyBall
    println(myBall.describe()) // MyBall is a red-foot-ball
  }
}

trait Knowledge {
  var amount: Int = 0
  def increase(): Unit = {
    println("knowledge increased")
  }
}

trait Talent {
  def singing(): Unit
  def dancing(): Unit
  def increase(): Unit = {
    println("talent increased")
  }
}

class Student15 extends Knowledge with Talent {

  /**
   * 于一个类可以混入（mixin）多个trait，且trait中可以有具体的属性和方法，若混入
   * 的特质中具有相同的方法（方法名，参数列表，返回值均相同），必然会出现继承冲突问题。
   *
   * 第一种，一个类（Sub）混入的两个trait（TraitA，TraitB）中具有相同的具体方法，且
   * 两个trait之间没有任何关系，解决这类冲突问题，直接在类（Sub）中重写冲突方法。
   */
  override def increase(): Unit = {
    // 特质叠加顺序，此时super指代的是Talent，从后往前（从右往左）Talent->Knowledge
    super.increase()
  }

  override def dancing(): Unit = println("dancing")

  override def singing(): Unit = println("singing")
}

/**
 * 一个类（Sub）混入的两个trait（TraitA，TraitB）中具有相同的具体方法，且
 * 两个trait继承自相同的trait（TraitC），及所谓的“钻石问题”，解决这类冲突问题，Scala
 * 采用了特质叠加的策略
 */
trait Ball {
  def describe(): String = "ball"
}

trait Color extends Ball {
  val color: String = "red"
  // super：Category
  override def describe(): String = color + "-" + super.describe()
}

trait Category extends Ball {
  val category: String = "foot"
  // super：Ball
  override def describe(): String = category + "-" +super.describe()
}

/**
 * 特质叠加排序规则：
 * 第一步：列出混入的第一个特质（Category）的继承关系，作为临时叠加顺序；
 * 第二步：列出混入的第二个特质（Color）的继承关系，并将该顺序叠加到临时顺序前边，已经出现的特质不再重复；
 * 第三步：将子类（MyBall）放在临时叠加顺序的第一个，得到最终的叠加顺序。
 *
 * 如果想要调用某个指定的混入特质中的方法，可以增加约束：super[]，例如super[Category].describe()。
 */
class MyBall extends Category with Color {
  // super：Color
  override def describe(): String = "MyBall is a " + super.describe()
}

