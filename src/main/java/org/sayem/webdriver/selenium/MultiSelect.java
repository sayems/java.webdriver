package org.sayem.webdriver.selenium;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by sayem on 1/23/16.
 */
public class MultiSelect extends DelegatingWebDriver
        implements ExplicitWait, SearchScope {

    private static final String VALUE = "value";

    public MultiSelect(WebDriver delegate) {
        super(delegate);
    }

    public Select getSelect(Supplier<By> by) {
        final Element element = untilFound(by);
        new WebDriverWait(this, 3, 100)
                .until((Predicate<WebDriver>) driver -> {
                    element.click();
                    return !element.findElements(By.tagName("option")).isEmpty();
                });
        return new Select(element);
    }

    public void select(Supplier<By> by, String select) {
        getSelect(by).selectByVisibleText(select);
    }

    public void selectFirstElement(Supplier<By> by) {
        getSelect(by).getAllSelectedOptions().get(1).click();
    }

    public Select getSelectLambda(Supplier<By> by) {
        Element element = untilFound(by);
        new WebDriverWait(this, 3, 100)
                .until((WebDriver driver) -> {
                    element.click();
                    return !element.findElements(By.tagName("option")).isEmpty();
                });
        return new Select(element);
    }

    public void selectByText(Supplier<By> by, String select) {
        final Element element = untilFound(by);
        Select dropdown = new Select(element);
        String textOption = dropdown
                .getOptions()
                .parallelStream().filter(opt -> opt.getText()
                        .contains(select))
                .findFirst()
                .get().getText();
        dropdown.selectByVisibleText(textOption);
    }

    public void selectFirstElementInTheDropDown(Supplier<By> by) {
        final Element element = untilFound(by);
        Select dropdown = new Select(element);
        String textOption = dropdown
                .getOptions()
                .parallelStream()
                .filter(el -> !el.getText().equals(""))
                .findFirst()
                .get().getText();
        dropdown.selectByVisibleText(textOption);
    }

    public boolean isTextPresentInTheDropdown(Supplier<By> by, String text) {
        final Element element = untilFound(by);
        Select dropdown = new Select(element);
        return dropdown
                .getOptions()
                .parallelStream()
                .anyMatch(opt -> opt.getText()
                        .contains(text));
    }

    public boolean isTextEqualInDropdown(Supplier<By> by, String text) {
        final Element element = untilFound(by);
        Select dropdown = new Select(element);
        return dropdown
                .getOptions()
                .parallelStream()
                .anyMatch(opt -> opt.getText()
                        .equals(text.trim()));
    }

    public MultiSelect deselectAll(Supplier<By> by) {
        new Select(findElement(by)).deselectAll();
        return this;
    }


    public MultiSelect selectByText(Supplier<By> by, String... texts) {
        Select select = new Select(findElement(by));
        select.deselectAll();
        Arrays.stream(texts).forEach(select::selectByVisibleText);
        return this;
    }


    public MultiSelect selectByValue(Supplier<By> by, String... values) {
        Select select = new Select(findElement(by));
        select.deselectAll();
        Arrays.stream(values).forEach(select::selectByValue);
        return this;
    }


    public MultiSelect selectByIndex(Supplier<By> by, Integer... indices) {
        Select select = new Select(findElement(by));
        select.deselectAll();
        Arrays.stream(indices).forEach(select::selectByIndex);
        return this;
    }

    public String getFirstSelectedText(Supplier<By> by) {
        try {
            return new Select(findElement(by)).getFirstSelectedOption().getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<String> getAllSelectedTexts(Supplier<By> by) {
        return new Select(findElement(by)).getAllSelectedOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getFirstSelectedValue(Supplier<By> by) {
        try {
            return new Select(findElement(by)).getFirstSelectedOption().getAttribute(VALUE);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<String> getAllSelectedValues(Supplier<By> by) {
        return new Select(findElement(by)).getAllSelectedOptions()
                .stream()
                .map(option -> option.getAttribute(VALUE))
                .collect(Collectors.toList());
    }

    public Integer getFirstSelectedIndex(Supplier<By> by) {
        try {
            Select select = new Select(findElement(by));
            List<WebElement> options = select.getOptions();
            if (!options.isEmpty()) {
                return options.indexOf(select.getFirstSelectedOption());
            }
            return null;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<Integer> getAllSelectedIndices(Supplier<By> by) {
        Select select = new Select(findElement(by));
        List<WebElement> options = select.getOptions();
        return select.getAllSelectedOptions().stream().map(options::indexOf).collect(Collectors.toList());
    }

    public List<String> getAllTexts(Supplier<By> by) {
        return new Select(findElement(by)).getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAllValues(Supplier<By> by) {
        return new Select(findElement(by)).getOptions()
                .stream()
                .map(option -> option.getAttribute(VALUE))
                .collect(Collectors.toList());
    }

    public Integer getNumberOfOptions(Supplier<By> by) {
        return new Select(findElement(by)).getOptions().size();
    }

    public Integer getNumberOfSelectedOptions(Supplier<By> by) {
        return new Select(findElement(by)).getAllSelectedOptions().size();
    }

    @Override
    public Element findElement(Supplier<By> by) {
        Element element = new Element(super.findElement(by.get()));
        element.setSearchContext(this);
        element.setLocator((ExplicitWait e) -> this.untilFound2(by));
        return element;
    }
}
