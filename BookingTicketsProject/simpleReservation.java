package BookingTicketsProject;

import javax.swing.*;
import java.awt.*;

class simpleReservation
{

    //数据域定义
    private JLabel origin = new JLabel("出发地点");
    private JLabel destination =new JLabel("到达地点");
    private JLabel singleTime = new JLabel("出发日期");
    private JLabel returnTime = new JLabel("返回日期");
    private JTextField originField = new JTextField("请输入起始地点",25);
    private JTextField destinationField =new JTextField("请输入目的地",25);
    private JTextField singleTimeField =new JTextField(25);
    private JRadioButton singleTicket =new JRadioButton("单程",true);
    private JRadioButton returnTicket =new JRadioButton("往返");
    private JButton QueryButton =new JButton("查 询");
    private JButton exchangeButton = new JButton("换");

    simpleReservation(){}

    void sr()
    {

        //设置面板
        JFrame frame = new JFrame("机票预订");
        JPanel jPanelTicketType = new JPanel();
        JPanel jPanelOrigin = new JPanel();
        JPanel jPanelDestination =new JPanel();
        JPanel jPanelSingleTime = new JPanel();
        JPanel jPanelQueryButton =new JPanel();
        JPanel jPanelExchangeButton = new JPanel();
        ButtonGroup btgTicketTyepe =new ButtonGroup();
        JPanel jPanel =new JPanel();

        //设置字体
        origin.setFont(new Font("宋体",Font.BOLD,20));
        destination.setFont(new Font("宋体",Font.BOLD,20));
        singleTime.setFont(new Font("宋体",Font.BOLD,20));
        returnTime.setFont(new Font("宋体",Font.BOLD,20));
        singleTicket.setFont(new Font("宋体",Font.BOLD,20));
        returnTicket.setFont(new Font("宋体",Font.BOLD,20));
        QueryButton.setFont(new Font("宋体",Font.BOLD,20));
        exchangeButton.setFont(new Font("宋体",Font.BOLD,20));


        // 添加组件
        btgTicketTyepe.add(singleTicket);
        btgTicketTyepe.add(returnTicket);
        jPanelTicketType.add(singleTicket);
        jPanelTicketType.add(returnTicket);
        jPanelOrigin.add(origin);
        jPanelOrigin.add(originField);
        jPanelDestination.add(destination);
        jPanelDestination.add(destinationField);
        jPanelSingleTime.add(singleTime);
        jPanelSingleTime.add(singleTimeField);
        jPanel.setLayout(new GridLayout(3,1,10,10));
        jPanel.add(jPanelOrigin);
        jPanel.add(jPanelDestination);
        jPanel.add(jPanelSingleTime);
        jPanelQueryButton.add(QueryButton);
        jPanelExchangeButton.add(exchangeButton);


        //frame基本设置
        frame.setLayout(new BorderLayout(10,10));
        frame.add(jPanelTicketType,BorderLayout.NORTH);
        frame.add(jPanel,BorderLayout.CENTER);
        frame.add(jPanelQueryButton,BorderLayout.SOUTH);
        frame.add(jPanelExchangeButton,BorderLayout.EAST);

        frame.pack();
        Toolkit kit =Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        frame.setLocation((screenSize.width-frame.getWidth())/2,(screenSize.height-frame.getHeight())/2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);


    }
    public static void main(String[] args)
    {
        simpleReservation s = new simpleReservation();
        s.sr();
    }
}


