package bankconsoleapp;

public class BankPojo {
    private String username;
    String password;
    private String name;
    private double money;

    public BankPojo(String username, String password, double money) {
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
