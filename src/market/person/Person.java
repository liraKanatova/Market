package market.person;

import market.enums.Discount;
import market.enums.Gender;
import market.enums.Market;
import market.enums.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Person {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private int money;
    private List<Product> products;
    private Market market;
    private Discount moneyFromBank;

    public Discount getMoneyFromBank() {
        return moneyFromBank;
    }

    public void setMoneyFromBank(Discount moneyFromBank) {
        this.moneyFromBank = moneyFromBank;
    }

    public Person(String name, LocalDate dateOfBirth, Gender gender, int money, List<Product> products, Market market, Discount moneyFromBank)throws MyException {
        if (!name.matches("[a-zA-Za-яА-Я]*")) {
            throw new MyException("san berse bolboit!");
        } else {
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
            if (money <= 0) {
                throw new MyException("Akcha 0 bolso bolboit!");
            } else {
                this.money = money;
                this.products = products;
                this.market = market;
                this.moneyFromBank = moneyFromBank;
            }
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    @Override
    public String toString() {
        return String.format("""
                name    -  %s
                dateOfBirth- %s
                gender  -   %s
                money   -   %d
                market  -   %s
                products -  %s
                moneyFromBank-%s
                """,name,dateOfBirth,gender,money,products,market,moneyFromBank);






    }
}
