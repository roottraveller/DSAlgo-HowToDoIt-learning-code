import org.learning.builder.BuilderClassDemo;
import org.learning.factory.Currency;
import org.learning.factory.CurrencyFactory;
import org.learning.singleton.SingletonClassDemo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Main object = new Main();

        object.testBuilderPattern();
        object.testSingletonPattern();
        object.testFactoryPattern();
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

        // Testing the created currencies
        System.out.println("Rupee symbol: " + rupee.getSymbol());
        System.out.println("Dollar symbol: " + dollar.getSymbol());
    }
}