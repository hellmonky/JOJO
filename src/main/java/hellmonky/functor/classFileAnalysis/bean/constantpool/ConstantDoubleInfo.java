package hellmonky.functor.classFileAnalysis.bean.constantpool;

import hellmonky.functor.classFileAnalysis.bean.basictype.U8;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantDoubleInfo extends ConstantPoolInfo {

    private double bytesValue;

    public ConstantDoubleInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U8 bytesValuesU8 = U8.read(inputStream);
        this.bytesValue = bytesValuesU8.getValue();
    }

    @Override
    public String toString() {
        return "ConstantDoubleInfo{" +
                "bytesValue=" + bytesValue +
                '}';
    }
}
