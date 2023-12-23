# svg2vector

基于[DonkiChen/svg2vector: 批量转换svg文件为Android可用的xml](https://github.com/DonkiChen/svg2vector)项目改造的代码,方便其他项目依赖使用

可以批量将svg文件转为Android里的xml图标文件

<img src="https://jitpack.io/v/stars-one/svg2vector.svg" />

## 引入依赖

### Maven引入

**1. 添加仓库**

由于jar包是上传在jitpack仓库中,所以得在项目的pom.xml添加仓库
```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```

**2.添加依赖**
```
<dependency>
	    <groupId>com.github.stars-one</groupId>
	    <artifactId>svg2vector</artifactId>
	    <version>1.1</version>
	</dependency>
```

### Gradle引入

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

```
dependencies {
    implementation 'com.github.stars-one:svg2vector:1.1'
}
```

### 2.使用

svg文件转为xml文件:

```kotlin
val file = File("E:\\download\\新建文件夹\\arrow-right-circle-fill.svg")

val outputFile = File(file.parentFile,file.nameWithoutExtension.replace("-","_")+".xml")

SvgUtils.toXmlFile(file,outputFile)
println("输出xml文件为 $outputFile")
```

svg代码转为xml文件:

```kotlin
 val svgStr = """
        <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M6 10H9L5 15L1 10H4V8C4 5.23858 6.23858 3 9 3H13V5H9C7.34315 5 6 6.34315 6 8V10ZM11 9H21C21.5523 9 22 9.44772 22 10V20C22 20.5523 21.5523 21 21 21H11C10.4477 21 10 20.5523 10 20V10C10 9.44772 10.4477 9 11 9Z"/></svg>
    """.trimIndent()
    val outputFile1 = File("test.xml")
    SvgUtils.toXmlFile(svgStr, outputFile1)
    println("输出xml文件为 $outputFile1")
```