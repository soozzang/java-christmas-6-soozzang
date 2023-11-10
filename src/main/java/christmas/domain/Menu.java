package christmas.domain;

public enum Menu {
    // 에피타이저
    MUSHROOM_SOUP(6000L,"에피타이저","양송이 수프"),
    TAPAS(5000L,"에피타이저","타파스"),
    CAESAR_SALAD(8000L,"에피타이저","시저샐러드"),
    // 메인
    T_BONE_STEAK(55000L,"메인","티본스테이크"),
    BBQ_RIBS(54000L,"메인","바비큐립"),
    SEAFOOD_PASTA(35000L,"메인","해산물파스타"),
    CHRISTMAS_PASTA(25000L,"메인","크리스마스파스타"),
    // 디저트
    CHOCOLATE_CAKE(15000L,"디저트","초코케이크"),
    ICE_CREAM(5000L,"디저트","아이스크림"),
    // 음료
    ZERO_COLA(3000L,"음료","제로콜라"),
    RED_WINE(60000L,"음료","레드와인"),
    CHAMPAGNE(25000L,"음료","샴페인");

    private final long price;
    private final String type;
    private final String korName;

    Menu(long price, String type, String korName) {
        this.price = price;
        this.type = type;
        this.korName = korName;
    }

    public static Menu getMenu(String korName) {
        //
    }

}
