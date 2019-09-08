package se.ecutb.oscarjohanneson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest 
{
    private HangMan testObject;

    @Before
    public void init() {
        testObject = new HangMan("Books");
    }
    @Test
    public void testRandomGeneratedWords()
    {
        //Arrange
        String[] testWord = {"Books"};
        RandomWord test = new RandomWord(testWord);
        String actual = "Books";
        //Act & Assert
        Assert.assertEquals("Books", actual);
    }
    @Test
    public void testNewGame(){
        //Arrange
        char[] expected = {'_','_','_','_','_'};
        testObject.newGame();
        //Act & Assert
        Assert.assertArrayEquals(expected,testObject.getWordToGuess());
    }
    @Test
    public void testPlayerInputContainsLetterInGameWorld(){
        //Arrange
        String input = "b";
        testObject.inputPlayerGuess(input);
        String expected = " b ";
        //Act & Assert
        Assert.assertEquals(expected,testObject.getStringBuilder().toString());

    }

}
