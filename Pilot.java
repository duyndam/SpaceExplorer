public class Pilot extends CrewMember {

  public Pilot(String name, int vitality, int food) {
    super("Pilot", name, vitality, food);
  }

  public void dodge() {

  }

  public void repair() {
    vessel.updateShield(10);
  }
}
