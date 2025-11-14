package org.example.task.service.impl;

import org.example.task.component.TextComponentType;
import org.example.task.component.TextComposite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceImplTest {

    private TextServiceImpl textService;

    private TextComposite paragraph1;
    private TextComposite paragraph2;

    @BeforeEach
    void setUp() {
        textService = new TextServiceImpl();

        TextComposite word1 = new TextComposite(TextComponentType.WORD) {
            @Override
            public String toString() {
                return "Hello";
            }
        };
        TextComposite word2 = new TextComposite(TextComponentType.WORD) {
            @Override
            public String toString() {
                return "world";
            }
        };
        TextComposite word3 = new TextComposite(TextComponentType.WORD) {
            @Override
            public String toString() {
                return "Java";
            }
        };

        TextComposite lex1 = new TextComposite(TextComponentType.LEXEME);
        lex1.addComponent(word1);

        TextComposite lex2 = new TextComposite(TextComponentType.LEXEME);
        lex2.addComponent(word2);

        TextComposite lex3 = new TextComposite(TextComponentType.LEXEME);
        lex3.addComponent(word3);

        TextComposite sentence1 = new TextComposite(TextComponentType.SENTENCE);
        sentence1.addComponent(lex1);

        TextComposite sentence2 = new TextComposite(TextComponentType.SENTENCE);
        sentence2.addComponent(lex2);
        sentence2.addComponent(lex3);

        paragraph1 = new TextComposite(TextComponentType.PARAGRAPH);
        paragraph1.addComponent(sentence1);

        paragraph2 = new TextComposite(TextComponentType.PARAGRAPH);
        paragraph2.addComponent(sentence2);
    }

    @Test
    void testSortByLexemeCount() {
        TextComposite text = new TextComposite(TextComponentType.TEXT);
        text.addComponent(paragraph1);
        text.addComponent(paragraph2);

        List<TextComposite> sorted = textService.sortByLexemeCount(text).stream()
                .map(c -> (TextComposite) c)
                .toList();

        assertEquals(1, sorted.get(0).getComponents().size());
        assertEquals(2, sorted.get(1).getComponents().size());
    }

    @Test
    void testMaxSentencesWithCommonWords() {
        TextComposite text = new TextComposite(TextComponentType.TEXT);
        text.addComponent(paragraph1);
        text.addComponent(paragraph2);

        int max = textService.maxSentencesWithCommonWords(text);
        assertEquals(1, max);
    }

    @Test
    void testSwapEdgeLexemes() {
        TextComposite text = new TextComposite(TextComponentType.TEXT);
        text.addComponent(paragraph1);
        text.addComponent(paragraph2);

        String firstLexBefore = ((TextComposite) paragraph2.getComponents().get(0)).getComponents().get(0).toString();
        assertEquals("world", firstLexBefore);

        textService.swapEdgeLexemes(text);

        String firstLexAfter = ((TextComposite) paragraph2.getComponents().get(0)).getComponents().get(0).toString();
        assertEquals("Java", firstLexAfter);
    }
}
