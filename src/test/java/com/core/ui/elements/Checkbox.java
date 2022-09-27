package com.core.ui.elements;

import com.core.ui.elements.types.PwCheckbox;
import com.microsoft.playwright.Page;
import com.utils.LoggerHandler;

public class Checkbox extends Element implements PwCheckbox {

    public Checkbox(String selector, String name, Page page) {
        super(selector, name, page);
    }

    public Boolean isChecked() {
        LoggerHandler.info(String.format("Check if element '%s'(%s) is checked", this.name, this.selector));
        return page.isChecked(this.selector);
    }

    public void check() {
        LoggerHandler.info(String.format("Check the element '%s'(%s)", this.name, this.selector));
        page.check(this.selector);
    }

    public void uncheck() {
        LoggerHandler.info(String.format("Uncheck the element '%s'(%s)", this.name, this.selector));
        page.uncheck(this.selector);
    }
}
