package lt.vaidotas.food.app.generic;

import java.util.Collection;
import java.util.stream.Collectors;

public interface Mapper<T, U> {
    U to(final T from);
    T from(final U to);

    default Collection<U> to(final Collection<T> from) {
        return from.stream()
                .map(this::to)
                .collect(Collectors.toList());
    }

    default Collection<T> from(final Collection<U> from) {
        return from.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
}
