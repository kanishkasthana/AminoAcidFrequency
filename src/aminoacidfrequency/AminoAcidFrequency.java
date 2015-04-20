/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aminoacidfrequency;

import java.io.*;
import java.util.*;

/**
 *
 * @author Kanishk Asthana kasthana@eng.ucsd.edu
 */
public class AminoAcidFrequency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            System.out.println(System.getProperty("user.dir"));
            PrintWriter out= new PrintWriter(new FileWriter("AminoAcidFrequencies.txt"));
            List<String> inputs= new <String>ArrayList();
            File newFile=new File("yeast_aaseqs.txt");
            FileReader fileReader=new FileReader(newFile);
            BufferedReader reader=new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
             inputs.add(line);
            }
            
            int count=0;
            List <String>proteinNames=new <String>ArrayList();
            List <String>proteinSequences=new <String>ArrayList();
            
            StringBuilder sequence=new StringBuilder();
            System.out.println(inputs.get(0));
            for(int i=0;i<inputs.size();i++){
                if(inputs.get(i).charAt(0)=='>'){
                    
                    proteinNames.add(inputs.get(i).substring(1));
                    if(!sequence.toString().isEmpty()){
                        proteinSequences.add(sequence.toString());
                    }
                    
                    sequence=new StringBuilder();
                }
                else
                    sequence.append(inputs.get(i));
            }            
            
            //Adding Last sequence
            if(!sequence.toString().isEmpty()){
                proteinSequences.add(sequence.toString());
            }
            
            System.out.println(proteinNames.size());
            System.out.println(proteinSequences.size());
            
            for(int i=0;i<proteinNames.size();i++){
                System.out.println(proteinNames.get(i));
                System.out.println(proteinSequences.get(i));
            }
            /*
            System.out.println(proteinNames.get(10));
            System.out.println(proteinNames.size());
            System.out.println(proteinSequences.get(10));
            */
            
            out.close();
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
        
    }
    
}
