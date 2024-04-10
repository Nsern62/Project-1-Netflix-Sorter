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
 *         Responsibilities of class: Create new CastMember objects to be
 *         aggregated into an array in Productions. CastMember is a further
 *         defined person.
 * 
 */

// CastMember IS A Person
public class CastMember extends Person
{

	/**
	 * Purpose: Make a new castMember from superclass no-args constructor.
	 */
	public CastMember()
	{
		super();
	}

	/**
	 * Purpose: Create a new CastMember object when only given one name.
	 * 
	 * @param fullName
	 */
	public CastMember(String fullName)
	{
		super(fullName);
	}

	/**
	 * Purpose: Create a new CastMember object when given first and last name.
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public CastMember(String firstName, String lastName)
	{
		super(firstName, lastName);
	}

}
