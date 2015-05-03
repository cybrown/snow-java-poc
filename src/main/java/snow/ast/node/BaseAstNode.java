package snow.ast.node;

import lombok.Getter;
import snow.IAstVisitor;
import snow.ast.Token;

abstract public class BaseAstNode {

    @Getter
    private Token firstToken;

    @Getter
    private Token lastToken;

    public BaseAstNode(Token firstToken, Token lastToken) {
        this.firstToken = firstToken;
        this.lastToken = lastToken;
    }

    abstract public void accept(IAstVisitor visitor);
}
