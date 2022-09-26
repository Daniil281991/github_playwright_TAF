package com.core.ui.elements;

import com.core.ui.elements.types.PwButton;
import com.microsoft.playwright.Page;

public class Button extends Element implements PwButton {
    Page page;

    public Button(String selector, String name, Page page) {
        super(selector, name, page);
    }
}
