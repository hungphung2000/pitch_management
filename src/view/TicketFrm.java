package view;

import dao.TicketDAO;
import model.Client;
import model.Ticket;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TicketFrm extends JFrame {
    private ArrayList<Ticket> ticketArrayList;
    private JTable tblResult;
    private User user;
    private Client client;
    private TicketFrm mainFrm;

    public TicketFrm(User user, Client client) {
        super();
        this.user = user;
        this.client = client;
        mainFrm = this;

        ticketArrayList = new ArrayList<>();

        JPanel pnMain = new JPanel();
        pnMain.setSize(this.getSize().width - 5, this.getSize().height - 20);
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel lblHome = new JLabel("Ticket");
        lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHome.setFont(lblHome.getFont().deriveFont(20.0f));
        pnMain.add(lblHome);
        pnMain.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel pn2 = new JPanel();
        pn2.setLayout(new BoxLayout(pn2, BoxLayout.Y_AXIS));
        tblResult = new JTable();
        showData();
        JScrollPane scrollPane = new JScrollPane(tblResult);
        tblResult.setFillsViewportHeight(false);
        scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width, 250));

        tblResult.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int column = tblResult.getColumnModel().
                        getColumnIndexAtX(e.getX()); // get the coloum of the button
                int row = e.getY() / tblResult.getRowHeight(); // get row

                if (row < tblResult.getRowCount() && row >= 0 && column < tblResult.getColumnCount() && column >= 0) {
                    (new CustomerBillFrm(user, ticketArrayList.get(row))).setVisible(true);
                    mainFrm.dispose();
                }
            }
        });

        pn2.add(scrollPane);
        pnMain.add(pn2);
        this.add(pnMain);
        this.setSize(600, 300);
        this.setLocation(200, 10);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void showData() {
        TicketDAO ticketDAO = new TicketDAO();
        ticketArrayList = ticketDAO.getTicketOfClient2(client.getId());

        String[] columnNames = {"Id", "BookingDay", "TotalAmount", "Note", "Client"};
        String[][] value = new String[ticketArrayList.size()][5];
        for (int i = 0; i < ticketArrayList.size(); i++) {
            value[i][0] = ticketArrayList.get(i).getId() + "";
            value[i][1] = String.valueOf(ticketArrayList.get(i).getBookingDay());
            value[i][2] = String.valueOf(ticketArrayList.get(i).getTotalAmount());
            value[i][3] = ticketArrayList.get(i).getNote();
            value[i][4] = client.getName();
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