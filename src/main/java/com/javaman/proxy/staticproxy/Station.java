package com.javaman.proxy.staticproxy;

/**
 * @author pengzhe 车站 realSubject
 * @date 2019-07-02 17:44
 */
public class Station implements TicketService {

    @Override
    public void sellTicket() {
        System.out.println("\n\t售票.....\n");
    }

    @Override
    public void inquire() {
        System.out.println("\n\t问询。。。。\n");
    }

    @Override
    public void withdraw() {
        System.out.println("\n\t退票......\n");
    }
}
