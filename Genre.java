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
 *         Responsibilities of class: Create genre objects, aggregated into an array by Productions
 */

public class Genre
{
	// Genre HAS A name
	private String name;

	/**
	 * Purpose: If no genre provided, set genre to unknown to avoid null.
	 */
	public Genre()
	{
		name = "Unknown Genre";
	}

	/**
	 * Purpose: Create a new genre object when given the category.
	 * 
	 * @param category
	 */
	public Genre(String category)
	{
		this.name = category;
	}

	/**
	 * Purpose: Get the genre.
	 */
	public String toString()
	{
		return name;
	}
}
