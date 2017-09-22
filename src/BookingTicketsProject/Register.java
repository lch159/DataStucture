package BookingTicketsProject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

 class Register
{
    //数据域定义
    private JLabel userName = new JLabel("  用户名");
    private JLabel password = new JLabel("  密  码");
    private JLabel telphoneNum = new JLabel("  手机号");
    private JLabel realName = new JLabel("真实姓名");
    private JLabel IDCard =new JLabel("身份证号");
    private JTextField userNameField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JTextField telphoneNumField = new JTextField(20);
    private JTextField IDCardField = new JTextField(20);
    private JTextField realNameField = new JTextField(20);
    private JButton registerButton = new JButton("注  册");
    private String id=null;
    private String psw=null;
    private String tn =null;
    private String rn =null;
    private String idc = null;
    private static DBSupport dbSupport =new DBSupport();

    static
    {
        //用Properties属性文件来配置数据库
        try {
            dbSupport.initParam();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Register (){}

    private void registerSQL()
    {
        try
        {
            //获取数据库连接
            Connection conn = DriverManager.getConnection(dbSupport.url, dbSupport.USER, dbSupport.PASS);
            //创建Statement对象
            PreparedStatement stmt =conn.prepareStatement("INSERT user_INTO info(ID,PASS,TELPHONENUMBER,NAME,IDCARD) values(?,?,?,?,?) ");
            stmt.setString(1,id);
            stmt.setString(2,psw);
            stmt.setString(3,tn);
            stmt.setString(4,rn);
            stmt.setString(5,idc);
            stmt.executeUpdate();

        } catch (SQLException e1)
        {
            e1.printStackTrace();
        }

    }

    void register()throws Exception
    {
        //基本面板定义
        JFrame frame = new JFrame("注  册");
        JPanel jPanelUserName = new JPanel();
        JPanel jPanelPassword = new JPanel();
        JPanel jPanelTelphoneNumber = new JPanel();
        JPanel jPanelRegisterButton = new JPanel();
        JPanel jPanelBottom = new JPanel();
        JPanel jPanelIDCard = new JPanel();
        JPanel jPanelRealName = new JPanel();

        //设置字体
        userName.setFont(new Font("宋体",Font.BOLD,20));
        password.setFont(new Font("宋体",Font.BOLD,20));
        registerButton.setFont(new Font("宋体",Font.BOLD,20));
        telphoneNum.setFont(new Font("宋体",Font.BOLD,20));
        realName.setFont(new Font("宋体",Font.BOLD,20));
        IDCard.setFont(new Font("宋体",Font.BOLD,20));

        //面板加入组件
        jPanelUserName.add(userName);
        jPanelUserName.add(userNameField);
        jPanelPassword.add(password);
        jPanelPassword.add(passwordField);
        jPanelTelphoneNumber.add(telphoneNum);
        jPanelTelphoneNumber.add(telphoneNumField);
        jPanelRegisterButton.add(registerButton);
        jPanelIDCard.add(IDCard);
        jPanelIDCard.add(IDCardField);
        jPanelRealName.add(realName);
        jPanelRealName.add(realNameField);
        jPanelBottom.setLayout(new GridLayout(6,1));
        jPanelBottom.add(jPanelUserName);
        jPanelBottom.add(jPanelPassword);
        jPanelBottom.add(jPanelTelphoneNumber);
        jPanelBottom.add(jPanelRealName);
        jPanelBottom.add(jPanelIDCard);
        jPanelBottom.add(jPanelRegisterButton);

        addListener();

        //设置上方图片
        JLabel top = new JLabel(new ImageIcon("C:\\Users\\李晨昊\\IdeaProjects\\SUSTC\\src\\BookingTicket\\Image\\2.JPG"));
        top.setSize(450,200);

       //设置frame布局管理器
        frame.setLayout(new GridLayout(2,1));
        //加入面板
        frame.add(top);
        frame.add(jPanelBottom);
        //frame基本设置
        frame.setSize(450,600);
        Toolkit kit =Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        frame.setLocation((screenSize.width-frame.getWidth())/2,(screenSize.height-frame.getHeight())/2);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void addListener()
    {
        registerButton.addActionListener(e -> {
            if(judgingRegister())
                try {
                    registerSQL();
                    Login.userNameField.setText(id);
                    Login.passwordField.setText(psw);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
        });
    }

    private boolean judgingRegister()
    {
        boolean judge = false;
        if(userNameField.getText().isEmpty()&&String.valueOf(passwordField.getPassword()).isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(userNameField.getText().isEmpty()||userNameField.getText().length()<6||userNameField.getText().length()>20)
        {
            JOptionPane.showMessageDialog( null,"用户名长度要求大于6个字符小于20个字符","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(String.valueOf(passwordField.getPassword()).isEmpty()||String.valueOf(passwordField.getPassword()).length()<6||String.valueOf(passwordField.getPassword()).length()>16)
        {
            JOptionPane.showMessageDialog(null, "密码长度要求大于6个字符小于20个字符", "提示消息", JOptionPane.WARNING_MESSAGE);
        }else if(telphoneNumField.getText().isEmpty()||telphoneNumField.getText().length()!=11)
        {
            JOptionPane.showMessageDialog(null,"请输入正确的手机号码","提示消息",JOptionPane.WARNING_MESSAGE);
        }
        else if(realName.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入真实姓名","提示消息",JOptionPane.WARNING_MESSAGE);
        }
        else if(IDCardField.getText().isEmpty()||IDCardField.getText().length()!=18)
        {
            JOptionPane.showMessageDialog(null,"请输入正确的身份证号码","提示消息",JOptionPane.WARNING_MESSAGE);
        }
        else if (judgingUserName())
        {
            JOptionPane.showMessageDialog(null,"已存在的用户名","提示消息",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            id = userNameField.getText();
            psw =String.valueOf(passwordField.getPassword());
            tn = telphoneNumField.getText();
            rn = realNameField.getText();
            idc = IDCardField.getText();
            JOptionPane.showMessageDialog(null,"注册成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            clear();
            judge = true;
        }
        return judge;
    }

    private boolean judgingUserName()
    {
        boolean judge =false;
        try
        {
            //获取数据库连接
            Connection conn = DriverManager.getConnection(dbSupport.url, dbSupport.USER, dbSupport.PASS);
            //创建Statement对象
            Statement stmt = conn.createStatement();
            ResultSet rs =stmt.executeQuery("SELECT ID FROM user_info");
            while (rs.next())
            {
                if(rs.getString("ID").equals(userNameField.getText()))
                judge = true;
            }

        } catch (SQLException e1)
        {
            e1.printStackTrace();
        }

        return judge;

    }

    private void clear()
    {
        userNameField.setText("");
        passwordField.setText("");
        telphoneNumField.setText("");
        IDCardField.setText("");
        realNameField.setText("");
    }

}
