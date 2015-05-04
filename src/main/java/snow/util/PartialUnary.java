package snow.util;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ast.Token;

@Value
@EqualsAndHashCode
public class PartialUnary {
    public final Token firstToken;
    public final Token lastToken;
    public final String operator;
}
