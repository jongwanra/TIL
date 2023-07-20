package chapter26;

import java.io.File;
import java.io.FileFilter;

public class FIleFilterSample {
    public static void main(String[] args) {
        FIleFilterSample sample = new FIleFilterSample();
        String pathName = File.separator + "Users/a." + File.separator + "Desktop";
        try{
            sample.checkList(pathName) ;
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void checkList(String pathName) throws Exception {
        File file = new File(pathName);
        File[] mainFileList = file.listFiles();
        // File[] mainFileList = file.listFiles(new JPGFilenameFilter());
        if (mainFileList != null) {
            for(File tempFile: mainFileList) {
                System.out.println(tempFile.getName());
            }
        }
    }
}
