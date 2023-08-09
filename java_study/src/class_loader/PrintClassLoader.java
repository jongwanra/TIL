package class_loader;

import java.sql.DriverManager;
import java.util.ArrayList;

public class PrintClassLoader {
    public void printClassLoaders() throws ClassNotFoundException {
        // System or Application Class Loader
        System.out.println("ClassLoader of this class: " + PrintClassLoader.class.getClassLoader());

        // Extension Class Loader
        System.out.println("ClassLoader of DriverManager: " + DriverManager.class.getClassLoader());

        // Bootstrap Class Loader(native code로 작성되어 있기 떄문에 볼 수가 없이 null로 나옴)
        // Bootstrap Class Loader -> Object, ClassLoader,Class
        System.out.println("ClassLoader of Object: " + Object.class.getClassLoader());
        System.out.println("ClassLoader of Class: " + Class.class.getClassLoader());
        System.out.println("ClassLoader of ClassLoader: " + ClassLoader.class.getClassLoader());
    }   // Bootstrap -> Extension -> Application(System)


    public static void main(String[] args) {
        PrintClassLoader m = new PrintClassLoader();
        try{
            m.printClassLoaders();
        }catch (ClassNotFoundException e) {

        }
    }
}
