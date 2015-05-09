package snow.parser.util;

import lombok.Value;

@Value
public class Pair<U, V> {
    private final U first;
    private final V second;
}
