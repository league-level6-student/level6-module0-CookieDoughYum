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
CellPhone cellPhone = new CellPhone();
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
    	double actualRefuel=car.getFuelLevel();

        //then
    }

    @Test
    void itShouldContactCustomer() {
        //given

        //when

        //then
    }

}