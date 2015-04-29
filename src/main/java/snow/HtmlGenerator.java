package snow;

import java.io.*;
import java.util.ArrayList;

public class HtmlGenerator {
	PrintStream s;
	int itemNo = 0;

	public HtmlGenerator(String fileName) throws FileNotFoundException {
		s = new PrintStream(fileName);
	}

	public void printHeader() {
		s.println("<html>");
		s.println("<head><title>Query Form</title></head>");
		s.println("<body>");
		s.println("  <form>");
	}

	public void printFooter() {
		s.println("  </form>");
		s.println("</body>");
		s.println("</html>");
		s.close();
	}

	public void printRadio(String caption, ArrayList values) {
		s.println(caption + "<br>");
		for (Object val: values) {
			s.print("<input type='radio' name='Q" + itemNo + "' ");
			s.print("value='" + val + "'>" + val + "<br>");
			s.println();
		}
		itemNo++; s.println("<br>");
	}

	public void printCheckbox(String caption, ArrayList values) {
		s.println(caption + "<br>");
		for (Object val: values) {
			s.print("<input type='checkbox' name='Q" + itemNo + "' ");
			s.print("value='" + val + "'>" + val + "<br>");
			s.println();
		}
		itemNo++; s.println("<br>");
	}

	public void printTextbox(String caption) {
		s.println(caption + "<br>");
		s.println("<textarea name='Q" + itemNo + "' cols='50' rows='3'></textarea><br>");
		itemNo++; s.println("<br>");
	}
}
