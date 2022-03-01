package by.tms;

public class Calc {
    private int value1;
    private int value2;
    private String operation;

    public Calc(int value1, int value2, String operaton) {
        this.value1 = value1;
        this.value2 = value2;
        this.operation = operaton;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Calc{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                ", operaton='" + operation + '\'' +
                '}';
    }
}
