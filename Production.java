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
 *         Responsibilities of class: Abstract class for the fields,
 *         constructors, and methods that apply to each production object
 *         (Movies and TV Shows)
 */

public abstract class Production
{
	// Production HAS A type
	private String type;
	// Production HAS A title
	private String title;
	// Production HAS Many directors
	private Person[] directors = new Director[20];
	// integer for the next element in a array to assign a director
	private int directorIndex = 0;
	// Production HAS Many castMembers
	private Person[] cast = new CastMember[20];
	// Production can HAVE Multiple genre's
	private Genre[] genres;
	// Production HAS A releaseDate
	private String releaseDate;
	// Production HAS A summary/ description
	private String description;

	/**
	 * Purpose: No args constructor for testing to set Production fields to
	 * unknown.
	 */
	public Production()
	{
		type = "Unknown";
		title = "No Title";
		releaseDate = "Unknown";
		description = "Unknown";
	}

	/**
	 * Purpose: Construct a Production object given the shared information each
	 * TV Show and Movie will have regardless of type.
	 * 
	 * @param type
	 * @param title
	 * @param releaseDate
	 * @param description
	 * @param directors
	 * @param cast
	 * @param genres
	 */
	public Production(String type, String title, String releaseDate,
			String description, Director[] directors, CastMember[] cast,
			Genre[] genres)
	{
		this.type = type;
		this.title = title;
		this.releaseDate = releaseDate;
		this.description = description;
		this.directors = directors;
		this.cast = cast;
		this.genres = genres;

	}

	/**
	 * Purpose: Add a director object to the next available index of the list of
	 * directors.
	 * 
	 * @param director
	 */
	public void addDirector(Director director)
	{
		directors[directorIndex] = director;
		directorIndex++;
	}

	/**
	 * Purpose: Get the title of a Production
	 * 
	 * @return title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Purpose: Get the type (movie or tv show)
	 * 
	 * @return type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Purpose: Get the description/ summary of a production.
	 * 
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Purpose: Output the information in the array of directors to a string.
	 * 
	 * @return string of directors.
	 */
	public String getDirectors()
	{
		String directorsString = "";

		// Loop to iterate through the array of director objects
		for (int i = 0; i < directors.length; i++)
		{
			// Null check
			if (directors[i] != null)
			{
				// If i matched the last element, add the director and no additional comma
				if (i == directors.length - 1)
				{
					directorsString += directors[i];
				}
				// If there are more director objects, add a comma to separate them
				else
				{
					directorsString += directors[i] + ", ";
				}
			}
		}
		
		// Return the string of directors with separating quotations from .csv file removed.
		return directorsString.replace('"', ' ');
	}

	/**
	 * Purpose: Return a string of the information store in the array of castMembers
	 * Processes similiarly to getDirectors method.
	 * 
	 * @return string of cast
	 */
	public String getCastMembers()
	{
		String castMembersString = "";

		for (int i = 0; i < cast.length; i++)
		{
			if (cast[i] != null)
			{
				if (i == cast.length - 1)
				{
					castMembersString += cast[i];
				}
				else
				{
					castMembersString += cast[i] + ", ";
				}
			}
		}

		return castMembersString;
	}

	/**
	 * Purpose: Get the ReleaseYear of a production.
	 * 
	 * @return
	 */
	public String getReleaseDate()
	{
		return releaseDate;
	}

	// Desired information is different depending on TV Show or Movie
	abstract String getInfo();

	/**
	 * Purpose: Get the information stored in the genre array as a string.
	 * Processes similarly to getDirectors and getCastMembers.
	 * 
	 * @return
	 */
	public String getGenre()
	{
		String genreString = "";

		for (int i = 0; i < genres.length; i++)
		{
			if (genres[i] != null)
			{
				if (i == genres.length - 1)
				{
					genreString += genres[i];
				}
				else
				{
					genreString += genres[i] + ", ";
				}
			}
		}
		return genreString;
	}

}
