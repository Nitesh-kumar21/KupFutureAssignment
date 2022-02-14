package com.knoldus.Directory

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import java.io.File
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class FileDirectory {
    def fileSubdirectory(path: String): Future[List[String]] = Future {
      def fileSubdirectoryHelper(dir: File, isFileDirectory: Boolean = true): List[File] = {
        val files = dir.listFiles
        files ++
          files
            .filter(_.isDirectory)
            .filter(_ => isFileDirectory)
            .flatMap(fileSubdirectoryHelper(_, isFileDirectory))
      }.toList

      val list: Seq[File] = fileSubdirectoryHelper(new File(path))
      list.asInstanceOf[List[String]]

    }
}