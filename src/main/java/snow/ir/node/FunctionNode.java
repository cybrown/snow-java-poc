package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;

@Value
@EqualsAndHashCode(callSuper=true)
public class FunctionNode extends BaseIrNode {

    private BaseIrNode expression;

    @Override
    public void accept(IIrVisitor visitor) {
        visitor.accept(this, true);
        visitor.accept(this, false);
    }
}
