package site.starsone.svg2vector.svg.attribute.group.transform;

import site.starsone.svg2vector.tool.MatrixHelper;

class SkewX implements ITransform {
    @Override
    public void transformMatrix(MatrixHelper matrixHelper, double[] params) {
        if (params.length == 1) {
            matrixHelper.preSkew(params[0], 0);
        }
    }
}
