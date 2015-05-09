package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;

@Value
@EqualsAndHashCode(callSuper = true)
public class IdentifierNode extends BaseIrNode {

    private String name;

    @Override
    public void accept(IIrVisitor visitor) {
        visitor.visit(this, true);
    }
}
