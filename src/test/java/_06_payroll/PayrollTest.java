package _06_payroll;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PayrollTest {

    Payroll payroll = new Payroll();

    @Test
    public void itShouldCalculatePaycheck() {
        //given
        double hourlyWage=2;
        int numHours=10;
        int expected=20;
        
        //when
        double actual=payroll.calculatePaycheck(hourlyWage, numHours);
        
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldCalculateMileageReimbursement() {
        //given
        int milesTraveled=10;
        double expected=5.75;
        
        //when
        double actual=payroll.calculateMileageReimbursement(milesTraveled);
        
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldCreateOfferLetter() {
        //given
    	String employeeName="Bob";
    	double hourlyWage=10;
    	String expected="Hello " + employeeName + ", We are pleased to offer you an hourly wage of " + hourlyWage;

        //when
        String actual=payroll.createOfferLetter(employeeName, hourlyWage);
        
        //then
        assertEquals(expected, actual);
    }

}