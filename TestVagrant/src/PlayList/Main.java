package PlayList;

public class Main {

	public static void main(String[] args) {
		RecentlyPlayedStore store = new RecentlyPlayedStore(3);
        User user = new User("John");

        Song s1 = new Song("S1");
        Song s2 = new Song("S2");
        Song s3 = new Song("S3");
        Song s4 = new Song("S4");

        store.addRecentlyPlayedSong(user, s1);
        store.addRecentlyPlayedSong(user, s2);
        store.addRecentlyPlayedSong(user, s3);
        System.out.println(store.getRecentlyPlayedSongs(user)); // [S3, S2, S1]

        store.addRecentlyPlayedSong(user, s4);
        System.out.println(store.getRecentlyPlayedSongs(user)); // [S4, S3, S2]

        store.addRecentlyPlayedSong(user, s2);
        System.out.println(store.getRecentlyPlayedSongs(user)); // [S2, S4, S3]

        store.addRecentlyPlayedSong(user, s1);
        System.out.println(store.getRecentlyPlayedSongs(user)); // [S1, S2, S4]
    }

	}


