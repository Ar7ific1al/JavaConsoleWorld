package com.mythton.java.javaconsoleworldport;

public class Tile
{
	public enum TileType
	{
		EMPTY(byCode(' ')), WALL(byCode('X')), INVALID(byCode('~')), ITEM(byCode('#')), PLAYER(byCode('S')),;

		@SuppressWarnings("unused")
		private final TileType type;

		private TileType(TileType type)
		{
			this.type = type;
		}

		public static TileType byCode(char c)
		{
			switch (c)
			{
				case ' ':
					return EMPTY;
				case 'X':
					return WALL;
				case '#':
					return ITEM;
				case 'S':
					return PLAYER;
				default:
					return INVALID;
			}
		}

		@Override
		public String toString()
		{
			switch (this)
			{
				case EMPTY:
					return "empty";
				case WALL:
					return "wall";
				case ITEM:
					return "item";
				case PLAYER:
					return "player";
				default:
					return "invalid";
			}
		}
	}

	private TileType type;

	public Tile(char c)
	{
		this.type = TileType.byCode(c);
	}

	public TileType getType()
	{
		return this.type;
	}

	public void setType(char c)
	{
		this.type = TileType.byCode(c);
	}
	
	public char getRenderCode()
	{
		switch (type)
		{
			case EMPTY:
				return ' ';
			case WALL:
				return 'X';
			case ITEM:
				return '#';
			case PLAYER:
				return 'O';
			default:
				return '~';
		}
	}

}
