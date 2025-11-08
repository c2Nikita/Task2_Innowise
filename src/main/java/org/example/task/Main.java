package org.example.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.exception.TextException;
import org.example.task.reader.impl.TextReaderImpl;

public class Main {
    public static void main(String[] args) throws TextException {
        Logger logger = LogManager.getLogger();
        TextReaderImpl textReader = new TextReaderImpl();
        String result = textReader.readFile("data/text.txt");
        logger.info(result);

    }
}