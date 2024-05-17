
public class Menu {



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

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    private String name;//菜命
    private double money;//单价
    private int love;//点赞数

    public double getSendMoney() {
        return sendMoney;
    }

    public void setSendMoney(double sendMoney) {
        this.sendMoney = sendMoney;
    }

    private double sendMoney;//配送费
}
