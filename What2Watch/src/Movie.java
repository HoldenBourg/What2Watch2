import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Movie {
    public String title;
    public String movieType;

    private double rating;
    private double actingRating;
    private double visualsRating;
    private double scriptRating;
    private double storyRating;
    private double pacingRating;
    private double climaxRating;
    private double endingRating;

    private static final String filePath = "/Users/holdenbourg/Desktop/Holden's Projects/Film Filtration System/FFS Data/";


    // TODO constructors
    public Movie(String title, String movieType, double rating, double acting, double visuals, double script, double story, double pacing, double climax, double ending){
        this.title = title;
        this.movieType = movieType;
        this.rating = rating;
        this.actingRating = acting;
        this.visualsRating = visuals;
        this.scriptRating = script;
        this.storyRating = story;
        this.pacingRating = pacing;
        this.climaxRating = climax;
        this.endingRating = ending;
    }


    // TODO getters/setters
    public String getMovieType() {return movieType;}
    public void setMovieType(String movieType) {this.movieType = movieType;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public double getRating() {return rating;}
    public void setRating(double rating) {this.rating = rating;}

    public double getActingRating() {return actingRating;}
    public void setActingRating(double actingRating) {this.actingRating = actingRating;}

    public double getVisualsRating() {return visualsRating;}
    public void setVisualsRating(double visualsRating) {this.visualsRating = visualsRating;}

    public double getScriptRating() {return scriptRating;}
    public void setScriptRating(double scriptRating) {this.scriptRating = scriptRating;}

    public double getStoryRating() {return storyRating;}
    public void setStoryRating(double storyRating) {this.storyRating = storyRating;}

    public double getPacingRating() {return pacingRating;}
    public void setPacingRating(double pacingRating) {this.pacingRating = pacingRating;}

    public double getClimaxRating() {return climaxRating;}
    public void setClimaxRating(double climaxRating) {this.climaxRating = climaxRating;}

    public double getEndingRating() {return endingRating;}
    public void setEndingRating(double endingRating) {this.endingRating = endingRating;}


    // TODO class methods
    public static void findBestRatedMovie() throws FileNotFoundException {
        System.out.print("Best rated movie: ");

        double highestRating = 0.0;

        for (int i = 0; i < readMoviesFromFile().size(); i++){
            Movie currentMovie = readMoviesFromFile().get(i);

            if (currentMovie.getRating() > highestRating){
                highestRating = currentMovie.getRating();
            }
        }

        for (int i = 0; i < readMoviesFromFile().size(); i++){
            Movie currentMovie = readMoviesFromFile().get(i);

            if (currentMovie.getRating() == highestRating) {
                System.out.print(currentMovie.getTitle() + " | " + currentMovie.getRating());
            }
        }
    }
    public static void findMovieWithRating(double rating) throws FileNotFoundException {
        System.out.println("All movies with a " + rating + " rating:\n");

        for (int i = 0; i < readMoviesFromFile().size(); i++){
            Movie currentMovie = readMoviesFromFile().get(i);

            if (currentMovie.getRating() == rating){
                System.out.println(currentMovie.getTitle());
            }
        }
    }
    public static void findMovieWithRatingOrHigher(double rating) throws FileNotFoundException {
        System.out.println("All movies with a " + rating + " rating or higher:\n");
        System.out.println("Title | Rating");

        for (int i = 0; i < readMoviesFromFile().size(); i++){
            Movie currentMovie = readMoviesFromFile().get(i);

            if (currentMovie.getRating() >= rating){
                System.out.println(currentMovie.getTitle() + " | " + currentMovie.getRating());
            }
        }
    }
    public static void findMovieWithFilmType(String filmType) throws FileNotFoundException {
        System.out.println("Movie Type: " + filmType + "\n");
        System.out.println("Title | Rating");

        for (int i = 0; i < readMoviesFromFile().size(); i++){
            Movie currentMovie = readMoviesFromFile().get(i);

            if (currentMovie.getMovieType().equalsIgnoreCase(filmType)){
                System.out.println(currentMovie.getTitle() + " | " + currentMovie.getRating());
            }
        }
    }
    public static void findBestRatedMovieType(String filmType) throws FileNotFoundException {
        System.out.println("Best rated film(s) from Movie Type: " + filmType + "\n");
        System.out.println("Title | Rating");

        double bestRating = 0.0;

        for (int i = 0; i < readMoviesFromFile().size(); i++){
            Movie currentMovie = readMoviesFromFile().get(i);

            if (currentMovie.getMovieType().equalsIgnoreCase(filmType) && currentMovie.getRating() >= bestRating){
                bestRating = currentMovie.getRating();
            }
        }

        for (int i = 0; i < readMoviesFromFile().size(); i++){
            Movie currentMovie = readMoviesFromFile().get(i);

            if (currentMovie.getRating() == bestRating){
                System.out.println(currentMovie.getTitle() + " | " + currentMovie.getRating());
            }
        }
    }
    public static void printMovies() throws FileNotFoundException {
        System.out.println("All Movies: \n");
        System.out.println("Title | Rating");

        for (int i = 0; i < readMoviesFromFile().size(); i++){
            Movie currentMovie = readMoviesFromFile().get(i);

            System.out.println(currentMovie.getTitle() + " | " + currentMovie.getRating());
        }
    }

    public static boolean findMovie (String movie) throws FileNotFoundException {
        for (int i = 0; i < readMoviesFromFile().size(); i++){
            Movie currentMovie = readMoviesFromFile().get(i);

            if (currentMovie.getTitle().equalsIgnoreCase(movie)){
                return true;
            }
        }

        return false;
    }
    public static void findAndDeleteMovie(String movie) throws IOException {
        for (int i = 0; i < readMoviesFromFile().size(); i++){
            Movie currentMovie = readMoviesFromFile().get(i);

            if (movie.equalsIgnoreCase(currentMovie.getTitle())){
                deleteMovie(currentMovie);
            }
        }
        System.out.println(movie + " has been deleted.");
    }


    //TODO read/write/delete
    public static void writeMovieToFile(Movie movie) throws IOException {
        String outputText = movie.getTitle() + "|" + movie.getMovieType() + "|" + movie.getRating() + "|" +
                movie.getActingRating() + "|" + movie.getVisualsRating() + "|" + movie.getScriptRating() + "|" +
                movie.getStoryRating() + "|" + movie.getPacingRating() + "|" + movie.getClimaxRating() + "|" + movie.getEndingRating();

        String path = filePath + "movie.txt";
        File file = new File(path);

        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(outputText);
        pw.close();

    }
    public static ArrayList<Movie> readMoviesFromFile() throws FileNotFoundException {
        String path = filePath + "movie.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        ArrayList<Movie> movieList = new ArrayList<>();

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            String[] properties = line.split("\\|");

            String movieTitle = properties[0];
            String filmType = properties[1];
            double rating = Double.parseDouble(properties[2]);
            double actingRating = Double.parseDouble(properties[3]);
            double visualsRating = Double.parseDouble(properties[4]);
            double scriptRating = Double.parseDouble(properties[5]);
            double storyRating = Double.parseDouble(properties[6]);
            double pacingRating = Double.parseDouble(properties[7]);
            double climaxRating = Double.parseDouble(properties[8]);
            double endingRating = Double.parseDouble(properties[9]);

            Movie movie = new Movie(movieTitle, filmType, rating, actingRating, visualsRating, scriptRating, storyRating, pacingRating, climaxRating, endingRating);
            movieList.add(movie);
        }

        return movieList;
    }
    public static void deleteMovie(Movie movie) throws IOException {
        File inputFile = new File(filePath + "movie.txt");
        File tempFile = new File(filePath + "myTempMovieFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = movie.getTitle() + "|" + movie.getMovieType() + "|" + movie.getRating() + "|" +
                movie.getActingRating() + "|" + movie.getVisualsRating() + "|" + movie.getScriptRating() + "|" +
                movie.getStoryRating() + "|" + movie.getPacingRating() + "|" + movie.getClimaxRating() + "|" + movie.getEndingRating();

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();

            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();
        tempFile.renameTo(inputFile);
    }


}
