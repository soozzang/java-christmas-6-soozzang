package christmas.domain;

public class Customer {

    private final long paidMoneyBeforeDiscount;
    private final Badge badge;

    public Customer(long paidMoneyBeforeDiscount ) {
        this.paidMoneyBeforeDiscount = paidMoneyBeforeDiscount;
        this.badge = null;
    }

    public void setCustomerBadge(long totalBenefits) {
        //
    }
}
