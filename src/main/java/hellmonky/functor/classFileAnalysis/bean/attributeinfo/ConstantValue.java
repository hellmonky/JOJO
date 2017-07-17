package hellmonky.functor.classFileAnalysis.bean.attributeinfo;

import hellmonky.functor.classFileAnalysis.bean.basictype.U2;
import hellmonky.functor.classFileAnalysis.bean.basictype.U4;
import hellmonky.functor.classFileAnalysis.bean.constantpool.ConstantPool;
import hellmonky.functor.classFileAnalysis.bean.constantpool.ConstantUtf8Info;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantValue extends BasicAttributeInfo {

    private short constantValueIndex;

    public ConstantValue(ConstantPool constantPool, short attributeNameIndex) {
        super(constantPool);
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        U4 attributeLengthU4 = U4.read(inputStream);
        U2 constantValueIndexU2 = U2.read(inputStream);
        setAttributeLength(attributeLengthU4.getValue());
        constantValueIndex = constantValueIndexU2.getValue();
    }

    @Override
    public String toString() {
        return "ConstantValue{" +
                "attributeNameIndex=" + getAttributeNameIndex() +
                " [attribute name = " + ((ConstantUtf8Info) (constantPool.getCpInfo()[getAttributeNameIndex() - 1])).getValue() + "]" +
                ", attributeLength=" + getAttributeLength() +
                ", constantValueIndex=" + constantValueIndex +
                '}';
    }
}
