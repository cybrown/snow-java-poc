package snow.parser.node;

import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.List;

public class ArgumentList extends BaseAstNode {

    private List<BaseAstNode> arguments;

    public ArgumentList(Token firstToken, Token lastToken, List<BaseAstNode> arguments) {
        super(firstToken, lastToken);
        this.arguments = arguments;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        arguments.forEach(a -> a.accept(visitor));
        visitor.visit(this, false);
    }
}
