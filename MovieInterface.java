import java.util.ArrayList;
import java.util.List;



  public class MovieInterface{
    public String descrip;
    public List<String> genretest= new ArrayList<String>();


      public String getTitle() {
        return ("Test movie");
      }
      public Integer getYear() {
        return 1999;
      }
      public List<String> getGenres(){
        return genretest;
      }
      public String getDirector() {
        return "Test Direct";
      }
      public String getDescription(){
        return "Test Descrip";
      }
      public Float getAvgVote() {
        return (float) 8.5;
      }
      
    }

