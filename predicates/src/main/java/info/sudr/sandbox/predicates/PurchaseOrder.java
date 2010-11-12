package info.sudr.sandbox.predicates;

import java.util.Date;

/**
 * Represents a simple purchase order
 * 
 * @author cyrille martraire
 */
public final class PurchaseOrder {

	private final Customer customer;

	private final Date date;

	private final OrderStatus status;

	public PurchaseOrder(Date date, OrderStatus status, Customer customer) {
		this.date = date;
		this.status = status;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Date getDate() {
		return date;
	}

	public boolean isInStatus(OrderStatus status) {
		return status.equals(status);
	}

	public boolean isPending() {
		return isInStatus(OrderStatus.PENDING);
	}

	public boolean isShipped() {
		return isInStatus(OrderStatus.SHIPPED);
	}

	public boolean isDelivered() {
		return isInStatus(OrderStatus.DELIVERED);
	}

	@Override
	public String toString() {
		return "PurchaseOrder [customer=" + customer + ", date=" + date + ", status=" + status + "]";
	}

}
