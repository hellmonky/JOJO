package hellmonky.functor.classFileAnalysis.bean.attributeinfo;

import hellmonky.functor.classFileAnalysis.bean.basictype.U1;
import hellmonky.functor.classFileAnalysis.bean.constantpool.ConstantPool;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class AttributeInfo extends BasicAttributeInfo {

    private byte[] info;

    public AttributeInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public void read(InputStream inputStream) {
        info = new byte[(int) getAttributeLength()];
        for (int i = 0; i < getAttributeLength(); i++) {
            U1 byteU1 = U1.read(inputStream);
            info[i] = byteU1.getValue();
        }
    }

}
