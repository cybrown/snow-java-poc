package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;
import snow.parser.node.BaseAstNode;

import java.util.Iterator;

@Value
@EqualsAndHashCode(callSuper = true)
public class IrNodeList extends BaseIrNode {

    private Iterable<BaseIrNode> nodes;

    public IrNodeList(BaseAstNode ast, Iterable<BaseIrNode> nodes) {
        super(ast);
        this.nodes = nodes;
    }

    @Override
    public Iterator<BaseIrNode> iterator() {
        return nodes.iterator();
    }

    @Override
    public void accept(IIrVisitor visitor) {
        visitor.visit(this, true);
        nodes.forEach(n -> n.accept(visitor));
        visitor.visit(this, false);
    }
}
