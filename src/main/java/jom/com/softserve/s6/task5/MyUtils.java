package jom.com.softserve.s6.task5;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
    public static Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map == null) {
            throw new NullPointerException("Map cannot be null");
        }

        return map.values().stream()
                .filter(Objects::nonNull)
                .flatMap(stream -> stream
                        .filter(Objects::nonNull)
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .map(s -> s.replaceAll("\\s+", " "))
                        .map(s -> s.replaceAll("\\s", ""))
                        .map(String::toLowerCase))
                .distinct()
                .sorted()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.toList())
                .stream();
    }
}
