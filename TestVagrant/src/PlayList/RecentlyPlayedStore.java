package PlayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecentlyPlayedStore {
	private int capacity;
    private Map<User, LinkedList<Song>> store;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>();
    }

    public void addRecentlyPlayedSong(User user, Song song) {
        LinkedList<Song> playlist = store.getOrDefault(user, new LinkedList<>());

        // Remove the song from the playlist if it already exists
        playlist.remove(song);

        // Add the song to the beginning of the playlist
        playlist.addFirst(song);

        // Truncate the playlist if it exceeds the capacity
        if (playlist.size() > capacity) {
            playlist.removeLast();
        }

        // Update the playlist for the user
        store.put(user, playlist);
    }

    public List<Song> getRecentlyPlayedSongs(User user) {
        return store.getOrDefault(user, new LinkedList<>());
    }
}
