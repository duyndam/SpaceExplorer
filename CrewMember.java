public class CrewMember {

  private String job;
  private String name;
  private int health;
  private int hunger;

  public CrewMember() {
    job = "Pilot";
    name = "Yuri";
    health = 100;
    hunger = 0;
  }

  public CrewMember(String role, String crewName, int vitality, int food) {
    job = role;
    name = crewName;
    health = vitality;
    hunger = food;
  }

  public void setName(String crewName) {
    name = crewName;
  }

  public String getName() {
    return name;
  }

  public void updateHealth(int amount) {
    health += amount;
  }

  public int getHealth() {
    return health;
  }

  public void updateHunger(int amount) {
    hunger += amount;
  }

  public int getHunger() {
    return hunger;
  }

  public String toString() {
    String bio = "I am " + name;
    return bio;
  }

  public static void main(String[] args) {
    CrewMember boi = new CrewMember();
    CrewMember gyal = new CrewMember("Engineer", "Valentina", 100, 0);

    System.out.println(boi.toString());
    System.out.println(gyal.toString());
    
  }
}
