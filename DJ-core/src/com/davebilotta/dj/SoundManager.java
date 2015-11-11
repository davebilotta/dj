package com.davebilotta.dj;

import java.util.ArrayList;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;

public class SoundManager {

	private ArrayList<DJSound> sounds;
	
	public SoundManager() {
		// TODO: Use AssetManager to load these in conjunction with splash screen
		loadSounds();
	}
	
	public void loadSounds() {
		Utils.startTimer();
		Utils.log("Loading sounds ...");
		sounds = new ArrayList<DJSound>();

		FileHandle dirHandle;
		boolean loop;
		if (Gdx.app.getType() == ApplicationType.Android) {
		  dirHandle = Gdx.files.internal("some/directory");
		} else {
		  // ApplicationType.Desktop ..
		  dirHandle = Gdx.files.internal("sounds/");
		  // TODO: Need to figure out how to handle sub directories (causes crash)
		}
		for (FileHandle entry: dirHandle.list()) {
			String name = entry.name();
			/* For now, files that end with "loop" are looping tracks */
			if (name.substring(name.length() - 8).equals("loop.wav")) {
				loop = true;
			}
			else {
				loop = false;
			}
			sounds.add(new DJSound(entry,loop));	
			
		}
		
		Utils.log("Sound load complete");
		Utils.stopTimer();
	}
	
	public void playStart(int id) {
		//this.sound.play();
		if (this.sounds.size() > id) {
			Utils.log("Playing sound for " + id);
			this.sounds.get(id).play();
		}
		else {
			Utils.log("Can't start - sound " + id + " does not exist");
		}
	}
	
	public void playStop(int id) {
		if (this.sounds.size() > id) {
			Utils.log("Stopping sound for " + id);
			this.sounds.get(id).stop();
		}
		else {
			Utils.log("Can't stop - sound " + id + " does not exist");
		}
	}

}
