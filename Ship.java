public class Ship {

  private String name;
  private int shield;

  public Ship(String shipName) {
    name = shipName;
    int shieldpercent = 100;
  }

  public int getShield() {
    return shield;
  }

  public void updateShield(int amount) {
    shield += amount;
    if (shield < 1) {
      System.out.println("Ship destroyed :(");
    }
  }

  public String toString() {
    String details = "Name: " + name + "\nShield: " + shield;
    return details;
  }

  public static void main(String[] args) {
    Ship starShip = new Ship("Nautilus");
    System.out.println(starShip.toString());
    starShip.updateShield(-50);
    starShip.updateShield(-50);
  }
}
