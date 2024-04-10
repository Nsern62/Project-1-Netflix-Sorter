package titleSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * 
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
 *         Responsibilities of class: Display text to interact with and guide
 *         the user through search criteria. Retrieve input from user to
 *         initiate different search criteria.
 * 
 */

public class UserInput
{

	public static void main(String[] args)
	{
		// Variables for holding search inputs
		String directorSearch = "";
		String castSearch = "";
		String yearSearch = "";
		String genreSearch = "";
		// Boolean to continue looping through the array until user is done.
		boolean searchDone = false;
		
		try
		{
			// Create a new production list object containing all titles in a
			// csv.
			ProductionList allTitles = new ProductionList("netflix_titles_smallSample.csv", 100);
			
//			ProductionList allTitles = new ProductionList("netflix_titles.csv" , 8810);

			Scanner scanner = new Scanner(System.in);

			// Loop statement until user is done searching.
			do
			{
				try
				{
					// "Main Menu" output to user
					System.out.printf("%nEnter number for search type: 1.Genre 2.Movies 3.TV-Shows 4.Director 5.Cast 6.Release Year%nPress 'e' to exit. %n");
					
					// Get int for user's search choice
					String userIn = scanner.next();
					// Force scanner to go to nextLine so it doesnt pull the previous int. 
					scanner.nextLine();

					// Switch statement to execute code based off user's initial input.
					switch (userIn)
					{
						// If user enters 1
						case "1":
							//Output text for user to enter a genre.
							System.out.println("Please enter a genre: ");
							//Get the genre user wants to search by.
							genreSearch = scanner.nextLine();
							// Call sort genre method 
							ProductionList genreList = allTitles.sortGenre(genreSearch);
							genreList.listDisplay(scanner);
							break;

						case "2":
							// Create movieList object and populate 
							ProductionList movieList = allTitles.sortMovies();
							System.out.printf("%nList of Movies: %n");
							movieList.listDisplay(scanner);
							break;

						case "3":
							ProductionList tvShows = allTitles.sortTVShows();
							System.out.println("List of TV-Shows: ");
							tvShows.listDisplay(scanner);
							break;

						case "4":
							System.out.println("Please enter the name of the director you wish to search for: ");
							directorSearch = scanner.nextLine();
							ProductionList directorList = allTitles.sortDirector(directorSearch);
							System.out.printf("%nList of titles by " + directorSearch + ". %n%n");
							directorList.listDisplay(scanner);
							break;

						case "5":
							System.out.println("Please enter the name of the actor you wish to search for: ");
							castSearch = scanner.nextLine();
							ProductionList actorList = allTitles.sortCast(castSearch);
							System.out.printf("%nList of titles with " + castSearch + ". %n%n");
							actorList.listDisplay(scanner);
							break;

						case "6":
							System.out.println("What year would you like to search by? ");
							yearSearch = scanner.nextLine();
							ProductionList yearList = allTitles.sortReleaseDate(yearSearch);
							System.out.printf("%nProductions released in " + yearSearch + ".%n");
							yearList.listDisplay(scanner);
							break;
							
						case "e":
							System.out.println("Goodbye.");
							searchDone = true;
							break;
							
						default:
							System.out.println("Please enter a valid search criteria");
					}
				}

				catch (InputMismatchException ime)
				{
					System.out.println("Please enter a valid option.");
					scanner.nextLine();
				}
			}
			while (searchDone == false);
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
