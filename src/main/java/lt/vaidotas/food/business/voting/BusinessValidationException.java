package lt.vaidotas.food.business.voting;

public class BusinessValidationException extends Exception {

    private final String businessMessage;

    public BusinessValidationException(final String businessMessage) {
        this.businessMessage = businessMessage;
    }

    public String getBusinessMessage() {
        return businessMessage;
    }
}
