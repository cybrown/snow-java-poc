package snow.ast.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = true)
public class ArrayType extends BaseAstNode {

    private final BaseAstNode type;

    public ArrayType(Token firstToken, Token lastToken, BaseAstNode type) {
        super(firstToken, lastToken);
        this.type = type;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.type.accept(visitor);
        visitor.visit(this, false);
    }
}
