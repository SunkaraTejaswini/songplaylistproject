package com.teju;
import java.util.ArrayList;
import java.util.LinkedList;

public class album {
    private String name;
    private String artist;
    private ArrayList<song> songs;

    public album(String name , String artist , ArrayList<song> songs) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<song>();
    }
    public album(){
        
    }
    public song findSong(String title){
        for( song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }
    public boolean addSong(String title ,double duration){
        if(findSong(title) == null){
            songs.add(new song(title,duration));
            System.out.println(title + "Successfully added to List");
            return true;
        }
        else{
            System.out.println("song with name" + title + "already exist in the list");
            return false;
        }
    }

    public boolean addToPlayList(int trackNumber , LinkedList<song> Playlist ){
        int index = trackNumber - 1;
        if(index > 0 && index <= this.songs.size()){
            Playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album does not have song with tracknumber" +trackNumber);
        return false;
    }

    public boolean addToPlayList(String title , LinkedList<song> Playlist){
        for(song checkedSong : this.songs){
            if(checkedSong.getTitle().equals(title)){
                Playlist.add(checkedSong);
                return  true;
            }
        }
        System.out.println("There is no such song in album");
        return false;
    }
}
