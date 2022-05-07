target: MarkdownParse.class test-file3.md
MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java
	java MarkdownParse test-file3.md
MarkdownParseTest.class: MarkdownParseTest.java
	javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

test: MarkdownParse.class MarkdownParseTest.class
    java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest