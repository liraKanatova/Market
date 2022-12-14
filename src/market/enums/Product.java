package market.enums;

public enum Product {
    BREAD(50,"bread"),MEAT(800,"meat"),FISH(500,"fish"),POTATO(80,"potato"),LEMONADE(45,"lemonade"),LEMON(30,"lemon"),APPLES(150,"apples"),PASTA(75,"pasta");
private int price;
private String name;

    Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
