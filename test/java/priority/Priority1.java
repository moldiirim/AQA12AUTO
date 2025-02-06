package priority;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static org.testng.Assert.assertTrue;

public class Priority1 {
    @Test (priority = 1)
    public void g() {
        System.out.println("Test G"); }

    @Test (priority = 2)
    public void f() {
        System.out.println("Test F");}

    @Test (priority = 3)
    public void e() {
        System.out.println("Test E"); }
    @Test (priority = 4)
    public void d() {
        System.out.println("Test D"); }
    @Test (priority = 5)
    public void c() {
        System.out.println("Test C"); }

    @Test (priority = 6)
    public void b() {
        System.out.println("Test B");}

    @Test (priority = 7)
    public void a() {
        System.out.println("Test A"); }
}
