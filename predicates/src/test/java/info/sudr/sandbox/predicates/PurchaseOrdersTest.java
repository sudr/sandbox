package info.sudr.sandbox.predicates;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

/**
 * You need Java 5 or more recent and Google Guava .jar in your classpath
 * 
 * @author cyrille martraire
 * @see <a href="http://cyrille.martraire.com">cyrille's blog</a>
 * @see <a href="http://twitter.com/cyriux">@cyriux</a>
 */
public class PurchaseOrdersTest {

	public static final Customer CUSTOMER_1 = new Customer("Cyrille");

	private static final PurchaseOrder ORDER_1 = new PurchaseOrder(new Date(2010, 10, 31), OrderStatus.PENDING,
			CUSTOMER_1);

	public static final Customer CUSTOMER_2 = new Customer("Martraire");

	private static final PurchaseOrder ORDER_2 = new PurchaseOrder(new Date(2010, 10, 15), OrderStatus.DELIVERED,
			CUSTOMER_2);

	private PurchaseOrders orders;

	@BeforeTest
	public void setup() {
		orders = new PurchaseOrders();
		orders.add(ORDER_1);
		orders.add(ORDER_2);
		assertEquals(2, orders.size());
	}

	@Test
	public void test_listOrdersByCustomer() {
		assertEquals(1, orders.listOrdersByCustomer(CUSTOMER_1).size());
		assertEquals(ORDER_1, orders.listOrdersByCustomer(CUSTOMER_1).get(0));
	}

	@Test
	public void test_listOrder_ByCustomer() {
		final Predicate<PurchaseOrder> condition = new Predicate<PurchaseOrder>() {

			public boolean apply(PurchaseOrder order) {
				return order.getCustomer().equals(CUSTOMER_1);
			}
		};
		final List<PurchaseOrder> list = orders.listOrders(condition);
		assertEquals(1, list.size());
		assertEquals(ORDER_1, list.get(0));
	}

	/**
	 * A predicate to select purchase orders by their customer
	 * 
	 * @author cyrille martraire
	 */
	public static final class CustomerPredicate implements Predicate<PurchaseOrder> {

		private final Customer customer;

		public CustomerPredicate(Customer customer) {
			this.customer = customer;
		}

		public boolean apply(PurchaseOrder order) {
			return order.getCustomer().equals(customer);
		}
	}

	@Test
	public void test_filterOrders_ByCustomer() {
		final Collection<PurchaseOrder> selection = orders.filterOrders(new CustomerPredicate(CUSTOMER_1));
		assertEquals(1, selection.size());
		assertEquals(ORDER_1, selection.iterator().next());
	}

	@Test
	public void test_selectOrders_ByCustomer() {
		final CustomerPredicate condition = new CustomerPredicate(CUSTOMER_1);
		for (PurchaseOrder order : orders.selectOrders(condition)) {
			System.out.println(order);
		}

		final Iterable<PurchaseOrder> selection = orders.selectOrders(condition);
		assertEquals(1, Iterables.size(selection));
		assertEquals(ORDER_1, selection.iterator().next());
	}

	@Test
	public void test_Predicates() {
		final Predicate<Integer> isZero = Predicates.equalTo(0);
		assertTrue(isZero.apply(0));
		assertFalse(isZero.apply(1));

		final Predicate<String> isNotNull = Predicates.notNull();
		assertTrue(isNotNull.apply("@cyriux"));
		assertFalse(isNotNull.apply(null));

		final Predicate<Object> isString = Predicates.instanceOf(String.class);
		assertTrue(isString.apply("@cyriux"));
		assertFalse(isString.apply(Integer.MIN_VALUE));

		final Predicate<Integer> isNullOrZero = Predicates.or(isZero, Predicates.isNull());
		assertTrue(isNullOrZero.apply(null));
		assertTrue(isNullOrZero.apply(0));
		assertFalse(isNullOrZero.apply(35));
	}
}
