import java.util.ArrayList;

import acsse.csc2a.fmb.file.*;
import acsse.csc2a.fmb.model.*;

public class Main
{

	public static void main(String[] args)
	{
		OrchestrationFileHandler handle = new OrchestrationFileHandler();
		ArrayList<FireworkEntity> entities;
		entities = handle.readLayout("data/layouts/layout_1.dat");
		entities.toString();
		for(FireworkEntity entity : entities)
		{
			System.out.println(entity.toString());
		}
	}

}
