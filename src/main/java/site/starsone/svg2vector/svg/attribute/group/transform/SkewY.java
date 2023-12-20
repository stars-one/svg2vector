package site.starsone.svg2vector.svg.attribute.group.transform;

import site.starsone.svg2vector.tool.MatrixHelper;

class SkewY implements ITransform{
    @Override
    public void transformMatrix(MatrixHelper matrixHelper, double[] params) {
        if (params.length == 1) {
            matrixHelper.preSkew(0, params[0]);
        }
    }
}
