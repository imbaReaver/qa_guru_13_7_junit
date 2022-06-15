package tests;

public enum Processors {
    COREI7("Core i7","Процессор Intel Core i7"),
    RYZEN5("Ryzen 5","Процессор AMD Ryzen 5");
    public final String desc;
    public final String processorName;

    Processors(String procName, String desc) {
        this.desc = desc;
        this.processorName = procName;
    }
}
