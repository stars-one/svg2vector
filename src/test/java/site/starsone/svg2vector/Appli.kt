package site.starsone.svg2vector

import java.io.File

fun main() {
    val file = File("E:\\download\\新建文件夹\\arrow-right-circle-fill.svg")

    val outputFile = File(file.parentFile,file.nameWithoutExtension.replace("-","_")+".xml")

    SvgUtils.toXmlFile(file, outputFile)
    println("输出xml文件为 $outputFile")


    val svgStr = """
        <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M6 10H9L5 15L1 10H4V8C4 5.23858 6.23858 3 9 3H13V5H9C7.34315 5 6 6.34315 6 8V10ZM11 9H21C21.5523 9 22 9.44772 22 10V20C22 20.5523 21.5523 21 21 21H11C10.4477 21 10 20.5523 10 20V10C10 9.44772 10.4477 9 11 9Z"/></svg>
    """.trimIndent()
    val outputFile1 = File("test.xml")
    SvgUtils.toXmlFile(svgStr, outputFile1)
    println("输出xml文件为 $outputFile1")
}