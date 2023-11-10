package christmas.domain;

public class Customer {

    private final long paidMoneyBeforeDiscount;
    private Badge badge;

    public Customer(long paidMoneyBeforeDiscount ) {
        this.paidMoneyBeforeDiscount = paidMoneyBeforeDiscount;
        this.badge = null;
    }

    public void setCustomerBadge(long totalBenefits) {
        if (totalBenefits >= 5000L && totalBenefits < 10000L) {
            badge = Badge.별;
        }
        if (totalBenefits >= 10000L && totalBenefits < 20000L) {
            badge = Badge.트리;
        }
        if (totalBenefits >= 20000L) {
            badge = Badge.산타;
        }
    }

    public Badge getBadge() {
        return badge;
    }

    public long getPaidMoneyBeforeDiscount() {
        return paidMoneyBeforeDiscount;
    }
}
