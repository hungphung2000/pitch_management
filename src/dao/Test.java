package dao;

import model.Ticket;

public class Test {
    public static void main(String[] args) {
        Ticket ticket = (new TicketDAO()).findByIdAndClientId(2,3);
        System.out.println(ticket.toString());
        System.out.println("size la: " + ticket.getBookedMiniPitchList().size());

    }
}
