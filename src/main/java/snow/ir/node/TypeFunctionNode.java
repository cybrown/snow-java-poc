package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;
import snow.parser.node.BaseAstNode;

@Value
@EqualsAndHashCode(callSuper = true)
public class TypeFunctionNode extends BaseTypeNode {

    private final Iterable<BaseTypeNode> arguments;
    private final BaseTypeNode returnType;

    public TypeFunctionNode(BaseAstNode ast, Iterable<BaseTypeNode> arguments, BaseTypeNode returnType) {
        super(ast);
        this.arguments = arguments;
        this.returnType = returnType;
    }

    @Override
    public void accept(IIrVisitor visitor) {
        visitor.visit(this, true);
        arguments.forEach(a -> a.accept(visitor));
        returnType.accept(visitor);
        visitor.visit(this, false);
    }
}
