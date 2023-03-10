import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Show {
    private String title;
    private String showType;

    private double rating;
    private double actingRating;
    private double visualsRating;
    private double scriptRating;
    private double storyRating;
    private double pacingRating;
    private double climaxRating;
    private double endingRating;

    private int seasons;
    private int episodes;

    private static final String filePath = "/Users/holdenbourg/Desktop/Holden's Projects/Film Filtration System/FFS Data/";


    //TODO constructors
    public Show(String title, String showType, double rating, double acting, double visuals, double script, double story, double pacing, double climax, double ending, int seasons, int episodes){
        this.title = title;
        this.showType = showType;
        this.rating = rating;
        this.scriptRating = script;
        this.actingRating = acting;
        this.storyRating = story;
        this.visualsRating = visuals;
        this.pacingRating = pacing;
        this.climaxRating = climax;
        this.endingRating = ending;
        this.seasons = seasons;
        this.episodes = episodes;
    }


    //TODO getters/setters
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getShowType() {return showType;}
    public void setShowType(String showType) {this.showType = showType;}

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

    public int getSeasons() {return seasons;}
    public void setSeasons(int seasons) {this.seasons = seasons;}

    public int getEpisodes() {return episodes;}
    public void setEpisodes(int episodes) {this.episodes = episodes;}


    //TODO class methods
    public static void findBestRatedShow() throws FileNotFoundException {
        double highestRating = 0.0;

        for (int i = 0; i < readShowsFromFile().size(); i++){
            Show currentShow = readShowsFromFile().get(i);

            if (currentShow.getRating() > highestRating){
                highestRating = currentShow.getRating();
            }
        }

        for (int i = 0; i < readShowsFromFile().size(); i++){
            Show currentShow = readShowsFromFile().get(i);

            if (currentShow.getRating() == highestRating) {
                System.out.println("Title: " + currentShow.getTitle() + " - Rating: " + currentShow.getRating());
            }
        }
    }
    public static void findShowWithRating(double rating) throws FileNotFoundException {
        System.out.println("All shows with a " + rating + " rating:\n");

        for (int i = 0; i < readShowsFromFile().size(); i++){
            Show currentShow = readShowsFromFile().get(i);

            if (currentShow.getRating() == rating) {
                System.out.println(currentShow.getTitle() + "seasons/episodes: " + currentShow.getSeasons() + "/" + currentShow.getEpisodes());
            }
        }
    }
    public static void findShowWithRatingOrHigher(double rating) throws FileNotFoundException {
        System.out.println("All movies with a " + rating + " rating or higher:\n");
        System.out.println("Title | Rating | Seasons/Episodes");

        for (int i = 0; i < readShowsFromFile().size(); i++){
            Show currentShow = readShowsFromFile().get(i);

            if (currentShow.getRating() >= rating){
                System.out.println(currentShow.getTitle() + " | " + currentShow.getRating() + " | " + currentShow.getSeasons() + "/" + currentShow.getEpisodes());
            }
        }
    }
    public static void findShowWithFilmType(String filmType) throws FileNotFoundException {
        System.out.println("Show Type: " + filmType);
        System.out.println("Title | Rating | Seasons/Episodes");

        for (int i = 0; i < readShowsFromFile().size(); i++){
            Show currentShow = readShowsFromFile().get(i);

            if (currentShow.getShowType().equalsIgnoreCase(filmType)){
                System.out.println(currentShow.getTitle() + " | " + currentShow.getRating() + " | " + currentShow.getSeasons() + "/" + currentShow.getEpisodes());
            }
        }
    }
    public static void findBestRatedShowType(String filmType) throws FileNotFoundException {
        System.out.println("Best rated show(s) from:" + filmType);
        System.out.println("Title | Rating | Seasons/Episodes");

        double bestRating = 0.0;

        for (int i = 0; i < readShowsFromFile().size(); i++){
            Show currentShow = readShowsFromFile().get(i);

            if (currentShow.getShowType().equalsIgnoreCase(filmType) && currentShow.getRating() >= bestRating){
                bestRating = currentShow.getRating();
            }
        }

        for (int i = 0; i < readShowsFromFile().size(); i++){
            Show currentShow = readShowsFromFile().get(i);

            if (currentShow.getRating() == bestRating){
                System.out.println(currentShow.getTitle() + " | " + currentShow.getRating() + " | " + currentShow.getSeasons() + "/" + currentShow.getEpisodes());
            }
        }
    }
    public static void findShowsWithSeasons(int seasons) throws FileNotFoundException {
        System.out.println("Shows with " + seasons + " seasons: \n");
        System.out.println("Title | Rating | Episodes");

        for (int i = 0; i < readShowsFromFile().size(); i++){
            Show currentShow = readShowsFromFile().get(i);

            if (currentShow.getSeasons() >= seasons){
                System.out.println(currentShow.getTitle() + " | " + currentShow.getRating() + " | " + currentShow.getEpisodes());
            }
        }
    }
    public static void printShows() throws FileNotFoundException {
        System.out.println("All Shows: \n");
        System.out.println("Title | Rating | Seasons/Episodes");

        for (int i = 0; i < readShowsFromFile().size(); i++){
            Show currentShow = readShowsFromFile().get(i);

            System.out.println(currentShow.getTitle() + " | " + currentShow.getRating() + " | " + currentShow.getSeasons() + "/" + currentShow.getEpisodes());
        }
    }

    public static boolean findShow (String show) throws FileNotFoundException {
        for (int i = 0; i < readShowsFromFile().size(); i++){
            Show currentShow = readShowsFromFile().get(i);

            if (currentShow.getTitle().equalsIgnoreCase(show)){
                return true;
            }
        }

        return false;
    }
    public static void findAndDeleteShow(String show) throws IOException {
        for (int i = 0; i < readShowsFromFile().size(); i++){
            Show currentShow = readShowsFromFile().get(i);

            if (show.equalsIgnoreCase(currentShow.getTitle())){
                deleteShow(currentShow);
            }
        }
    }


    //TODO read/write/delete
    public static void writeShowToFile(Show show) throws IOException {
        String outputText = show.getTitle() + "|" + show.getShowType().toString() + "|" + show.getRating() + "|" +
                show.getActingRating() + "|" + show.getVisualsRating() + "|" + show.getScriptRating() + "|" +
                show.getStoryRating() + "|" + show.getPacingRating() + "|" + show.getClimaxRating() + "|" +
                show.getEndingRating() + "|" + show.getSeasons() + "|" + show.getEpisodes();

        String path = filePath + "show.txt";
        File file = new File(path);

        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(outputText);
        pw.close();
    }
    public static ArrayList<Show> readShowsFromFile() throws FileNotFoundException {

        String path = filePath + "show.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        ArrayList<Show> showList = new ArrayList<>();

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            String[] properties = line.split("\\|");

            String showTitle = properties[0];
            String showType = properties[1];
            double rating = Double.parseDouble(properties[2]);
            double actingRating = Double.parseDouble(properties[3]);
            double visualsRating = Double.parseDouble(properties[4]);
            double scriptRating = Double.parseDouble(properties[5]);
            double storyRating = Double.parseDouble(properties[6]);
            double pacingRating = Double.parseDouble(properties[7]);
            double climaxRating = Double.parseDouble(properties[8]);
            double endingRating = Double.parseDouble(properties[9]);
            int seasons = Integer.parseInt(properties[10]);
            int episodes = Integer.parseInt(properties[11]);

            Show show = new Show(showTitle, showType, rating, actingRating, visualsRating, scriptRating, storyRating, pacingRating, climaxRating, endingRating, seasons, episodes);
            showList.add(show);
        }
        return showList;
    }
    public static void deleteShow(Show show) throws IOException {
        File inputFile = new File(filePath + "show.txt");
        File tempFile = new File(filePath + "myTempShowFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = show.getTitle() + "|" + show.getShowType().toString() + "|" + show.getRating() + "|" +
                show.getActingRating() + "|" + show.getVisualsRating() + "|" + show.getScriptRating() + "|" +
                show.getStoryRating() + "|" + show.getPacingRating() + "|" + show.getClimaxRating() + "|" +
                show.getEndingRating() + "|" + show.getSeasons() + "|" + show.getEpisodes();
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
