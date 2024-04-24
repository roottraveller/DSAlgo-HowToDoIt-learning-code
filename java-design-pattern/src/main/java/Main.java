import org.learning.adapter.UnitAdapter;
import org.learning.adapter.impl.Kilometer;
import org.learning.adapter.impl.Miles;
import org.learning.builder.BuilderClassDemo;
import org.learning.decorator.Decorator;
import org.learning.decorator.DollerDecorator;
import org.learning.decorator.RupeeDecorator;
import org.learning.decorator.impl.Dollar;
import org.learning.decorator.impl.Rupee;
import org.learning.factory.Currency;
import org.learning.factory.CurrencyFactory;
import org.learning.singleton.SingletonClassDemo;

public class Main {
    public static void main(String[] args) {
        Main object = new Main();

        object.testBuilderPattern();
        object.testSingletonPattern();
        object.testFactoryPattern();
        object.testAdapterPattern();
        object.testDecoratorPattern();
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

    public void testAdapterPattern() {
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
}
