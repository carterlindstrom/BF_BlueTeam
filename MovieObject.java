// --== CS400 File Header Information ==--
// Name: irving peng
// Email: cpeng53@wisc.edu
// Team: BF
// Role: Data Wrangler
// TA: BRIANNA COCHRAN
// Lecturer: GARY DAHL
// Notes to Grader: <optional extra notes>
import java.util.List;
public class MovieObject implements MovieInterface{
  //movie objects field
  private String title;
  private String original_title;
  private Integer year;
  private List<String> genre;
  private Integer duration;
  private String country;
  private String language;
  private String director;
  private String writer;
  private String production_company;
  private String actors;
  private String description;
  private Float avg_vote;
  
  public MovieObject(String title, String original_title,Integer year,List<String> genre,Integer duration,String country,String language,
      String director,String writer,String production_company,String actors,String description,Float avg_vote) {
    this.title = title;
    this.original_title = original_title;
    this.year = year;
    this.genre = genre;
    
    
    
    this.duration = duration;
    this.country = country;
    this.language = language;
    this.director = director;
    this.writer = writer;
    this.production_company = production_company;
    this.actors = actors;
    this.description = description;
    this.avg_vote = avg_vote;
  }
  @Override
  public String getTitle() {
    
    return this.title;
  }

  @Override
  public Integer getYear() {
    return this.year;
  }

  @Override
  public List<String> getGenres() {
    // TODO Auto-generated method stub
    return this.genre;
  }

  @Override
  public String getDirector() {
    // TODO Auto-generated method stub
    return this.director;
  }

  @Override
  public String getDescription() {
    // TODO Auto-generated method stub
    return this.description;
  }

  @Override
  public Float getAvgVote() {
    // TODO Auto-generated method stub
    return this.avg_vote;
  }

  @Override
  public int compareTo(MovieInterface otherMovie) {
    // TODO Auto-generated method stub
    if(this.getAvgVote() < otherMovie.getAvgVote())
      return 1;
    if(this.getAvgVote() > otherMovie.getAvgVote())
      return -1;
    return 0;       
  }
  
  @Override
  public String toString() {
    return this.getTitle()+","+this.getYear()+","+this.getGenres()+","+this.getDirector()+","+this.getDescription()+","+this.getAvgVote();
  }


}