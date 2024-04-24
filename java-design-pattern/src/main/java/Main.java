import org.learning.adapter.UnitAdapter;
import org.learning.adapter.impl.Kilometer;
import org.learning.adapter.impl.Miles;
import org.learning.builder.BuilderClassDemo;
import org.learning.chainofresponsibility.AuthenticationHandler;
import org.learning.chainofresponsibility.RoleCheckHandler;
import org.learning.chainofresponsibility.ThrottlingHandler;
import org.learning.chainofresponsibility.UserExistsHandler;
import org.learning.composite.Developer;
import org.learning.composite.Employee;
import org.learning.composite.Manager;
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
import org.learning.prototype.impl.CloneClass;
import org.learning.proxy.Database;
import org.learning.proxy.DatabaseProxy;
import org.learning.proxy.impl.RealDatabase;
import org.learning.singleton.SingletonClassDemo;
import org.learning.statemachine.Coin;
import org.learning.statemachine.Item;
import org.learning.statemachine.VendingMachine;
import org.learning.strategy.SortingStrategy;
import org.learning.strategy.impl.BubbleSort;
import org.learning.strategy.impl.HeapSort;
import org.learning.strategy.impl.QuickSort;
import org.learning.template.ComputerBuilderTemplate;
import org.learning.template.HighEndComputerBuilder;
import org.learning.template.StandardComputerBuilder;
import org.learning.visitor.ShippingCostCalculator;
import org.learning.visitor.StandardShippingCostCalculator;
import org.learning.visitor.impl.Book;
import org.learning.visitor.impl.Electronics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main object = new Main();

        object.testBuilderPattern();
        object.testSingletonPattern();
        object.testFactoryPattern();
        object.testAdapter_or_WrapperPattern();
        object.testDecoratorPattern();
        object.testFacadePattern();
        object.testProxyPattern();
        object.testObserver_or_PubSubPattern();
        object.testStrategyPattern();
        object.testVisitorPattern();
        object.testChainOfResponsibilityPattern();
        object.testPrototypePattern();
        object.testCompositePattern();
        object.testTemplatePattern();
        object.testStateMachinePattern();
    }

    // Method to recursively display employee hierarchy
    private static void displayHierarchy(Employee employee, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("    ");
        }
        System.out.println(indent + employee.getName() + "(" + employee.getId() + ")");
        if (employee instanceof Manager) {
            List<Employee> directs = ((Manager) employee).getDirects();
            for (Employee direct : directs) {
                displayHierarchy(direct, level + 1);
            }
        }
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

    public void testObserver_or_PubSubPattern() {
        // Creating instances of subject and observer
        Subject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();

        // Adding observer to subject
        subject.addObserver(observer);

        // Setting state of subject
        String newState = "New State";
        subject.setState(newState);
    }

    public void testStrategyPattern() {
        // Sorting an array using the strategy
        int[] array = {5, 2, 8, 1, 4};

        // Creating a strategy with bubble sort algorithm
        SortingStrategy strategy = new SortingStrategy(new BubbleSort());
        strategy.performSort(array);

        // Changing the sorting algorithm to quick sort
        strategy.setAlgorithm(new QuickSort());
        strategy.performSort(array);

        // Changing the sorting algorithm to heap sort
        strategy.setAlgorithm(new HeapSort());
        strategy.performSort(array);
    }

    public void testVisitorPattern() {
        Book book = new Book(2.5);
        Electronics electronics = new Electronics(1.8);

        // Create visitor
        ShippingCostCalculator calculator = new StandardShippingCostCalculator();

        // Calculate shipping costs for each product
        book.accept(calculator);
        electronics.accept(calculator);
    }

    public void testChainOfResponsibilityPattern() {
        // Create the chain of responsibility
        AuthenticationHandler throttlingHandler = new ThrottlingHandler();
        AuthenticationHandler userExistsHandler = new UserExistsHandler();
        AuthenticationHandler roleCheckHandler = new RoleCheckHandler();

        // Set up the chain
        throttlingHandler.setNextHandler(userExistsHandler);
        userExistsHandler.setNextHandler(roleCheckHandler);
        boolean isAuthenticated = throttlingHandler.authenticate("user@example.com", "password123");

        System.out.println("Authentication result: " + (isAuthenticated ? "Success" : "Failed"));
    }

    public void testPrototypePattern() {
        // Create an instance of CloneClass
        CloneClass original = new CloneClass("Original Object");

        // Clone the original object
        CloneClass cloned = (CloneClass) original.clone();

        // Verify that cloning was successful
        System.out.println("Original Object: " + original);
        System.out.println("Cloned Object: " + cloned);
        System.out.println("Are they the same? " + (original == cloned));
    }

    public void testCompositePattern() {
        // Create developers
        Developer dev1 = new Developer("D1", "John Doe", Arrays.asList("Java", "Python"));
        Developer dev2 = new Developer("D2", "Jane Smith", Arrays.asList("JavaScript", "HTML", "CSS"));

        // Create managers
        Manager manager1 = new Manager("M1", "Alice Johnson", Arrays.asList(dev1, dev2));
        Manager manager2 = new Manager("M2", "Bob Williams", new ArrayList<>());

        // Create a senior manager who manages managers
        Manager seniorManager = new Manager("SM1", "Charlie Brown", Arrays.asList(manager1, manager2));

        // Display employee hierarchy
        displayHierarchy(seniorManager, 0);
    }

    public void testTemplatePattern() {
        // Build a standard computer
        ComputerBuilderTemplate standardBuilder = new StandardComputerBuilder();
        standardBuilder.buildComputer();

        // Build a high-end computer
        ComputerBuilderTemplate highEndBuilder = new HighEndComputerBuilder();
        highEndBuilder.buildComputer();
    }

    public void testStateMachinePattern() {
        // Create a vending machine
        VendingMachine vendingMachine = new VendingMachine();
        // Load initial inventory
        vendingMachine.loadInventory();

        // Display current state
        System.out.println("Initial state: " + vendingMachine.getState());

        // Simulate a transaction
        Item item = new Item("Coke", 1.50, 10);
        vendingMachine.selectItem(item);
        vendingMachine.insertCoin(Coin.RUPEE);
        vendingMachine.processTransaction();

        // Display current state after transaction
        System.out.println("Final state: " + vendingMachine.getState());
    }


}
