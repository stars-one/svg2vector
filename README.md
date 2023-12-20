# svg2vector

基于[DonkiChen/svg2vector: 批量转换svg文件为Android可用的xml](https://github.com/DonkiChen/svg2vector)项目改造的代码,方便其他项目依赖使用

可以批量将svg文件转为Android里的xml图标文件

## 使用

### 1.添加依赖
### 2.使用

```kotlin
val file = File("E:\\download\\新建文件夹\\arrow-right-circle-fill.svg")

val outputFile = File(file.parentFile,file.nameWithoutExtension.replace("-","_")+".xml")

SvgUtils.toXmlFile(file,outputFile)
println("输出xml文件为 $outputFile")
```