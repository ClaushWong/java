package MiniLibrary;

import java.util.ArrayList;

public class CSVTest 
{
    public ArrayList<ArrayList<String>> CSV_Derived(String data)
    {
        ArrayList<ArrayList<String>> full_data = new ArrayList();
        ArrayList<String> part_data = new ArrayList();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0 ; i < data.length(); i++)
        {
            if (data.charAt(i) != '\n')
            {
                if (data.charAt(i) != ',')
                {
                    sb.append(data.charAt(i));
                }
                else
                {
                    part_data.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            else
            {
                {
                    part_data.add(sb.toString());
                    sb = new StringBuilder();
                }
                full_data.add(part_data);
                part_data = new ArrayList();
            }
            
            if (i == data.length() -1)
            {
                part_data.add(sb.toString());
                full_data.add(part_data);
            }
            
        }
        
        return full_data;
    }
}
