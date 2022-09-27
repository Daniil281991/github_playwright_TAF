package com.core.ui.elements;

import com.core.ui.elements.types.PwRadio;
import com.microsoft.playwright.Page;
import com.utils.LoggerHandler;

public class Radio extends Element implements PwRadio {
    public Radio(String selector, String name, Page page) {
        super(selector, name, page);
    }

    @Override
    public Boolean isChecked() {
        LoggerHandler.info(String.format("Check if element '%s'(%s) is checked", this.name, this.selector));
        return page.locator(this.selector).isChecked();
    }

    @Override
    public void setChecked(Boolean state) {
        String elementStateString = state ? "Checked" : "Unchecked";
        LoggerHandler.info(String.format("Set element '%s'(%s) %s", this.name, this.selector, elementStateString));
        page.setChecked(this.selector, state);
    }

    @Override
    public void check() {
        LoggerHandler.info(String.format("Check element '%s'(%s)", this.name, this.selector));
        page.check(this.selector);
    }
}
