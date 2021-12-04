package _08_mocking.models;

import _07_intro_to_mocking.models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeliveryDriverTest {

    DeliveryDriver deliveryDriver;

    @Mock
    CellPhone cellPhone;
    
    @Mock 
    Car car;
    
    @BeforeEach
    void setUp() {
    MockitoAnnotations.openMocks(this);
    deliveryDriver=new DeliveryDriver("Bob", car, cellPhone, true, true, false);
    }

    @Test
    void itShouldWasteTime() {
        //given
boolean ExpectedBrowsing=true;

when(cellPhone.browseCatMemes()).thenReturn(true);

        //when
boolean ActualBrowsing=cellPhone.browseCatMemes();

        //then
assertEquals(ActualBrowsing, ExpectedBrowsing);
    }

    @Test
    void itShouldRefuel() {
        //given
    	int octaneGrade = 10;
    	boolean expectedRefuel=true;
    	
    	when(car.fillTank(octaneGrade)).thenReturn(true);

        //when
    	boolean actualRefuel=car.fillTank(octaneGrade);

        //then
    	assertEquals(actualRefuel, expectedRefuel);
    	
    }

    @Test
    void itShouldContactCustomer() {
        //given
String phoneNumber="111 111 1111";
boolean expectedContact=true;

when(cellPhone.call(phoneNumber)).thenReturn(true);

        //when
boolean actualContact=cellPhone.call(phoneNumber);

        //then
assertEquals(actualContact, expectedContact);

    }

}