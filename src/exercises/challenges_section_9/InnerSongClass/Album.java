package exercises.challenges_section_9.InnerSongClass;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songList;
    //private ArrayList<Song> songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new SongList();
    }

   public boolean addToAlbum(String title, double duration){
        return songList.add(new Song(title, duration));
   }

   public boolean addToPlayList(int trackNo, LinkedList<Song> playlist){
        Song toAdd = songList.findSong(trackNo);
        if(toAdd==null){
            System.out.println("Album does not contain track #" + trackNo);
            return false;
        }
        playlist.add(toAdd);
        return true;

   }

   public boolean addToPlayList(String title, LinkedList<Song> playlist){
        Song toAdd = songList.findSong(title);
       if(toAdd==null){
           System.out.println("Album does not contain track " + title);
           return false;
       }
       playlist.add(toAdd);
       return true;
   }

   //Inner Class
    private class SongList{
        private ArrayList<Song> songs;

        public SongList(){
            this.songs = new ArrayList<>();
        }

        public boolean add(Song song){
            if(this.songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }

       private Song findSong(String title){
           for(Song s : this.songs){
               if(s.getTitle().equals(title)){
                   return s;
               }
           }
           return null;
       }
       private Song findSong(int trackNo){
            int index = trackNo - 1;
            if((trackNo>=0)&&(trackNo<=songs.size())){
                return songs.get(index);
            }
            return null;
       }
   }
}
