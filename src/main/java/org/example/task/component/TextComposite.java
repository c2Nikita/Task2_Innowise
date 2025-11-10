package org.example.task.component;

import java.util.ArrayList;

public class TextComposite extends TextComponent{
    ArrayList<TextComponent> components = new ArrayList<>();

    public TextComposite(TextComponentType textComponentType) {
        setComponentType(textComponentType);
    }

    public void addComponent(TextComponent textComponent) {
        components.add(textComponent);
    }
    public void removeComponent(TextComponent textComponent) {
        components.remove(textComponent);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < components.size(); i++) {
            TextComponent current = components.get(i);
            TextComponent next = (i < components.size() - 1) ? components.get(i + 1) : null;

            sb.append(current.toString());

            if (current.getComponentType() == TextComponentType.WORD &&
                    next != null &&
                    next.getComponentType() == TextComponentType.WORD) {
                sb.append(" ");
            }

            if ((current.getComponentType() == TextComponentType.PUNCTUATION ||
                    isPunctuation(current)) &&
                    next != null &&
                    next.getComponentType() == TextComponentType.WORD) {
                sb.append(" ");
            }
        }


        if (getComponentType() == TextComponentType.PARAGRAPH) {
            sb.append("\n");
        }

        return sb.toString().trim();
    }

    private boolean isPunctuation(TextComponent component) {
        if (component instanceof TextLeaf) {
            char c = component.toString().charAt(0);
            return c == '.' || c == ',' || c == '!' || c == '?' || c == ';' || c == ':';
        }
        return false;
    }
}
