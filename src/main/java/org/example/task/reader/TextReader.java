package org.example.task.reader;

import org.example.task.exception.TextException;

import java.io.IOException;

public interface TextReader {
    String readFile(String path) throws TextException;
}
