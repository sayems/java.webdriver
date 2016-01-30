package org.sayem.webdriver.java8;

import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;

/**
 * Created by sayem on 1/25/16.
 */
public class StreamUtils {

    /**
     * Based on http://stackoverflow.com/questions/27547519/most-efficient-way-to-get-the-last-element-of-a-stream
     */
    public static <T> Optional<T> findLastOf(Stream<T> stream) {
        Spliterator<T> split = stream.spliterator();

        if (split.hasCharacteristics(Spliterator.SIZED | Spliterator.SUBSIZED)) {
            while (true) {
                Spliterator<T> part = split.trySplit();

                if (part == null) {
                    break;
                }

                if (split.getExactSizeIfKnown() == 0) {
                    split = part;
                    break;
                }
            }
        }

        T value = null;
        for (Iterator<T> it = traverse(split); it.hasNext(); ) {
            value = it.next();
        }

        return Optional.ofNullable(value);
    }

    private static <T> Iterator<T> traverse(Spliterator<T> sp) {
        Spliterator<T> prev = sp.trySplit();

        if (prev == null) {
            return Spliterators.iterator(sp);
        }

        Iterator<T> it = traverse(sp);

        if (it != null && it.hasNext()) {
            return it;
        }

        return traverse(prev);
    }

}
