import org.learning.adapter.UnitAdapter;
import org.learning.adapter.impl.Kilometer;
import org.learning.adapter.impl.Miles;
import org.learning.builder.BuilderClassDemo;
import org.learning.decorator.Decorator;
import org.learning.decorator.DollerDecorator;
import org.learning.decorator.RupeeDecorator;
import org.learning.decorator.impl.Dollar;
import org.learning.decorator.impl.Rupee;
import org.learning.facade.DriveMode;
import org.learning.facade.DriveModeFacade;
import org.learning.factory.Currency;
import org.learning.factory.CurrencyFactory;
import org.learning.observer.ConcreteObserver;
import org.learning.observer.ConcreteSubject;
import org.learning.observer.Observer;
import org.learning.observer.Subject;
import org.learning.proxy.Database;
import org.learning.proxy.DatabaseProxy;
import org.learning.proxy.impl.RealDatabase;
import org.learning.singleton.SingletonClassDemo;

public class Main {
    public static void main(String[] args) {
        Main object = new Main();

//        object.testBuilderPattern();
//        object.testSingletonPattern();
//        object.testFactoryPattern();
//        object.testAdapter_or_WrapperPattern();
//        object.testDecoratorPattern();
//        object.testFacadePattern();
//        object.testProxyPattern();
        object.testObserver_or_PubSubPattern();
    }

    private void testBuilderPattern() {
        BuilderClassDemo demo = new BuilderClassDemo.Builder()
                .name("Rishi")
                .crush("Gussi")
                .build();

        System.out.println("Name: " + demo.getName());
        System.out.println("Crush: " + demo.getCrush());
    }

    public void testSingletonPattern() {
        SingletonClassDemo singleton = SingletonClassDemo.getInstance();
        singleton.setField("Setting field value");
        System.out.println(singleton.getField());
    }

    public void testFactoryPattern() {
        // Creating currencies using the factory
        Currency rupee = CurrencyFactory.createCurrency("INDIA");
        Currency dollar = CurrencyFactory.createCurrency("USA");

        System.out.println("Rupee symbol: " + rupee.getSymbol());
        System.out.println("Dollar symbol: " + dollar.getSymbol());
    }

    public void testAdapter_or_WrapperPattern() {
        Kilometer kilometer = new Kilometer();
        kilometer.setValue(100);
        Miles miles = new Miles();
        miles.setValue(62.1371);

        // Creating an instance of UnitAdapter to convert between Kilometers and Miles
        UnitAdapter adapter = new UnitAdapter();

        // Converting Kilometers to Miles
        double milesConverted = adapter.getMiles(kilometer);
        System.out.println("Converted Kilometers to Miles: " + milesConverted);

        // Converting Miles to Kilometers
        double kilometerConverted = adapter.getKm(miles);
        System.out.println("Converted Miles to Kilometers: " + kilometerConverted);
    }

    public void testDecoratorPattern() {
        // Creating instances of concrete components
        org.learning.decorator.Currency rupee = new Rupee();
        org.learning.decorator.Currency dollar = new Dollar();

        // Creating instances of concrete decorators
        Decorator rupeeDecorator = new RupeeDecorator();
        Decorator dollarDecorator = new DollerDecorator();

        System.out.println("Rupee symbol: " + rupee.getSymbol());
        System.out.println("Dollar symbol: " + dollar.getSymbol());

        // Testing the concrete decorators
        System.out.println("Decorated Rupee symbol: " + rupeeDecorator.getSymbol());
        System.out.println("Decorated Rupee country: " + rupeeDecorator.getCountry());
        System.out.println("Decorated Dollar symbol: " + dollarDecorator.getSymbol());
        System.out.println("Decorated Dollar country: " + dollarDecorator.getCountry());
    }

    public void testFacadePattern() {
        // Using the Facade to select driving modes
        DriveModeFacade.selectMode(DriveMode.COMFORT);
        DriveModeFacade.selectMode(DriveMode.SPORT);
    }

    public void testProxyPattern() {
        // Creating instances of real object and proxy
        Database realDatabase = new RealDatabase();
        Database adminProxy = new DatabaseProxy("admin");
        Database userProxy = new DatabaseProxy("user");

        // Testing real object
        System.out.println("Testing Real Database:");
        realDatabase.fetchData();

        // Testing proxy with admin role
        System.out.println("\nTesting Database Proxy with Admin Role:");
        adminProxy.fetchData();

        // Testing proxy with user role
        System.out.println("\nTesting Database Proxy with User Role:");
        userProxy.fetchData();
    }


    public void testObserver_or_PubSubPattern(){
        // Creating instances of subject and observer
        Subject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();

        // Adding observer to subject
        subject.addObserver(observer);

        // Setting state of subject
        String newState = "New State";
        subject.setState(newState);
    }


}
