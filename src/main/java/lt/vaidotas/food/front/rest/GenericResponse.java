package lt.vaidotas.food.front.rest;

public class GenericResponse<T> {

    private T data;
    private ResponseStatus status;

    public GenericResponse() {
    }

    public GenericResponse(final T data, final ResponseStatus status) {
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

    public static <T> GenericResponse ok(final T data) {
        return new GenericResponse<>(data, ResponseStatus.SUCCESS);
    }

    public static <T> GenericResponse fail(final T data) {
        return new GenericResponse<>(data, ResponseStatus.FAIL);
    }

    public static <T> GenericResponse error(final T data) {
        return new GenericResponse<>(data, ResponseStatus.ERROR);
    }
}
