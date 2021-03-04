package org.jesperancinha.std.flash314.jdk.enhancer;

public class Bean implements IBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String beanState() {
        return "I'm just a bean seed. " + makeBeanSoup();
    }

    private String makeBeanSoup() {
        return "The soup is made";
    }

    public String makeProtectedBeanSoup() {
        return "The soup is made";
    }

    @Override
    public String toString() {
        return "Bean{" +
                "message='" + message + '\'' +
                '}';
    }
}
