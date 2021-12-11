package _10_white_box_testing;

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

class MyDonutShopTest {

    MyDonutShop myDonutShop;

    @Mock
    Order order;
    
    @Mock
    BakeryService bakeryService;
    
    @BeforeEach
    void setUp() {
             MockitoAnnotations.openMocks(this);
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
List<Order> orders=Collections.singletonList(order);

        //when
          myDonutShop.takeOrder(order);
          
        //then
          verify(myDonutShop, times(1)).equals(order.getNumberOfDonuts());
          
    }

    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() throws Exception{
        //given
bakeryService.setDonutsRemaining(order.getNumberOfDonuts()-1);

        //when

        //then
Throwable exceptionThrown = assertThrows(Exception.class, () -> myDonutShop.takeOrder(order));
assertEquals(//expectedException, exceptionThrown);
//assertEquals("There are currently not enough donuts to fulfil your order", exceptionThrown.getMessage());
try {
	verify(myDonutShop, never()).takeOrder(any());
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println(e.getMessage());
}



    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException(){
        //given

        //when

        //then
    }

}