package com.core.ui.elements;

import com.core.ui.elements.types.PwInput;
import com.microsoft.playwright.Page;

public class Input extends Element implements PwInput {
    public Input(String selector, String name, Page page) {
        super(selector, name, page);
    }

    public void type(String value) {
        page.fill(this.selector, value);
    }

    public void clear() {
        page.fill(this.selector, "");
    }
}
