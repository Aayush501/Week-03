// definition of MovieNode class
class MovieNode {
    // declaring the attributes of this class
    private final String movieTitle, director, yearOfRelease;
    private float rating;
    MovieNode previous, next;

    // created a parameterized constructor to initialize the object
    MovieNode(String director, String movieTitle, float rating, String yearOfRelease) {
        this.director = director;
        this.movieTitle = movieTitle;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
    }

    // created getter methods to maintain encapsulation and data security
    public String getMovieTitle(){
        return this.movieTitle;
    }

    public String getDirector(){
        return this.director;
    }

    public String getYearOfRelease(){
        return this.yearOfRelease;
    }

    public float getRating(){
        return this.rating;
    }

    // created a method to update the rating of a movie
    public void updateRating(float newRating){
        this.rating = newRating;
    }
}

// definition of Movie class
class Movie {
    // declaring the attributes of this class
    MovieNode head, tail; // head of the linked list
    static int totalMovies=0;

    // created a parameterized constructor to initialize a linked list of Movies
    Movie(String director, String movieTitle, float rating, String yearOfRelease) {
        head = new MovieNode(director, movieTitle, rating, yearOfRelease);
        tail = head;
        totalMovies++;
    }

    // created a method to display all movie records in required order
    public void displayAllRecords(String order) {
        boolean check = order.equals("backward");
        MovieNode movie = (check)? tail : head;
        System.out.println("Printing all records of this list in " + order + " order.");
        while (movie != null) {
            System.out.println("Title of the movie: " + movie.getMovieTitle() + "\nDirector Name: " + movie.getDirector() + "\nRating: " + movie.getRating() + "\nYear of Release: " + movie.getYearOfRelease() + "\n");
            movie = (check)? movie.previous : movie.next;
        }
    }

    // created a method addMovie to add a new movie at the end of the list
    public void addMovie(String director, String movieTitle, float rating, String yearOfRelease) {
        addMovie(director, movieTitle, rating, yearOfRelease, totalMovies+1);
    }

    // created a method to add a record at any position of the list including the beginning and end position
    public void addMovie(String director, String movieTitle, float rating, String yearOfRelease, int position) {
        if (position == 1) { // if user wants to add a record at the beginning
            MovieNode newMovie = new MovieNode(director, movieTitle, rating, yearOfRelease);
            newMovie.next = head;
            head.previous = newMovie;
            head = newMovie;
            totalMovies++;
            return;
        }

        if(position == totalMovies+1){ // if user wants to add a record at the end
            MovieNode newMovie = new MovieNode(director, movieTitle, rating, yearOfRelease);
            newMovie.previous = tail;
            tail.next = newMovie;
            tail = newMovie;
            totalMovies++;
            return;
        }

        MovieNode movie1 = head;
        // created an integer variable to iterate through the list till we reach to the position
        int i=1;
        while (i<position) {
            if (movie1 == null){ // means movie1 has crossed the last position and now it id out of bound of the list
                System.out.println("Invalid insert position!!");
                return;
            }
            movie1 = movie1.next;
            i++;
        }

        // initializing a new movie record
        MovieNode newMovie = new MovieNode(director, movieTitle, rating, yearOfRelease);
        // inserting the new record
        newMovie.next = movie1;
        newMovie.previous = movie1.previous;
        movie1.previous.next = newMovie;
        movie1.previous = newMovie;
        totalMovies++;
    }

    // created a method to search a record by director
    public void searchMovie(String director) {
        // iterator for the list
        MovieNode movie1 = head;
        while (movie1 != null) { // iterate till the iterator reaches the last node
            if (movie1.getDirector().equals(director)) {
                System.out.println("\nDetails of the movie:\nTitle: " + movie1.getMovieTitle() + "\nDirector: " + movie1.getDirector() + "\nRating: " + movie1.getRating() + "\nYear of Release: " + movie1.getYearOfRelease() + "\n");
                return;
            }
            movie1 = movie1.next;
        }

        System.out.println("Director name is entered wrong.");
    }

    // created a method to search a record by rating
    public void searchMovie(float rating) {
        // iterator for the list
        MovieNode movie1 = head;
        while (movie1 != null) { // iterate till the iterator reaches the last node
            if (movie1.getRating() == rating) {
                System.out.println("\nDetails of the movie:\nTitle: " + movie1.getMovieTitle() + "\nDirector: " + movie1.getDirector() + "\nRating: " + movie1.getRating() + "\nYear of Release: " + movie1.getYearOfRelease() + "\n");
                return;
            }
            movie1 = movie1.next;
        }

        System.out.println("Rating is entered wrong.");
    }

    // created a method to delete a record by movie title
    public void deleteByMovieTitle(String movieTitle) {
        // iterators for the list
        MovieNode movie1 = head;
        while (movie1 != null) { // iterate till the iterator reaches the last node
            if (movie1.getMovieTitle().equals(movieTitle)) {
                movie1.previous.next = movie1.next;
                movie1.next.previous = movie1.previous;
                totalMovies--;
                return;
            }
            movie1 = movie1.next;
        }

        System.out.println("This movie does not exist.");
    }

    // created a method to update the rating of a movie by movie title
    public void updateRating(String movieTitle, float newRating) {
        // iterator for the list
        MovieNode movie1 = head;
        while (movie1 != null) { // iterate till the iterator reaches the last node
            if (movie1.getMovieTitle().equals(movieTitle)) {
                movie1.updateRating(newRating);
                return;
            }
            movie1 = movie1.next;
        }

        System.out.println("This movie does not exist.");
    }
}

// definition of MovieManagementSystem class
public class MovieManagementSystem {
    public static void main(String[] args) {
        // created a linked list of movies
        Movie movies = new Movie("Director1", "Movie1", 3.5f, "2024");

        // iteration to add new movies
        for (int i = 0; i < 4; i++) {
            movies.addMovie("Director" + (i+2), "Movie" + (i+2), (i+4.5f), "2024");
        }

        // displaying details of all movies in forward and backward order
        movies.displayAllRecords("forward");
        movies.displayAllRecords("backward");

        // adding new record at beginning of the list
        movies.addMovie("Director0", "Movie0", 3.0f, "2024", 1);

        // adding new record at the end of the list
        movies.addMovie("Director6", "Movie6", 6.5f, "2024", Movie.totalMovies+1);

        // adding new record at a specific position of the list
        movies.addMovie("Director7", "Movie7", 7.5f, "2025", 3);

        // searching a movie by director
        movies.searchMovie("Director3");

        // searching a movie by rating
        movies.searchMovie(5.5f);

        // deleting a movie record by movie title
        movies.deleteByMovieTitle("Movie2");

        // updating the yearOfRelease of a movie by roll number
        movies.updateRating("Movie4", 3.5f);

        // displaying details of all movies
        movies.displayAllRecords("forward");
    }
}