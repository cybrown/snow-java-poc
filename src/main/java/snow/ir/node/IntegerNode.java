package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;

@Value
@EqualsAndHashCode(callSuper=true)
public class IntegerNode extends BaseIrNode {

    private int value;

    @Override
    public void accept(IIrVisitor visitor) {
        visitor.accept(this, true);
    }
}
