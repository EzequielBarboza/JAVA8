package teste.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @user ezequiel
 * @since 5 de ago de 2016
 */
public class Main
{
	/**
	 * @user ezequiel
	 * @since 5 de ago de 2016
	 */
	private static class HotelReview
	{
		int id;
		String[] words;
		
		@Override
		public String toString()
		{
			return "id: "  + id + "words: " + Arrays.toString(words);
		}
		
		
	}

	private static class TheInput
	{
		int numberOfReviews;
		String[] clientWords;
		List<HotelReview> reviews = new ArrayList<>();

		@Override
		public String toString()
		{
			return "number of reviews: " + numberOfReviews + "\n client words: " + Arrays.toString(clientWords) + "\n reviews "
					+ reviews.toString();

		}
	}

	public static void main(String[] args) throws IOException
	{
		
		TheInput theInput = readInput();

		
		
		System.out.println(theInput.toString());
		
		for (HotelReview ht : theInput.reviews)
		{
			
			System.out.println(ht);
			
		}
		
	}

	private static TheInput readInput() throws IOException
	{
		BufferedReader br = null;
		final TheInput theInput = new TheInput();
		try
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			int lineC = 1;
			while (true)
			{
				line = br.readLine();
				if (line == null || line == "")
				{
					break;
				}
				line = line.trim();
				if (lineC == 1)
				{
					theInput.clientWords = line.split(" ");
				}
				else if (lineC == 2)
				{
					theInput.numberOfReviews = Integer.parseInt(line.trim());
				}
				else
				{
					if (lineC % 2 != 0)
					{
						HotelReview hotelReview = new HotelReview();
						hotelReview.id = Integer.parseInt(line);
						theInput.reviews.add(hotelReview);
					}
					else
					{
						int size = theInput.reviews.size();
						theInput.reviews.get(size - 1).words = line.replaceAll("[\\.\\,\\!]", "").split(" ");
					}
				}
				lineC++;
			}
		}
		catch (Exception e)
		{
			
		}
		finally {
			if (br != null){
				br.close();
			}
		}
		return theInput;
	}
}

//-2000 -2000 -2000 -2000 -2000 -2000
