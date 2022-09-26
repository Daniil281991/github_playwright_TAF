package com.core.ui.elements;

import com.core.ui.elements.types.PwElement;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class Element implements PwElement {
    String selector;
    String name;
    Page page;

    public Element(String selector, String name, Page page) {
        this.selector = selector;
        this.name = name;
        this.page = page;
    }

    @Override
    public ElementHandle getElement() {
        return page.locator(selector).elementHandle();
    }

    @Override
    public Boolean isVisible() {
        return page.isVisible(selector);
    }

    @Override
    public Boolean isDisabled() {
        return page.isDisabled(selector);
    }

    @Override
    public void click() {
        page.click(selector);
    }

    @Override
    public String getText() {
        return page.innerText(selector);
    }
}
