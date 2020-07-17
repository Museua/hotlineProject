package helpers;

import com.codeborne.selenide.CollectionCondition;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.log4testng.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static locators.SearchResultLocators.*;

public class SearchResultPageHelper {
    private Logger log;

    public SearchResultPageHelper(Logger log){this.log = log;}

    public void openFirstSuitableResultByText(String nameOfProduct) {
        $$(String.format(LIST_OF_SUITABLE_PRODUCTS, nameOfProduct)).shouldBe(CollectionCondition.sizeGreaterThan(0)).get(0).click();
    }

    public boolean checkMatchingDisplayedProductsWithProvided(String path) {
        try {
            CSVReader reader = new CSVReader(new FileReader(path));
            String [] nextLine;
            List<String> listFromInterface = PRODUCT_TITLES.shouldBe(CollectionCondition.sizeGreaterThan(10)).texts();
            List<String> listFromInterface2 = listFromInterface.stream().limit(10).collect(Collectors.toList());

            while ((nextLine = reader.readNext()) != null) {
                String nameOfProduct = "";
                for (int i = 0; i < 10; i++) {
                    for (String row : nextLine) {
                        nameOfProduct += row;
                        nameOfProduct += " ";
                    }
                    String fdfsf = nameOfProduct.trim();
                    if (listFromInterface2.stream().filter(el->el.contains(fdfsf)).collect(Collectors.toList()).size() < 1) {
                        System.out.println("There are no present product. File product - " + fdfsf);
                        System.out.println("List of products at page - ");
                        listFromInterface2.forEach(el-> System.out.println(el));
                        return false;
                    }
                    break;
                }
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public void sortOffersBy(String text) {
        SORT_SELECT.selectOptionContainingText(text);
    }
}
