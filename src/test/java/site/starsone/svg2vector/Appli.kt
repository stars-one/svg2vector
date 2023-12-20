package site.starsone.svg2vector

import java.io.File

fun main() {
    val file = File("E:\\download\\新建文件夹\\arrow-right-circle-fill.svg")

    val outputFile = File(file.parentFile,file.nameWithoutExtension.replace("-","_")+".xml")

    SvgUtils.toXmlFile(file, outputFile)
    println("输出xml文件为 $outputFile")
}