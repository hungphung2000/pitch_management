package view;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.User;
public class ManagerHomeFrm extends JFrame implements ActionListener{
    private JButton btnPay;
    private User user;

    public ManagerHomeFrm(User user) {
        super("Manager home");
        this.user = user;

        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));

        JPanel lblPane = new JPanel();
        lblPane.setLayout(new BoxLayout(lblPane, BoxLayout.LINE_AXIS));
        lblPane.add(Box.createRigidArea(new Dimension(450, 0)));
        JLabel lblUser = new JLabel("Loged in as: " + user.getName());
        lblUser.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblPane.add(lblUser);
        listPane.add(lblPane);
        listPane.add(Box.createRigidArea(new Dimension(0,20)));

        JLabel lblHome = new JLabel("Manager's home");
        lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHome.setFont (lblHome.getFont ().deriveFont (28.0f));
        listPane.add(lblHome);
        listPane.add(Box.createRigidArea(new Dimension(0,20)));

        btnPay = new JButton("CustomerPay");
        btnPay.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPay.addActionListener(this);
        listPane.add(btnPay);

        this.setSize(600,300);
        this.setLocation(200,10);
        this.add(listPane, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if((e.getSource() instanceof JButton)&&
                (((JButton)e.getSource()).equals(btnPay))) {
            (new SearchClientFrm(user)).setVisible(true);
            this.dispose();
        }else {
            JOptionPane.showMessageDialog(this,
                    "This function is under construction!");
        }
    }
}
