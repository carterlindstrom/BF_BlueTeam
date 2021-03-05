// --== CS400 File Header Information ==--
// Name:Eagan Kutz
// Email: ejkutz@wisc.edu
// Team: BF Blue
// Role: Front End
// TA: Brianna Cochran
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;


public class hashmain {//starts the program and fills the average ratings
  static HashTableMap<Integer, Integer> TestTable= new HashTableMap<Integer, Integer>(10);
  int lengthlist;

  static BackendInterface testback;//Insert file path here
  static Scanner scnn = new Scanner(System.in);
  public static void main(String[] args) {
    try {
      testback=new Backend("Movies.csv");
    } catch (FileNotFoundException e) {
      System.out.print("file not found");
    }//Insert file path here
    
    testback.addAvgRating("10");
    testback.addAvgRating("9");
    testback.addAvgRating("8");
    testback.addAvgRating("7");
    testback.addAvgRating("6");
    testback.addAvgRating("5");
    testback.addAvgRating("4");
    testback.addAvgRating("3");
    testback.addAvgRating("2");
    testback.addAvgRating("1");
    testback.addAvgRating("0");
    List<String> list2= testback.getAllGenres();
    for (int x=0; x< list2.size();x++)
    {
      testback.addGenre(list2.get(x));
    }
    printList();
    
   }
  
    public static void printList() {//Writes the three movies and explains how to use the program

      //clearScreen();
    List<MovieInterface> list= testback.getThreeMovies(0);
    System.out.println(list.toString());
    
    System.out.println("Welcome to the Movie Sorter program");
    System.out.println("Please enter the number of the movie to recieve more details");
    System.out.println("Or, press G to enter genre selection or R to enter Rating selection");
    System.out.println("X will exit the program");
      System.out.println("Movies:");
      for (int x=0; x< list.size();x++)
      {
        if(list.get(x)!=null)
          System.out.println(x+1 + " " + list.get(x).getTitle());
          
      }
      String input = scnn.nextLine();
      if (input.equals("x")||input.equals("X")) {
        return;
      }
      else if (input.equals("g")||input.equals("G")) {
        changeGenre();
      }
      else if (input.equals("r")||input.equals("R")) {
        changeRating();
      }
      else if (list.get(0)!=null&&(input.equals("1")||input.equals("One")||input.equals("one"))) {
        displayMovie(list.get(0));
      }
      else if (list.get(1)!=null&&(input.equals("2")||input.equals("two")||input.equals("Two"))) {
        displayMovie(list.get(1));
      }
      else if (list.get(2)!=null&&(input.equals("3")||input.equals("Three")||input.equals("three"))) {
        displayMovie(list.get(2));
      }
    }
    
    public static void changeGenre() {//Displays all generes and genres that are and are not included, asks user for imput, input switches the positions
     // clearScreen();
      int lengthlist=0;
      double inputnum=0;
      List<String> list1= testback.getGenres();
    List<String> list2= testback.getAllGenres();
    System.out.println(list2.toString());
    List<String> list3= new ArrayList<String>();
    System.out.println("Please press the number of a genre ");
    System.out.println("If it is curenttly being used it will be removed. If it is not it will be added.");
    System.out.println("X will display top 3 movies that match criteria again");
      System.out.println("Genres:");
      for (int x=0; x< list2.size();x++)
      {
        boolean pass=true;
          for(int y=0; y<list1.size();y++)
            if(list1.get(y).equals(list2.get(x))) {
              pass=false;
              break;
            }
          if (pass)
           list3.add(list2.get(x));
          
      }
      System.out.println("Genres currently being sorted ");
      for (int x=0; x< list1.size();x++)
      {
          System.out.println(x+1 + " Genre:" + list1.get(x));
          lengthlist=x+1;
      }
      System.out.println("Genres not included ");
      for (int x=0; x< list3.size();x++)
      {
          System.out.println(x+1+lengthlist + " Genre:" + list3.get(x));
      }
      String input = scnn.nextLine();
      if (input.equals("x")||input.equals("X")) {
        printList();
      }
      else {
      try {
        inputnum = Integer.parseInt(input);
    } catch (NumberFormatException nfe) {
      System.out.println("Improper input, try again.");
      changeRating();
    }
      if (inputnum-1 >= list2.size()||inputnum-1 <0) {
        System.out.println("Improper input, try again.");
        changeGenre();
      }
       
      else if (inputnum-1 < lengthlist) {
        System.out.println("Removing "+ list1.get((int) (inputnum-1)));
        testback.removeGenre(list1.get((int) (inputnum-1)));
        changeGenre();
        
      }
      else if (inputnum-1 >= lengthlist) {
        System.out.println("Adding "+ list3.get((int) (inputnum-1-lengthlist)));
        testback.addGenre(list3.get((int) (inputnum-1-lengthlist)));
        changeGenre();
      }
      }
    }
    public static void changeRating() {//Displays all ratings and Ratings that are and are not included, asks user for imput, input switches the positions
      int lengthlist=0;
      double inputnum=0;
      List<String> list1= testback.getAvgRatings();
    List<String> list2= new ArrayList<String>();
    list2.add("0");
    list2.add("1");
    list2.add("2");
    list2.add("3");
    list2.add("4");
    list2.add("5");
    list2.add("6");
    list2.add("7");
    list2.add("8");
    list2.add("9");
    list2.add("10");
    List<String> list3= new ArrayList<String>();
    System.out.println("Please press the number of rating to add ");
    System.out.println("If it is curenttly being used it will be removed. If it is not it will be added.");
    System.out.println("X will display top 3 movies that match criteria again");
      System.out.println("Average Ratings:");
      for (int x=0; x< list2.size();x++)
      {
        boolean pass=true;
          for(int y=0; y<list1.size();y++)
            if(list1.get(y).equals(list2.get(x))) {
              pass=false;
              break;
            }
          if (pass)
           list3.add(list2.get(x));
          
      }
      System.out.println("Ratings currently being sorted ");
      for (int x=0; x< list1.size();x++)
      {
          System.out.println(x+1 + " Rating:" + list1.get(x));
          lengthlist=x+1;
      }
      System.out.println("Ratings not included ");
      for (int x=0; x< list3.size();x++)
      {
          System.out.println(x+1+lengthlist + " Rating:" + list3.get(x));
      }
      String input = scnn.nextLine();
      if (input.equals("x")||input.equals("X")) {
        printList();
      }
      else {
      try {
        inputnum = Integer.parseInt(input);
    } catch (NumberFormatException nfe) {
      System.out.println("Improper input, try again.lol");
      changeRating();
    }
      if (inputnum-1 > list2.size()||inputnum-1 <0) {
        System.out.println("Improper input, try again.");
        changeRating();
      }
       
      else if (inputnum-1 < lengthlist) {
        System.out.println("Removing "+ list1.get((int) (inputnum-1)));
        testback.removeAvgRating(list1.get((int) (inputnum-1)));
        changeRating();
        
      }
      else if (inputnum-1 >= lengthlist) {
        System.out.println("Removing "+ list3.get((int) (inputnum-1-lengthlist)));
        testback.addAvgRating(list3.get((int) (inputnum-1)-lengthlist));
        changeRating();
      }
      }
    }
      
    public static void displayMovie(MovieInterface movie) {//Displays the movie and their internals.
      //clearScreen();
      List<String> list1= movie.getGenres();
      System.out.println("The movie title is: " + movie.getTitle());
      System.out.println("genres: ");
      for (int x=0; x< list1.size();x++)
      {
        System.out.println(list1.get(x));
      }
      System.out.println("It was made in: " + movie.getYear());
      System.out.println("The Avg Rating is: " + movie.getAvgVote());
      System.out.println("It was directed by: " + movie.getDirector());
      System.out.println("Press any key to go back ");
      String input = scnn.nextLine();
      printList();
      
    }

      
      
  }

