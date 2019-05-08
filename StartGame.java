public class StartGame {
  /**Choose 2-4 crew members from the following classes:
     - Engineer:
       ~ Bonus to repair
       ~ Passive buff to shields
     - Pilot:
       ~ Reduces chance of asteroid impact
     - Soldier:
       ~ Most health
       ~ Intimidate: Reduces chance of aliens boarding
     - Navigator:
       ~
     - Medical Officer:
       ~ Able to heal crew members
     - Scavenger:
       ~ Increased chance of finding ship parts



     Name each crew member

     Name ship (create new Ship object):

     Start adventure */
     public static void main(String[] args) {
       Ship frigate = new Ship("Endeavour");
       Crew theTeam = new Crew(frigate);

       CrewMember yuri = new CrewMember();
       CrewMember val = new CrewMember("Engineer", "Valentina", 100, 0);
       CrewMember bob = new CrewMember("Scientist", "Bob", 100, 0);

       theTeam.addCrew(yuri);
       theTeam.addCrew(val);
       theTeam.addCrew(bob);

       System.out.println(theTeam.toString());

     }
}
