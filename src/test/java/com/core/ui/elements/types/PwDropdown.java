package com.core.ui.elements.types;

public interface PwDropdown extends PwElement {
    void selectByIndex();
    void selectByValue();
    String getSelectedText();
    void selectByVisibleText(String visibleText);
}
