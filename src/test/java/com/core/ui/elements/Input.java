package com.core.ui.elements;

import com.core.ui.elements.types.PwInput;
import com.microsoft.playwright.Page;

public class Input extends Element implements PwInput {
    public Input(String selector, String name, Page page) {
        super(selector, name, page);
    }

    public void type(String value) {
        this.logger.info(String.format("Typing %s into element '%s'(%s)", value, this.name, this.selector));
        page.fill(this.selector, value);
    }

    public void clear() {
        this.logger.info(String.format("Clear input '%s'(%s)", this.name, this.selector));
        page.fill(this.selector, "");
    }
}
