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
 *         Responsibilities of class: Superclass for creating Person objects, used to create Director and CastMember objects.
 */

public abstract class Person
{
	// Person HAS a firstName
	private String firstName;
	// Person HAS A lastName
	private String lastName;

	/**
	 * Purpose: When no argument is provided, construct an object with name set
	 * to "Unknown Name" so that Person's descriptions will not show as blank or
	 * return null.
	 */
	public Person()
	{
		this.lastName = "Unknown Name";
	}

	/**
	 * Purpose: Constructor for a person object when given one name. The single
	 * name is assigned to the lastName field.
	 * 
	 * @param fullName
	 */
	public Person(String fullName)
	{
		lastName = fullName;
	}

	/**
	 * Purpose: Constructor for a person object when given both names.
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Purpose: Output a person's names to a string
	 * 
	 * @return string of a persons name
	 */
	public String toString()
	{
		String name = "";

		// If only given one name, name is last name.
		if (firstName == null)
		{
			name = lastName;
		}
		// If given first and last name
		else if (firstName != null && lastName != null)
		{
			name = lastName + ", " + firstName;
		}
		return name;
	}

}
