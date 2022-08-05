package dao;

import model.BookedMiniPitch;
import model.Client;
import model.ItemOrder;
import model.Ticket;

import javax.xml.transform.Result;
import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class TicketDAO extends DAO {

    public TicketDAO() {
        super();
    }

    public ArrayList<Ticket> getTicketOfClient(int id) {
        ArrayList<Ticket> ticketArrayList = new ArrayList<>();

        String querySql = "SELECT * FROM ticket WHERE client_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(querySql)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Ticket ticket = new Ticket();

                ticket.setId(resultSet.getInt("id"));
                ticket.setBookingDay(resultSet.getDate("booking_day").toLocalDate());
                ticket.setTotalAmount(resultSet.getFloat("total_amount"));
                ticket.setNote(resultSet.getString("note"));
                ticketArrayList.add(ticket);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ticketArrayList;
    }

    public ArrayList<Ticket> getTicketOfClient2(int id) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        String sqlQuery = "select * from (select b.ticket_id, b.booking_day, b.total_amount, b.client_id, b.name, b.address, b.tel, b.id_card, b.bookedminipitch_id, b.checkin, b.checout, b.price, i.item_id, i.quantity, i.price as price_item, i.total_amount as total_amount_item from (select t.ticket_id, t.booking_day, t.total_amount, t.client_id, t.name, t.address, t.tel, t.id_card, b.id as bookedminipitch_id, b.checkin, b.checout, b.price from (select t.id as ticket_id, t.booking_day, t.total_amount, t.note, t.client_id, c.name, c.address, c.tel, c.id_card from client as c inner join ticket as t on c.id = t.client_id) as t inner join booked_mini_pitch as b on t.ticket_id = b.ticket_id) as b inner join item_order as i on b.bookedminipitch_id = i.bookedminipitch_id) as kq where kq.client_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ItemOrder itemOrder = new ItemOrder();
                BookedMiniPitch bookedMiniPitch = new BookedMiniPitch();
                Ticket ticket = new Ticket();
                Client client = new Client();
                ArrayList<BookedMiniPitch> bookedMiniPitches = new ArrayList<>();
                ArrayList<ItemOrder> itemOrders = new ArrayList<>();

                client.setId(resultSet.getInt("client_id"));
                client.setName(resultSet.getString("name"));
                client.setAddress(resultSet.getString("address"));
                client.setTel(resultSet.getString("tel"));
                client.setIdCard(resultSet.getString("id_card"));

                itemOrder.setQuantity(resultSet.getInt("quantity"));
                itemOrder.setPrice(resultSet.getFloat("price_item"));
                itemOrder.setTotalAmount(resultSet.getFloat("total_amount_item"));
                itemOrders.add(itemOrder);

                bookedMiniPitch.setId(resultSet.getInt("bookedminipitch_id"));
                bookedMiniPitch.setCheckin(resultSet.getDate("checkin").toLocalDate());
                bookedMiniPitch.setCheckout(resultSet.getDate("checout").toLocalDate());
                bookedMiniPitch.setItemOrderList(itemOrders);
                bookedMiniPitches.add(bookedMiniPitch);

                ticket.setId(resultSet.getInt("ticket_id"));
                ticket.setBookingDay(resultSet.getDate("booking_day").toLocalDate());
                ticket.setTotalAmount(resultSet.getFloat("total_amount"));
                ticket.setBookedMiniPitchList(bookedMiniPitches);

                tickets.add(ticket);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tickets;
    }

    public Ticket findByIdAndClientId(int ticketId, int id){
        Client client = new Client();
        Ticket ticket = new Ticket();

        Set<BookedMiniPitch> bookedMiniPitches = new HashSet<>();
        ArrayList<ItemOrder> itemOrders = new ArrayList<>();
        String sqlQuery = "select * from (select b.ticket_id, b.booking_day, b.total_amount, b.client_id, b.name, b.address, b.tel, b.id_card, b.bookedminipitch_id, b.checkin, b.checout, b.price, i.item_id, i.quantity, i.price as price_item, i.total_amount as total_amount_item from (select t.ticket_id, t.booking_day, t.total_amount, t.client_id, t.name, t.address, t.tel, t.id_card, b.id as bookedminipitch_id, b.checkin, b.checout, b.price from (select t.id as ticket_id, t.booking_day, t.total_amount, t.note, t.client_id, c.name, c.address, c.tel, c.id_card from client as c inner join ticket as t on c.id = t.client_id where t.id = ?) as t inner join booked_mini_pitch as b on t.ticket_id = b.ticket_id) as b inner join item_order as i on b.bookedminipitch_id = i.bookedminipitch_id) as kq where kq.client_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, ticketId);
            preparedStatement.setInt(2, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                client.setId(resultSet.getInt("client_id"));
                client.setName(resultSet.getString("name"));
                client.setAddress(resultSet.getString("address"));
                client.setTel(resultSet.getString("tel"));
                client.setIdCard(resultSet.getString("id_card"));

                ticket.setId(resultSet.getInt("ticket_id"));
                ticket.setBookingDay(resultSet.getDate("booking_day").toLocalDate());
                ticket.setTotalAmount(resultSet.getFloat("total_amount"));
                ticket.setClient(client);
            }

            while (resultSet.next()) {
                ItemOrder itemOrder = new ItemOrder();
                BookedMiniPitch bookedMiniPitch = new BookedMiniPitch();

                itemOrder.setQuantity(resultSet.getInt("quantity"));
                itemOrder.setPrice(resultSet.getFloat("price_item"));
                itemOrder.setTotalAmount(resultSet.getFloat("total_amount_item"));
                itemOrder.setBookedMiniPitchId(resultSet.getInt("bookedminipitch_id"));
                itemOrders.add(itemOrder);

                bookedMiniPitch.setId(resultSet.getInt("bookedminipitch_id"));
                bookedMiniPitch.setCheckin(resultSet.getDate("checkin").toLocalDate());
                bookedMiniPitch.setCheckout(resultSet.getDate("checout").toLocalDate());
                bookedMiniPitch.setPrice(resultSet.getFloat("price"));
                bookedMiniPitch.setItemOrderList(itemOrders);
                bookedMiniPitches.add(bookedMiniPitch);

            }
            System.out.println("size: " + bookedMiniPitches.size());

//            Iterator<BookedMiniPitch> itera+tor = bookedMiniPitches.iterator();
//            while (iterator.hasNext()) {
//                ArrayList<ItemOrder> itemOrdersById = (ArrayList<ItemOrder>) itemOrders.stream()
//                        .filter(itemOrder -> Integer.valueOf(itemOrder.getBookedMiniPitchId()) == iterator.next().getId())
//                        .collect(Collectors.toList());
//                // lỗi do iterator chỉ đang có 1 phần tử next này lần 2 con trỏ đã trở tới cái khác
//                iterator.next().setItemOrderList(itemOrdersById);
//            }
            // sủa lỗi
            ArrayList<BookedMiniPitch> bookedMiniPitches1 = (ArrayList<BookedMiniPitch>) bookedMiniPitches.stream().collect(Collectors.toList());
            for (int i = 0; i < bookedMiniPitches1.size(); i++) {
                int key = i;
                ArrayList<ItemOrder> itemOrdersById = (ArrayList<ItemOrder>) itemOrders.stream()
                        .filter(itemOrder -> Integer.valueOf(itemOrder.getBookedMiniPitchId()) == bookedMiniPitches1.get(key).getId())
                        .collect(Collectors.toList());
            }

            ticket.setBookedMiniPitchList(bookedMiniPitches1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ticket;
    }

}
