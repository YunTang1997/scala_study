package com.ty.chapter05

/**
 * @author ty
 * @date 2022/4/17 12:09
 * @describe
 */
object Test07_CollectionOperation {
  def main(args: Array[String]): Unit = {
    /**
     * 自定义函数操作传入，依次处理collection中的元素，并将处理后的结果存入集合中返回
     * @param collection 需要处理的collection对象
     * @param ope 需传入的函数操作
     * @return 处理后的集合结果
     */
    def arrayOperation(collection: Array[Int], ope: Int => Int): Array[Int] = {
      for(i <- collection) yield ope(i)
    }

    /**
     * 传入Int类型的变量a，并将a翻倍返回
     * @param a
     * @return a * 2
     */
    def f(a: Int): Int = {
      a * 2
    }

    // 调用arrayOperation
    val coll: Array[Int] = Array(11, 21, 31, 45)
    val res01 = arrayOperation(coll, f)
    // 输出处理之后的结果
    println(res01.mkString(", "))

    // 所有元素加1，通过匿名函数传入，由于arrayOperation中已经定义了ope的参数类型，所以在调用的时候无需指定类型
    val res02 = arrayOperation(coll, _ + 1)
    println(res02.mkString(", "))
  }
}
