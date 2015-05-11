package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;
import snow.parser.node.BaseAstNode;

@Value
@EqualsAndHashCode(callSuper = true)
public class TypeGenericNode extends BaseTypeNode {

    private final BaseTypeNode genericType;
    private final Iterable<BaseTypeNode> parameters;

    public TypeGenericNode(BaseAstNode ast, BaseTypeNode genericType, Iterable<BaseTypeNode> parameters) {
        super(ast);
        this.genericType = genericType;
        this.parameters = parameters;
    }

    @Override
    public void accept(IIrVisitor visitor) {
        visitor.visit(this, true);
        genericType.accept(visitor);
        parameters.forEach(p -> p.accept(visitor));
        visitor.visit(this, false);
    }
}
