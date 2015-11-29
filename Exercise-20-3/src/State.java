import java.util.ArrayList;

/**
 * The type State. A State is a region that can be uniquely identified by a combination of
 * its name and capital.
 *
 * @author Joey Davis
 */
public class State {
  private String name;
  private String capital;

  /**
   * Instantiates a new State.
   *
   * @param name
   *     the name of the state
   * @param capital
   *     the capital of the state
   */
  public State(String name, String capital) {
    this.name = name;
    this.capital = capital;
  }

  /**
   * Gets the state name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the state capital.
   *
   * @return the capital
   */
  public String getCapital() {
    return capital;
  }

  /**
   * Returns an ArrayList of the 50 USA States
   *
   * @return the array list
   */
  public static ArrayList<State> stateArrayList() {
    ArrayList<State> states = new ArrayList<>();
    states.add(new State("Alabama", "Montgomery"));
    states.add(new State("Alaska", "Juneau"));
    states.add(new State("Arizona", "Phoenix"));
    states.add(new State("Arkansas", "Little Rock"));
    states.add(new State("California", "Sacramento"));
    states.add(new State("Colorado", "Denver"));
    states.add(new State("Connecticut", "Hartford"));
    states.add(new State("Delaware", "Dover"));
    states.add(new State("Florida", "Tallahassee"));
    states.add(new State("Georgia", "Atlanta"));
    states.add(new State("Hawaii", "Honolulu"));
    states.add(new State("Idaho", "Boise"));
    states.add(new State("Illinois", "Springfield"));
    states.add(new State("Indiana", "Indianapolis"));
    states.add(new State("Iowa", "Des Moines"));
    states.add(new State("Kansas", "Topeka"));
    states.add(new State("Kentucky", "Frankfort"));
    states.add(new State("Louisiana", "Baton Rouge"));
    states.add(new State("Maine", "Augusta"));
    states.add(new State("Maryland", "Annapolis"));
    states.add(new State("Massachusetts", "Boston"));
    states.add(new State("Michigan", "Lansing"));
    states.add(new State("Minnesota", "Saint Paul"));
    states.add(new State("Mississippi", "Jackson"));
    states.add(new State("Missouri", "Jefferson City"));
    states.add(new State("Montana", "Helena"));
    states.add(new State("Nebraska", "Lincoln"));
    states.add(new State("Nevada", "Carson City"));
    states.add(new State("New Hampshire", "Concord"));
    states.add(new State("New Jersey", "Trenton"));
    states.add(new State("New Mexico", "Santa Fe"));
    states.add(new State("New York", "Albany"));
    states.add(new State("North Carolina", "Raleigh"));
    states.add(new State("North Dakota", "Bismarck"));
    states.add(new State("Ohio", "Columbus"));
    states.add(new State("Oklahoma", "Oklahoma City"));
    states.add(new State("Oregon", "Salem"));
    states.add(new State("Pennsylvania", "Harrisburg"));
    states.add(new State("Rhode Island", "Providence"));
    states.add(new State("South Carolina", "Columbia"));
    states.add(new State("South Dakota", "Pierre"));
    states.add(new State("Tennessee", "Nashville"));
    states.add(new State("Texas", "Austin"));
    states.add(new State("Utah", "Salt Lake City"));
    states.add(new State("Vermont", "Montpelier"));
    states.add(new State("Virginia", "Richmond"));
    states.add(new State("Washington", "Olympia"));
    states.add(new State("West Virginia", "Charleston"));
    states.add(new State("Wisconsin", "Madison"));
    states.add(new State("Wyoming", "Cheyenne"));
    return states;
  }

}
