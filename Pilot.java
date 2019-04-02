public class Pilot extends CrewMember {

  public Pilot(String name, int experience, int vitality, int food) {
    super("Pilot", name, experience, vitality, food);
  }

  public void dodge() {
    if (vessel.getHull() < 1) {
      vessel.updateHull(20);
    }
    else {
      vessel.updateShield(30);
    }
  }
}
