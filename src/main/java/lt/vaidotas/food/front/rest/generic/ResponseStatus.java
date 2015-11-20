package lt.vaidotas.food.front.rest.generic;

public enum ResponseStatus {
    SUCCESS("success"), FAIL("fail"), ERROR("error");

    private final String text;
    ResponseStatus(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
