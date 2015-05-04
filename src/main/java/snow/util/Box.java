package snow.util;

import lombok.Data;

@Data
public class Box<T> {

    private T value;

    public Box(T value) {
        this.value = value;
    }
}
