package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.Collections;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class ArgumentList extends BaseAstNode {

    private List<BaseAstNode> arguments;

    public ArgumentList(Token firstToken, Token lastToken, List<BaseAstNode> arguments) {
        super(firstToken, lastToken);
        this.arguments = arguments;
    }

    static public ArgumentList of(ArgumentList arguments, BaseAstNode node) {
        if (arguments != null) {
            List<BaseAstNode> argumentsWithFunction = arguments.getArguments();
            argumentsWithFunction.add(node);
            return new ArgumentList(arguments.getFirstToken(), node.getLastToken(), argumentsWithFunction);
        } else {
            return new ArgumentList(node.getFirstToken(), node.getLastToken(), Collections.singletonList(node));
        }
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        arguments.forEach(a -> a.accept(visitor));
        visitor.visit(this, false);
    }
}
