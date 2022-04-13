package com.ty.chapter02

import java.io.{File, PrintWriter}

import scala.io.{BufferedSource, Source}

/**
 * @author ty
 * @date 2022/4/13 20:28
 * @describe
 */
object Test06_FileIO {

  def main(args: Array[String]): Unit = {
    // 读取文件数据
    val readFile: BufferedSource = Source.fromFile("src/main/resources/fileTest01.txt")
    readFile.foreach(print)
    readFile.close()

    // 写入文件
    val write = new PrintWriter(new File("src/main/resources/fileTest02.txt"))
    write.write("测试scala写入文件")
    write.close()
  }

}
