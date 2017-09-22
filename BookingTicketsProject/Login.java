package BookingTicketsProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

public class Login
{
    //数据域定义
    private  JFrame frame = new JFrame("登录");
    private JLabel userName = new JLabel("用户名");
    private JLabel password = new JLabel("密  码");
    static JTextField userNameField = new JTextField("请输入用户名",20);
    static JPasswordField passwordField = new JPasswordField("请输入密码",20);
    private JCheckBox jCheckBoxRememberPassword =new JCheckBox("记住密码");
    private JCheckBox jCheckBoxAutomaticLogin =new JCheckBox("自动登录");
    private JCheckBox jCheckBoxAdministrator =new JCheckBox("管理员");
    private JButton LoginButton = new JButton("登  录");
    private JButton registerButton = new JButton("注  册");
    private static DBSupport dbSupport =new DBSupport();
    private static Register r = new Register();
    private static Administrator_login al = new Administrator_login();
    private static user_login ul = new user_login();
    private static Login l = new Login();

    static
    {
        //用Properties属性文件来配置数据库
        try {
            dbSupport.initParam();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Login(){}

    private void loginSQL()
    {
        try
        {

            //获取数据库连接
            Connection conn = DriverManager.getConnection(dbSupport.url, dbSupport.USER, dbSupport.PASS);
            //创建Statement对象
            Statement stmt = conn.createStatement();
            ResultSet rs  =stmt.executeQuery("SELECT ID,PASS FROM user_info");
            boolean judge = true;
            while(rs.next())
            {
                if (userNameField.getText().equals(rs.getString("ID")) && String.valueOf(passwordField.getPassword()).equals(rs.getString("PASS"))) {
                    JOptionPane.showMessageDialog(null, "登录成功!", "提示消息", JOptionPane.WARNING_MESSAGE);
                    judge = false;

                    //记住密码相关设置
                   PreparedStatement pstmt =conn.prepareStatement("UPDATE rememberInfo SET REMEMBERID=?,REMEMBERPASS=?,REMEMBER=?,AUTOLOGIN=? ");
                    pstmt.setString(1,userNameField.getText());
                    pstmt.setString(2,String.valueOf(passwordField.getPassword()));
                    if(jCheckBoxRememberPassword.isSelected())
                    {
                        pstmt.setInt(3,1);
                        pstmt.setInt(4,0);
                        pstmt.executeUpdate();
                    }else if(jCheckBoxAutomaticLogin.isSelected())
                    {
                        pstmt.setInt(3,0);
                        pstmt.setInt(4,1);
                        pstmt.executeUpdate();
                    }
                }
            }
            if(judge)
                JudgingLogin();
            else
                close();//进入新的界面
        } catch (SQLException e1)
        {
            e1.printStackTrace();
        }

    }

   private void checkBoxSQL()throws Exception
    {
        //连接数据库调用上次登录的账号密码

        Connection conn = DriverManager.getConnection(dbSupport.url, dbSupport.USER, dbSupport.PASS);
        Statement stmt = conn.createStatement();
        ResultSet rs  =stmt.executeQuery("SELECT REMEMBERID,REMEMBERPASS,REMEMBER,AUTOLOGIN FROM REMEMBERINFO ");
        rs.next();
        while(rs.next()) {
            if (rs.getInt("REMEMBER") == 1) {
                userNameField.setText(rs.getString("REMEMBERID"));
                passwordField.setText(rs.getString("REMEMBERPASS"));
            } else if (rs.getInt("AUTOLOGIN") == 1) {
                JOptionPane.showMessageDialog(null, "登录成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
                close();
            }
        }
    }

    private void login()
    {
        JPanel jPanelUserName = new JPanel();
        JPanel jPanelPassword = new JPanel();
        JPanel jPanelCheckBox = new JPanel();
        JPanel jPanelButton = new JPanel();
        JPanel jPanelBottom = new JPanel();

        //设置字体
        userName.setFont(new Font("宋体",Font.BOLD,20));
        password.setFont(new Font("宋体",Font.BOLD,20));
        jCheckBoxRememberPassword.setFont(new Font("宋体",Font.BOLD,20));
        jCheckBoxAutomaticLogin.setFont(new Font("宋体",Font.BOLD,20));
        jCheckBoxAdministrator.setFont(new Font("宋体",Font.BOLD,20));
        LoginButton.setFont(new Font("宋体",Font.BOLD,20));
        registerButton.setFont(new Font("宋体",Font.BOLD,20));

        //面板加入组件
        jPanelUserName.add(userName);
        jPanelUserName.add(userNameField);
        jPanelPassword.add(password);
        jPanelPassword.add(passwordField);
        jPanelCheckBox.add(jCheckBoxRememberPassword);
        jPanelCheckBox.add(jCheckBoxAutomaticLogin);
        jPanelCheckBox.add(jCheckBoxAdministrator);
        jPanelButton.add(LoginButton);
        jPanelButton.add(registerButton);
        jPanelBottom.setLayout(new GridLayout(4,1,10,10));
        jPanelBottom.add(jPanelUserName);
        jPanelBottom.add(jPanelPassword);
        jPanelBottom.add(jPanelCheckBox);
        jPanelBottom.add(jPanelButton);

        addListener();

        //设置上方图片
        JLabel top = new JLabel(new ImageIcon("C:\\Users\\李晨昊\\IdeaProjects\\SUSTC\\src\\BookingTicket\\Image\\1.jpg"));
        top.setSize(450,200);

        //设置frame布局管理器
        frame.setLayout(new GridLayout(2,1));
        //加入面板
        frame.add(top);
        frame.add(jPanelBottom);
        //frame基本设置
        frame.setSize(450,400);
        Toolkit kit =Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        frame.setLocation((screenSize.width-frame.getWidth())/2,(screenSize.height-frame.getHeight())/2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.requestFocus();

        //检查复选块
        try {
            checkBoxSQL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addListener()
    {
        userNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                userNameField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                userNameField.setText("请输入用户名");
            }
        });
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        LoginButton.addActionListener(e -> {
            try {
                loginSQL();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        registerButton.addActionListener(e -> {
            try {
                r.register();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() ==KeyEvent.VK_ENTER)
                    LoginButton.doClick();
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    private void JudgingLogin()
    {
         if(userNameField.getText().isEmpty()&&String.valueOf(passwordField.getPassword()).isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(userNameField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog( null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(String.valueOf(passwordField.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入密码！", "提示消息", JOptionPane.WARNING_MESSAGE);

        } else
        {
        JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
        clear();
        }
    }

    private void clear()
    {
        userNameField.setText("");
        passwordField.setText("");
    }

    private void close()
    {
        if(jCheckBoxAdministrator.isSelected())
             al.AL();//管理员界面
        else
            ul.BS();//用户界面
        frame.dispose();

    }

    public static void main(String[] args)throws Exception
    {
        l.login();
    }



}
