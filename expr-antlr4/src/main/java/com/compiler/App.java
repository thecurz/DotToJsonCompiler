package com.compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;

import picocli.CommandLine;

@CommandLine.Command(name = "Expr", mixinStandardHelpOptions = true, version = "0.0.1", description = "Antlr4 Analyzer")
public class App implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        CharStream input = CharStreams.fromFileName("./input.dot");
        String outFile = "output.json";

        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        ParseTree tree = parser.graph();

        ToJSONListener listener = new ToJSONListener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        // listener.printTupleMap();
        String json = listener.convertTupleMapToJson();
        try (FileWriter fileWriter = new FileWriter(outFile)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.out.println(exitCode);
    }
}
