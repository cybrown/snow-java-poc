package snow.parser.node;

import lombok.Getter;
import snow.parser.IAstVisitor;
import snow.parser.Token;

abstract public class BaseAstNode {

    @Getter
    private Token firstToken;

    @Getter
    private Token lastToken;

    @Getter
    private boolean replaceable = true;

    public BaseAstNode(Token firstToken, Token lastToken) {
        this.firstToken = firstToken;
        this.lastToken = lastToken;
    }

    public void doNotReplace() {
        this.replaceable = false;
    }

    abstract public void accept(IAstVisitor visitor);
}
