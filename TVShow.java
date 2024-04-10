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
 *         Responsibilities of class: Create TV Show objects. Aggregated into an
 *         array in ProductionList. Further classification of Production but
 *         adds seasons.
 */

// TVShow IS A Production
public class TVShow extends Production
{
	// TV Show has seasons
	private String seasons;

	/**
	 * Purpose: Create a new TV Show object from the superclass constructor for
	 * production and add the seasons.
	 * 
	 * @param type
	 * @param title
	 * @param releaseYear
	 * @param description
	 * @param seasons
	 * @param directors
	 * @param castMember
	 * @param genres
	 */
	public TVShow(String type, String title, String releaseYear,
			String description, String seasons, Director[] directors,
			CastMember[] castMember, Genre[] genres)
	{
		// Call superclass constructor from Production
		super(type, title, releaseYear, description, directors, castMember,
				genres);
		// Set number of seasons
		this.seasons = seasons;
	}

	/**
	 * Purpose: Get the number of seasons
	 * 
	 * @return
	 */
	public String getSeasons()
	{
		return seasons;
	}

	/**
	 * Purpose: Output the information of a TV Show object to the user in a
	 * string format.
	 */
	String getInfo()
	{
		String info = String.format("%nTitle: " + getTitle() + "%nDescription: "
				+ getDescription() + "%nDirector: " + getDirectors() + "%n"
				+ "Cast: " + getCastMembers() + "%n" + "Genre: " + getGenre()
				+ "%n" + "Release Date: " + getReleaseDate() + "%n"
				+ "Seasons: " + getSeasons());
		;
		return info;
	}

}
