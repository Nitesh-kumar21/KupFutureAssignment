import com.knoldus.Directory.FileDirectory
import org.scalatest.funsuite.AnyFunSuite

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


class FileDirectoryTest extends AnyFunSuite {
  val filePath1 = "./src"
  val filePath2 = "./src/test"

val fileSearch = new FileDirectory

  val resp1: Future[List[String]] = fileSearch.fileSubdirectory(filePath1)
  val resp2: Future[List[String]] = fileSearch.fileSubdirectory(filePath2)
  val result1: List[String] = List("./src/test", "./src/new", "./src/main", "./src/test/scala", "./src/test/scala/edu", "./src/test/scala/edu/knoldus", "./src/test/scala/edu/knoldus/SearchSpec.scala", "./src/main/scala", "./src/main/scala/edu", "./src/main/scala/edu/knoldus", "./src/main/scala/edu/knoldus/Search.scala", "./src/main/scala/edu/knoldus/Main.scala")
  val result2: List[String] = List("./src/test/scala", "./src/test/scala/edu", "./src/test/scala/edu/knoldus", "./src/test/scala/edu/knoldus/SearchSpec.scala")
  test("Searching the directory  src provide all the sub-directories and files of src directory") {
    for {
      response <- resp1
      r <- resp1
    } yield {
      assert(response == result1)
      assert(r.size == result1.size)
    }
  }
  test("Searching the directory src/test provide all the sub-directories and files of src/test directory") {
    for {
      response <- resp2
      r <- resp2
    } yield {
      assert(response == result2)
      assert(r.size == result2.size)
    }
  }
}
