coco: FORCE
	mkdir -p src/main/java/gen
	java -jar ./coco/Coco.jar -frames ./coco/ -package gen -o src/main/java/gen SnowCompilationUnit.ATG
	rm -f src/main/java/gen/*.java.old

FORCE:
