package chap3.deliveryManagement.main;

import chap3.deliveryManagement.bean.Express;
import chap3.deliveryManagement.dao.ExpressDao;
import chap3.deliveryManagement.view.Views;

/**
 * @Author: 0707-���ҫ Dave_GY_Li
 * @Description:���ȶ���õĹ�����ExpressDao��Views��ɳ�������
 * @Date Created in 2020-07-19 21:35
 * @Modified By:
 */
public class Main {
    //��ʼ����ͼ����,Ϊ�˿��Կ緽��ʹ�ã�Ҫ�����static��
    private static Views v = new Views();
    //��ʼ��dao����
    private static ExpressDao dao = new ExpressDao();

    public static void main(String[] args) {


        //1.չʾ��ӭ
        v.welcome();
        //2.�������ѡ��˵�
        m:while(true){//ѭ����ʾ�˵���Ϣ
            int menu = v.menu();
            switch (menu){
                case 0:
                    break m;
                case 1://case��Ҫд�ܶ���룬����Ҫ����һ��switchʱ�����ʺϽ����ȡ����������Ϊһ������
                    //������Ա�ͻ���
                    dClient();//����д��һ������
                    break;
                case 2:
                    //�����û��ͻ���
                    uClient();
                    break;
            }
        }
        //�˳����ټ�
        v.bye();
    }

    private static void dClient() {
        while(true) {
            //���Ա�Ĳ˵�
            int menu = v.deliveryPersonMenu();
            switch (menu) {
                case 0:
                    return;//�������˵�
                case 1:{
                    //1.��ʾ���¼����Ϣ
                    Express e = v.insert();
                    //2.�жϴ˿���Ƿ��Ѿ��洢��
                    Express e2 = dao.findByNumber(e.getNumber());
                    //3.û�����洢���
                    if(e2 == null){
                        dao.add(e);
                        v.printExpress(e);//��ӡһ�´˿����ȡ����
                    }else{
                        //�����Ѿ��ڿ�ݹ���Ҫ����ͼ�෽��������ʾ
                        v.expressExist();
                    }

                    break;
                }
                //����޸�
                case 2:{
                    //1.��ʾ��������Ϣ
                    String number = v.findByNumber();
                    //2.��������
                    Express e = dao.findByNumber(number);//�鵽�Ķ���
                    Express e2 = e; //e2���¶���e�Ǿɶ���
                    //3.��ӡ�����Ϣ
                    if (e == null){
                        v.printNull();//��ӡΪ����Ϣ
                    }else{
                        v.printExpress(e);//��ӡ�����Ϣ
                        //4.��ʾ�޸�
                        v.update(e2);
                        dao.update(e,e2);//e����Ϊe2
                        v.printExpress(e2);//��ӡһ�´˿���µ���Ϣ
                    }

                }
                    break;

                case 3:{//���ɾ��
                    //1.�����ݵ���
                    String number = v.findByNumber();
                    //2. ���ҿ�ݶ���
                    Express e = dao.findByNumber(number);
                    if(e == null){
                        v.printNull();
                    }else{
                        v.printExpress(e);
                        int type = v.delete();//�Ƿ�ȷ��ɾ��
                        if(type == 1){
                            //1�����û�ȷ��Ҫɾ��
                            dao.delete(e);
                            v.success();//������ͼ����ʾ�����ɹ��ĺ���
                        }
                    }

                }
                    break;
                case 4:{//�鿴���п��
                    Express [][] data = dao.findAll();//���մ����Ŀ����Ϣ�Ķ�ά����
                    v.printAll(data);//��ӡ���п����Ϣ
                }
                    break;
            }
        }
    }

    private static void uClient() {
        //1.ȡ�����ȡ
        int code = v.userMenu();//�û��˵����õ�int���͵�ȡ����
        //2.����ȡ����ȥ�����
        Express e = dao.findByCode(code);
        if(e == null){
            v.printNull();
        }else{
            v.success();//�����ɹ���ʾ
            v.printExpress(e);//��ӡ�����Ϣ
            dao.delete(e);//�ɹ�ȥ����ݺ�Ѵ˿�ݴӹ���ɾ��
        }
    }
}
