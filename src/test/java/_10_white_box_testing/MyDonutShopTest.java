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

	@Mock
	PaymentService paymentService;

	@Mock
	DeliveryService deliveryService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		myDonutShop = new MyDonutShop(paymentService, deliveryService, bakeryService);
		myDonutShop.setDeliveryService(deliveryService);
		myDonutShop.setPaymentService(paymentService);
	}

	@Test
	void itShouldTakeDeliveryOrder() throws Exception {
		// given
		List<Order> orders = Collections.singletonList(order);
		Order order2 = new Order("Joe", "1111111111", 5, 1.29, "1011346576", true);
		when(paymentService.charge(order2)).thenReturn(true);
		when(bakeryService.getDonutsRemaining()).thenReturn(100);

		// when
		myDonutShop.openForTheDay();
		myDonutShop.takeOrder(order2);
		// then
		verify(deliveryService, times(1)).scheduleDelivery(order2);
	}

	@Test
	void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() throws Exception {
		// given
		Order order1 = new Order("Joe", "1111111111", 5, 1.29, "1011346576", true);
		// bakeryService.setDonutsRemaining(order.getNumberOfDonuts()-1);
		when(paymentService.charge(order1)).thenReturn(true);
		when(bakeryService.getDonutsRemaining()).thenReturn(0);
		// when
		myDonutShop.openForTheDay();
		// then
		Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> myDonutShop.takeOrder(order1));
		assertEquals("Insufficient donuts remaining", exceptionThrown.getMessage());
	}

	@Test
	void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException() {
		// given
Order order3=new Order("Joe", "1111111111", 5, 1.29, "1011346576", true);
when(paymentService.charge(order3)).thenReturn(true);
when(bakeryService.getDonutsRemaining()).thenReturn(100);
		// when
myDonutShop.closeForTheDay();
		// then
Throwable exceptionThrown = assertThrows(IllegalStateException.class, () -> myDonutShop.takeOrder(order3));
assertEquals("Sorry we're currently closed", exceptionThrown.getMessage());
	}

}