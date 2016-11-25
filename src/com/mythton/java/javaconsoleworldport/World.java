package com.mythton.java.javaconsoleworldport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class World
{
	public String				worldMapPath	= "/maps";
	public String				worldMapName	= "default.txt";
	private ArrayList<char[]>	mapList			= new ArrayList<char[]>();
	private Tile[][]			map;
	private short mapXLength = -1;
	private short mapYLength = -1;

	public short				playerX, playerY;

	public World(String mapPath, String mapName)
	{
		if (mapPath != null) worldMapPath = mapPath;
		if (mapName != null) worldMapName = mapName;
		playerX = 0;
		playerY = 0;
		try
		{
			String mapLine = null;
			String path = Paths.get("").toAbsolutePath().toString() + worldMapPath;
			// System.out.println("Creating world \"" + worldMapName + " from "
			// + path + "\n");
			FileReader reader = new FileReader(new File(path, worldMapName));

			BufferedReader buffer = new BufferedReader(reader);

			mapLine = buffer.readLine();
			while (mapLine != null)
			{
//				System.out.println(mapLine);
				mapList.add(mapLine.toCharArray());
				mapXLength++;
				mapLine = buffer.readLine();
			}
			System.out.println("mapXLength: " + mapXLength + "\nmapYLength: " + mapList.size() + "\n");

			reader.close();
			buffer.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		/*System.out.println("\n\n");
		for (char[] ca : mapList)
		{
			for (int i = 0; i < ca.length; i++)
			{
				System.out.print(ca[i]);
			}
			System.out.println();
		}*/
		//	TODO: Figure out map length discrepancy
		map = new Tile[mapList.size()][mapXLength];
		for (int x = 0; x < map[0].length; x++)
		{
			for (int y = 0; y < map[1].length; y++)
			{
				try
				{
					Tile newTile = new Tile(mapList.get(y)[x]);
					if (newTile.getType().toString().equalsIgnoreCase("player"))
					{
						playerX = (short) x;
						playerY = (short) y;
					}
					map[x][y] = newTile;
				}
				catch (Exception e)
				{
					e.printStackTrace();
					//System.out.println("Error occurred in World constructor:\n\tX = " + x + ", Y = " + y);
				}
			}
		}
	}

	public void RenderMap()
	{
		boolean error = false;
		for (int y = 0; y < map[0].length; y++)
		{
			for (int x = 0; x < map[1].length; x++)
			{
				try
				{
					Tile t = map[x][y];
					System.out.print(t.getRenderCode());
				}
				catch (Exception e)
				{
					System.out.println("\n\nError occurred in RenderMap:\n\tX = " + x + ", Y = " + y);
					error = true;
				}
				if (error)
					break;
			}
			if (error)
				break;
			System.out.println("");
		}
	}

}
