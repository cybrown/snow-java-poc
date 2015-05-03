package snow.ast.node;

import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

@Value
public class Function extends BaseAstNode {

    private BaseAstNode body;
    private String name;

    public Function(Token firstToken, Token lastToken, String name, BaseAstNode body) {
        super(firstToken, lastToken);
        this.name = name;
        this.body = body;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.body.accept(visitor);
        visitor.visit(this, false);
    }
}
