package com.core.ui.elements;

import com.core.ui.elements.types.PwRadio;
import com.microsoft.playwright.Page;

public class Radio extends Element implements PwRadio {
    public Radio(String selector, String name, Page page) {
        super(selector, name, page);
    }

    @Override
    public Boolean isChecked() {
        return page.locator(this.selector).isChecked();
    }

    @Override
    public void setChecked(Boolean state) {
        page.setChecked(this.selector, state);
    }

    @Override
    public void check() {
        page.check(this.selector);
    }
}
