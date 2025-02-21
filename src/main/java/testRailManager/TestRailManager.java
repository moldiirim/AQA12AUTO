package testRailManager;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;
import org.testng.annotations.Test;

import java.util.List;

public class TestRailManager {
    public static void main(String[] args) {
        //Получаем экземпляр TestRail
        String testRailUrl = "https://moldiirimb.testrail.io/";
        String userName = "mba6104@gmail.com";
        String password = "Bmoldirim@8";

        TestRail myTestRail = TestRail
                .builder(testRailUrl, userName, password).applicationName("TestRailIntegration").build();

        // Список все проектов
        System.out.println("==========PROJECT LIST==========");
        List<Project> projectList = myTestRail.projects().list().execute();
        for (Project project : projectList) {
            System.out.println("Project Name:" + project.getName() + "\nProjectId: " + project.getId());
        }
// Список Suites
        System.out.println("==========Suites LIST==========");
        List<Suite> suitesList = myTestRail.suites().list(1).execute();
        for (Suite suites : suitesList) {
            System.out.println("Suite Name: " + suites.getName() + "\nSuite Id: " + suites.getId());
        }
    }
//Список всех тест кейсов
        System.out.println("===========Suites LIST============");
    private TestRail myTestRail;
    List<CaseField> caseFieldList = myTestRail.caseFields().list().execute();
    List<Case> caseList = myTestRail.;case().

    list(1,1,caseFieldList).execute();

    for(Case testCase : caseList) {
        System.out.println("Case Name:" + testCase.getTitle() + "\n" + "Case Id:" + testCase.getId());
    }


Run run = myTestRail.runs().add(1, new Run().setName("AQA TEST RUN")).execute().setSuiteId(1);
    List<ResultField> resultFieldList = myTestRail.resultFields().list().execute();
    myTestRail.results().addForCase(run.getId(), 5,1, new Result().setStatusId(1), resultFieldList).execute();
     myTestRail.results().addForCase(run.getId(), 6,1, new Result().setStatusId(2), resultFieldList).execute();
      myTestRail.results().addForCase(run.getId(), 7,1, new Result().setStatusId(4), resultFieldList).execute();
       myTestRail.results().addForCase(run.getId(), 8,1, new Result().setStatusId(5), resultFieldList).execute();
    }
myTestRail.run().close(run.getId()).execute();
}




