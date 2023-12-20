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
            val xml = SvgParser().parseSvg(svgFile, size)
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

    }
}