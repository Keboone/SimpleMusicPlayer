
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Player
{
	static ArrayList<Playlist> PL = new ArrayList<>();
	static int z = 1;
//	private Map<String, Playlist> playlists;
	
//	public Player()
//	{
//		playlists = new HashMap<String, Playlist>();
//		
//		Playlist rock = new Playlist("ROCK");
//		Playlist pop = new Playlist("POP");
//		
//		playlists.put("ROCK", rock);
//		playlists.put("POP", pop);
//		
//		rock.add(new Song("sfafa", "fdsfs", 123));
//		rock.add(new Song("fwefwfw", "qfqf", 323));
//		rock.add(new Song("fqqc", "gbdnf", 4255));
//		rock.add(new Song("yuy", "fwqwqq", 5325));
//		rock.add(new Song("yjy", "aaa", 151));
//		rock.add(new Song("acvs", "mnbvc", 5466));
//		pop.add(new Song("kjgf", "hwek2w", 1414));
//		pop.add(new Song("awrfd", "hwwwg", 15667));
//		pop.add(new Song("caaf", "mjtr", 7586));
//		pop.add(new Song("vahah", "gfdb", 133323));
//	}
	
	public static void createPlaylist() throws Exception
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Type the playlist name:");
		String n = input.next();
		if(n == null || n.trim().equals("")) throw new Exception("Playlist name cannot be empty!");
			PL.add(new Playlist(n));
	}
	
	public static void addSong()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Select playlist to which you want to add the song?\n");
		
		for(int i=0; i<PL.size();i++) 
			System.out.println(i+1 + ". " + PL.get(i));
		
		int i = input.nextInt();
		
		try {
			PL.get(i-1).add();
		} catch (PlaylistException e) {
			e.printStackTrace();
		}
	}
	
	public static void showPlaylists()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Select playlist which you want to show:\n");
		
		for(int i=0; i<PL.size();i++) 
			System.out.println((i+1)+ ". " + PL.get(i));
		
		int i = input.nextInt();
		PL.get(i-1).show();
	}
	
	public static void sortPlaylists()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Select playlist which you want to sort:\n");
		
		for(int i=0; i<PL.size();i++) 
			System.out.println((i+1)+ ". " + PL.get(i));
		
		int i = input.nextInt();
		PL.get(i-1).sort();
	}
	
	public static void deleteSong()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Select playlist from which you want delete the song?\n");
		
		for(int i=0; i<PL.size(); i++) 
			System.out.println((i+1) + ". " + PL.get(i));
		
		int i = input.nextInt();
		PL.get(i-1).deleteS();
	}
	
	public static void copySong() 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Select playlist from which you want copy the song?\n");
		
		for(int i=0; i<PL.size(); i++) 
			System.out.println((i+1) + ". " + PL.get(i));
		
		int i = input.nextInt();
		
		System.out.println("Select song you want to copy: ");
		PL.get(i-1).show();
		
		int z = input.nextInt();
	
		Song song = PL.get(i-1).getsongsList().get(z-1);//??s z du
		
		System.out.println("\nSelect playlist to which you want to past " + song + "?\n");
		
		for(int j=0; j<PL.size(); j++) 
			System.out.println((j+1) + ". " + PL.get(j));
		
		i = input.nextInt();
		PL.get(i-1).past(song);
		
		PL.get(i-1).show();
		PL.get(i-1).sort();
		
	}
	
	public static void downloadSong()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("From which playlist you want to download the song?");
		
		for(int i=0; i<PL.size(); i++)
			System.out.println((i+1) + ". "+ PL.get(i));
		
		int i = input.nextInt();
		
		System.out.println("Which song your want to download?");
		PL.get(i-1).show();
		
		int j = input.nextInt();
		
		System.out.println(PL.get(i-1).download(j) + " has been downloaded.");
	}
	
	public static void moveSong()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("From which playlist you want to move the song?\n");
		
		for(int i=0; i<PL.size(); i++)
			System.out.println((i+1) + ". "+ PL.get(i));
		
		int i = input.nextInt();
		
		System.out.println("Which song your want to move?");
		PL.get(i-1).show();
		int z = input.nextInt();
		
		Song song = PL.get(i-1).getsongsList().get(z-1);
		System.out.println("\nYou are moving " + song + " from " + PL.get(i-1).PLN() + " playlist!\n");
		PL.get(i-1).move(z);
		System.out.println("\nTo which playlist you want to move " + song + "?\n");
		
		for(i=0; i<PL.size(); i++)
			System.out.println((i+1) + ". "+ PL.get(i));
		
		int j = input.nextInt();
		PL.get(j-1).past(song);	}
	
	public static void downloadTitle()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("From which playlist you want to download the title of some song?");
		
		for(int i=0; i<PL.size(); i++)
			System.out.println((i+1) + ". "+ PL.get(i));
		
		int i = input.nextInt();
		
		System.out.println("From which song you want to download the title?");
		PL.get(i-1).show();
		
		int j = input.nextInt();
		
		String title = PL.get(i-1).getsongsList().get(j-1).getTitle();
		
		System.out.println(title);	
	}
	
	public static void downloadAuthor()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("From which playlist you want to download the author of some song?");
		
		for(int i=0; i<PL.size(); i++)
			System.out.println((i+1) + ". "+ PL.get(i));
		
		int i = input.nextInt();
		
		System.out.println("From which song you want to download the author?");
		PL.get(i-1).show();
		
		int j = input.nextInt();
		
		String author = PL.get(i-1).getsongsList().get(j-1).getAuthor();
		
		System.out.println(author);	
	}
	
	public static void downloadYearOfRelease()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("From which playlist you want to download the year of release of some song?");
		
		for(int i=0; i<PL.size(); i++)
			System.out.println((i+1) + ". "+ PL.get(i));
		
		int i = input.nextInt();
		
		System.out.println("From which song you want to download the year of release?");
		PL.get(i-1).show();
		
		int j = input.nextInt();
		
		int year = PL.get(i-1).getsongsList().get(j-1).getSongReleaseYear();
		
		System.out.println(year);	
	}
	
	public static void deletePlaylist()

	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Select playlist which you want to delete?\n");
		
		for(int i=0; i<PL.size();i++) 
			System.out.println((i+1) + ". " + PL.get(i));
		
		int i = input.nextInt();
		
		System.out.println("Are you sure you want to delete " + PL.get(i-1).PLN() + " playlist? (yes/no)");
		String d = input.next();
		
		switch(d)
		{
			case "yes":
				System.out.println(PL.get(i-1).PLN() + " playlist has been deleted!");
				PL.remove(i-1);
				break;
			default:
				break;
		}
	}
	
	private static void saveToFile() throws IOException	 {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Select playlist which you want to save?\n");
		
		for(int i=0; i<PL.size();i++) 
			System.out.println((i+1) + ". " + PL.get(i));
		
		int i = input.nextInt();
		
		System.out.println("Type the file name: ");
		String fileName = input.nextLine();
		File file = new File("playlists/" + fileName);
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		System.out.println("Type playlist name: ");
		String playlistName = input.nextLine();
		bw.write(serialize);//...temat 8 tam jest git :DDDD
	}
	
	private static void loadFromFile() throws IOException, Exception
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Type file name: ");
		String fileName = input.nextLine();
		
		File file = new File("playlists/"+ fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		StringBuilder sb = new StringBuilder();
		String wiersz = br.readLine();
		while(wiersz != null) 
		{
			sb.append(wiersz);
			sb.append("\n");
			wiersz = br.readLine();
		}
		String serialized = sb.toString();
		Playlist playlist = Playlist.deserialize(serialized);
		System.out.println("Podaj nazwe playlisty");
	}
	
	public static void menu() throws Exception
	{
		System.out.println("\n-------------------------------");
		System.out.println("MENU\n[1]->Create playlist.\n[2]->Add the song to playlist.\n[3]->Show playlist."
							+ "\n[4]->Sort playlist.\n[5]->Delete the song.\n[6]->Copy the song.\n"
							+ "[7]->Download the song.\n[8]->Move the song.\n[9]->Delete playlist.\n[10]->Quit.");
		System.out.println("-------------------------------\n");
		
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		
		switch(a)
		{
			case 1:
				createPlaylist();
				break;
			case 2:
				addSong();
				break;
			case 3:
				showPlaylists();
				break;
			case 4:
				sortPlaylists();
				break;
			case 5:
				deleteSong();
				break;	
			case 6:
				copySong();
				break;
			case 7:
				downloadSong();
				break;
			case 8:
				moveSong();
				break;
			case 9:
				deletePlaylist();
				break;
				//wszystko działa(9-11)
//			case 10: 
//				downloadTitle();
//				break;
//			case 11:
//				downloadAuthor();
//				break;
//			case 12:
//				downloadYearOfRelease();
//				break;
//			case 13:
//				saveToFile();
//				break;
//			case 14:
//				loadFromFile();
//				break;
			default:
				System.out.println("\nYou've quit the player!");
				z=0;
				input.close();
				return;
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		PL.add(new Playlist("Pop"));
		PL.add(new Playlist("Rock"));
//		PL.get(1).getplaylistName("Rock").add(new Song("ja", "fe", 34));?????????
		while(z != 0) menu();
	}
}
