package snow;

import snow.parser.IAstVisitor;
import snow.parser.node.*;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class XmlAstVisitor implements IAstVisitor {

	@Override
	public void visit(LiteralInteger node, boolean start) {
		this.printIndentation();
		s.println("<LiteralInteger>" + node.getFirstToken().getVal() + "</LiteralInteger>");
	}

	@Override
	public void visit(LiteralString node, boolean start) {
		this.printIndentation();
		s.println("<LiteralString>" + node.getFirstToken().getVal() + "</LiteralString>");
	}

	@Override
	public void visit(Binary node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<Binary operator=\"" + node.getOperator() + "\">");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</Binary>");
		}
	}

	@Override
	public void visit(Function node, boolean start) {
		if (start) {
			this.printIndentation();
			s.print("<Function");
			if (node.getName() != null) {
				s.print(" name=\"" + node.getName() + "\"");
			}
			s.println(">");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</Function>");
		}
	}

	@Override
	public void visit(Identifier node, boolean start) {
		this.printIndentation();
		s.println("<Identifier>" + node.getFirstToken().getVal() + "</Identifier>");
	}

	@Override
	public void visit(Definition definition, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<Definition>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</Definition>");
		}
	}

	@Override
	public void visit(Call call, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<Call>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</Call>");
		}
	}

	@Override
	public void visit(TypeGeneric node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<TypeGeneric>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</TypeGeneric>");
		}
	}

	@Override
	public void visit(If node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<If>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</If>");
		}
	}

	@Override
	public void visit(ExpressionList node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<ExpressionList>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</ExpressionList>");
		}
	}

	@Override
	public void visit(SnowClass node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<SnowClass>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</SnowClass>");
		}
	}

	@Override
	public void visit(Tuple tuple, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<Tuple>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</Tuple>");
		}
	}

	@Override
	public void visit(Unary unary, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<Unary operator=\"" + unary.getOperator() + "\" postfix=\"" + (unary.isPostfix() ? "true" : "false") + "\">");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</Unary>");
		}
	}

	@Override
	public void visit(PrimitiveOperation node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<PrimitiveOperation>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</PrimitiveOperation>");
		}
	}

	@Override
	public void visit(SnowType node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<SnowType>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</SnowType>");
		}
	}

	@Override
	public void visit(TypeInterfaceMember node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<TypeInterfaceMember>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</TypeInterfaceMember>");
		}
	}

	@Override
	public void visit(Argument node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<Argument>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</Argument>");
		}
	}

	@Override
	public void visit(TypeInterface node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<TypeInterface>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</TypeInterface>");
		}
	}

	@Override
	public void visit(TypeTuple node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<TypeTuple>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</TypeTuple>");
		}
	}

	@Override
	public void visit(TypeArray node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<TypeArray>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</TypeArray>");
		}
	}

	@Override
	public void visit(TypeFunction node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<TypeFunction>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</TypeFunction>");
		}
	}

	@Override
	public void visit(TypeFunctionParameterList node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<TypeFunctionParameterList>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</TypeFunctionParameterList>");
		}
	}

	@Override
	public void visit(TypeFunctionParameter node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<TypeFunctionParameter>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</TypeFunctionParameter>");
		}
	}

	@Override
	public void visit(ArgumentList node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<ArgumentList>");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</ArgumentList>");
		}
	}

	private PrintStream s;

	public XmlAstVisitor(String fileName) throws FileNotFoundException {
		s = fileName == null || "-".equals(fileName) ? System.out : new PrintStream(fileName);
	}

	private int spaceCount = 0;

	private void printIndentation() {
		for (int i = 0; i < this.spaceCount; i++) {
			s.print(' ');
		}
	}

	private void incIndentation() {
		this.spaceCount += 4;
	}

	private void decIndentation() {
		this.spaceCount -= 4;
	}
}
