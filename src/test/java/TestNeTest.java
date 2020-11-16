import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestNeTest {

    /* test1 */
    By inputForms = By.xpath("//a[text()='Input Forms']");
    By simpleFormDemo = By.xpath("//li[@class='tree-branch']//a[text()='Simple Form Demo']");
    By noThanksButton = By.linkText("No, thanks!");
    By inputSingleMessage = By.xpath("//input[@id='user-message']");
    By inputSingleMessageButton = By.xpath("//form[@id='get-input']//button");
    String messageCheck = "Hello";
    By checkMessage = By.xpath("//span[@id='display']");

    /* test2 */
    By inputA = By.xpath("//label[text()='Enter a']/following-sibling::input");
    By inputB = By.xpath("//label[text()='Enter b']/following-sibling::input");
    By getTotalButton = By.xpath("//button[text()='Get Total']");
    String checkTotalString = "5";
    By checkTotal = By.xpath("//span[@id='displayvalue']");

    /* test3 */
    By checkboxDemo = By.xpath("//li[@class='tree-branch']//a[text()='Checkbox Demo']");
    By checkBox1 = By.xpath("//label[text()[contains(.,'Option 1')]]/input");
    By checkBox3 = By.xpath("//label[text()[contains(.,'Option 3')]]/input");

    /* test4 */
    By radioButtonDemo = By.xpath("//li[@class='tree-branch']//a[text()='Radio Buttons Demo']");
    By checkBoxSex = By.xpath("//h4[text()['Sex :']]/following-sibling::label//input[@value='Female']");
    By checkBoxAge = By.xpath("//h4[text()['Sex :']]/following-sibling::label//input[@value='5 - 15']");
    By getValuesButton = By.xpath("//button[text()='Get values']");
    By checkBoxMessage = By.xpath("//p[@class='groupradiobutton']");
    String checkBoxMessageCheck = "Sex : Female \n Age group: 5 - 15";

    /* test5 */
    By dropDownDemo = By.xpath("//li[@class='tree-branch']//a[text()='Select Dropdown List']");
    By dropDownSingleMenu = By.xpath("//select[@id='select-demo']");
    By optionFriday = By.xpath("//option[@value='Friday']");
    By selectedValueDropDown = By.xpath("//p[@class='selected-value']");
    String singleDropdownTextCheck = "Day selected :- Friday";

    /* test6 */
    By dropDownMultiMenu = By.xpath("//select[@id='multi-select']");
    By optionNewYork = By.xpath("//option[@value='New York']");
    By printAllButton = By.xpath("//button[@id='printAll']");
    By multiCheck = By.xpath("//p[@class='getall-selected']");
    String multiCheckMessage = "Options selected are : New York";

    /* test 7 */
    By ajaxFormSubmit = By.xpath("//li[@class='tree-branch']//a[text()='Ajax Form Submit']");
    By ajaxSubmitButton = By.xpath("//input[@id='btn-submit']");
    By ajaxTitleField = By.xpath("//input[@id='title']");
    String borderColor = "rgb(255, 0, 0)";

    /* test8 */
    By datePicker = By.xpath("//a[text()='Date pickers']");
    By bootstrapDatePicker = By.xpath("//li[@class='tree-branch']//a[text()='Bootstrap Date Picker']");
    By datePickerButton = By.xpath("//div[@id='sandbox-container1']//input");
    private int getYesterdayDate() {
        String pattern = "dd/MM/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        String todayAsString = df.format(today);
        return Integer.parseInt(todayAsString.substring(0,2)) - 1; }
    String dateToCompare = "16/11/2020";    //jodatime lib

    /* test10 */
    By tableLink = By.xpath("//a[text()='Table']");
    By tableDataSearch = By.xpath("//li[@class='tree-branch']//a[text()='Table Data Search']");
    By inputTable = By.xpath("//input[@id='task-table-filter']");
    By resultRow = By.xpath("//table[@id='task-table']//tbody//tr[@style='display: table-row;']");
    String resultRowString = "4 Bootstrap 3 Emily John in progress";


    @BeforeClass
    public static void beforeTestClass(){
        Configuration.baseUrl="https://www.seleniumeasy.com/";
        Configuration.startMaximized=true;
        Configuration.timeout=20000;
    }

    @Before
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        WebDriverRunner.setWebDriver(new ChromeDriver());
        open("/test");
        $(noThanksButton).shouldBe(visible).click();

    }
    @Test
    public void test1(){
        $(inputForms).shouldBe(visible).click();
        $(simpleFormDemo).shouldBe(visible).click();
        $(inputSingleMessage).setValue("Hello");
        $(inputSingleMessageButton).click();
        $(checkMessage).shouldHave(text(messageCheck));
        System.out.println("test1");
    }
    @Test
    public void test2() {
        $(inputForms).shouldBe(visible).click();
        $(simpleFormDemo).shouldBe(visible).click();
        $(inputA).setValue("2");
        $(inputB).setValue("3");
        $(getTotalButton).click();
        $(checkTotal).shouldHave(text(checkTotalString));
        System.out.println("test2");
    }
    @Test
    @Ignore
    public void test3() {
        $(inputForms).shouldBe(visible).click();
        $(checkboxDemo).shouldBe(visible).click();
        $(checkBox1).shouldBe(visible).click();
        $(checkBox3).click();
        $(checkBox1).shouldBe(enabled);
        $(checkBox3).shouldBe(enabled);
        System.out.println("test3");
    }
    @Test
    public void test4(){
        $(inputForms).shouldBe(visible).click();
        $(radioButtonDemo).shouldBe(visible).click();
        $(checkBoxSex).shouldBe(visible).click();
        $(checkBoxAge).shouldBe(visible).click();
        $(getValuesButton).shouldBe(visible).click();
        $(checkBoxMessage).shouldBe(visible).shouldHave(text(checkBoxMessageCheck));
        System.out.println("test4");
    }
    @Test
    public void test5() {
        $(inputForms).shouldBe(visible).click();
        $(dropDownDemo).shouldBe(visible).click();
        $(dropDownSingleMenu).shouldBe(visible).click();
        $(optionFriday).shouldBe(visible).click();
        $(selectedValueDropDown).shouldBe(visible).shouldHave(text(singleDropdownTextCheck));
        System.out.println("test5");
    }
    @Test
    public void test6() {
        $(inputForms).shouldBe(visible).click();
        $(dropDownDemo).shouldBe(visible).click();
        $(dropDownMultiMenu).shouldBe(visible).click();
        $(optionNewYork).shouldBe(visible).click();
        $(printAllButton).shouldBe(visible).click();
        $(multiCheck).shouldBe(visible).shouldHave(text(multiCheckMessage));
        System.out.println("test6");
    }
    @Test
    public void test7(){
        $(inputForms).shouldBe(visible).click();
        $(ajaxFormSubmit).shouldBe(visible).click();
        $(ajaxSubmitButton).shouldBe(visible).click();
        $(ajaxTitleField).shouldHave(cssValue("borderColor", borderColor));
        System.out.println("test7");
    }
    @Test
    @Ignore
    public void test8() {
        $(datePicker).shouldBe(visible).click();
        $(bootstrapDatePicker).shouldBe(visible).click();
        $(datePickerButton).shouldBe(visible).click();
        int yesterday = getYesterdayDate();
        By yesterdayDate = By.xpath("//td[text()[contains(.,'" + yesterday + "')]]");
        $(yesterdayDate).click();
        $(datePickerButton).shouldBe(visible).shouldHave(attribute("value",dateToCompare));
        System.out.println("test8");
    }
    @Test
    @Ignore
    public void test10(){
        $(tableLink).shouldBe(visible).click();
        $(tableDataSearch).shouldBe(visible).click();
        $(inputTable).setValue("Emily John");
        System.out.println(resultRow);
        String a = $(resultRow).innerText();
        System.out.println("print: " + a);
        $(resultRow).shouldBe(visible).shouldHave(text(resultRowString));
        System.out.println("test10");

    }



    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
