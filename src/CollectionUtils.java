import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class CollectionUtils {

    private CollectionUtils() {
    }

    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        List<E> result = new ArrayList<>();
        for (E element : elements) {
            if (filter.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements) {
            if (predicate.test(element)) {
                return true;
            }
        }
        return false;
    }

    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements) {
            if (!predicate.test(element)) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements) {
            if (predicate.test(element)) {
                return false;
            }
        }
        return true;
    }

    public static <T, R> List<R> map(List<T> elements, Function<T, R> mappingFunction) {
        List<R> result = new ArrayList<>();
        for (T element : elements) {
            result.add(mappingFunction.apply(element));
        }
        return result;
    }


    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        if (elements.size() == 0) {
            return Optional.empty();
        }
        E maxElement = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            if (!(comparator.compare(maxElement, elements.get(i)) > 0)) {
                maxElement = elements.get(i);
            }
        }
        return Optional.of(maxElement);
    }

    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        if (elements.size() == 0) {
            return Optional.empty();
        }
        E minElement = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            if (!(comparator.compare(minElement, elements.get(i)) < 0)) {
                minElement = elements.get(i);
            }
        }
        return Optional.of(minElement);
    }

    public static <E> List<E> distinct(List<E> elements) {
        List<E> result = new ArrayList<>();
        for (E element : elements) {
            if (result.contains(element)) {
                continue;
            } else {
                result.add(element);
            }
        }
        return result;
    }

    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        for (E element : elements) {
            consumer.accept(element);
        }
    }

    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        if (elements.size() == 0) {
            Optional.empty();
        }
        E element = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            element = accumulator.apply(element, elements.get(i));
        }
        return Optional.of(element);
    }

    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        if (elements.size() == 0) {
            return null;
        }
        E element = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            element = accumulator.apply(element, elements.get(i));
        }
        return element;
    }

    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements, Predicate<E> predicate) {
        Map<Boolean, List<E>> result = new HashMap<>();
        List<E> trueList = new ArrayList<>();
        List<E> falseList = new ArrayList<>();
        for (E element : elements) {
            if (predicate.test(element)) {
                trueList.add(element);
            } else {
                falseList.add(element);
            }
        }
        result.put(true, trueList);
        result.put(false, falseList);
        return result;
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> elements, Function<T, K> classifier) {

        return null;
    }

    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction) {

        return null;
    }
}

