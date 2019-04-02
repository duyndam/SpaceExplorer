public class Engineer extends CrewMember {

  public Engineer(String name, int experience, int vitality, int food) {
    super("Engineer", name, experience, vitality, food);
    vessel.updateShield(20);
  }

  public void repair() {
    if (vessel.getHull() < 1) {
      vessel.updateHull(20);
    }
    else {
      vessel.updateShield(30);
    }
  }

}
