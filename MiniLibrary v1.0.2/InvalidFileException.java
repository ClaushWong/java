package MiniLibrary;

public class InvalidFileException extends Exception
{
    String file_path;
    
    public InvalidFileException(String file)
    {
        file_path = file;
    }
    
    @Override
    public String toString()
    {
        return "Invalid file format for file : " + file_path +"\n"
                + "Must use .csv file.";
    }
}
