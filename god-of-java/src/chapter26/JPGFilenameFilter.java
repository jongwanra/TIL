package chapter26;

import java.io.File;
import java.io.FilenameFilter;

public class JPGFilenameFilter implements FilenameFilter {
    @Override
    public boolean accept(File file, String fileName) {
        return fileName.endsWith(".jpg") || fileName.endsWith(".jpeg");
    }
}
