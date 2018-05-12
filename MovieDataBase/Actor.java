// Author: Matt McGuiness

package movies;

import java.util.ArrayList;

public class Actor {

    private String name;
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
