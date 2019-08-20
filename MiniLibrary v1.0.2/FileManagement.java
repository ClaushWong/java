package MiniLibrary;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileManagement 
{
    public String GetFileAddress() throws InvalidFileException
    {
        JFileChooser j = new JFileChooser("C:\\Users\\Acer\\Desktop\\");
        int r = j.showOpenDialog(null); 
        
        String path = "";
        
        if (r == JFileChooser.APPROVE_OPTION)
        { 
            path = (j.getSelectedFile().getAbsolutePath()); 
        }
        else
        {
            path = "null";
        }
        
        if ( !(path.equalsIgnoreCase("null")) &&
                !(path.substring(path.lastIndexOf('.')+1, path.length()).equalsIgnoreCase("csv")))
        {
            throw new InvalidFileException(path);
        }
        
        return path;
    }
    
    public String GetData(MainWindow3 mw3, String path) 
            throws FileNotFoundException, IOException
    {
        if (path.equalsIgnoreCase("null"))
        {
            JOptionPane.showMessageDialog(mw3, "No File chosen.");
            return path;
        }
        FileReader fr = new FileReader(path);
        StringBuilder sb = new StringBuilder();
        int ascii_value;
        
        while ((ascii_value = fr.read()) != -1)
        {
            sb.append((char)ascii_value);
        }
        return sb.toString();
    }
    
    public void Store_Data(String path, ArrayList<ArrayList<String>> list) 
            throws FileNotFoundException, IOException
    {
        DataOutputStream dout = new DataOutputStream(new FileOutputStream(path));

        for (int element_index = 0 ; element_index < list.size(); element_index++)
        {
            for (int string_index = 0; string_index < list.get(element_index).size()
                    ; string_index++)
            {
                for (int character_index = 0; 
                        character_index < list.get(element_index).get(string_index).length();
                        character_index++)
                {
                    dout.write(list.get(element_index).get(string_index).charAt(character_index));
                }
                
                if (!(string_index == list.get(element_index).size()-1))
                {
                    dout.write(',');
                }
            }
            if (!(element_index == list.size()-1))
            {
                dout.write('\n');
            }
        }
        dout.close();
    }
}
