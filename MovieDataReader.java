// --== CS400 File Header Information ==--
// Name: irving peng
// Email: cpeng53@wisc.edu
// Team: BF
// Role: Data Wrangler
// TA: BRIANNA COCHRAN
// Lecturer: GARY DAHL
// Notes to Grader: <optional extra notes>
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.List;
public class MovieDataReader implements MovieDataReaderInterface {
  
  private List<MovieInterface> movieList;
  
  public MovieDataReader() {
    movieList = new ArrayList<MovieInterface>();
  } 
  @Override
  public List<MovieInterface> readDataSet(Reader inputFileReader) throws IOException, DataFormatException {
    // TODO Auto-generated method stub
    Reader reader = inputFileReader;
    int data = reader.read();
    
    //fields of a movieObject
    String title;
    String original_title;
    Integer year;
    //geners
    List<String> genre;
    String genres;//string representation of genres
    Integer duration;
    String country;
    String language;
    String director;
    String writer;
    String production_company;
    String actors;
    String description;
    Float avg_vote; 
    //helping variables
    HashTableMap<Integer, String> hashtable = new HashTableMap<Integer, String>();
    String thisString = "";
    int counter = 0;
    int currentData = 0;
    int lineNumber = 0;
    //iterate through all the file
    while(data != -1) {
      //System.out.println("looping!!!");
      if(lineNumber == 0) {
        while(data!=10) {
          //System.out.println("looping in the first line");
          data = reader.read();
        }
        lineNumber++;
        data = reader.read();
        //data = reader.read();
        continue;
      }
      //iterate this line
      while(data != 10) {
        //System.out.println("enter second loop");
        if(data == 34) {
          /////////////////modified
          data = reader.read();
          currentData = data;
          while(1==1) {
            if(data == 34) {
              currentData = data;
              data = reader.read();
              if(data == 44) {
                break;
              }
              thisString += (char)currentData;
              continue;
            }
            thisString += (char)data;
            data = reader.read();
          }
          /////modified
          hashtable.put(counter, thisString);
          //System.out.println(counter+" : "+thisString);
          counter++;
          thisString = "";
          data = reader.read();
          //data = reader.read();
        }
      

        else{
          if(data == 44) {
          //genres
          
          
          hashtable.put(counter,thisString);
          //System.out.println(counter+" : "+thisString);
          data = reader.read();
          counter++;
          thisString="";
          continue;
            
          }
          thisString+=(char)data;
          data = reader.read();
        }
      }
      //end of a line
      if(counter != 12) {
        System.out.println("counter: "+counter);
        throw new DataFormatException("the cloumns are not right");
      }
      hashtable.put(counter, thisString);
      //hashtable.print();
      title = (String)hashtable.get(0);
      original_title = (String)hashtable.get(1);
      year = Integer.valueOf(hashtable.get(2));
      //getting the list of genre
      genres = (String)hashtable.get(3);
      genre = Arrays.asList(genres.split(","));
      duration = Integer.valueOf(hashtable.get(4));
      country = (String)hashtable.get(5);
      language = (String)hashtable.get(6);
      director = (String)hashtable.get(7);
      writer = (String)hashtable.get(8);
      production_company = (String)hashtable.get(9);
      actors = (String)hashtable.get(10);
      description = (String)hashtable.get(11);
      avg_vote = Float.valueOf(hashtable.get(12));
      this.movieList.add(new MovieObject(title, original_title, year, genre, duration, country, language,
           director, writer, production_company, actors, description, avg_vote));
      //initialize all helping variables, and move on to next line
      counter = 0;
      thisString = "";
      data = reader.read();
      //data = reader.read();
      hashtable.clear();
    }
    return movieList;
  }
  
  
  
  

  public static void main(String[] args) throws DataFormatException  {
    FileReader fr;
    try {
      
      fr = new FileReader("movies.csv");
      
  
      MovieDataReader movieReader = new MovieDataReader();
      List<MovieInterface> movies = movieReader.readDataSet(fr);
      for(int i = 0; i < movies.size(); i++) {
        MovieInterface thisMovie = movies.get(i);
        System.out.println("title: "+thisMovie.getTitle()+"///  description: "+thisMovie.getDescription()+"///   average vate: "+thisMovie.getAvgVote());
      }
      
      
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch blocka
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 
  }
  
  public static MapADT testLine(FileReader inputReader) throws IOException, DataFormatException { 
    FileReader reader = inputReader;
    int counter = 0;
    String thisString = "";
    int data = reader.read();
    List<String> genre = new ArrayList<String>();
    HashTableMap hashtable = new HashTableMap();
    
    while(data != 13) {
      if(data == 34) {
        data = reader.read();
        while(data != 34) {
          thisString += (char)data;
          data = reader.read();
        }
        genre =  Arrays.asList(thisString.split(","));
        hashtable.put(counter, thisString);
        counter++;
        thisString = "";
        data = reader.read();
        data = reader.read();
      }
    

      else{
        if(data == 44) {
        //genres
        
        
        hashtable.put(counter,thisString);
        data = reader.read();
        counter++;
        thisString="";
        continue;
          
        }
        thisString+=(char)data;
        data = reader.read();
      }
    }
    hashtable.put(counter, thisString);
    reader.close();
    return hashtable;
  }

}