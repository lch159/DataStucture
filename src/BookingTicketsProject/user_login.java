package BookingTicketsProject;

import javax.swing.*;
import java.awt.*;

class user_login
{
    private JButton simpleReservationButton = new JButton("开始预订机票");
    private JButton userInterfaceButton =new JButton("查看个人信息");
    private simpleReservation s = new simpleReservation();
    private userInterface u = new userInterface();
    private JFrame frame =new JFrame("选择界面");

    user_login(){}

    void BS()
    {
        JPanel jPanel =new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER,450,35));


        //添加组件
        jPanel.add(simpleReservationButton);
        jPanel.add(userInterfaceButton );

        //设置上方图片
        JLabel top = new JLabel(new ImageIcon("C:\\Users\\李晨昊\\IdeaProjects\\SUSTC\\src\\BookingTicket\\Image\\2.JPG"));
        top.setSize(450,200);

        addListener();

        //frame基本设置
        frame.setLayout(new GridLayout(2,1));
        //加入面板
        frame.add(top);
        frame.add(jPanel);
        frame.setSize(450,400);
        Toolkit kit =Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        frame.setLocation((screenSize.width-frame.getWidth())/2,(screenSize.height-frame.getHeight())/2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);



    }
    private void addListener()
    {
        //添加监听器
        simpleReservationButton.addActionListener(e ->
                {
                    s.sr();
                    frame.setVisible(false);
                }

        );
        userInterfaceButton.addActionListener(e ->
                {
                    u.ui();
                    frame.setVisible(false);
                }
        );
    }

}
