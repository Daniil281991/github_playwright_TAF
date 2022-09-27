package com.core.ui.elements;

import com.core.ui.elements.types.PwRadio;
import com.microsoft.playwright.Page;

public class Radio extends Element implements PwRadio {
    public Radio(String selector, String name, Page page) {
        super(selector, name, page);
    }

    @Override
    public Boolean isChecked() {
        this.logger.info(String.format("Check if element '%s'(%s) is checked", this.name, this.selector));
        return page.locator(this.selector).isChecked();
    }

    @Override
    public void setChecked(Boolean state) {
        String elementStateString = state ? "Checked" : "Unchecked";
        this.logger.info(String.format("Set element '%s'(%s) %s", this.name, this.selector, elementStateString));
        page.setChecked(this.selector, state);
    }

    @Override
    public void check() {
        this.logger.info(String.format("Check element '%s'(%s)", this.name, this.selector));
        page.check(this.selector);
    }
}
