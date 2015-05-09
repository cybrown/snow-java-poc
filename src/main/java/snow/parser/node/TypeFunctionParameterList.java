package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class TypeFunctionParameterList extends BaseAstNode {

    private List<TypeFunctionParameter> parameters;

    public TypeFunctionParameterList(Token firstToken, Token lastToken, List<TypeFunctionParameter> parameters) {
        super(firstToken, lastToken);
        this.parameters = parameters;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        parameters.forEach(p -> p.accept(visitor));
        visitor.visit(this, false);
    }
}
