package christmas.service;

import christmas.domain.Restrictions;

public class RestrictionsService {

    public static boolean checkIsAbleToApplyEvent(Restrictions restrictions) {
        return restrictions.getIsOverTenthousand();
    }

    public static boolean checkIsAbleToOrder(Restrictions restrictions) {
        return restrictions.getNotOnlyDrink() && restrictions.getIsOverTwenty();
    }
}
