/**
 *
 */
package exercise;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

/**
 * @author Hongxue.Liu
 *
 */
public class EnduserMyPlanPage {

    WebDriver driver;

    Actions action;

    public EnduserMyPlanPage(WebDriver driver) {

        this.driver = driver;
    }

    @FindBy(xpath = ".//li[@class='x-tree-node']")
    List<WebElement> folders;

    @FindBy(xpath = ".//span[@title='Assigned']")
    WebElement assignedFolder;

    @FindBy(xpath = ".//span[@title='Personal']")
    WebElement personalFolder;

    @FindBy(xpath = ".//*[@id='toolbar_myplan']")
    WebElement myplanLink;

    @FindBy(xpath = "//select[@id='category']")
    WebElement category;

    @FindBy(xpath = "//select[@id='language']")
    WebElement language;

    @FindBy(id = "search_submit")
    WebElement searchButton;

    @FindBy(id = "goal")
    WebElement goal;

    @FindBy(id = "data_div")
    WebElement showcalendar;

    @FindBy(id = "dateTarget")
    WebElement datetarget;

    @FindBy(id = "submit_myPlan")
    WebElement submitmyplan;

    @FindBy(id = "choose_folder")
    WebElement changefolder;

    @FindBy(xpath = ".//div[@id='folderTree']/div/div/ul/div/li[2]/div/a/span")
    WebElement developmentplan;

    @FindBy(id = "choosefolder_submit")
    WebElement changefoldersubmit;

    @FindBy(css = ".remove_from_myplan")
    WebElement removefrommyplan;

    @FindBy(css = ".x-window-header-text")
    WebElement removemyplanconfirm;

    @FindBy(css = ".x-btn-text")
    List<WebElement> buttons;

    public boolean ismyPlanDisplayed() {

        boolean myPlan = myplanLink.isDisplayed();

        return myPlan;

    }

    public void clickOnMyplan() {

        myplanLink.click();

    }

    public String getMyPlanLinktext() {
        return myplanLink.getText();
    }

    public void inputGoal(String svalue) {
        if (goal.isDisplayed()) {
            goal.click();
            goal.clear();
            goal.sendKeys(svalue);
        }

    }

    public void inputDateTarget(String days) {
        if (datetarget.isDisplayed()) {
            datetarget.click();
            datetarget.clear();
            float f = Float.parseFloat(days);
            int i = Math.round(f);
            DateFormat fmtDateTime = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, i);
            String date = fmtDateTime.format(calendar.getTime());
            datetarget.sendKeys(date);

        }
    }

    public void clickOkButton() {
        submitmyplan.click();

    }

    public WebElement getPersonalFolder() {
        return this.personalFolder;
    }

    public WebElement getAssigendFolder() {
        return this.assignedFolder;
    }

    public void addToPersonalPlan(String svalue, String days) {
        inputGoal(svalue);
        inputDateTarget(days);

        clickOkButton();

    }

    public void clickChangeFolder() {
        changefolder.click();
    }

    public void clickDevelopmentPlan() {
        developmentplan.click();
    }

    public void clickChangeFolderSubmit() {
        changefoldersubmit.click();

    }

    public void myplanClickCourseTitle(String stitle) {
        WebElement title = driver.findElement(By.xpath(".//span[@title='" + stitle + "']"));
        title.click();

    }

    public void clickRemoveMyPlan() {
        removefrommyplan.click();

    }

    /*
	public void deletePlanFromPersonalFolder(String stitle){
		try{
		WebElement tmp=this.personalFolder.findElement(By.xpath(".//span[@title='" + stitle + "']"));
		tmp.click();
		
		}catch(Exception ex){
			
		}
		
	}
     */
    public void clickYesButton() {
        WebElement yes = driver.findElement(By.cssSelector("css = button.x-btn-text:contains('Yes')"));

        yes.click();
    }

    public void clickButton(String name) {
        for (WebElement we : buttons) {
            if (we.getText().equals(name)) {
                we.click();
            }
        }

    }

    /*
	public void container(String name){
		//WebElement container = driver.findElement(By.className("#rightcontent_panel ul .x-tree-root-node"));
		WebElement container = driver.findElement(By.className("x-tree-root-node"));
		List<WebElement> items = container.findElements(By.xpath(".//span[@title='Personal']"));
		//int count = 0;
		for (WebElement we : items) {
			//we.findElement(By.xpath(".//span[@title='" + name + "']"));
			we.findElement(By.xpath(".//span[@title='Advanced Formatting in Word 2003']"));
			if (we.getText().equals(name)){
				System.out.println("found web element!");
			}
			//count++;
		}
		
	}*/
    public WebElement getPlanElement(Folder folder, By by) throws Exception {
        WebElement planElement = null;
        int[] index = getIndex(this.folders);
        int start;
        int end;
        switch (folder) {
            case ASSIGNED:
                start = index[0] + 1;
                end = index[1];
                for (int i = start; i < end; i++) {
                    try {
                        planElement = folders.get(i).findElement(by);
                        return planElement;
                    } catch (Exception ex) {
                        continue;
                    }
                }
                break;
            case PERSONAL:
                start = index[1] + 1;
                end = index[2];
                for (int i = start; i < end; i++) {
                    try {
                        planElement = folders.get(i).findElement(by);
                        return planElement;
                    } catch (Exception ex) {
                        continue;
                    }
                }
                break;
            case DEVELOPMENT:
                start = index[2] + 1;
                end = folders.size() - 1;
                for (int i = start; i < end; i++) {
                    try {
                        planElement = folders.get(i).findElement(by);
                        return planElement;
                    } catch (Exception ex) {
                        continue;
                    }
                }
                break;

        }
        if (planElement == null) {
            throw new Exception("Element is not exists");
        }
        return planElement;
    }

    private int[] getIndex(List<WebElement> webelements) {
        int[] index = new int[3];
        for (int i = 0; i <= webelements.size() - 1; i++) {
            try {

                webelements.get(i).findElement(By.xpath("Assgined"));
                webelements.get(i).getText();
                index[0] = i;
            } catch (Exception ex) {
                try {
                    webelements.get(i).findElement(By.xpath("Personal"));
                    index[1] = i;
                } catch (Exception ex1) {
                    try {
                        webelements.get(i).findElement(By.xpath("Dev"));
                        index[2] = i;
                    } catch (Exception ex2) {
                        continue;
                    }

                }
            }
        }

        return index;
    }

    public enum Folder {
        ASSIGNED, PERSONAL, DEVELOPMENT
    }
}
