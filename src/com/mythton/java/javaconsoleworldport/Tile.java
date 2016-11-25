package com.mythton.java.javaconsoleworldport;

public class Tile
{
	public enum TileType
	{
		EMPTY(byCode(' ')), WALL(byCode('X')), INVALID(byCode('~')), ITEM(byCode('I'));

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
				case 'I':
					return ITEM;
			}
			return INVALID;
		}

		@Override
		public String toString()
		{
			switch (type)
			{
				case EMPTY:
					return "empty";
				case WALL:
					return "wall";
				case ITEM:
					return "item";
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

}
