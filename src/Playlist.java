import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Playlist
{
	private String playlistName;
	private ArrayList<Song> songsList;
	private int songsQuantity = 0;
	
	public String serialize() 
	{
		StringBuilder sb = new StringBuilder();
		sb.append(playlistName);
		sb.append("\n");
		//dodawanie info o utowrach w kolejnych liniach tekstu
		for(Song s: songsList)
		{
			sb.append(s.getTitle());
			sb.append("|");
			sb.append(s.getAuthor());
			sb.append("|");
			sb.append(s.getSongReleaseYear());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static Playlist deserialize(String serialized) throws PlaylistException 
	{
		String[] wiersze = serialized.split("\n");
		String playlistName = wiersze[0];
		Playlist playlist = new Playlist(playlistName);
		try 
		{
			for(int i=1; i<wiersze.length; i++) 
			{
				String wiersz = wiersze[i];
				String[] elementsOfSong = wiersz.split("|");
				String title = elementsOfSong[0];
				String author = elementsOfSong[1];
				int year = Integer.parseInt(elementsOfSong[2]);
				
				Song s = new Song(title, author, year);
//				songsList.add(s);
			
			}
		}
		catch (Exception e) {
			throw new PlaylistException("Nieprawidlowe dane wejsciowe" + e.getMessage());
		}
		return playlist;
	}
	
	public Playlist(String name)
	{
		playlistName = name;
		songsList = new ArrayList<>();
		System.out.println("You've successfully created " + name + " playlist!");
		
		//dodanie kilku piosenek do ka�dej playlisty
		
		try {
			songsList.add(new Song("Dream", "The Cranberries", 180));
			songsQuantity++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		try {
			songsList.add(new Song("", "Fleetwood Mac", 1977));
			songsQuantity++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {
			songsList.add(new Song("Blinding Lights", "The Weekend", 2019));
			songsQuantity++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {
			songsList.add(new Song("Intentions", "Justin Bieber", 2020));
			songsQuantity++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {
			songsList.add(new Song("Stuck In The Middle", "Mike Posner", 2019));
			songsQuantity++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {
			songsList.add(new Song("Waiting all night", "Rudimental", 2016));
			songsQuantity++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {
			songsList.add(new Song("Jolo", "The Lonely Island", 2013));
			songsQuantity++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {
			songsList.add(new Song("Closer", "Ne-Yo", 2008));
			songsQuantity++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {
			songsList.add(new Song("Empty", "Juice WRLD", 2019));
			songsQuantity++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	public String PLN()
	{
		return playlistName;	
	}
	
	public void add() throws PlaylistException
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Type the title of the song you want to add to "+ playlistName +" playlist: ");
		String title = input.nextLine();
		System.out.println("Type the author of the song: ");
		String author = input.nextLine();
		System.out.println("Type the song release year: ");
		int year = input.nextInt();
		
		try {
			songsList.add(new Song(title, author, year));
			System.out.println("You've successfully added \"" + title + "\" (" + author + ")" + " [" + year + "] " + "to " + playlistName + " playlist!");
			
			songsQuantity++;
			System.out.println("\nNow " + playlistName + " contains " + songsQuantity + " songs!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void show()
	{
		System.out.println("\nYour " + playlistName + " playlist:");
		Iterator<Song> iterator = songsList.iterator();
		int i = 0;
		while(iterator.hasNext())
		{
			System.out.println((i+1) + ". " + iterator.next());
			i++;
		}
	}
	
	public void showAfterSort()
	{
		System.out.println("\nYour " + playlistName + " playlist after sorting:\n");
		Iterator<Song> iterator = songsList.iterator();
		int i = 0;
		while(iterator.hasNext())
		{
			System.out.println((i+1) + ". " + iterator.next());
			i++;
		}
	}
	
	public void sort()
	{
		Collections.sort(songsList);
		showAfterSort();
	}
	
	public void deleteS()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Type the number of the song you want to remove form " + playlistName + " playlist:");
		show();
		int z = input.nextInt();
		System.out.println("Are you sure you want to delete " + songsList.get(z-1) + "? (yes/no)");
		String d = input.next();
		
		switch(d)
		{
			case "yes":
				System.out.println("You've successfully deleted " + songsList.get(z-1) + " from " + playlistName + " playlist!" );
				songsList.remove(z-1);
				songsQuantity--;
				sort();
				System.out.println("\nNow " + playlistName + " playlist contains " + songsQuantity + " songs!");
				break;
			default:
				break;
		}
	}
	
	public void past(Song s)
	{
		songsList.add(s);
		System.out.println("You've added " + s + " to " + playlistName + " playlist!");
		songsQuantity++;
		sort();
		System.out.println("\nNow " + playlistName + " playlist contains " + songsQuantity + " songs!");
	}
	
	public Song download(int i)
	{
		return songsList.get(i-1);
	}
	
	public void move(int i)
	{
		Scanner input = new Scanner(System.in);
		songsList.remove(i-1);
		
		sort();
		songsQuantity--;
		System.out.println("\nNow " + playlistName + " playlist contains " + songsQuantity + " songs!");
	}
	
	//gettery i settery
	
	public String getplaylistName()
	{
		return playlistName;
	}

	public void setplaylistName(String playlistName)
	{
		this.playlistName = playlistName;
	}

	public ArrayList<Song> getsongsList() 
	{
		return songsList;
	}

	public void setsongsList(ArrayList<Song> songsList) 
	{
		this.songsList = songsList;
	}

	@Override
	public String toString() 
	{
		return "Playlist \"" + playlistName + "\", songsQuantity: " + songsQuantity + ", songsList: " + songsList ;
	}
}
