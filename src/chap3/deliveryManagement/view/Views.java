package chap3.deliveryManagement.view;

import chap3.deliveryManagement.bean.Express;

import java.util.Scanner;

/**
 * @Author: 0707-���ҫ Dave_GY_Li
 * @Description: ֻ������û�����չʾ�������û����������,��Ҫ�漰�����ȵ��߼�
 * @Date Created in 2020-07-19 18:52
 * @Modified By:
 */
public class Views {

    private Scanner input = new Scanner(System.in);


    /**
    * @Description:��ӭ��Ϣ
    * @Param:[]
    * @Return void
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 19:09
    */
    public void welcome() {
        System.out.println("��ӭʹ��LGY�Ŀ�ݹ���ϵͳ");;
    }


    /**
    * @Description:������Ϣ
    * @Param:[]
    * @Return void
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 19:09
    */
    public void bye() {
        System.out.println("�ټ�����ӭ�´�ʹ��");;
    }


    /**
    * @Description: ��ʾѡ����ݵĲ˵�
    * @Param:[]
    * @Return int
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 19:07
    */
    public int menu(){
        System.out.println("�������ʾ�����빦����ţ�");
        System.out.println("1.���Ա");
        System.out.println("2.��ͨ�û�");
        System.out.println("0.�˳�");
        //˼��ȫ�֣������.nextInt,nextLine���ţ����з�������nextLine������Ϊ���������ͻ�������Ը��õؽ��ո�����������
        String text = input.nextLine(); //������nextLineȡ�û����룬������Ϊ����ָ���һ����λ
        int num = -1;
        //������ܷ�����NumberFormatException
        try{
            num = Integer.parseInt(text);//���ð�װ�ཫ�û������ַ���תΪ����
        }catch (NumberFormatException e){

        }
        if(num<0 || num>2){
            return menu();//������һ������
        }
        return num;
    }


    /**
    * @Description: ѡ���ɫΪ���Ա��Ĳ˵�
    * @Param:[]
    * @Return int
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 19:12
    */
    public int deliveryPersonMenu(){
        System.out.println("�������ʾ��������Ա������ţ�");
        System.out.println("1.���¼��");
        System.out.println("2.����޸�");
        System.out.println("3.���ɾ��");
        System.out.println("4.�鿴���п��");
        System.out.println("0.�����ϼ�Ŀ¼");
        String text = input.nextLine();
        int num = -1;
        //������ܷ�����NumberFormatException
        try{
            num = Integer.parseInt(text);
        }catch (NumberFormatException e){

        }
        if(num<0 || num>4){
            System.out.println("������������������");
            return menu();
        }
        return num;
    }


    /**
     * @Description: ���Ա���¼��Ĳ���
     * @Param:[]
     * @Return �����˿�ݵ��źͿ�ݹ�˾��Express���� chap3.deliveryManagement.bean.Express
     * @Author 0707-���ҫ Dave_GY_Li
     * @Date Created in 2020/7/19 19:23
     */
    public Express insert(){
        System.out.println("�������ʾ��������Ϣ��");
        System.out.println("�������ݵ��ţ�");
        String number = input.nextLine();
        System.out.println("�������ݹ�˾��");
        String company = input.nextLine();
        //��������Ϣ��Ϊһ�����巵�أ�Ҫ��װ����,Express����bean����
        Express e = new Express();
        e.setCompany(company);//���ÿ�ݹ�˾
        e.setNumber(number);//���ÿ�ݵ���
        return e;
    }


    /**
    * @Description:���ݿ�ݵ��Ų�ѯ��Ӧ�Ŀ��
    * @Param:[]
    * @Return chap3.deliveryManagement.bean.Express
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 19:39
    */
    public String findByNumber(){
        System.out.println("�������ʾ����Ҫ�޸ĵĿ����Ϣ��");
        System.out.println("������Ҫ���ҵĿ�ݵ��ţ�");
        String number = input.nextLine();
        return number;
    }


    /**
    * @Description:
    * @Param:[e]
    * @Return void
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 19:39
    */
    public void update(Express e){
        System.out.println("�������ʾ�����µĿ����Ϣ��");
        System.out.println("�������µĿ�ݹ�˾��Ϣ��");
        String company = input.nextLine();
        System.out.println("�������µĿ�ݵ��ţ�");
        String number = input.nextLine();
        e.setCompany(company);//���ÿ�ݹ�˾
        e.setNumber(number);//���ÿ�ݵ���
    }

    
    /**
    * @Description: ��ӡ��ʾ��ݵ������Ϣ(�����Ϣ��Ϊ��ʱ)
    * @Param:[e]
    * @Return void
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 19:47
    */
    public void printExpress(Express e){
        System.out.println("��ݾ�����Ϣ���£�");
        System.out.println("��ݹ�˾��"+e.getCompany()+", ��ݵ��ţ�"+e.getNumber()+", ȡ���룺"+e.getCode());
    }


    /**
     * @Description: ��ӡ��ʾ��ݵ������Ϣ(�����ϢΪ��ʱ)
     * @Param:[e]
     * @Return void
     * @Author 0707-���ҫ Dave_GY_Li
     * @Date Created in 2020/7/19 19:47
     */
    public void printNull(){
        System.out.println("��ݲ����ڣ�������������");
    }


    /**
    * @Description: ѯ���Ƿ�ɾ�������Ϣ
    * @Param:[]
    * @Return int 1��ʾȷ��ɾ����2��ʾȡ������
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 20:24
    */
    public int delete(){
        System.out.println("�Ƿ�ȷ��ɾ����");
        System.out.println("1.ȷ��ɾ��");
        System.out.println("2.ȡ������");
        String text = input.nextLine();
        int num = -1;
        try{
            num = Integer.parseInt(text);
        }catch(NumberFormatException e){

        }
        if(num<1 || num>2){
            System.out.println("������������������");
            return menu();
        }
        return num;
    }


    /**
    * @Description: ������ʾ���п����Ϣ
    * @Param:[es] �����ݹ�Ķ�ά���飬���溬�п�ݾ�����Ϣ
    * @Return void
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 20:28
    */
    public void printAll(Express[][] es){
        int count = 0;
        for(int i=0; i<10; i++){
            for(int j =0; j<10; j++){
                if(es[i][j]!=null){//��ӡ������ڵĹ���λ���Լ������Ϣ
                    count++;
                    System.out.println("���λ�ڵ�"+(i+1)+"��"+(j+1)+"��");
                    printExpress(es[i][j]);
                }
            }
        }
        if(count == 0){//���������count��0˵���޿����Ϣ
            System.out.println("��ݹ������޿����Ϣ");
        }
    }


    /**
    * @Description:ѡ���ɫΪ�û���Ĳ˵�
    * @Param:[]
    * @Return int
    * @Author 0707-���ҫ Dave_GY_Li
    * @Date Created in 2020/7/19 19:12
    */
    public int userMenu(){
        System.out.println("�������ʾ������ȡ����");
        System.out.println("����������6λȡ���룺");
        String code = input.nextLine();//��סalt+enter���Կ�ݵصõ���ʾ����local variable
        int num = -1;
        //������ܷ�����NumberFormatException
        try{
            num = Integer.parseInt(code);
        }catch (NumberFormatException e){

        }
        //ȡ���������6λ�����
        if(num<100000 || num>999999){
            System.out.println("������������������");
            return userMenu();
        }
        return num;
    }


    public void expressExist(){
        System.out.println("�˿�ݵ����ڿ�ݹ����Ѿ����ڣ������ظ��洢��");
    }

//    public void printCode(Express e){
//        System.out.println("�����ȡ����Ϊ��"+e.getCode());
//    }

    public void success(){
        System.out.println("�����ɹ�");
    }

}
