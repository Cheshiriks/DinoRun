package com.example.puzzle;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import java.io.IOException;

public class MusicPuz implements MediaPlayer.OnCompletionListener {

	MediaPlayer mediaPlayer;
	boolean isPrepared = false;

/*
		Метод android.media.MediaPlayer._prepare(Native Method)
		выбрасывает IllegalStateException
		ошибка FATAL EXCEPTION: Thread-2
		Проблема возникает если работать с одним заранее подгруженным аудиофайлом.
		Нужно разобраться
*/
	public MusicPuz(AssetFileDescriptor assetFileDescriptor) {
		mediaPlayer = new MediaPlayer();

		try {
			mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			mediaPlayer.prepare();
		} catch (IOException e) {
			e.printStackTrace();
		}

		isPrepared = true;

		mediaPlayer.setOnCompletionListener(this);

	}

	//looping - зациклить ли музыку
	//volume - звук
	public void play(boolean looping, float volume) {

		if (isPlay()) {
			return;
		}

		synchronized (this) {
			if (!isPrepared) {
				try {
					mediaPlayer.prepare();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			mediaPlayer.setLooping(looping);

			//разделение звука на 2 канала
			mediaPlayer.setVolume(volume, volume);
			mediaPlayer.start();
		}

	}

	public void stop() {

		if (isPlay()) {
			mediaPlayer.stop();
		}
		synchronized (this) {
			isPrepared = false;
		}
	}

	public void pause() {

		if (isPlay()) {
			mediaPlayer.pause();
		}
		synchronized (this) {
			isPrepared = false;
		}
	}

	public void dispose() {
		if (isPlay()) {
			mediaPlayer.stop();
		}
		mediaPlayer.release();
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		synchronized (this) {
			isPrepared = false;
		}
	}

	private boolean isPlay() {
		boolean isPlay = false;
		try {
			isPlay = mediaPlayer.isPlaying();
		} catch (IllegalStateException e) {
			isPlay = false;
		}
		return isPlay;
	}

}
