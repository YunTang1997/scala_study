package com.ty.chapter06

/**
 * @author ty
 * @date 2022/5/4 16:11
 * @describe 使用特质自身类型的方式实现依赖注入
 */
object Test16_TraitSelfType {
  def main(args: Array[String]): Unit = {
    val registerUser: RegisterUser = new RegisterUser("Tom", "123456")
    registerUser.insert()
  }
}

/**
 * 定义用户类
 * @param name 属性name
 * @param password 属性password
 */
class User(var name: String, var password: String)


trait UserDao {

  /*
  1、UserDao中想使用User类中的属性或者方法，但是又不想通过继承的方式是的两者产生关系，可以使用特质自身类型的方式实现依赖注入
  2、使用时通过this调用属性或者方法
  3、"_"只是一个别名可以使用其它任意字符充当别名
   */
  _: User =>

  /**
   * 向数据库里插入数据
   * 使用User中的属性
   */
  def insert(): Unit = println(s"insert into db: ${this.name}, ${this.password}")
}

/**
 * 定义注册类
 * @param name 属性name
 * @param password 属性password
 */
class RegisterUser(name: String, password: String) extends User(name, password) with UserDao