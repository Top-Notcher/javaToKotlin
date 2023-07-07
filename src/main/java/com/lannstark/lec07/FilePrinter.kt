package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader


class FilePrinter {

    //3. 프로젝트 내 파일의 내용물을 읽어오는 예제
    fun readFile() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }

    // 4. 프로젝트 내 파일의 내용물을 읽어오는 예제
    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}