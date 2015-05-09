package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = true)
public class TypeFunction extends BaseAstNode {

    private final Optional<TypeFunctionParameterList> parameters;
    private final BaseAstNode returnType;

    public TypeFunction(Token firstToken, Token lastToken, TypeFunctionParameterList parameters, BaseAstNode returnType) {
        super(firstToken, lastToken);
        this.parameters = Optional.ofNullable(parameters);
        this.returnType = returnType;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.parameters.ifPresent(p -> p.accept(visitor));
        this.returnType.accept(visitor);
        visitor.visit(this, false);
    }
}
