package chap3.deliveryManagement.dao;

import chap3.deliveryManagement.bean.Express;

import java.util.Random;

/**
 * @Author: 0707-李光耀 Dave_GY_Li
 * @Description:负责数据存取
 * @Date Created in 2020-07-19 20:39
 * @Modified By:
 */
public class ExpressDao {
    private Express[][] data = new Express[10][];
    //当前柜子中存储的快递数量
    private int size; //牺牲内存换取效率，不用每次存快递之前都遍历一遍数组
    {
        for (int i=0; i<10; i++){
            data[i] = new Express[10];//10*10的快递柜
        }
    }
    private Random random = new Random(); //生成随机取件码


    /**
    * @Description:存入快递
    * @Param:[e]
    * @Return boolean
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 20:47
    */
    public boolean add(Express e){
        if(size == 100){
            return false;//存快递失败
        }
        //1.随机生成2个0-9的下标
        int x=-1;
        int y=-1;
        while(true){
            x = random.nextInt(10);
            y = random.nextInt(10);
            if(data[x][y]==null){
                //说明此位置无快递
                break;
            }
        }
        //2.生成取件码
        int code = randomCode();
        e.setCode(code);
        data[x][y] = e;//快递存入
        return true;
    }

    /**
    * @Description: 生成随机取件码
    * @Param:[]
    * @Return int
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 20:56
    */
    private int randomCode(){
        //100000-999999
        while(true){
            int code = random.nextInt(900000)+100000;//取件码
            Express e = findByCode(code);//查询
            if(e == null){//取件码可以用
                return code;
            }
        }

    }
    
    /**
    * @Description: 快递员根据快递单号查询柜子中快递
    * @Param:[e]
    * @Return void
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 21:09
    */
    public Express findByNumber(String number){
        Express e = new Express();
        e.setNumber(number);//封装
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(e.equals(data[i][j])){//调用equals方法比较是否是同一对象
                    return data[i][j];//找到快递
                }
            }
        }
        return null;
    }


    /**
    * @Description: 查询柜中是否有这个code对应的快递
    * @Param: code 要查询的取件码
    * @Return 查询失败时返回null
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 21:00
    */
    public Express findByCode(int code){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if (data[i][j]!=null){//防止data[i][j]处为空，没快递，会出现错误
                    if(data[i][j].getCode() == code){
                        return data[i][j];//找到快递
                    }
                }

            }
        }
        return null;
    }
    
    
    /**
    * @Description: 数据的更新操作（其实是多余的，在view中就已经更新过了，是为了mvc模式的规范）
    * @Param:[oldExpress, newExpress]
    * @Return void
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 21:20
    */
    public void update(Express oldExpress, Express newExpress){
        //删除旧对象，传入新对象
        delete(oldExpress);
        add(newExpress);
    }
    
    
    /**
    * @Description: 删除旧的对象，暴力遍历，查到匹配的将其删除
    * @Param:[e]
    * @Return void
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 21:21
    */
    public void delete(Express e){
        p:for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(e.equals(data[i][j])){//调用equals方法比较是否是同一对象
                    data[i][j]=null;//找到了快递进行删除，置为null
                    break p;//跳出循环
                }
            }
        }

    }

    /**
    * @Description: 返回快递柜及柜中快递的所有信息
    * @Param:[]
    * @Return chap3.deliveryManagement.bean.Express[][]
    * @Author 0707-李光耀 Dave_GY_Li
    * @Date Created in 2020/7/19 21:30
    */
    public Express[][] findAll(){
        return data;
    }
}
