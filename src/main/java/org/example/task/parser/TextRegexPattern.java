package org.example.task.parser;

final class TextRegexPattern {
    static final String PARAGRAPH_DELIMITER = "{4}";
    static final String SENTENCE_DELIMETER = "(?<=[.!?])";
    static final String LEXEME_DELIMETER = "\\s+";
    static final String WORD_OR_PUNCT_DELIMETER = "([a-zA-Z]+)|([^a-zA-Z]+)";
    static final String WORD_DELIMETER = "([a-zA-Z]+)";

    private TextRegexPattern() {}

}
