package exercises.challenges_section_8.SongListChallenge;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlayList {

    public static void main(String[] args) {
        Album album1 = new Album("Pass out of existence", "Chimaira");
        album1.addToAlbum("Let Go", 3.51);
        album1.addToAlbum("Dead Inside", 3.45);
        album1.addToAlbum("Severed", 3.16);
        album1.addToAlbum("Lumps", 3.54);
        //album1.addToAlbum("Abeo", 1.44);
        album1.addToAlbum("Pass Out of Existence", 3.24);
        album1.addToAlbum("Abeo", 1.44);
        album1.addToAlbum("Sp Lit", 3.12);

        LinkedList<Song> playList = new LinkedList<>();
        album1.addToPlayList(1, playList);
        album1.addToPlayList(2, playList);
        album1.addToPlayList(3, playList);
        album1.addToPlayList(4, playList);
        album1.addToPlayList(6, playList);
        album1.addToPlayList(7, playList);
        //album1.addToPlayList("Sp Lit", playList);
        System.out.println(playList);
        play(playList);

    }

    public static void play(LinkedList<Song> playList){
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> iterator = playList.listIterator();
        if(playList.size()<=0){
            System.out.println("No songs in playlist");
            return;
        }else{
            System.out.println("Now playing " + iterator.next().toString());
        }
        while(!quit){
            System.out.println("0 -  quit \n 1 - next \n 2 - previous");
            int action = input.nextInt();
            input.nextLine();

            switch(action){
                case 0:
                    System.out.println("Bye bye");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if (iterator.hasNext()) {
                            iterator.next();
                            forward = true;
                        }
                    }
                    if(iterator.hasNext()){
                        System.out.println("Now playing " + iterator.next().toString());
                    }else{
                        System.out.println("Reached beginning of the list");
                        forward = false;
                    }

                    break;
                case 2:
                    if(forward){
                        if(iterator.hasPrevious()) {
                            iterator.previous();
                            forward = false;
                        }
                    }
                    if(iterator.hasPrevious()) {
                        System.out.println("Now playing " + iterator.previous().toString());
                    }else{
                        System.out.println("Reached beginning of the list");
                        forward = true;
                    }
                    break;
            }
        }

    }

}
