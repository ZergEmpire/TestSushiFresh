package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class TaskSecondSendAnOrder extends PageBase {
    public TaskSecondSendAnOrder(WebDriver driver) {
        super(driver);
    }

/*    public TaskSecondSendAnOrder GoToMenuRoll() {
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Роллы')]"));
        element.click();
        return this;
    }*/



    public TaskSecondSendAnOrder ClickRandomCard() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, \"productBox\") and not(contains(@class, \"in-stop-list\")) and not (contains(@class, \"action-wrapper\"))]")));
        List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class, \"productBox\") and not(contains(@class, \"in-stop-list\")) and not (contains(@class, \"action-wrapper\"))]"));
        int i = (int) (Math.random() * list.size() - 1);
        wait.until(ExpectedConditions.elementToBeClickable(list.get(i)));
        list.get(i).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, \"mfp-content\")]//a[contains(@class, \"add-to-\")]")));
        WebElement elementButton = driver.findElement(By.xpath("//div[contains(@class, \"mfp-content\")]//a[contains(@class, \"add-to-\")]"));
        elementButton.click();

        /*if (driver.findElements(By.xpath("//div[@class = \"mfp-content\"]//div[contains(@class, \"modal-body\")]")).size() > 0) {// Click on Teaching Notes

            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("$(document.elementFromPoint(1000, 280)).click();");

        } else {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


        }*/
        return this;
    }

    public TaskSecondSendAnOrder ScrollMenuToProductCards(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, \"productBox\") and not(contains(@class, \"in-stop-list\")) and not (contains(@class, \"action-wrapper\"))]")));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//div[contains(@class, \"productBox\") and not(contains(@class, \"in-stop-list\")) and not (contains(@class, \"action-wrapper\"))]"));
        je.executeScript("arguments[0].scrollIntoView(true);",element);

        return this;
    }

    public TaskSecondSendAnOrder AssertElementsInMenu (){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, \"productBox\")]")));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement TitleElement = driver.findElement(By.xpath("//div[@id='catalog']/div[@class='container']/child::div[contains(@class, 'section-title')]"));
        je.executeScript("arguments[0].scrollIntoView(true);",TitleElement);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='catalog']/div[@class='container']/child::div[contains(@class, 'section-title')]")));
        isElementByDisplayed(By.xpath("//div[@id='catalog']/div[@class='container']/child::div[contains(@class, 'section-title')]"));
        isElementByDisplayed(By.xpath("//div[@id='discounttime_block']/div[contains(@class, 'row')][1]/child::div[contains(@class, 'section-title')][1]"));
        //a[contains(@class, "highlightable")][1]
        //section[@id = "recomended"]//div[@class = "section-title"]
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, \"highlightable\")][1]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, \"highlightable\")][2]")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement SortElements = driver.findElement(By.xpath("//a[contains(@class, \"highlightable\")][1]"));
        js.executeScript("arguments[0].scrollIntoView(true);",TitleElement);
        isElementByDisplayed(By.xpath("//a[contains(@class, \"highlightable\")][1]"));
        isElementByDisplayed(By.xpath("//a[contains(@class, \"highlightable\")][2]"));


        return this;
    }
    public TaskSecondSendAnOrder AssertElementsInMenuAfterClickCards (){
        JavascriptExecutor jx = (JavascriptExecutor) driver;
        WebElement RecommendedTitle = driver.findElement(By.xpath("//section[@id = \"recomended\"]//div[@class = \"section-title\"]"));
        jx.executeScript("arguments[0].scrollIntoView(true);",RecommendedTitle);
        isElementByDisplayed(By.xpath("//section[@id = \"recomended\"]//div[@class = \"section-title\"]"));


        return this;
    }



    //Идём в корзину
    public TaskSecondSendAnOrder GoToFiledBasket() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, \"btn-basket\")]")));
        WebElement webElement = driver.findElement(By.xpath("//a[contains(@class, \"btn-basket\")]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
        return this;
    }

    public TaskSecondSendAnOrder FillInFields() {
        //Заполнить имя
        wait.until(ExpectedConditions.elementToBeClickable(By.id("order_name")));
        WebElement Name = driver.findElement(By.id("order_name"));
        Name.clear();
        Name.sendKeys(TestName);
        //Заполнить Тестовый телефон
        wait.until(ExpectedConditions.elementToBeClickable(By.id("order_phone")));
        WebElement TestPhone = driver.findElement(By.id("order_phone"));
        TestPhone.clear();
        TestPhone.sendKeys(TestPhoneNumberLogin);
        //Заполнить Тестовый email
        wait.until(ExpectedConditions.elementToBeClickable(By.id("order_email")));
        WebElement TestEmail = driver.findElement(By.id("order_email"));
        TestEmail.clear();
        TestEmail.sendKeys(TestEmailAddress);
        //Заполнить Адрес (который располагается на карте)
        wait.until(ExpectedConditions.elementToBeClickable(By.id("order_street")));
        WebElement Address1 = driver.findElement(By.id("order_street"));
        Address1.clear();
        Address1.sendKeys(AddressStreet);
        //Заполнить Номер дома( Который располагается на карте)
        wait.until(ExpectedConditions.elementToBeClickable(By.id("order_house")));
        WebElement Address2 = driver.findElement(By.id("order_house"));
        Address2.clear();
        Address2.sendKeys(AddressHome);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("order_doorway")));
        WebElement Doorway = driver.findElement(By.id("order_doorway"));
        Doorway.clear();
        Doorway.sendKeys(DoorWay);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("order_floor")));
        WebElement Orderfloor = driver.findElement(By.id("order_floor"));
        Orderfloor.clear();
        Orderfloor.sendKeys(OrderFloor);


        wait.until(ExpectedConditions.elementToBeClickable(By.id("order_apartment")));
        WebElement Orderapartment = driver.findElement(By.id("order_apartment"));
        Orderapartment.clear();
        Orderapartment.sendKeys(OrderApartment);

        //Заполнить поле комментарий.
        wait.until(ExpectedConditions.elementToBeClickable(By.id("order_comment")));
        WebElement Address3 = driver.findElement(By.id("order_comment"));
        Address3.clear();
        Address3.sendKeys(OrderComment);
        return this;
    }

    public  TaskSecondSendAnOrder selectPayType(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".payment-title")));
        WebElement paymentTitle = driver.findElement(By.cssSelector(".payment-title"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",paymentTitle);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#change")));
        WebElement HowGetMoneyCourier = driver.findElement(By.cssSelector("#change"));
         HowGetMoneyCourier.click();
         HowGetMoneyCourier.clear();
        HowGetMoneyCourier.sendKeys(howMoneyToCourier);
        return this;
    }

    public TaskSecondSendAnOrder SendOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='sendOrder']")));
        WebElement GoSendOrder = driver.findElement(By.xpath("//button[@id='sendOrder']"));
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click[1];",GoSendOrder);  *//* .scrollIntoView(true)*/
        GoSendOrder.click();
        wait.until(ExpectedConditions.urlContains("/complete/"));
        isElementByDisplayed(By.xpath("//b[contains(text(),'Информация о заказе')]"));
        return this;
    }

    public TaskSecondSendAnOrder FuckingClick(){
        WebElement FuckClick = driver.findElement(By.className("mfp-wrap mfp-close-btn-in mfp-auto-cursor my-mfp-zoom-in mfp-ready"));
        FuckClick.click();
        return this;
    }


    public TaskSecondSendAnOrder MathRandomHead (){
        List<WebElement> list = driver.findElements(By.xpath("//a[contains(@class, \"scroll-nav_link\") and not (contains(@href, \"/menu/nabory-i-sety\"))]"));
        int i = (int) (Math.random() * list.size());
        list.get(i).click();
        return this;
    }
    public TaskSecondSendAnOrder ClickDesert (){
        WebElement desert = driver.findElement(By.xpath("//span[contains(text(), 'Десерты')]"));
        desert.click();
        return this;
    }


    /*public TaskSecondSendAnOrder CheckStatusOrder(){
        isElementByDisplayed(By.xpath("//span[contains(text(),'Принят') or (contains(text(),'Поступил')) ]"));
        return this;
    }*/

    public TaskSecondSendAnOrder ClickGoTopButton (){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class, \"top-button\")]")));
        WebElement TopButton = driver.findElement(By.xpath("//a[contains(@class, \"top-button\")]"));
        TopButton.click();
        return this;
    }

}
