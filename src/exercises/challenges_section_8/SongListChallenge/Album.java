package exercises.challenges_section_8.SongListChallenge;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new ArrayList<Song>();
    }

   public boolean addToAlbum(String title, double duration){
        if(findSong(title)==null){
            songList.add(new Song(title, duration));
            return true;
        }
       System.out.println("Song is already added to the album.");
        return false;
   }

   private Song findSong(String title){
        for(Song s : this.songList){
            if(s.getTitle().equals(title)){
                return s;
            }
        }
        return null;
   }

   public boolean addToPlayList(int trackNo, LinkedList<Song> playlist){
        int index = trackNo - 1;
        if(index >= 0 && index <= this.songList.size()){
            playlist.add(this.songList.get(index));
            return true;
        }
       System.out.println("Album does not contain track #" + trackNo);
        return false;
   }

   public boolean addToPlayList(String title, LinkedList<Song> playlist){
        Song song = findSong(title);
        if(song!=null){
            playlist.add(song);
            return true;
        }
       System.out.println("Album does not contain song named " + title);
        return false;
   }

}
