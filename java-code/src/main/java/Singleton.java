/*
 * Singleton Class Rules:
 * 
 * 1. Private Constructor: Ensure that the class cannot be instantiated from outside.
 * 2. Private Static Volatile Instance: static ensures visibility across threads and 'volatile' 
 * ensures that changes made to the instance are immediately visible to other threads.
 * 3. Public Static Method to access the singleton instance i.e. getInstance()
 * 4. Thread-Safety: Use double-checked locking for thread safety to prevent multiple threads 
 * from creating separate instances.
 * 
 */
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
