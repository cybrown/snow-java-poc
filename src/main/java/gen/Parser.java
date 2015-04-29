package gen;

import java.util.ArrayList;
import snow.HtmlGenerator;



public class Parser {
	public static final int _EOF = 0;
	public static final int _string = 1;
	public static final int maxT = 8;

	static final boolean _T = true;
	static final boolean _x = false;
	static final int minErrDist = 2;

	public Token t;    // last recognized token
	public Token la;   // lookahead token
	int errDist = minErrDist;
	
	public Scanner scanner;
	public Errors errors;

	public HtmlGenerator html;



	public Parser(Scanner scanner) {
		this.scanner = scanner;
		errors = new Errors();
	}

	void SynErr (int n) {
		if (errDist >= minErrDist) errors.SynErr(la.line, la.col, n);
		errDist = 0;
	}

	public void SemErr (String msg) {
		if (errDist >= minErrDist) errors.SemErr(t.line, t.col, msg);
		errDist = 0;
	}
	
	void Get () {
		for (;;) {
			t = la;
			la = scanner.Scan();
			if (la.kind <= maxT) {
				++errDist;
				break;
			}

			la = t;
		}
	}
	
	void Expect (int n) {
		if (la.kind==n) Get(); else { SynErr(n); }
	}
	
	boolean StartOf (int s) {
		return set[s][la.kind];
	}
	
	void ExpectWeak (int n, int follow) {
		if (la.kind == n) Get();
		else {
			SynErr(n);
			while (!StartOf(follow)) Get();
		}
	}
	
	boolean WeakSeparator (int n, int syFol, int repFol) {
		int kind = la.kind;
		if (kind == n) { Get(); return true; }
		else if (StartOf(repFol)) return false;
		else {
			SynErr(n);
			while (!(set[syFol][kind] || set[repFol][kind] || set[0][kind])) {
				Get();
				kind = la.kind;
			}
			return StartOf(syFol);
		}
	}
	
	void QueryForm() {
		html.printHeader(); 
		while (la.kind == 2 || la.kind == 3 || la.kind == 4) {
			Query();
		}
		html.printFooter(); 
	}

	void Query() {
		String caption; ArrayList values; 
		if (la.kind == 2) {
			Get();
			caption = Caption();
			values = Values();
			html.printRadio(caption, values); 
		} else if (la.kind == 3) {
			Get();
			caption = Caption();
			values = Values();
			html.printCheckbox(caption, values); 
		} else if (la.kind == 4) {
			Get();
			caption = Caption();
			html.printTextbox(caption); 
		} else SynErr(9);
	}

	String  Caption() {
		String  s;
		s = StringVal();
		return s;
	}

	ArrayList  Values() {
		ArrayList  values;
		String s; 
		Expect(5);
		s = StringVal();
		values = new ArrayList(); values.add(s); 
		while (la.kind == 6) {
			Get();
			s = StringVal();
			values.add(s); 
		}
		Expect(7);
		return values;
	}

	String  StringVal() {
		String  s;
		Expect(1);
		s = t.val.substring(1, t.val.length()-1); 
		return s;
	}



	public void Parse() {
		la = new Token();
		la.val = "";		
		Get();
		QueryForm();
		Expect(0);

	}

	private static final boolean[][] set = {
		{_T,_x,_x,_x, _x,_x,_x,_x, _x,_x}

	};
} // end Parser


class Errors {
	public int count = 0;                                    // number of errors detected
	public java.io.PrintStream errorStream = System.out;     // error messages go to this stream
	public String errMsgFormat = "-- line {0} col {1}: {2}"; // 0=line, 1=column, 2=text
	
	protected void printMsg(int line, int column, String msg) {
		StringBuffer b = new StringBuffer(errMsgFormat);
		int pos = b.indexOf("{0}");
		if (pos >= 0) { b.delete(pos, pos+3); b.insert(pos, line); }
		pos = b.indexOf("{1}");
		if (pos >= 0) { b.delete(pos, pos+3); b.insert(pos, column); }
		pos = b.indexOf("{2}");
		if (pos >= 0) b.replace(pos, pos+3, msg);
		errorStream.println(b.toString());
	}
	
	public void SynErr (int line, int col, int n) {
		String s;
		switch (n) {
			case 0: s = "EOF expected"; break;
			case 1: s = "string expected"; break;
			case 2: s = "\"RADIO\" expected"; break;
			case 3: s = "\"CHECKBOX\" expected"; break;
			case 4: s = "\"TEXTBOX\" expected"; break;
			case 5: s = "\"(\" expected"; break;
			case 6: s = "\",\" expected"; break;
			case 7: s = "\")\" expected"; break;
			case 8: s = "??? expected"; break;
			case 9: s = "invalid Query"; break;
			default: s = "error " + n; break;
		}
		printMsg(line, col, s);
		count++;
	}

	public void SemErr (int line, int col, String s) {	
		printMsg(line, col, s);
		count++;
	}
	
	public void SemErr (String s) {
		errorStream.println(s);
		count++;
	}
	
	public void Warning (int line, int col, String s) {	
		printMsg(line, col, s);
	}
	
	public void Warning (String s) {
		errorStream.println(s);
	}
} // Errors


class FatalError extends RuntimeException {
	public static final long serialVersionUID = 1L;
	public FatalError(String s) { super(s); }
}
