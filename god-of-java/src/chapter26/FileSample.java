package chapter26;

import java.io.DataInput;
import java.io.File;
import java.util.Date;

public class FileSample {
    public static void main(String[] args) {
        FileSample sample = new FileSample();
        String pathName = "." + File.separator + "file-test" + File.separator + "text";
        sample.lastModified(pathName);

    }

    private void lastModified(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " last modified = " + new Date(file.lastModified()));
    }

    private void checkPath(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " is Exists? = " + file.exists());
    }
    private void checkFileMethod(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + "is directory? " + file.isDirectory());
        System.out.println(pathName + "is file? " + file.isFile());
        System.out.println(pathName + "is hidden? " + file.isHidden());
    }

    private void canFileMethods(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " can read? = " + file.canRead());
        System.out.println(pathName + " can write? = " + file.canWrite());
        System.out.println(pathName + " can execute? = " + file.canExecute());
    }
    public void makeDir(String pathName) {
        File file = new File(pathName);
        System.out.println("Make " + pathName + " result = " + file.mkdirs());
    }
}
