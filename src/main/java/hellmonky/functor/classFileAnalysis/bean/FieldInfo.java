package hellmonky.functor.classFileAnalysis.bean;

import hellmonky.functor.classFileAnalysis.bean.accessflags.AccessFlags;
import hellmonky.functor.classFileAnalysis.bean.accessflags.FieldAccessFlags;
import hellmonky.functor.classFileAnalysis.bean.attributeinfo.AttributeInfo;
import hellmonky.functor.classFileAnalysis.bean.attributeinfo.BasicAttributeInfo;
import hellmonky.functor.classFileAnalysis.bean.basictype.U2;
import hellmonky.functor.classFileAnalysis.bean.constantpool.ConstantPool;
import hellmonky.functor.classFileAnalysis.bean.constantpool.ConstantUtf8Info;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chenyangli.
 */
public class FieldInfo {

    private ConstantPool constantPool;

    private short accessFlags;
    private short nameIndex;
    private short descriptorIndex;
    private short attributesCount;
    private BasicAttributeInfo[] attributes;

    public FieldInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public void read(InputStream inputStream) {
        U2 accessFlagsU2 = U2.read(inputStream);
        U2 nameIndexU2 = U2.read(inputStream);
        U2 descriptorIndexU2 = U2.read(inputStream);
        U2 attributesCountU2 = U2.read(inputStream);
        this.accessFlags = accessFlagsU2.getValue();
        this.nameIndex = nameIndexU2.getValue();
        this.descriptorIndex = descriptorIndexU2.getValue();
        this.attributesCount = attributesCountU2.getValue();

        ArrayList<BasicAttributeInfo> basicAttributeInfoList = new ArrayList<BasicAttributeInfo>();
        for (int i = 0; i < attributesCount; i++) {
            short attributeNameIndex = U2.read(inputStream).getValue();
            BasicAttributeInfo basicAttributeInfo = BasicAttributeInfo.newAttributeInfo(constantPool, attributeNameIndex);
            basicAttributeInfo.read(inputStream);
        }
        this.attributes = basicAttributeInfoList.toArray(new AttributeInfo[0]);
    }

    @Override
    public String toString() {
        return "FieldInfo{" +
                "accessFlags=" + accessFlags + ": " + AccessFlags.getFormattedAccessFlags(new FieldAccessFlags(), accessFlags) +
                ", nameIndex=" + nameIndex + " [name = " +
                ((ConstantUtf8Info) (constantPool.getCpInfo()[nameIndex - 1])).getValue() + "]" +
                ", descriptorIndex=" + descriptorIndex + " [descriptor = " +
                ((ConstantUtf8Info) (constantPool.getCpInfo()[descriptorIndex - 1])).getValue() + "]" +
                ", attributesCount=" + attributesCount +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }

}
