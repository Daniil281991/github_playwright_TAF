package com.core.ui.elements;

import com.core.ui.elements.types.PwInput;
import com.microsoft.playwright.Page;
import com.utils.LoggerHandler;

public class Input extends Element implements PwInput {
    public Input(String selector, String name, Page page) {
        super(selector, name, page);
    }

    public void type(String value) {
        LoggerHandler.info(String.format("Typing %s into element '%s'(%s)", value, this.name, this.selector));
        page.fill(this.selector, value);
    }

    public void clear() {
        LoggerHandler.info(String.format("Clear input '%s'(%s)", this.name, this.selector));
        page.fill(this.selector, "");
    }
}
