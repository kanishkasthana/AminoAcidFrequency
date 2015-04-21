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
            
            String aminoAcids="ACDEFGHIKLMNPQRSTVWY";
            System.out.println(aminoAcids.length());
            
            for(int i=0;i<proteinSequences.size();i++){
                String protein=proteinSequences.get(i);
            
                Map <Character,Double>AminoFrequencies=new <Character,Double> HashMap();
                //Initializing HashMap
                for(int j=0;j<aminoAcids.length();j++){
                   AminoFrequencies.put(aminoAcids.charAt(j), 0.0);
                }
                
                //Calculating Counts;
                for(int k=0;k<protein.length();k++){
                    Double oldValue=AminoFrequencies.get(protein.charAt(k));
                    AminoFrequencies.put(protein.charAt(k), oldValue+1);
                }
                
                //Calculating Frequencies
                for(int k=0;k<aminoAcids.length();k++){
                    Double newValue=AminoFrequencies.get(aminoAcids.charAt(k))/protein.length();
                    //Rounding to two decimal places for output
                    newValue=Math.round(newValue*1000.0)/1000.0;
                    AminoFrequencies.put(aminoAcids.charAt(k), newValue);
                    
                }
                
                //Printing output                
                out.print(proteinNames.get(i)+" ");                
                for(int j=0;j<aminoAcids.length();j++){
                    out.print(AminoFrequencies.get(aminoAcids.charAt(j)));
                    out.print(" ");
                }
                //Line Break
                if(i<proteinSequences.size()-1)
                    out.println("");
            }
            
            
            out.close();
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
        
    }
    
}
