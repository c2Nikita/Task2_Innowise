package org.example.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.component.TextComponent;
import org.example.task.component.TextComposite;
import org.example.task.exception.TextException;
import org.example.task.parser.*;
import org.example.task.reader.impl.TextReaderImpl;
import org.example.task.service.TextService;
import org.example.task.service.impl.TextServiceImpl;
import org.w3c.dom.Text;

public class Main {
    public static void main(String[] args) throws TextException {
        Logger logger = LogManager.getLogger();
        TextReaderImpl textReader = new TextReaderImpl();
        String text = textReader.readFile("data/text.txt");
        AbstractTextParser textParser = buildChain();
        TextComponent tree = textParser.parse(text);

        TextService textService = new TextServiceImpl();

        System.out.println(textService.maxSentencesWithCommonWords((TextComposite) tree));
        System.out.println(textService.sortByLexemeCount((TextComposite) tree));
        System.out.println(tree);
        System.out.println("\n\n\n");
        textService.swapEdgeLexemes((TextComposite) tree);
        System.out.println(tree);


    }

    private static AbstractTextParser buildChain() {
        AbstractTextParser symbol = new SymbolParser();
        AbstractTextParser punct = new PunctuationParser();
        punct.setNextParser(symbol);
        AbstractTextParser word = new WordParser();
        word.setNextParser(punct);
        AbstractTextParser lexeme = new LexemeParser();
        lexeme.setNextParser(word);
        AbstractTextParser sentence = new SentenceParser();
        sentence.setNextParser(lexeme);
        AbstractTextParser paragraph = new ParagraphParser();
        paragraph.setNextParser(sentence);
        AbstractTextParser text = new TextParser();
        text.setNextParser(paragraph);

        return text;
    }
}