package site.starsone.svg2vector

import site.starsone.svg2vector.svg.SvgParser
import java.io.File

class SvgUtils {
    companion object {

        /**
         * 将svg文件转为xml文件
         * @param svgFile svg文件
         * @param outputFile 输出文件
         * @param size xml文件里的宽高属性(单位为dp,默认是24dp)
         */
        @JvmStatic
        fun toXmlFile(svgFile: File, outputFile: File, size: Int = 24): File {
            return toXmlFile(svgFile.readText(),outputFile,size)
        }

        /**
         * 将svg代码转为xml文件
         * @param svgStr svg文本代码
         * @param outputFile 输出文件
         * @param size xml文件里的宽高属性(单位为dp,默认是24dp)
         */
        @JvmStatic
        fun toXmlFile(svgStr: String, outputFile: File, size: Int = 24): File {
            val xml = SvgParser().parseSvg(svgStr.reader(), size)
            outputFile.writeText(xml)
            return outputFile
        }

        /**
         * 将svg文件转为xml文本
         * @param svgFile svg文件
         * @param size xml文件里的宽高属性(单位为dp,默认是24dp)
         */
        @JvmStatic
        fun toXmlString(svgFile: File, size: Int = 24): String {
            return SvgParser().parseSvg(svgFile, size)
        }

        /**
         * 将svg代码转为xml文本
         * @param svgStr svg文本代码
         * @param size xml文件里的宽高属性(单位为dp,默认是24dp)
         */
        @JvmStatic
        fun toXmlString(svgStr: String, size: Int = 24): String {
            return SvgParser().parseSvg(svgStr.reader(), size)
        }

    }
}