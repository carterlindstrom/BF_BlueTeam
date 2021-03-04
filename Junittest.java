

public class Junittest {
  @Test
  void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
       hashmain.main(null);
      Assert.assertEquals("elcome to the Movie Sorter program\r\n"
          + "Please enter the number of the movie to recieve more details\r\n"
          + "Or, press G to enter genre selection or R to enter Rating selection\r\n"
          + "X will exit the program\r\n"
          + "Movies:\r\n"
          + "1 title3\r\n"
          + "2 title1\r\n"
          + "3 title2\r\n", outputStreamCaptor.toString().trim());
  }