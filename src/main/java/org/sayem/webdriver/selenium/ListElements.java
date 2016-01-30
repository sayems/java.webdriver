package org.sayem.webdriver.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sayem on 1/23/16.
 */
public class ListElements extends DelegatingWebDriver
        implements ExplicitWait, SearchScope {

    public ListElements(WebDriver delegate) {
        super(delegate);
    }

    public Element getFirstRelatedElementFromList(Supplier<By> by, String contains) {
        return findElements(by).filter(tab -> tab.getText()
                .contains(contains))
                .findFirst().get();
    }

    public Element getFirstRelatedElementFromList(Supplier<By> by, String contains1, String contains2) {
        return findElements(by).filter(tab -> tab.getText().contains(contains1)
                && tab.getText().contains(contains2))
                .findFirst().get();
    }

    public boolean isElementPresentInTheList(Supplier<By> by, String contains) {
        return findElements(by).anyMatch(row -> row.getText().contains(contains));
    }

    public boolean isElementPresentInTheList(Supplier<By> by, String contains1, String contains2) {
        return findElements(by).anyMatch(row -> row.getText().contains(contains1)
                && row.getText().contains(contains2));
    }

    public Element getChildElement(Supplier<By> parent, Supplier<By> child, String contains) {
        return findElements(parent).filter(tab ->
                tab.getText().contains(contains))
                .findFirst().get()
                .findElement(child);
    }


    public List<String> getListOfChildElement(Supplier<By> parent, Supplier<By> child) {
        return findElements(parent)
                .map(e -> e.findElement(child).getText())
                .collect(Collectors.toList());
    }

    @Override
    public Element findElement(Supplier<By> by) {
        Element element = new Element(super.findElement(by.get()));
        element.setSearchContext(this);
        element.setLocator((ExplicitWait e) -> this.untilFound2(by));
        return element;
    }

    public Stream<Element> findElements(Supplier<By> by) {
        return super.findElements(by.get()).stream().map(Element::new);
    }
}
