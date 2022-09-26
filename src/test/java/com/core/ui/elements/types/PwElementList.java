package com.core.ui.elements.types;

import com.microsoft.playwright.ElementHandle;

interface TwoArgInterface {

    Integer operation(Integer a, Integer b);
}

interface elementForEachInterface {
    void handleElement(ElementHandle element);
}

interface elementFilterInterface {
    Boolean handleElement(ElementHandle element);
}

interface elementFindInterface {
    Boolean handleElement(ElementHandle element);
}

public interface PwElementList extends UiComponent {
    ElementHandle[] all();
    ElementHandle first();
    void forEach(elementForEachInterface func);
    ElementHandle[] filter(elementFilterInterface func);
    ElementHandle find(elementFindInterface func);
    ElementHandle get(Integer number);
}
