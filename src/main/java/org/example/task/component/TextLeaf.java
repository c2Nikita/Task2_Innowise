package org.example.task.component;

import java.util.ArrayList;
import java.util.List;

public class TextLeaf extends TextComponent{
    private char text;

    public TextLeaf(char text, TextComponentType componentType) {
        this.text = text;
        this.setComponentType(componentType);
    }

    @Override
    public String toString() {
        return String.valueOf(text);
    }


}
