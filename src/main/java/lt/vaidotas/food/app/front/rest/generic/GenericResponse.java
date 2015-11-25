package lt.vaidotas.food.app.front.rest.generic;

public class GenericResponse<T> {

    private T data;
    private ResponseStatus status;

    private GenericResponse() {
    }

    private GenericResponse(final T data, final ResponseStatus status) {
        this.data = data;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(final ResponseStatus status) {
        this.status = status;
    }

    public static <T> GenericResponse<T> ok(final T data) {
        return new GenericResponse<>(data, ResponseStatus.SUCCESS);
    }

    public static <T> GenericResponse<T> fail(final T data) {
        return new GenericResponse<>(data, ResponseStatus.FAIL);
    }

    public static <T> GenericResponse<T> error(final T data) {
        return new GenericResponse<>(data, ResponseStatus.ERROR);
    }
}
