package com.core.ui.elements;

import com.core.ui.elements.types.PwElement;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.utils.LoggerHandler;

import java.util.logging.Logger;

public class Element implements PwElement {
    String selector;
    String name;
    Page page;
    Logger logger;


    public Element(String selector, String name, Page page) {
        this.selector = selector;
        this.name = name;
        this.page = page;
        this.logger = new LoggerHandler().setupLogger();
    }

    public Element(String selector, String name, Page page, String loggerFileName) {
        this.selector = selector;
        this.name = name;
        this.page = page;
        this.logger = new LoggerHandler(loggerFileName).setupLogger();
    }

    @Override
    public ElementHandle getElement() {
        this.logger.info(String.format("Get element '%s'(%s)", this.name, this.selector));
        return page.locator(selector).elementHandle();
    }

    @Override
    public Boolean isVisible() {
        this.logger.info(String.format("Check if element '%s'(%s) is visible", this.name, this.selector));
        return page.isVisible(selector);
    }

    @Override
    public Boolean isDisabled() {
        this.logger.info(String.format("Check if element '%s'(%s) is disabled", this.name, this.selector));
        return page.isDisabled(selector);
    }

    @Override
    public void click() {
        this.logger.info(String.format("Click on element '%s'(%s)", this.name, this.selector));
        page.click(selector);
    }

    @Override
    public String getText() {
        this.logger.info(String.format("Get text of the element '%s'(%s)", this.name, this.selector));
        return page.innerText(selector);
    }
}
