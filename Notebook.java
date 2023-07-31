import java.util.*;

class Notebook {
    private String model;
    private int ram;
    private int hdd;
    private String operationSystem;
    private String color;
    private String vendor;

    // Конструктор класса Notebook
    public Notebook(String model, int ram, int hdd, String operationSystem, String color, String vendor) {
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.operationSystem = operationSystem;
        this.color = color;
        this.vendor = vendor;
    }

    // Геттеры для полей класса Notebook
    public String getModel() {
        return model;
    }

    public int getRAM() {
        return ram;
    }

    public int getHDD() {
        return hdd;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public String getColor() {
        return color;
    }

    public String getVendor() {
        return vendor;
    }
}