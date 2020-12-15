package com.example.puzzle;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import java.io.IOException;

public class AudioPuz {

	AssetManager assetManager;
	SoundPool soundPool;

	public AudioPuz(Activity activity) {
		activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		assetManager = activity.getAssets();
		if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
			AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME)
					.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();
			soundPool = new SoundPool.Builder().setAudioAttributes(audioAttributes).build();
		} else {
			soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
		}
	}

	public MusicPuz newMusic(String fileName) {

		AssetFileDescriptor assetFileDescriptor = null;

		try {
			assetFileDescriptor = assetManager.openFd(fileName);
			return new MusicPuz(assetFileDescriptor);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load music");

		}
	}

	public SoundPuz newSound(String fileName) {
		AssetFileDescriptor assetFileDescriptor = null;
		try {
			assetFileDescriptor = assetManager.openFd(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int sound = soundPool.load(assetFileDescriptor, 0);
		return new SoundPuz(sound, soundPool);
	}

}
