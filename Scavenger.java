public class Scavenger extends CrewMember {

  public Scavenger(String name, int vitality, int food) {
    super("Scavenger", name, vitality, food);
  }

  public void lucky() {

  }

  public void repair() {
    vessel.updateShield(10);
  }
}
