package immutable_object;

public class SynchronizedRGB implements Runnable {
    private int red;
    private int green;
    private int blue;
    private String name;

    private void check(int red, int green, int blue) {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }


    public SynchronizedRGB(int red, int green, int blue, String name) {
        check(red, green, blue);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
    }

    public void set(int red, int green, int blue, String name) {
        check(red, green, blue);
        synchronized (this) {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.name = name;
        }
    }

    public synchronized int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }


    public synchronized String getName() {
        return name;
    }

    public synchronized void invert() {
        red = 255 - red;
        green = 255 - green;
        blue = 255- blue;
        name = "Inverse of " + name;
    }
    public static void main(String[] args) {
        SynchronizedRGB color = new SynchronizedRGB(0,0 ,0, "Pitch Black");

        int myColorInt = color.getRGB();
        System.out.println("myColorInt = " + myColorInt);
        color.set(1,1,1,"2");
        new Thread(color).start();
        System.out.println("myColorInt = " + myColorInt);
        String myColorName = color.getName();
        System.out.println("myColorName = " + myColorName);
    }

    @Override
    public void run() {
        set(this.red + 1, this.blue + 1, this.green + 1, "3");
    }
}
