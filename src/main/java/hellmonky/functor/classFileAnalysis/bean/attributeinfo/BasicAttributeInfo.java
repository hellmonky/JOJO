package hellmonky.functor.classFileAnalysis.bean.attributeinfo;

import hellmonky.functor.classFileAnalysis.bean.constantpool.ConstantPool;
import hellmonky.functor.classFileAnalysis.bean.constantpool.ConstantPoolInfo;
import hellmonky.functor.classFileAnalysis.bean.constantpool.ConstantUtf8Info;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class BasicAttributeInfo {

    public ConstantPool constantPool;

    private short attributeNameIndex;
    private int attributeLength;

    public BasicAttributeInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public void read(InputStream inputStream) {
    }

    public static BasicAttributeInfo newAttributeInfo(ConstantPool constantPool, short attributeNameIndex) {
        BasicAttributeInfo basicAttributeInfo = null;
        String attributeName = null;
        ConstantPoolInfo constantPoolInfo = constantPool.getCpInfo()[attributeNameIndex - 1];
        if (constantPoolInfo instanceof ConstantUtf8Info) {
            attributeName = ((ConstantUtf8Info) constantPoolInfo).getValue();
        }
        System.out.println("attributeName = " + attributeName);
        if (attributeName.equals("Code")) {
            basicAttributeInfo = new Code(constantPool, attributeNameIndex);
        } else if (attributeName.equals("ConstantValue")) {
            basicAttributeInfo = new ConstantValue(constantPool, attributeNameIndex);
        } else if (attributeName.equals("Deprecated")) {
            basicAttributeInfo = new Deprecated(constantPool, attributeNameIndex);
        } else if (attributeName.equals("Exceptions")) {
            basicAttributeInfo = new Exceptions(constantPool, attributeNameIndex);
        } else if (attributeName.equals("LineNumberTable")) {
            basicAttributeInfo = new LineNumberTable(constantPool, attributeNameIndex);
        } else if (attributeName.equals("LocalVariableTable")) {
            basicAttributeInfo = new LocalVariableTable(constantPool, attributeNameIndex);
        } else if (attributeName.equals("LocalVariableTypeTable")) {
            basicAttributeInfo = new LocalVariableTypeTable(constantPool, attributeNameIndex);
        } else if (attributeName.equals("SourceFile")) {
            basicAttributeInfo = new SourceFile(constantPool, attributeNameIndex);
        } else if (attributeName.equals("Synthetic")) {
            basicAttributeInfo = new Synthetic(constantPool, attributeNameIndex);
        } else if (attributeName.equals("Signature")) {
            basicAttributeInfo = new Signature(constantPool, attributeNameIndex);
        } else if (attributeName.equals("BootstrapMethods")) {
            basicAttributeInfo = new hellmonky.functor.classFileAnalysis.bean.attributeinfo.BootstrapMethods(constantPool, attributeNameIndex);
        } else if (attributeName.equals("InnerClasses")) {
            basicAttributeInfo = new InnerClasses(constantPool, attributeNameIndex);
        } else {
            basicAttributeInfo = new hellmonky.functor.classFileAnalysis.bean.attributeinfo.Unparsed(constantPool, attributeNameIndex);
        }
        basicAttributeInfo.setAttributeNameIndex(attributeNameIndex);
        return basicAttributeInfo;
    }

    public short getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(short attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public long getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(int attributeLength) {
        this.attributeLength = attributeLength;
    }

}
