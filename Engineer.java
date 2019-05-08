public class Engineer extends CrewMember {

  public Engineer(String name, int vitality, int food) {
    super("Engineer", name, vitality, food);
  }

  public void repair() {
    vessel.updateShield(25);
  }

}
