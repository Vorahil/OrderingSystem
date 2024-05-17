import java.util.ArrayList;
import java.util.Scanner;

public class MenuOperate {
    private int UserId=-1;
    private ArrayList<User>users=new ArrayList<>();
    private  Menu [] menu=new Menu[5];
    Scanner scanner=new Scanner(System.in);
    private boolean exit;

    private void information1(int id,String Name,double money,double sendMoney){
        this.menu[id] = new Menu();//使得列表的元素有地址而不是null
        this.menu[id].setName(Name);
        this.menu[id].setMoney(money);
        this.menu[id].setSendMoney(sendMoney);

    }
    private Menu[] set(){
        information1(0,"鱼香肉丝",10.0,0.0);
        information1(1,"马剖豆腐",20.0,1.0);
        information1(2,"西湖醋鱼",34.5,2.0);
        information1(3,"哇相机",11.1,4.0);
        information1(4,"唐僧肉",10.1,0);
        return menu;
    }

    public void operate() {
        this.menu=set();
        do {

            System.out.println("*****************************");
            System.out.println("欢迎使用外卖系统");
            System.out.println("1.我要点餐");
            System.out.println("2.查看餐袋");
            System.out.println("3.签收订单");
            System.out.println("4.删除订单");
            System.out.println("5.我要点赞");
            System.out.println("6.退出系统");
            System.out.println("*****************************");
            System.out.println("请选择:");
            Choose(scanner.nextInt());
        } while (!exit);
    }

    private void Choose(int choose) {


        switch (choose) {
            case 1:

                order();
                return;
            case 2:
                check();
                return;
            case 3:
                sign();
                return;
            case 4:
                delete();
                return;
            case 5:
                cheer();
                return;
            case 6:
                exit();
                return;
            default:
                System.out.println("请输入正确的数字");
                break;
        }

    }

    private void order() {//订餐
        User user=new User();
        this.UserId++;
        System.out.println("我要订餐");
        System.out.println("请输入用户名");
        user.setUserName(scanner.next());
        System.out.println("序号\t菜名\t单价\t点赞数\t");
        for (int i=0;i<=4;i++){
            System.out.println((i+1)+"\t"+menu[i].getName()+"\t"+menu[i].getMoney()+"\t"+menu[i].getLove()+"\t");
        }
        System.out.println("请输入你选择的序号");
        int id=scanner.nextInt()-1;
        this.users.add(user);
        users.get(UserId).setMeal(menu[id].getName());
        System.out.println("请输入购买的数量");
        int number=scanner.nextInt();
        users.get(this.UserId).setNumber(number);
        users.get(UserId).setPayMoney((menu[id].getMoney()+menu[id].getSendMoney())*users.get(this.UserId).getNumber());
        int time = 0;
        while (time>22||time<7){
            System.out.println("请输入送餐的时间,时间是7-22点之间的整点");
            time=scanner.nextInt();
            if (time>22||time<7){
                System.out.println("请输入正确的时间");
            }
        }
        users.get(this.UserId).setTime(time);
        System.out.println("请输入送餐的地址");
        users.get(this.UserId).setAddress(scanner.next());
        System.out.println("订餐成功");
        System.out.println("您的订餐是"+users.get(UserId).getMeal()+users.get(UserId).getNumber()+"份");
        System.out.println("餐费是"+menu[id].getMoney()+"元"+" 配送费是"+menu[id].getSendMoney()+"元"+"总价是"+users.get(UserId).getPayMoney()+"元");
        System.out.println("按任意键返回");
        scanner.next();
    }

    private void check() {//查看餐袋
        System.out.println("查看餐袋");
        System.out.println("序号\t订餐人\t餐品信息\t送餐时间\t");
        for (int i=0;i<users.toArray().length;i++){
            System.out.println((i+1)+"\t"+users.get(i).getUserName()+"\t"+users.get(i).getMeal()+users.get(i).getNumber()+"份"+"\t"+users.get(i).getTime()+"点"+"\t");
        }
        System.out.println(users.size());
        System.out.println("按任意键返回");
        scanner.next();
    }

    private void sign() {//签订餐单
        System.out.println("签订餐单");
        System.out.println("请选择需要签收的订单序号");
        int userId=scanner.nextInt();
        if (userId>0&&userId<=users.size()){
            if (!users.get(userId-1).isSign()){
                users.get(userId-1).setSign(true);
                System.out.println("签收成功");
                System.out.println("按任意键返回");
                scanner.next();
            }else {
                System.out.println("此订单已签收");
                System.out.println("按任意键返回");
                scanner.next();
            }
        }else {
            System.out.println("查无此订单");
            System.out.println("按任意键返回");
            scanner.next();
        }
    }

    private void delete() {//删除餐单
        System.out.println("删除订单");
        System.out.println("请输入删除的订单号");
        int orderId= scanner.nextInt();
        if (orderId>0&&orderId<=users.size()){
            if (users.get(orderId-1).isSign()){
                users.remove(orderId-1);
                System.out.println("删除成功");
                System.out.println("按任意键返回");
                scanner.next();
            }else {
                System.out.println("此订单未签收");
                System.out.println("按任意键返回");
                scanner.next();
            }
        }else {
            System.out.println("查无此订单");
            System.out.println("按任意键返回");
            scanner.next();
        }

    }
    private void cheer(){
        System.out.println("我要点赞");
        System.out.println("序号\t菜名\t单价\t点赞数\t");
        for (int i=0;i<=4;i++){
            System.out.println((i+1)+"\t"+menu[i].getName()+"\t"+menu[i].getMoney()+"\t"+menu[i].getLove()+"\t");
        }
        System.out.println("请输入您要点赞的菜品序号");
        int mealId= scanner.nextInt();
        if (mealId<=0||mealId>menu.length){
            System.out.println("无此餐品");
        }else {
            menu[mealId-1].setLove(menu[mealId-1].getLove()+1);
            System.out.println("点赞成功");
        }
        System.out.println("按任意键返回");
        scanner.next();
    }

    private void exit() {//退出
        System.out.println("退出系统");
        System.out.println("欢迎下次使用");
        exit=true;
    }

}
