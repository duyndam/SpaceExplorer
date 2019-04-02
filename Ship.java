public class Ship {

  private String name;
  private int shield;
  private int hull;

  public Crew crew;


  public Ship(String shipName, int shieldPercent, Crew team) {
    crew = team;
    name = shipName;
    shield = shieldPercent;
  }

  public void setName(String newName) {
    name = newName;
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
    String details = "Name: " + name + "\nShield: " + shield + "\nHull: " + hull;
    details += "\nIt is crewed by: " + crew.toString();
    return details;
  }

  public static void main(String[] args) {
    Crew theTeam = new Crew();

    CrewMember yuri = new CrewMember();
    CrewMember val = new CrewMember("Engineer", "Valentina", 100, 0);
    CrewMember bob = new CrewMember("Scientist", "Bob", 100, 0);

    theTeam.addCrew(yuri);
    theTeam.addCrew(val);
    theTeam.addCrew(bob);

    Ship starShip = new Ship("Nautilus", 100, theTeam);
    System.out.println(starShip.toString());
    starShip.updateShield(-50);
    starShip.updateShield(-50);
  }
}
