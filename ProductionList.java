package titleSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
 *         Java: Splitting a comma-separated string but ignoring commas in
 *         quotes. (n.d.). Stack Overflow. Retrieved March 27, 2022, from
 *         https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
 *         Version/date: v3 20 March 2022
 * 
 *         Responsibilities of class: Create and sort through collections of
 *         production objects to return data that the user is searching for.
 */

public class ProductionList
{
	// ProductionList HAS A list of all the titles
	private Production[] allTitles;
	// ProductionList HAS Many productions
	private Production[] list;

	public ProductionList(int listSize)
	{
		list = new Production[listSize];
	}

	/**
	 * Purpose: Read a CSV file and set the allTitles field to all
	 * available titles within the list.
	 * 
	 * @param fileName to search
	 * @param listSize number of productions in the csv.
	 */
	public ProductionList(String fileName, int listSize)
	{
		BufferedReader csvReader = null;
		
		try
		{
			// Open the provided file name and create a buffered reader object
			// to read the file
			FileReader file = new FileReader(fileName);
			csvReader = new BufferedReader(file);

			// Set the size of allTitles to number of rows in the file
			allTitles = new Production[listSize];

			//Index to hold the next empty index of the array for allTitles.
			int listIndex = 0;
			
			// While the buffer is not empty. (File has more to be read)
			while (csvReader.ready())
			{
				String line = csvReader.readLine();
				// Regular Expression Splits the line at
				// commas that are not within a quotation pair.
				String[] productionInfo = line
						.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

				// Each element of the array contains a column of information
				// from the .csv, so create strings to store that information
				// and pass to a Production sub-constructor
				String title = productionInfo[2];
				String releaseYear = productionInfo[7];
				String duration = productionInfo[9];
				String description = productionInfo[11];
				String type = productionInfo[1];

				/*
				 * Since the following columns can contain more than one
				 * director, genre, or actor. Each column will need to be split
				 * in order to process each individual criteria. Create a new
				 * object for each piece to send as an Array of objects to the
				 * Production sub-constructors.
				 */
				String[] directorNames = productionInfo[3].split(",");
				Director[] directors = new Director[directorNames.length];
				for (int directorIndex = 0; directorIndex < directorNames.length; directorIndex++)
				{
					if (directorNames[directorIndex] != null)
					{
						// Create a new director object
						Director director = new Director(directorNames[directorIndex]);
						// Store the new object in a array to pass to production
						// constructor
						directors[directorIndex] = director;
					}
					else
					{
						// If null, use no-args constructor to create Director
						// Object with "Unknown Name".
						Director director = new Director();
						directors[directorIndex] = director;
					}
				}

				// Remove excess quotations and split the 4th column to separate
				// names of cast members
				String[] castNames = productionInfo[4].replace('"', ' ')
						.split(",");
				CastMember[] castMembers = new CastMember[castNames.length];
				// Process cast information similarly to directors
				for (int castIndex = 0; castIndex < castMembers.length; castIndex++)
				{
					if (castNames[castIndex] != null)
					{
						CastMember actor = new CastMember(castNames[castIndex]);
						castMembers[castIndex] = actor;
					}
					else
					{
						CastMember actor = new CastMember();
						castMembers[castIndex] = actor;
					}
				}

				// Process genre similarly to above criteria
				String[] genres = productionInfo[10].split(",");
				Genre[] genreList = new Genre[genres.length];
				for (int genreIndex = 0; genreIndex < genres.length; genreIndex++)
				{
					if (genres[genreIndex] != null)
					{
						Genre genre = new Genre(genres[genreIndex]);
						genreList[genreIndex] = genre;
					}
					else
					{
						Genre genre = new Genre();
						genreList[genreIndex] = genre;
					}
				}

				// Create a Movie object if type variable is movie
				if (type.equalsIgnoreCase("Movie"))
				{
					// Call movie constructor to create a new movie object
					Production movie = new Movie(type, title, releaseYear,
							description, duration, directors, castMembers,
							genreList);
					// Assign the object to current index of allTitles[]
					allTitles[listIndex] = movie;
					// Iterate to the next index after assigning.
					listIndex++;
				}

				// Create a TV Show object if type variable is TV Show.
				else if (type.equalsIgnoreCase("TV Show"))
				{
					//Process similar to the one above.
					Production tvShow = new TVShow(type, title, releaseYear,
							description, duration, directors, castMembers,
							genreList);
					allTitles[listIndex] = tvShow;
					listIndex++;
				}
			}
		}
		// Catch an exception if the .csv file is not found. Which shouldn't
		// happen as it's attached to the project.
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (csvReader != null)
				{
					csvReader.close();
				}
			}
			catch (IOException e)
			{
				
				e.printStackTrace();
			}
		}
	}

	/**
	 * Purpose: Make a deep copy of Productions in a list given a production
	 * list to copy.
	 * 
	 * @return copy of a productions list.
	 */
	public ProductionList getProductionsList(Production[] titles)
	{
		
		ProductionList copyOfProductions = new ProductionList(titles.length);

		for (int i = 0; i < allTitles.length; i++)
		{
			if (allTitles[i] != null)
			{
				copyOfProductions.list[i] = allTitles[i];
			}
		}
		return copyOfProductions;
	}

	/**
	 * Purpose: Make a new ProductionList and populate the list field
	 * (Production[]) with Productions of the Movie type.
	 * 
	 * @return list of movies
	 */
	public ProductionList sortMovies()
	{
		int movieCounter = 0;

		ProductionList listCopy = getProductionsList(allTitles);

		// Check whether an object in the list is of Type movie, if so iterate
		// movieCounter +1 to determine the necessary size of the movie list.
		for (int i = 0; i < allTitles.length; i++)
		{
			if (listCopy.list[i] != null
					&& listCopy.list[i].getType().equalsIgnoreCase("Movie"))
			{
				movieCounter++;
			}
		}

		// Create a new ProductionList for movies with the necessary length we
		// found in the previous for loop
		ProductionList movieList = new ProductionList(movieCounter);
		// integer for the next open index to add a movie object
		int nextMovieListIndex = 0;

		// If the object is a movie, add it to the new production list. index+1
		// for the next available index.
		for (int i = 0; i < listCopy.list.length; i++)
		{
			if (listCopy.list[i] != null
					&& listCopy.list[i].getType().equalsIgnoreCase("Movie"))
			{
				movieList.list[nextMovieListIndex] = listCopy.list[i];
				nextMovieListIndex++;
			}
		}
		return movieList;
	}

	/**
	 * Purpose: Make a new ProductionList[] of Productions with type TVShow.
	 * Process similarly to the sortMovies method.
	 * 
	 * @return list of TVShows.
	 */
	public ProductionList sortTVShows()
	{
		int showCounter = 0;

		ProductionList listCopy = getProductionsList(allTitles);

		for (int i = 0; i < allTitles.length; i++)
		{
			if (listCopy.list[i] != null
					&& listCopy.list[i].getType().equalsIgnoreCase("TV Show"))
			{
				showCounter++;
			}
		}

		ProductionList showList = new ProductionList(showCounter);
		int nextShowListIndex = 0;

		for (int i = 0; i < listCopy.list.length; i++)
		{
			if (listCopy.list[i] != null
					&& listCopy.list[i].getType().equalsIgnoreCase("TV Show"))
			{
				showList.list[nextShowListIndex] = listCopy.list[i];
				nextShowListIndex++;
			}
		}
		return showList;
	}

	/**
	 * Purpose: Make a new ProductionList sorted by genre. Processes similarly
	 * to previous sort methods.
	 * 
	 * @param genre to search for
	 * @return list of Productions with matching genre.
	 */
	public ProductionList sortGenre(String genreSearch)
	{
		int genreCount = 0;

		ProductionList listCopy = getProductionsList(allTitles);

		for (int i = 0; i < allTitles.length; i++)
		{
			if (listCopy.list[i] != null
					&& listCopy.list[i].getGenre().contains(genreSearch))
			{
				genreCount++;
			}
		}

		ProductionList genreList = new ProductionList(genreCount);
		int nextShowListIndex = 0;

		for (int i = 0; i < listCopy.list.length; i++)
		{
			if (listCopy.list[i] != null
					&& listCopy.list[i].getGenre().contains(genreSearch))
			{
				genreList.list[nextShowListIndex] = listCopy.list[i];
				nextShowListIndex++;
			}
		}
		return genreList;
	}

	/**
	 * Purpose: Create a ProductionList that contain a matching director object.
	 * Processes similarly to previous sort methods.
	 * 
	 * @param director to search for
	 * @return list of titles with matching director
	 */
	public ProductionList sortDirector(String director)
	{
		int directorCount = 0;

		ProductionList listCopy = getProductionsList(allTitles);

		for (int i = 0; i < allTitles.length; i++)
		{
			if (listCopy.list[i] != null
					&& listCopy.list[i].getDirectors().contains(director))
			{
				directorCount++;
			}
		}

		ProductionList directorList = new ProductionList(directorCount);
		int nextShowListIndex = 0;

		for (int i = 0; i < listCopy.list.length; i++)
		{
			if (listCopy.list[i] != null
					&& listCopy.list[i].getDirectors().contains(director))
			{
				directorList.list[nextShowListIndex] = listCopy.list[i];
				nextShowListIndex++;
			}
		}
		return directorList;
	}

	/**
	 * Purpose: Create a new ProductionList that contains productions with a
	 * specified cast member. Processes similar to previous methods.
	 * 
	 * @param castMember to search for
	 * @return list of titles containing castMember object.
	 */
	public ProductionList sortCast(String castMember)
	{
		int castListCount = 0;

		ProductionList listCopy = getProductionsList(allTitles);

		for (int i = 0; i < allTitles.length; i++)
		{
			if (listCopy.list[i] != null
					&& listCopy.list[i].getCastMembers().contains(castMember))
			{
				castListCount++;
			}
		}

		ProductionList listByCastMember = new ProductionList(castListCount);
		int nextCastListIndex = 0;

		for (int i = 0; i < listCopy.list.length; i++)
		{
			if (listCopy.list[i] != null
					&& listCopy.list[i].getCastMembers().contains(castMember))
			{
				listByCastMember.list[nextCastListIndex] = listCopy.list[i];
				nextCastListIndex++;
			}
		}
		return listByCastMember;
	}

	/**
	 * Purpose: Given a year, create a new ProductionList of titles made in that
	 * year. Processes similar to previous methods.
	 * 
	 * @param releaseYear
	 * @return list of productions made that year
	 */
	public ProductionList sortReleaseDate(String releaseYear)
	{
		int yearListCount = 0;

		ProductionList listCopy = getProductionsList(allTitles);

		for (int i = 0; i < allTitles.length; i++)
		{
			if (listCopy.list[i] != null
					&& listCopy.list[i].getReleaseDate().contains(releaseYear))
			{
				yearListCount++;
			}
		}

		ProductionList listByYear = new ProductionList(yearListCount);
		int nextCastListIndex = 0;

		for (int i = 0; i < listCopy.list.length; i++)
		{
			if (listCopy.list[i] != null
					&& listCopy.list[i].getReleaseDate().contains(releaseYear))
			{
				listByYear.list[nextCastListIndex] = listCopy.list[i];
				nextCastListIndex++;
			}
		}

		return listByYear;
	}

	/**
	 * Purpose: Consolidate information output to the user in a single method to
	 * clean up the UserInput switch statement
	 * 
	 * @param scanner to allow user input in the method call
	 * @return boolean value to continue or exit the switch statement
	 */
	public void listDisplay(Scanner scanner)
	{
		// boolean searchDone = false;
		String userInput = "";
		int nextIndex = 0;

		try
		{
			// Do while loop to continue the search program until the user
			// enters the exit option.
			do
			{
				// for loop for first 10 results
				for (int i = nextIndex; i < Math.min(nextIndex + 10,
						this.list.length); i++)
				{
					// Print titles at first 10 indexes
					System.out
							.println((i + 1) + ": " + this.list[i].getTitle());
				}
				// Output options to user
				System.out.printf(
						"%nEnter 'm' for more results, 'b' to go back, 'e' to exit. %nEnter a number for Movie information.%n%n");
				// Get user's input
				userInput = scanner.next();

				// If user enters "m" for more results
				if (userInput.equalsIgnoreCase("m"))
				{
					// Increase index by 10
					nextIndex += 10;

					// If increasing index by 10 would cause it to go out of
					// bounds, return to index of 0, or start of list
					if (nextIndex > this.list.length)
					{
						System.out.printf(
								"%n-- End of list. Returning to beginning. --%n");
						nextIndex = 0;
					}
				}

				// If user enters "b" to go back
				else if (userInput.equalsIgnoreCase("b"))
				{
					// Set index back 10
					nextIndex -= 10;

					// If previous step would cause index to go out of bounds,
					// set index to 0.
					if (nextIndex < 0)
					{
						nextIndex = 0;
					}
				}

				// If the user enters an integer greater than -1 (must be in the
				// array)
				else if (Integer.parseInt(userInput) >= 0)
				{
					// Retrieve the information for the title at a given index
					System.out
							.println(this.list[Integer.parseInt(userInput) - 1]
									.getInfo());
					userInput = "e";
				}

				// While user input is not "e" for exit
			} while (!userInput.equalsIgnoreCase("e"));
		}

		// If user inputs an invalid search option, return to the main menu.
		catch (InputMismatchException | NumberFormatException
				| ArrayIndexOutOfBoundsException ime)

		{
			System.out.printf("Returning to Main Menu.%n%n");
		}
	}
}
