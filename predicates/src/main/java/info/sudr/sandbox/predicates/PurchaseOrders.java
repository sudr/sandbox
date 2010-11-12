package info.sudr.sandbox.predicates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;

/**
 * Represents every purchase order in the system
 * 
 * @author cyrille martraire
 */
public class PurchaseOrders {

	private final List<PurchaseOrder> orders = new ArrayList<PurchaseOrder>();

	@Deprecated
	public List<PurchaseOrder> listOrdersByCustomer(Customer customer) {
		final List<PurchaseOrder> selection = new ArrayList<PurchaseOrder>();
		for (PurchaseOrder order : orders) {
			if (order.getCustomer().equals(customer)) {
				selection.add(order);
			}
		}
		return selection;
	}

	@Deprecated
	public List<PurchaseOrder> listRecentOrders(Date fromDate) {
		final List<PurchaseOrder> selection = new ArrayList<PurchaseOrder>();
		for (PurchaseOrder order : orders) {
			if (order.getDate().after(fromDate)) {
				selection.add(order);
			}
		}
		return selection;
	}

	public List<PurchaseOrder> listOrders(Predicate<PurchaseOrder> condition) {
		final List<PurchaseOrder> selection = new ArrayList<PurchaseOrder>();
		for (PurchaseOrder order : orders) {
			if (condition.apply(order)) {
				selection.add(order);
			}
		}
		return selection;
	}

	public Collection<PurchaseOrder> filterOrders(Predicate<PurchaseOrder> condition) {
		return Collections2.filter(orders, condition);
	}

	public Iterable<PurchaseOrder> selectOrders(Predicate<PurchaseOrder> condition) {
		return Iterables.filter(orders, condition);
	}

	public boolean add(PurchaseOrder o) {
		return orders.add(o);
	}

	public int size() {
		return orders.size();
	}

	@Override
	public String toString() {
		return "PurchaseOrders: " + orders.size() + " orders";
	}
}
