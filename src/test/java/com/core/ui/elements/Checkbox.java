package com.core.ui.elements;

import com.core.ui.elements.types.PwCheckbox;
import com.microsoft.playwright.Page;

import static com.core.ui.elements.types.UiComponent.selector;

public class Checkbox extends Element implements PwCheckbox {

    public Checkbox(String selector, String name, Page page) {
        super(selector, name, page);
    }

    public Boolean isChecked() {
        return page.isChecked(this.selector);
    }

    public void check() {
        page.check(this.selector);
    }

    public void uncheck() {
        page.uncheck(this.selector);
    }
}
