import java.util.Scanner;

public class Song implements Comparable<Song> 
{
	private String title;
	private String author;
	private Integer year;

	public Song(String title, String author, Integer year) throws Exception
	{
		if(title == null || title.trim().equals("")) throw new Exception("Title cannot be null!");
			this.title = title;
		if(author == null || author.trim().equals("")) throw new Exception("Author cannot be null!");
			this.author = author;
		if(year<1900 || year>2020) throw new Exception("Wrong year!");
			this.year = year;
	}
	
	//gettery i settery
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getSongReleaseYear() {
		return year;
	}

	public void setSongReleaseYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "\"" + title + "\" (" + author + ") [" + year + "]";
	}
	
	public int compareTo(Song o)
	{
		String thisSong = new String(this.title);
		String otherSong = new String(o.title);
		Integer thisYear = new Integer(this.year);
		Integer otherYear = new Integer(o.year);
		String thisAuthor = new String(this.author);
		String otherAuthor = new String(o.author);
		int songComparison = thisSong.compareTo(otherSong);
		int yearComparison = thisYear.compareTo(otherYear);
		
		if(songComparison == 0) 
		{
			if(year<1900 && year>2020)
			{
				if(yearComparison == 0) 
					return this.author.compareTo(o.author);
				return this.year.compareTo(o.year);
			}
		}
		return songComparison;
	}
}
