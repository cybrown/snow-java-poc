package snow.parser.util;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.Token;

@Value
@EqualsAndHashCode
public class PartialUnary {
    public final Token firstToken;
    public final Token lastToken;
    public final String operator;
}
