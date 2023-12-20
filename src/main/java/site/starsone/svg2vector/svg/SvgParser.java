package site.starsone.svg2vector.svg;

import site.starsone.svg2vector.svg.attribute.AttributeDispatcher;
import site.starsone.svg2vector.svg.attribute.style.Attributes;
import site.starsone.svg2vector.svg.shape.ShapeDispatcher;
import site.starsone.svg2vector.xml.XmlHelper;
import site.starsone.svg2vector.xml.XmlPathNode;
import site.starsone.svg2vector.xml.constant.AndroidQName;
import com.sun.istack.internal.Nullable;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

public class SvgParser {

    private static final String SVG_ATTRIBUTE_WIDTH = "width";
    private static final String SVG_ATTRIBUTE_HEIGHT = "height";
    private static final String SVG_ATTRIBUTE_VIEW_BOX = "viewBox";
    private static final String PATH_ATTRIBUTE_D = "d";

    private XmlHelper mXmlHelper = new XmlHelper();
    private Element mRootElement;

    public SvgParser() {

    }

    public String parseSvg(File file,int size) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            mRootElement = document.getRootElement();

            int trueSize = 24;
            if (size > 0) {
                trueSize = size;
            }

            mXmlHelper.addRootAttribute(AndroidQName.WIDTH, trueSize+"dp");
            mXmlHelper.addRootAttribute(AndroidQName.HEIGHT, trueSize+"dp");

            String viewBox = SvgHelper.getAttributeText(mRootElement, SVG_ATTRIBUTE_VIEW_BOX, "");
            if (!viewBox.isEmpty()) {
                String[] box = viewBox.split("\\s+");
                if (box.length == 4) {
                    mXmlHelper.addRootAttribute(AndroidQName.VIEWPORT_WIDTH, box[2]);
                    mXmlHelper.addRootAttribute(AndroidQName.VIEWPORT_HEIGHT, box[3]);
                }
            }
            searchShapeNode(mRootElement, null);
            //System.out.println(mXmlHelper.getDocumentString());
            return mXmlHelper.getDocumentString();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 递归搜索支持的图形节点
     */
    private void searchShapeNode(Element parent, @Nullable PathNodeSearchState state) {
        for (Iterator<Element> iterator = parent.elementIterator(); iterator.hasNext(); ) {
            Element element = iterator.next();
            if (parent == mRootElement) {
                //独立节点重置state
                state = null;
            }
            if (element.getName().equalsIgnoreCase("g") && element.hasMixedContent()) {
                //如果g里面有子节点
                state = inheritGroupStyle(element, state);
                searchShapeNode(element, state);
            } else if (ShapeDispatcher.isShapeSupported(element.getName())) {
                //图形节点
                if (state == null) {
                    state = new PathNodeSearchState();
                }
                XmlPathNode node = ShapeDispatcher.dispatch(element, state.attributes);
                if (node != null) {
                    //for (double[] doubles : state.attributes.matrixHelper.getMatrix().getArray()) {
                    //    System.out.println(Arrays.toString(doubles));
                    //}
                    //System.out.println();
                    mXmlHelper.addPath(node);
                }
            }
        }
    }

    /**
     * 继承group 样式
     */
    private PathNodeSearchState inheritGroupStyle(Element groupElement, PathNodeSearchState state) {
        if (state == null) {
            state = new PathNodeSearchState();
        }
        for (Attribute attribute : groupElement.attributes()) {
            AttributeDispatcher.dispatch(attribute.getName(), attribute.getValue(), state.attributes);
        }
        return state;
    }

    private static class PathNodeSearchState {
        Attributes attributes = new Attributes();
    }

}
