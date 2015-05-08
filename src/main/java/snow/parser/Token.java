package snow.parser;

import lombok.Value;

@Value
public class Token {
    private int pos;
    int charPos;
    private int col;
    private int line;
    private String val;
}
