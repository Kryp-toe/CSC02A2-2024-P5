package acsse.csc2a.fmb.file;

import java.io.*;
import java.util.ArrayList;
import acsse.csc2a.fmb.model.*;

public class OrchestrationFileHandler
{
	private ArrayList<FireworkEntity> entities= new ArrayList<FireworkEntity>(); 
	
	public OrchestrationFileHandler() 
	{
	}
	
	public ArrayList<FireworkEntity> readLayout(String filename)
	{
		// Data stream with ARM
		try(FileInputStream fin = new FileInputStream(filename);
				BufferedInputStream bufIn = new BufferedInputStream(fin);
				DataInputStream dataIn = new DataInputStream(bufIn);)
		{
			// Read data types
			String FD_ID = dataIn.readUTF();
			String F_ID;
			int X_Locaion;
			double Angle;
			
			while(dataIn.available() != 0)
			{
				F_ID = dataIn.readUTF();
				X_Locaion = dataIn.readInt();
				Angle = dataIn.readDouble();
				
				//Create Firework 
				//Create DisplayFileHnlder to get FireworkDisplay from file
				DisplayFileHandler handler = new DisplayFileHandler();
				
				//Create firework display from file 
				FireworkDisplay fireworkdisplay = handler.readDisplay("data/displays/FD0001.txt");
				
				FireworkEntity entity = null;
				
				//Create firework
				if(F_ID.startsWith("FF"))
				{
					FountainFirework firework_f = (FountainFirework) fireworkdisplay.getFirework(F_ID);
					entity = new FireworkEntity(X_Locaion,Angle, firework_f);
				}
				
				//Create firework
				if(F_ID.startsWith("FR"))
				{
					RocketFirework firework_r = (RocketFirework) fireworkdisplay.getFirework(F_ID);
					entity = new FireworkEntity(X_Locaion,Angle, firework_r);
				}
				
				//Create FireworkEntity 
				this.entities.add(entity);
			}
			System.out.println("----------------------------------------------------------------------------------------\n"
							 + "                                    DONE READING FILE                                   \n"
							 + "----------------------------------------------------------------------------------------");
		}catch (EOFException ex)
		{
			System.err.println("End of file");
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return this.entities;
	}
}
