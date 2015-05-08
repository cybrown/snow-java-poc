package snow.parser.util;

import lombok.Data;

@Data
public class Box<T> {

    private T value;

    public Box(T value) {
        this.value = value;
    }
}
