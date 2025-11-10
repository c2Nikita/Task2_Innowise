package org.example.task.component;

import java.util.ArrayList;

public class TextComposite extends TextComponent{
    private ArrayList<TextComponent> components = new ArrayList<>();

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
        for (TextComponent component : components) {

            if (getComponentType() == TextComponentType.PARAGRAPH) {
                sb.append("\t");
            }
            sb.append(component.toString());

            if (getComponentType() == TextComponentType.PARAGRAPH) {
                sb.append("\n");
            }

            if (getComponentType() == TextComponentType.SENTENCE) {
                sb.append(" ");
            }


        }
        return sb.toString().stripTrailing();
    }


}
