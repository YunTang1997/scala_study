package com.ty.chapter02

/**
 * @author ty
 * @date 2022/4/13 20:10
 * @describe scala字符串相关用法
 */
object Test04_String {

  def main(args: Array[String]): Unit = {
    val name: String = "Tom"
    val age: Int = 18

    //字符串重复拼接使用"*"
    println(name * 3)

    // 字符串模板（插值字符串），${}表示需要插入的值
    println(s"${name}已经${age}岁啦！")

    val pi: Double = 3.1415926
    // 格式化显示
    println(f"圆周率保留两位小数为：${pi}%2.2f") // 第一个2表示整数部分长度>=2，不足空格补全，第二个2表示小数位数为2位，四舍五入

    // 原生字符串（字符串是什么样子就输出什么样子，不会做任何转义）
    println(raw"???//dasd  dasidjoa")

    // 三引号，表示原格式输出，一般用于多行字符串的情况
    val sql: String =
      s"""
        |select * from
        |table where
        |name = ${name} and
        |age < ${age}
        |""".stripMargin
    println(sql)
  }
}
