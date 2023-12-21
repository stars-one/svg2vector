# svg2vector

基于[DonkiChen/svg2vector: 批量转换svg文件为Android可用的xml](https://github.com/DonkiChen/svg2vector)项目改造的代码,方便其他项目依赖使用

可以批量将svg文件转为Android里的xml图标文件

<img src="https://jitpack.io/v/Stars-One/svg2vector.svg" />

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

```kotlin
val file = File("E:\\download\\新建文件夹\\arrow-right-circle-fill.svg")

val outputFile = File(file.parentFile,file.nameWithoutExtension.replace("-","_")+".xml")

SvgUtils.toXmlFile(file,outputFile)
println("输出xml文件为 $outputFile")
```