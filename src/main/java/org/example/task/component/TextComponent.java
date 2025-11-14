package org.example.task.component;

import java.util.List;

public abstract class TextComponent {

    private TextComponentType componentType;

    public TextComponentType getComponentType(){
        return this.componentType;
    }

    public void setComponentType(TextComponentType componentType) {
        this.componentType = componentType;
    }

    public abstract String toString();

}
