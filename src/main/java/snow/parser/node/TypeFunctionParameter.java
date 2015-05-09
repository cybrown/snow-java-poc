package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

@Value
@EqualsAndHashCode(callSuper = true)
public class TypeFunctionParameter extends BaseAstNode {

    private Identifier name;
    private BaseAstNode type;

    public TypeFunctionParameter(Token firstToken, Token lastToken, Identifier name, BaseAstNode type) {
        super(firstToken, lastToken);
        this.name = name;
        this.type = type;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        name.accept(visitor);
        type.accept(visitor);
        visitor.visit(this, false);
    }
}
