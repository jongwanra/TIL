package chapter24;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesSample {
    public static void main(String[] args) {
        PropertiesSample sample = new PropertiesSample();
        sample.savaeAndLoadProperties();
    }

    private void checkProperties() {
        Properties properties = System.getProperties();
        Set<Object> keySet = properties.keySet();
        for(Object tempObj: keySet) {
            System.out.println(tempObj +"= " + properties.get(tempObj));
        }
    }

    private void  savaeAndLoadProperties() {
        try{
            String fileName="test.xml";
            File propertiesFile = new File(fileName);
            FileOutputStream fos = new FileOutputStream(propertiesFile);
            Properties prop = new Properties();
            prop.setProperty("Writer", "Jongwan");
            prop.setProperty("WriterHome", "https://github.com/jongwanra");
            prop.storeToXML(fos, "Basic XML Property file");
            fos.close();

            FileInputStream fis = new FileInputStream(propertiesFile);
            Properties propLoaded = new Properties();
            propLoaded.loadFromXML(fis);
            fis.close();
            System.out.println("propLoaded = " + propLoaded);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
