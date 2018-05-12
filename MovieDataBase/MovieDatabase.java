// Author: Matt McGuiness

package movies;

import java.io.*;
import java.util.*;

public class MovieDatabase {

	private ArrayList<Movie> movieList = new ArrayList<Movie>();
	private ArrayList<Actor> actorList = new ArrayList<Actor>();

	public MovieDatabase() {
		this.movieList = new ArrayList<Movie>();
		this.actorList = new ArrayList<Actor>();
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public ArrayList<Actor> getActorList() {
		return actorList;
	}

	/**
	 * This method takes in the name of a movie that is not currently in the
	 * database along with a list of actors for that movie. If the movie is already
	 * in the database, your code ignores this request (this specification is an
	 * oversimplification). If the movie is a new movie, a movie object is created
	 * and added to the movieList. If any of the actors happen to be new, they will
	 * be added to the actorList.
	 * 
	 * @param name   - name of movie
	 * @param actors - List of actor names
	 */
	void addMovie(String name, String[] actors) {
		Movie newMovie = new Movie();
		newMovie.setName(name);

		// Create temp Movie list and add the initialized Movie
		ArrayList<Movie> tempMovieList = new ArrayList<Movie>();
		tempMovieList.add(newMovie);

		// Create temp actor list for adding list of actors to Movie later
		ArrayList<Actor> tempActorList = new ArrayList<Actor>();

		// Loop through actors list and create/add actors
		for (int i = 0; i < actors.length; i++) {

			Actor newActor = new Actor();
			newActor.setName(actors[i]);
			newActor.setMovies(tempMovieList);
			tempActorList.add(newActor);

			// See if actor is already added to actorList
			boolean actorAlreadyAdded = false;
			for (Actor actor : actorList) {
				if (actor.getName().equals(actors[i])) {
					actorAlreadyAdded = true;
				}
			}
			if (!actorAlreadyAdded) {
				actorList.add(newActor);
			}
		}

		// Loop through movie list and see if the movie is already added
		boolean movieAlreadyAdded = false;
		for (Movie movie : movieList) {
			if (movie.getName().equals(name)) {
				movieAlreadyAdded = true;
			}
		}

		if (!movieAlreadyAdded) {
			newMovie.setActors(tempActorList);
			movieList.add(newMovie);
		}
	}

	/**
	 * Add a rating for this movie. Assume that the name argument will definitely be
	 * a name that is currently in the database.
	 * 
	 * @param name   - name of the movie
	 * @param rating - rating of the movie
	 */
	void addRating(String name, double rating) {
		// Loop through movieList to find movie and add rating
		for (Movie movie : movieList) {
			if (movie.getName().equals(name)) {
				movie.setRating(rating);
				return;
			}
		}
	}

	/**
	 * Overwrite the current rating of a movie with this new rating. Again, assume
	 * that the name argument will definitely be a name that is currently in the
	 * database.
	 * 
	 * @param name      - name of movie
	 * @param newRating - new rating of movie
	 */
	void updateRating(String name, double newRating) {
		// Another way to loop through movies and set rating
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getName() == name) {
				movieList.get(i).setRating(newRating);
				return;
			}
		}
	}

	/**
	 * Returns the name of the actor that has the best average rating for their
	 * movies.
	 * 
	 * @return
	 */
	String getBestActor() {
		String bestActor = "";
		double highestRating = 0;

		for (Actor actor : actorList) {
			ArrayList<Movie> movies = actor.getMovies();
			if (movies.size() > 0) {
				double sum = 0;
				for (Movie movie : movies) {
					sum += movie.getRating();
				}
				double rating = sum / movies.size();
				if (rating > highestRating) {
					highestRating = rating;
					bestActor = actor.getName();
				}
			}
		}
		return bestActor;
	}

	/**
	 * Returns the name of the movie with the highest rating.
	 * 
	 * @return
	 */
	String getBestMovie() {
		String bestMovie = "";
		double highestRating = 0;

		for (Movie movie : movieList) {
			double rating = movie.getRating();
			if (rating > highestRating) {
				highestRating = rating;
				bestMovie = movie.getName();
			}
		}

		return bestMovie;
	}

	public static void main(String[] args) {
		MovieDatabase movieDB = new MovieDatabase();

		Map<String, ArrayList<String>> tempDB = new HashMap<String, ArrayList<String>>();

		// Parse Movie File and structure it into a temp DB
		try {
			File file = new File("movies.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String newLine = scanner.nextLine();
				String[] lineArray = newLine.split("\\s*,\\s*");

				// Loop through line and create key/pairs for movies/actorsInMovie
				for (int i = 1; i < lineArray.length; i++) {
					if (!tempDB.containsKey(lineArray[i])) {
						tempDB.put(lineArray[i], new ArrayList<String>());
					}
					tempDB.get(lineArray[i]).add(lineArray[0]);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Add movies to actual MovieDataBase Class
		for (String movie : tempDB.keySet()) {
			String[] actors = tempDB.get(movie).toArray(new String[tempDB.size()]);
			movieDB.addMovie(movie, actors);
		}

		// Parse Rating File and update movie ratings
		try {
			File file = new File("ratings.txt");
			Scanner scanner = new Scanner(file);
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String newLine = scanner.nextLine();
				int index = newLine.length() - 3;
				String movieTitle = newLine.substring(0, index).trim();
				double rating = Double.valueOf(newLine.substring(index, newLine.length()).trim());

				movieDB.addRating(movieTitle, rating);

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(movieDB.getBestActor());
		System.out.println(movieDB.getBestMovie());

	}

}
