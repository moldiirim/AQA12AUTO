package grouping;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Groups {
    private static boolean firstGroupPrinted = false;
    private static boolean secondGroupPrinted = false;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(ITestContext context) {
        // Проверяем, какой тест сейчас запускается
        String[] includedGroups = context.getIncludedGroups();

        for (String group : includedGroups) {
            if (group.equals("first") && !firstGroupPrinted) {
                System.out.println("\nFirstGroup:");
                firstGroupPrinted = true;
            } else if (group.equals("second") && !secondGroupPrinted) {
                System.out.println("\nSecondGroup:");
                secondGroupPrinted = true;
            }
        }
    }
        @Test (groups = "first", priority = 1)
    public void one() {
        System.out.println("Test 1");
    }
    @Test(groups = "second", priority = 1)
    public void two() {
        System.out.println("Test 2");
    }

    @Test(groups = "first", priority = 2)
    public void three() {
        System.out.println("Test 3");
    }

    @Test(groups = "second", priority = 2)
    public void four() {
        System.out.println("Test 4");
    }

    @Test(groups = "first", priority = 3)
    public void five() {
        System.out.println("Test 5");
    }

    @Test(groups = "second", priority = 3)
    public void six() {
        System.out.println("Test 6");
    }

    @Test(groups = "first", priority = 4)
    public void seven() {
        System.out.println("Test 7");
    }

    @Test(groups = "second", priority = 4)
    public void eight() {
        System.out.println("Test 8");
    }
}
