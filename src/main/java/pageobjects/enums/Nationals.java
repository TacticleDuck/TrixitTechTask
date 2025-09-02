package pageobjects.enums;

public enum Nationals {
    EN("English"),
    DE("German"),
    FR("French"),
    IT("Italian");

    private final String value;

    Nationals(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name();
    }

    public String toLowerCase() {
        return name().toLowerCase();
    }
}
