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
 *         Responsibilities of class: Create new movie objects. Aggregated into
 *         an array by ProductionList. Uses the Production superclass but
 *         further classifies by runtime.
 * 
 */

// Movie IS A Production
public class Movie extends Production
{
	// Movie HAS A runtime
	private String runtime;

	/**
	 * Purpose: Create a new Movie object from the superclass constructor for
	 * Production, add the runtime (duration) of the movie.
	 * 
	 * @param type
	 * @param title
	 * @param releaseYear
	 * @param description
	 * @param runtime
	 * @param directors
	 * @param castMembers
	 * @param genres
	 */
	public Movie(String type, String title, String releaseYear,
			String description, String runtime, Director[] directors,
			CastMember[] castMembers, Genre[] genres)
	{
		// Call superclass constructor for Production
		super(type, title, releaseYear, description, directors, castMembers,
				genres);
		// Add the runtime
		this.runtime = runtime;
	}

	/**
	 * Purpose: Get the duration/runtime of a movie.
	 * 
	 * @return runtime
	 */
	private String getDuration()
	{
		return runtime;
	}

	/**
	 * Purpose: Output the information of a Movie object in a string format.
	 */
	public String getInfo()
	{
		String info = String.format("%nTitle: " + getTitle() + "%nDescription: "
				+ getDescription() + "%nDirector: " + getDirectors() + "%n"
				+ "Cast: " + getCastMembers() + "%n" + "Genre: " + getGenre()
				+ "%n" + "Release Date: " + getReleaseDate() + "%n"
				+ "Duration: " + getDuration());
		return info;
	}

}
