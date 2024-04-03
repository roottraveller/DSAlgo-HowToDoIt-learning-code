import com.google.common.collect.Maps;

import java.util.Map;

enum Coin {
    TEN(10),
    TWENTY(20),
    THIRTY(30);

    private long value;

    Coin(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}

public interface IMachine {
}

interface Inventory {
    void loadInventory();

    boolean isStockAvailable(Item currentItem);

    void decreaseStock(Item currentItem, long count);
}

interface IState {
}

class VendingMachine implements IMachine {
    private final Inventory itemInventory = new ItemInventory();
    private IState state;
    private Item currentItem;

    public VendingMachine() {
        this.state = new SoldOutState(this);
        initialize();
    }

    private void initialize() {
        itemInventory.loadInventory();
        this.state = new IdealState(this);
    }

    public Inventory getItemInventory() {
        return itemInventory;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public Item getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(Item currentItem) {
        this.currentItem = currentItem;
    }
}

class ItemInventory implements Inventory {
    private final Map<Item, Long> itemInventoryMap = Maps.newConcurrentMap();

    @Override
    public void loadInventory() {
        itemInventoryMap.put(new Item("Chips", 10, 100), 100L);
        itemInventoryMap.put(new Item("Biscuit", 20, 50), 50L);
        itemInventoryMap.put(new Item("Drink", 30, 40), 40L);
    }

    @Override
    public boolean isStockAvailable(Item currentItem) {
        return itemInventoryMap.getOrDefault(currentItem, 0L) >= 1;
    }

    @Override
    public void decreaseStock(Item currentItem, long count) {
        itemInventoryMap.put(currentItem, itemInventoryMap.getOrDefault(currentItem, 0L) - 1L);
    }
}

class VendingMachineState implements IState {
    public void insert(Coin coin) {
        throw new IllegalStateException();
    }

    public int choose(Item item) {
        throw new IllegalStateException();
    }

    public Item dispense() {
        throw new IllegalStateException();
    }

    public Coin refund() {
        throw new IllegalStateException();
    }
}

class IdealState extends VendingMachineState {
    private final VendingMachine vendingMachine;

    public IdealState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public int choose(Item item) {
        if (vendingMachine.getItemInventory().isStockAvailable(item)) {
            vendingMachine.setCurrentItem(item);
            vendingMachine.setState(new ProcessingState(vendingMachine));
        }
        return super.choose(item);
    }
}

class ProcessingState extends VendingMachineState {
    private final VendingMachine vendingMachine;

    public ProcessingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insert(Coin coin) {
        if (coin.getValue() == vendingMachine.getCurrentItem().getPrice()) {
            // add coin to machine balance and move to next state
            vendingMachine.setState(new SoldState(vendingMachine));
        }
    }
}

class SoldState extends VendingMachineState {
    private final VendingMachine vendingMachine;

    public SoldState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public Item dispense() {
        if (!vendingMachine.getItemInventory().isStockAvailable(vendingMachine.getCurrentItem())) {
            vendingMachine.setState(new SoldOutState(vendingMachine));
            return vendingMachine.getCurrentItem();
        }
        vendingMachine.getItemInventory().decreaseStock(vendingMachine.getCurrentItem(), 1);
        vendingMachine.setState(new IdealState(vendingMachine));
        return vendingMachine.getCurrentItem();
    }
}

class SoldOutState extends VendingMachineState {
    private final VendingMachine vendingMachine;

    public SoldOutState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}

class Item {
    private String name;
    private long price;
    private long initialStock;

    public Item(String name, long price, long initialStock) {
        this.name = name;
        this.price = price;
        this.initialStock = initialStock;
    }

    public long getPrice() {
        return price;
    }
}

