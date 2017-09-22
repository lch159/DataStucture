package BookingTicketsProject;

import java.io.FileInputStream;
import java.util.Properties;

 class DBSupport
{
    //数据域定义
     String driver=null;
     String url=null;
     String USER=null;
     String PASS=null;

    DBSupport(){}

     void initParam()throws Exception
    {
        //使用Properties类来加载属性文件
        System.out.println("正在初始化数据库...");
        Properties props = new Properties();
        props.load(new FileInputStream("C:\\Program Files\\MySQL\\MySQL Server 5.7\\MySql.ini"));
        this.driver = props.getProperty("driver");
        this.url =props.getProperty("url");
        this.USER =props.getProperty("USER");
        this.PASS = props.getProperty("PASS");
        System.out.println("数据库配置完成！");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类，加载驱动失败！");
            e.printStackTrace();
        }
    }

}
