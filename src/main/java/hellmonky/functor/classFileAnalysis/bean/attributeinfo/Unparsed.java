package hellmonky.functor.classFileAnalysis.bean.attributeinfo;

import hellmonky.functor.classFileAnalysis.bean.basictype.U1;
import hellmonky.functor.classFileAnalysis.bean.basictype.U4;
import hellmonky.functor.classFileAnalysis.bean.constantpool.ConstantPool;

import java.io.InputStream;

/**
 * Created by chenyang li.
 */
public class Unparsed extends BasicAttributeInfo {

    public Unparsed(ConstantPool constantPool, short attributeNameIndex) {
        super(constantPool);
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        U4 attributeLengthU4 = U4.read(inputStream);
        setAttributeLength(attributeLengthU4.getValue());
        for (int i = 0; i < getAttributeLength(); i++) {
            U1.read(inputStream);
        }
    }
}
