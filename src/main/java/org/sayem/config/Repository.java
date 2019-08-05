package org.sayem.config;

public enum Repository {

    CHROME("chrome"),
    FIREFOX("firefox");

    private String value;

    Repository(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
