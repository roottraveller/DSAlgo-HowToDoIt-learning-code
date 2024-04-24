import org.learning.BuilderClassDemo;
import org.learning.SingletonClassDemo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Main object = new Main();

        object.testBuilderPattern();
        object.testSingletonPattern();
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
}