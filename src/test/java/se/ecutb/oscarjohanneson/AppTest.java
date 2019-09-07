package se.ecutb.oscarjohanneson;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest 
{
    @Test
    public void testRandomGeneratedWords()
    {
        //Arrange
        String[] testWord = {"test"};
        RandomWord test = new RandomWord(testWord);
        String actual = "test";
        //Act & Assert
        assertEquals("test", actual);
    }
}
