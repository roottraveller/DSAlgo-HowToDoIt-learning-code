public class Singleton {
    private static volatile Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
        // Initialization code, if any
    }

    // Public static method to get the singleton instance
    public static Singleton getInstance() {
        // Double-checked locking for thread safety
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Other methods and fields...
}
