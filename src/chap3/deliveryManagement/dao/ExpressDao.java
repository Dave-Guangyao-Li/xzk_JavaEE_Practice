package chap3.deliveryManagement.dao;

import chap3.deliveryManagement.bean.Express;

import java.util.Random;

/**
 * @Author: 0707-���ҫ Dave_GY_Li
 * @Description:�������ݴ�ȡ
 * @Date Created in 2020-07-19 20:39
 * @Modified By:
 */
public class ExpressDao {
    private Express[][] data = new Express[10][];
    //��ǰ�����д洢�Ŀ������
    private int size; //�����ڴ滻ȡЧ�ʣ�����ÿ�δ���֮ǰ������һ������
    {
        for (int i=0; i<10; i++){
            data[i] = new Express[10];//10*10�Ŀ�ݹ�
        }
    }
    private Random random = new Random(); //�������ȡ����


    /**
    * @Description:������
    * @Param:[e]
    * @Return boolean
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 20:47
    */
    public boolean add(Express e){
        if(size == 100){
            return false;//����ʧ��
        }
        //1.�������2��0-9���±�
        int x=-1;
        int y=-1;
        while(true){
            x = random.nextInt(10);
            y = random.nextInt(10);
            if(data[x][y]==null){
                //˵����λ���޿��
                break;
            }
        }
        //2.����ȡ����
        int code = randomCode();
        e.setCode(code);
        data[x][y] = e;//��ݴ���
        return true;
    }

    /**
    * @Description: �������ȡ����
    * @Param:[]
    * @Return int
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 20:56
    */
    private int randomCode(){
        //100000-999999
        while(true){
            int code = random.nextInt(900000)+100000;//ȡ����
            Express e = findByCode(code);//��ѯ
            if(e == null){//ȡ���������
                return code;
            }
        }

    }
    
    /**
    * @Description: ���Ա���ݿ�ݵ��Ų�ѯ�����п��
    * @Param:[e]
    * @Return void
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 21:09
    */
    public Express findByNumber(String number){
        Express e = new Express();
        e.setNumber(number);//��װ
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(e.equals(data[i][j])){//����equals�����Ƚ��Ƿ���ͬһ����
                    return data[i][j];//�ҵ����
                }
            }
        }
        return null;
    }


    /**
    * @Description: ��ѯ�����Ƿ������code��Ӧ�Ŀ��
    * @Param: code Ҫ��ѯ��ȡ����
    * @Return ��ѯʧ��ʱ����null
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 21:00
    */
    public Express findByCode(int code){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if (data[i][j]!=null){//��ֹdata[i][j]��Ϊ�գ�û��ݣ�����ִ���
                    if(data[i][j].getCode() == code){
                        return data[i][j];//�ҵ����
                    }
                }

            }
        }
        return null;
    }
    
    
    /**
    * @Description: ���ݵĸ��²�������ʵ�Ƕ���ģ���view�о��Ѿ����¹��ˣ���Ϊ��mvcģʽ�Ĺ淶��
    * @Param:[oldExpress, newExpress]
    * @Return void
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 21:20
    */
    public void update(Express oldExpress, Express newExpress){
        //ɾ���ɶ��󣬴����¶���
        delete(oldExpress);
        add(newExpress);
    }
    
    
    /**
    * @Description: ɾ���ɵĶ��󣬱����������鵽ƥ��Ľ���ɾ��
    * @Param:[e]
    * @Return void
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 21:21
    */
    public void delete(Express e){
        p:for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(e.equals(data[i][j])){//����equals�����Ƚ��Ƿ���ͬһ����
                    data[i][j]=null;//�ҵ��˿�ݽ���ɾ������Ϊnull
                    break p;//����ѭ��
                }
            }
        }

    }

    /**
    * @Description: ���ؿ�ݹ񼰹��п�ݵ�������Ϣ
    * @Param:[]
    * @Return chap3.deliveryManagement.bean.Express[][]
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 21:30
    */
    public Express[][] findAll(){
        return data;
    }
}
