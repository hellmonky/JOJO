package hellmonky.functor.classFileAnalysis.operator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by yuanlai.xwt on 2017/7/14.
 */
public class ReaderTest {

    public static void main(String[] args){
        try{
            String classFilePath = "D:\\workspace\\java_workspace\\github"
                + ".localhost\\JOJO\\src\\main\\java\\hellmonky\\functor\\classFileAnalysis\\resource\\Bootstrap.class";
            File file = new File(classFilePath);
            FileInputStream inputStream = new FileInputStream(file);
            System.out.println("analysis class file : ");
            System.out.println(classFilePath);
            ClassReader.analyze(inputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
