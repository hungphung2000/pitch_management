package view;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.ClientDAO;
import model.Client;
import model.User;

public class SearchClientFrm extends JFrame implements ActionListener{
    private ArrayList<Client> clientArrayList;
    private JTextField txtKey;
    private JButton btnSearch;
    private JTable tblResult;
    private User user;
    private SearchClientFrm mainFrm;

    public SearchClientFrm(User user){
        super("Payment");
        this.user = user;
        mainFrm = this;
        clientArrayList = new ArrayList<Client>();

        JPanel pnMain = new JPanel();
        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));

        JLabel lblHome = new JLabel("Payment for customer");
        lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHome.setFont (lblHome.getFont ().deriveFont (20.0f));
        pnMain.add(lblHome);
        pnMain.add(Box.createRigidArea(new Dimension(0,20)));

        JPanel pn1 = new JPanel();
        pn1.setLayout(new BoxLayout(pn1,BoxLayout.X_AXIS));
        pn1.setSize(this.getSize().width-5, 20);
        pn1.add(new JLabel("Client name: "));
        txtKey = new JTextField();
        pn1.add(txtKey);
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        pn1.add(btnSearch);
        pnMain.add(pn1);
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));

        JPanel pn2 = new JPanel();
        pn2.setLayout(new BoxLayout(pn2,BoxLayout.Y_AXIS));
        tblResult = new JTable();
        JScrollPane scrollPane= new  JScrollPane(tblResult);
        tblResult.setFillsViewportHeight(false);
        scrollPane.setPreferredSize(new
               Dimension(scrollPane.getPreferredSize().width, 250));

        tblResult.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int column = tblResult.getColumnModel().
                        getColumnIndexAtX(e.getX()); // get the coloum of the button
                int row = e.getY()/tblResult.getRowHeight(); // get row

                if (row < tblResult.getRowCount() && row >= 0 && column < tblResult.getColumnCount() && column >= 0) {
                    (new TicketFrm(user, clientArrayList.get(row))).setVisible(true);
                    mainFrm.dispose();
                }
            }
        });

        pn2.add(scrollPane);
        pnMain.add(pn2);
        this.add(pnMain);
        this.setSize(600,300);
        this.setLocation(200,10);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton btnClicked = (JButton)e.getSource();

        if(btnClicked.equals(btnSearch)){
            if((txtKey.getText() == null)||(txtKey.getText().length() == 0)) return;

            ClientDAO rd = new ClientDAO();
            clientArrayList = rd.searchClient(txtKey.getText().trim());

            String[] columnNames = {"Id", "Name", "Address", "Tel","IDCard"};
            String[][] value = new String[clientArrayList.size()][5];
            for(int i = 0; i< clientArrayList.size(); i++){
                value[i][0] = clientArrayList.get(i).getId() +"";
                value[i][1] = clientArrayList.get(i).getName();
                value[i][2] = clientArrayList.get(i).getAddress();
                value[i][3] = clientArrayList.get(i).getTel() +"";
                value[i][4] = clientArrayList.get(i).getIdCard();
            }
            DefaultTableModel tableModel = new DefaultTableModel(value, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                   //unable to edit cells
                   return false;
                }
            };
            tblResult.setModel(tableModel);
        }
    }
}