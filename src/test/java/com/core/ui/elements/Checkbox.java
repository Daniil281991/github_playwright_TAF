package com.core.ui.elements;

import com.core.ui.elements.types.PwCheckbox;
import com.microsoft.playwright.Page;

import static com.core.ui.elements.types.UiComponent.selector;

public class Checkbox extends Element implements PwCheckbox {

    public Checkbox(String selector, String name, Page page) {
        super(selector, name, page);
    }

    public Boolean isChecked() {
        this.logger.info(String.format("Check if element '%s'(%s) is checked", this.name, this.selector));
        return page.isChecked(this.selector);
    }

    public void check() {
        this.logger.info(String.format("Check the element '%s'(%s)", this.name, this.selector));
        page.check(this.selector);
    }

    public void uncheck() {
        this.logger.info(String.format("Uncheck the element '%s'(%s)", this.name, this.selector));
        page.uncheck(this.selector);
    }
}
