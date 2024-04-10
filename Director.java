package titleSort;

/**
 * Lead Author(s):
 * 
 * @author Jordan Roby
 * @author Nicolas Serna
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 *         Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         Version/date: v4 06 April 2022
 * 
 *         Responsibilities of class: Create Director objects to be aggregated
 *         into an array in Production class. Further classification of Person.
 * 
 */

// Director IS A Person
public class Director extends Person

{
	/**
	 * Purpose: Call superclass no-args constructor
	 */
	public Director()
	{
		super();
	}

	/**
	 * Purpose: When given 1 string, call superclass to assign fullName to the
	 * last name field
	 * 
	 * @param fullName
	 */
	public Director(String fullName)
	{
		super(fullName);
	}

	/**
	 * Purpose: Call superclass constructor to assign both name fields
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Director(String firstName, String lastName)
	{
		super(firstName, lastName);
	}

}
