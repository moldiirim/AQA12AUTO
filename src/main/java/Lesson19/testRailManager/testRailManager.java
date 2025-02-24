package main.java.Lesson19.testRailManager;


import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;

import java.util.List;

public class testRailManager {
    public static void main(String[] args) {
        //Получаем экземпляр TestRail
        String testRailUrl = "https://moldiirimb.testrail.io/";
        String userName = "mba6104@gmail.com";
        String password = "Bmoldirim@8";

        TestRail myTestRail = TestRail
                .builder(testRailUrl, userName, password).applicationName("TestRailIntegration").build();

        testRailManager manager = new testRailManager();
        manager.getPrintln(myTestRail);
        manager.createTestRunAndAddResults(myTestRail);

        // Список все проектов
        System.out.println("==========PROJECT LIST==========");
        List<Project> projectList = myTestRail.projects().list().execute();
        for (Project project : projectList) {
            System.out.println("Project Name:" + project.getName() + "\nProjectId: " + project.getId());
        }
// Список Suites
        System.out.println("==========Suites LIST==========");
        List<Suite> suitesList = myTestRail.suites().list(1).execute();
        ;
        for (Suite suites : suitesList) {
            System.out.println("Suite Name: " + suites.getName() + "\nSuite Id: " + suites.getId());
        }
    }

    public void getPrintln(TestRail myTestRail) {

        System.out.println("==========Cases LIST==========");
        List<CaseField> caseFieldList = myTestRail.caseFields().list().execute();
        List<Case> caseList = myTestRail.cases().list(1, 1, caseFieldList).execute();
        for (Case cases : caseList) {
            System.out.println("Case Name: " + cases.getTitle() + "\nCases Id: " + cases.getId());
        }

    }
    public void createTestRunAndAddResults(TestRail myTestRail) {
        System.out.println("========== Creating Test Run ==========");

        // Создаем тест-ран (Обязательно указываем suiteId)
        Run run = myTestRail.runs()
                .add(1, new Run().setName("AQA Test Run").setIncludeAll(true).setSuiteId(1))
                .execute();

        int runId = run.getId();
        System.out.println("Test Run ID: " + runId);

        // Получаем список тестов внутри этого Test Run
        List<Test> tests = myTestRail.tests().list(runId).execute();

        if (tests.isEmpty()) {
            System.out.println("No tests found in the test run!");
            return;
        }

        // Выводим список тестов
        for (Test test : tests) {
            System.out.println("Test ID in run: " + test.getId() + ", Case ID: " + test.getCaseId());
        }

        // Выбираем первый тест-кейс из списка
        int caseId = tests.get(0).getCaseId();
        System.out.println("Using Case ID: " + caseId);

        // Получаем поля результатов
        List<ResultField> resultFieldList = myTestRail.resultFields().list().execute();


        // Добавляем результат для первого тест-кейса в ран
        myTestRail.results().addForCase( run.getId(), 5, new Result().setStatusId(1),resultFieldList).execute();
        myTestRail.results().addForCase( run.getId(), 6, new Result().setStatusId(2),resultFieldList).execute();
        myTestRail.results().addForCase( run.getId(), 7, new Result().setStatusId(4),resultFieldList).execute();
        myTestRail.results().addForCase( run.getId(), 8, new Result().setStatusId(5),resultFieldList).execute();
        System.out.println("Result added successfully!");
    }

}
