// DISCLAIMER: THIS IS A REPRODUCTION CODE, DO NOT USE IT WHATEVER ARE YOU DOING.

package example

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.Await

import slick.jdbc.H2Profile.api._

object Repro extends App {
  val db = Database.forConfig("db")

  val testQuery = sql"SELECT 1e4".as[Int].headOption
  
  val res = Await.result(
    db.run(testQuery).map(_.contains(1e4)),
    Duration.Inf
  )

  println(s"Everything worked fine m8 => ${res}")
}
