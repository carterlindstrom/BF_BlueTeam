run: compile
  
        java hashmain


compile: hashmain.java

        javac *.java

test: testData testBackend testFrontend

testFrontend: compile

testBackend: compile
         
testData: compile
         
        java TestMovieAndMovieDataReader
clean:
        $(RM) *.class
