import java.util.Random;

/**
 * Make class final -> No subclass possible
 * Make all instance variables final and private
 * Don't provide setter methods, only getter methods
 * For mutable instance, return a copy of it
 */
final class ImmutableClass {
    private final int dummyInt;
    private final String dummyName;

    ImmutableClass() {
        this.dummyInt = new Random().nextInt();
        this.dummyName = "MY STRING";
    }

    ImmutableClass(int dummyIntIn, String dummyNameIn) {
        this.dummyInt = dummyIntIn;
        this.dummyName = dummyNameIn;
    }

    // NO setter methods for Immutable class

    public int getInt() {
        return dummyInt;
    }

    public String getString() {
        return dummyName;
    }
}

public class ImmutableClassDemo {
    public static void main(String[] args) {
        ImmutableClass obj = new ImmutableClass();
        System.out.println(obj.getClass() + "  " + obj.getInt() + "  " + obj.getString());
    }
}
