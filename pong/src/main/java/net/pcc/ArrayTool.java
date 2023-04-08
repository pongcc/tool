package net.pcc;

public class ArrayTool
{
	public static int[][] rotate2DArray(int[][] box, int rotate)
	{
		rotate %= 4;
		if (rotate < 0)
			rotate += 4;
		if (rotate == 0)
			return box;

		if (box.length == 0 || box[0].length == 0)
			throw new IllegalArgumentException("array is empty");


		int[][] cbox = null;
		if (rotate == 1 || rotate == 3) // rotate
		{
			cbox = new int[box[0].length][box.length];
			for (int y = 0; y < box.length; y++)
			{
				for (int x = 0; x < box[y].length; x++)
				{
					if (rotate == 1)
						cbox[x][box.length - y - 1] = box[y][x];
					else
						cbox[box[y].length - x - 1][y] = box[y][x];
				}
			}
		}
		else if (rotate == 2)
		{
			cbox = new int[box.length][box[0].length];
			for (int y = 0; y < box.length; y++)
			{
				for (int x = 0; x < box[y].length; x++)
				{
					cbox[y][x] = box[box.length - y - 1][box[y].length - x - 1];
				}
			}
		}

		return cbox;
	}
}
