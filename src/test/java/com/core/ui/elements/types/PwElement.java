package com.core.ui.elements.types;

import com.microsoft.playwright.ElementHandle;

//public interface PwElement extends UiComponent {
public interface PwElement {
    ElementHandle getElement();
    Boolean isVisible();
    Boolean isDisabled();
    void click();
    String getText();
}
