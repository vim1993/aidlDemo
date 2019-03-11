package android.os;

interface IGpioManager {
    boolean setGPIODir(int gpioid, boolean dir);
    boolean getGPIODir(int gpioid);
    boolean setGPIOLevel(int gpioid, boolean level);
}