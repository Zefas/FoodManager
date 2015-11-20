package lt.vaidotas.food.business.voting;

public class BusinessValidationException extends Exception {

    public final String message;

    public BusinessValidationException(final String message) {
        this.message = message;
    }
}
