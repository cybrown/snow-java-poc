build: coco
	javac Scanner.java Parser.java HtmlGenerator.java MakeQueryForm.java

coco:
	mkdir -p src/main/java/gen
	coco -package gen -o src/main/java/gen SnowCompilationUnit.ATG
	rm -f src/main/java/gen/*.java.old

clean:
	rm -f *.class output.html Parser.java Scanner.java

run:
	java MakeQueryForm input.txt output.html
