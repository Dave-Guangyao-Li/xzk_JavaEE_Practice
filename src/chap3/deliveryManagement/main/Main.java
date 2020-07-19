package chap3.deliveryManagement.main;

import chap3.deliveryManagement.bean.Express;
import chap3.deliveryManagement.dao.ExpressDao;
import chap3.deliveryManagement.view.Views;

/**
 * @Author: 0707-李光耀 Dave_GY_Li
 * @Description:调度定义好的工具类ExpressDao和Views完成程序流程
 * @Date Created in 2020-07-19 21:35
 * @Modified By:
 */
public class Main {
    //初始化视图对象,为了可以跨方法使用，要定义成static的
    private static Views v = new Views();
    //初始化dao对象
    private static ExpressDao dao = new ExpressDao();

    public static void main(String[] args) {


        //1.展示欢迎
        v.welcome();
        //2.弹出身份选择菜单
        m:while(true){//循环显示菜单信息
            int menu = v.menu();
            switch (menu){
                case 0:
                    break m;
                case 1://case里要写很多代码，比如要再套一个switch时，更适合将其抽取出来单独成为一个方法
                    //进入快递员客户端
                    dClient();//单独写成一个方法
                    break;
                case 2:
                    //进入用户客户端
                    uClient();
                    break;
            }
        }
        //退出，再见
        v.bye();
    }

    private static void dClient() {
        while(true) {
            //快递员的菜单
            int menu = v.deliveryPersonMenu();
            switch (menu) {
                case 0:
                    return;//返回主菜单
                case 1:{
                    //1.提示快递录入信息
                    Express e = v.insert();
                    //2.判断此快递是否已经存储过
                    Express e2 = dao.findByNumber(e.getNumber());
                    //3.没存过则存储快递
                    if(e2 == null){
                        dao.add(e);
                        v.printExpress(e);//打印一下此快件的取件码
                    }else{
                        //单号已经在快递柜，需要用视图类方法进行提示
                        v.expressExist();
                    }

                    break;
                }
                //快递修改
                case 2:{
                    //1.提示输入快递信息
                    String number = v.findByNumber();
                    //2.查找数据
                    Express e = dao.findByNumber(number);//查到的对象
                    Express e2 = e; //e2是新对象，e是旧对象
                    //3.打印快递信息
                    if (e == null){
                        v.printNull();//打印为空信息
                    }else{
                        v.printExpress(e);//打印快递信息
                        //4.提示修改
                        v.update(e2);
                        dao.update(e,e2);//e更新为e2
                        v.printExpress(e2);//打印一下此快件新的信息
                    }

                }
                    break;

                case 3:{//快递删除
                    //1.输入快递单号
                    String number = v.findByNumber();
                    //2. 查找快递对象
                    Express e = dao.findByNumber(number);
                    if(e == null){
                        v.printNull();
                    }else{
                        v.printExpress(e);
                        int type = v.delete();//是否确认删除
                        if(type == 1){
                            //1代表用户确认要删除
                            dao.delete(e);
                            v.success();//调用视图中显示操作成功的函数
                        }
                    }

                }
                    break;
                case 4:{//查看所有快递
                    Express [][] data = dao.findAll();//接收传来的快递信息的二维数组
                    v.printAll(data);//打印所有快递信息
                }
                    break;
            }
        }
    }

    private static void uClient() {
        //1.取件码获取
        int code = v.userMenu();//用户菜单，得到int类型的取件码
        //2.根据取件码去除快递
        Express e = dao.findByCode(code);
        if(e == null){
            v.printNull();
        }else{
            v.success();//操作成功提示
            v.printExpress(e);//打印快递信息
            dao.delete(e);//成功去除快递后把此快递从柜中删除
        }
    }
}
