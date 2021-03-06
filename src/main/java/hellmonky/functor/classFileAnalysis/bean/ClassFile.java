package hellmonky.functor.classFileAnalysis.bean;

import hellmonky.functor.classFileAnalysis.bean.attributeinfo.BasicAttributeInfo;
import hellmonky.functor.classFileAnalysis.bean.basictype.U2;
import hellmonky.functor.classFileAnalysis.bean.basictype.U4;
import hellmonky.functor.classFileAnalysis.bean.constantpool.ConstantPoolInfo;

/**
 * Created by chenyangli.
 */
public class ClassFile {

    public U4 magic;                            // magic
    public U2 minorVersion;                     // minor_version
    public U2 majorVersion;                     // major_version
    public U2 constantPoolCount;                // constant_pool_count
    public ConstantPoolInfo[] cpInfo;           // cp_info
    public U2 accessFlags;                      // access_flags
    public U2 thisClass;                        // this_class
    public U2 superClass;                       // super_class
    public U2 interfacesCount;                  // interfaces_count
    public U2[] interfaces;                     // interfaces
    public U2 fieldsCount;                      // fields_count
    public FieldInfo[] fields;                  // fields
    public U2 methodsCount;                     // methods_count
    public MethodInfo[] methods;                // methods
    public U2 attributesCount;                  // attributes_count
    public BasicAttributeInfo[] attributes;     // attributes

}
