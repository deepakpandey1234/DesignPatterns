package com.deepak.facade;

import java.io.File;

/**
 * Created by panded4 on 9/7/2016.
 * Example: Media player (start/stop)
 *
 */
interface MediaPlayer{
    public void play();
    public void pause();
    public void stop();
}

class FileLoader{
    public void loadFile(){
        System.out.println("FileLoader.loadFile");
    }
    public void unload(){
        System.out.println("FileLoader.unload");
    }
}

class DecodeFormatValidate{
    public void validateDecode(){
        System.out.println("DecodeFormatValidate.validateDecode");
    }
}

class Sound{
    public void on(){
        System.out.println("Sound.on");
    }
    public void off(){
        System.out.println("Sound.off");
    }
}
class MediaPlayerFacade implements MediaPlayer{
    FileLoader fileLoader=new FileLoader();
    DecodeFormatValidate decodeFormatValidate=new DecodeFormatValidate();
    Sound sound=new Sound();

    @Override
    public void play() {
        fileLoader.loadFile();
        decodeFormatValidate.validateDecode();
        sound.on();
    }

    @Override
    public void pause() {
        sound.off();
    }

    @Override
    public void stop() {
        sound.off();
        fileLoader.unload();
    }
}
public class FacadeDemo {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer=new MediaPlayerFacade();
        mediaPlayer.play();
        System.out.println("::::::::::::::::::::::::::::::::::::");
        mediaPlayer.stop();
    }
}
