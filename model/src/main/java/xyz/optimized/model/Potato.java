package xyz.optimized.model;

public class Potato {
    private String name;

    public Potato(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
            return "I am a potato! My name is " + name;
        }
}
