import oop.ex22.Ticket;

class Main22 {
  public static void main(String[] args) {
    System.out.println("Max Reservation number is " + Ticket.MAX_NUM);
    Ticket t1 = new Ticket(3);
    Ticket t2 = new Ticket(5);
    //Ticket.MAX_NUM = 100;
    for(int i = -1; i <= Ticket.MAX_NUM; ++i) {
      Ticket t = new Ticket(i);
      if(t.isValid()) {
        System.out.println("Succeed to reserve number : " + i);
      }
      else {
        System.out.println("Failed to reserve number : " + i);
      }
      t.release();
    }
  }
}