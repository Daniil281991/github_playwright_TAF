package com.core.ui.elements;

import com.core.ui.elements.types.PwElement;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.utils.LoggerHandler;

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
        LoggerHandler.info(String.format("Get element '%s'(%s)", this.name, this.selector));
        return page.locator(selector).elementHandle();
    }

    @Override
    public Boolean isVisible() {
        LoggerHandler.info(String.format("Check if element '%s'(%s) is visible", this.name, this.selector));
        return page.isVisible(selector);
    }

    @Override
    public Boolean isDisabled() {
        LoggerHandler.info(String.format("Check if element '%s'(%s) is disabled", this.name, this.selector));

        return page.isDisabled(selector);
    }

    @Override
    public void click() {
        LoggerHandler.info(String.format("Click on element '%s'(%s)", this.name, this.selector));
        page.click(selector);
    }

    @Override
    public String getText() {
        LoggerHandler.info(String.format("Get text of the element '%s'(%s)", this.name, this.selector));
        return page.innerText(selector);
    }
}
