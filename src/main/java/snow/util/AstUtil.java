package snow.util;

import snow.ast.node.BaseAstNode;
import snow.ast.node.Function;
import snow.ast.node.Tuple;

import java.util.ArrayList;
import java.util.List;

public class AstUtil {

    public BaseAstNode addToTuple(BaseAstNode maybeTuple, BaseAstNode bodyOfFunction) {
        if (bodyOfFunction == null) {
            return maybeTuple;
        }
        bodyOfFunction = new Function(bodyOfFunction.getFirstToken(), bodyOfFunction.getLastToken(), null, bodyOfFunction, null, null, null);
        if (maybeTuple == null) {
            return bodyOfFunction;
        }
        if (maybeTuple instanceof Tuple) {
            List<BaseAstNode> expressions = new ArrayList<>();
            expressions.addAll(((Tuple) maybeTuple).getExpressions());
            expressions.add(bodyOfFunction);
            return new Tuple(maybeTuple.getFirstToken(), maybeTuple.getLastToken(), expressions);
        } else {
            return new Tuple(maybeTuple.getFirstToken(), maybeTuple.getLastToken(), maybeTuple, bodyOfFunction);
        }
    }
}
