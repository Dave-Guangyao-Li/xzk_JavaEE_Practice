package chap3.deliveryManagement.view;

import chap3.deliveryManagement.bean.Express;

import java.util.Scanner;

/**
 * @Author: 0707-李光耀 Dave_GY_Li
 * @Description: 只负责给用户进行展示，接收用户输入的内容,不要涉及到调度的逻辑
 * @Date Created in 2020-07-19 18:52
 * @Modified By:
 */
public class Views {

    private Scanner input = new Scanner(System.in);


    /**
    * @Description:欢迎信息
    * @Param:[]
    * @Return void
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 19:09
    */
    public void welcome() {
        System.out.println("欢迎使用LGY的快递管理系统");;
    }


    /**
    * @Description:结束信息
    * @Param:[]
    * @Return void
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 19:09
    */
    public void bye() {
        System.out.println("再见，欢迎下次使用");;
    }


    /**
    * @Description: 显示选择身份的菜单
    * @Param:[]
    * @Return int
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 19:07
    */
    public int menu(){
        System.out.println("请根据提示，输入功能序号：");
        System.out.println("1.快递员");
        System.out.println("2.普通用户");
        System.out.println("0.退出");
        //思考全局，相比于.nextInt,nextLine更优，所有方法均用nextLine不会因为输入产生冲突，还可以更好地接收各种类型数据
        String text = input.nextLine(); //建议用nextLine取用户输入，以行作为输入指令的一个单位
        int num = -1;
        //处理可能发生的NumberFormatException
        try{
            num = Integer.parseInt(text);//利用包装类将用户输入字符串转为数字
        }catch (NumberFormatException e){

        }
        if(num<0 || num>2){
            return menu();//重新走一遍流程
        }
        return num;
    }


    /**
    * @Description: 选择角色为快递员后的菜单
    * @Param:[]
    * @Return int
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 19:12
    */
    public int deliveryPersonMenu(){
        System.out.println("请根据提示，输入快递员功能序号：");
        System.out.println("1.快递录入");
        System.out.println("2.快递修改");
        System.out.println("3.快递删除");
        System.out.println("4.查看所有快递");
        System.out.println("0.返回上级目录");
        String text = input.nextLine();
        int num = -1;
        //处理可能发生的NumberFormatException
        try{
            num = Integer.parseInt(text);
        }catch (NumberFormatException e){

        }
        if(num<0 || num>4){
            System.out.println("输入有误，请重新输入");
            return menu();
        }
        return num;
    }


    /**
     * @Description: 快递员快递录入的操作
     * @Param:[]
     * @Return 包含了快递单号和快递公司的Express对象 chap3.deliveryManagement.bean.Express
     * @Author 0707-李光耀 Dave_GY_Li
     * @Date Created in 2020/7/19 19:23
     */
    public Express insert(){
        System.out.println("请根据提示输入快递信息：");
        System.out.println("请输入快递单号：");
        String number = input.nextLine();
        System.out.println("请输入快递公司：");
        String company = input.nextLine();
        //把两个信息作为一个整体返回，要封装对象,Express类在bean包下
        Express e = new Express();
        e.setCompany(company);//设置快递公司
        e.setNumber(number);//设置快递单号
        return e;
    }


    /**
    * @Description:根据快递单号查询对应的快递
    * @Param:[]
    * @Return chap3.deliveryManagement.bean.Express
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 19:39
    */
    public String findByNumber(){
        System.out.println("请根据提示输入要修改的快递信息：");
        System.out.println("请输入要查找的快递单号：");
        String number = input.nextLine();
        return number;
    }


    /**
    * @Description:
    * @Param:[e]
    * @Return void
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 19:39
    */
    public void update(Express e){
        System.out.println("请根据提示输入新的快递信息：");
        System.out.println("请输入新的快递公司信息：");
        String company = input.nextLine();
        System.out.println("请输入新的快递单号：");
        String number = input.nextLine();
        e.setCompany(company);//设置快递公司
        e.setNumber(number);//设置快递单号
    }

    
    /**
    * @Description: 打印显示快递的相关信息(快递信息不为空时)
    * @Param:[e]
    * @Return void
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 19:47
    */
    public void printExpress(Express e){
        System.out.println("快递具体信息如下：");
        System.out.println("快递公司："+e.getCompany()+", 快递单号："+e.getNumber()+", 取件码："+e.getCode());
    }


    /**
     * @Description: 打印显示快递的相关信息(快递信息为空时)
     * @Param:[e]
     * @Return void
     * @Author 0707-李光耀 Dave_GY_Li
     * @Date Created in 2020/7/19 19:47
     */
    public void printNull(){
        System.out.println("快递不存在，请检查您的输入");
    }


    /**
    * @Description: 询问是否删除快递信息
    * @Param:[]
    * @Return int 1表示确认删除。2表示取消操作
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 20:24
    */
    public int delete(){
        System.out.println("是否确认删除？");
        System.out.println("1.确认删除");
        System.out.println("2.取消操作");
        String text = input.nextLine();
        int num = -1;
        try{
            num = Integer.parseInt(text);
        }catch(NumberFormatException e){

        }
        if(num<1 || num>2){
            System.out.println("输入有误，请重新输入");
            return menu();
        }
        return num;
    }


    /**
    * @Description: 遍历显示所有快递信息
    * @Param:[es] 代表快递柜的二维数组，里面含有快递具体信息
    * @Return void
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 20:28
    */
    public void printAll(Express[][] es){
        int count = 0;
        for(int i=0; i<10; i++){
            for(int j =0; j<10; j++){
                if(es[i][j]!=null){//打印快递所在的柜子位置以及快递信息
                    count++;
                    System.out.println("快递位于第"+(i+1)+"排"+(j+1)+"列");
                    printExpress(es[i][j]);
                }
            }
        }
        if(count == 0){//遍历完如果count是0说明无快递信息
            System.out.println("快递柜中暂无快递信息");
        }
    }


    /**
    * @Description:选择角色为用户后的菜单
    * @Param:[]
    * @Return int
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 19:12
    */
    public int userMenu(){
        System.out.println("请根据提示，进行取件：");
        System.out.println("请输入您的6位取件码：");
        String code = input.nextLine();//按住alt+enter可以快捷地得到提示创建local variable
        int num = -1;
        //处理可能发生的NumberFormatException
        try{
            num = Integer.parseInt(code);
        }catch (NumberFormatException e){

        }
        //取件码必须是6位随机数
        if(num<100000 || num>999999){
            System.out.println("输入有误，请重新输入");
            return userMenu();
        }
        return num;
    }


    public void expressExist(){
        System.out.println("此快递单号在快递柜中已经存在，请勿重复存储！");
    }

//    public void printCode(Express e){
//        System.out.println("快件的取件码为："+e.getCode());
//    }

    public void success(){
        System.out.println("操作成功");
    }

}
