package com.davebilotta.dj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;

public class DJSound implements Sound {

	Sound sound;
	boolean loop;
	
	public DJSound(FileHandle entry, boolean loop) {
		this.sound = Gdx.audio.newSound(entry);
		this.loop = loop;
	}
	
	@Override
	public long play() {
		if (this.loop) { 
			Utils.log("this is looping");
			this.sound.loop();
		}
		else { 
			this.sound.play();
		}
		return 0;
	}

	@Override
	public long play(float volume) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long play(float volume, float pitch, float pan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long loop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long loop(float volume) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long loop(float volume, float pitch, float pan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void stop() {
		this.sound.stop();
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop(long soundId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause(long soundId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume(long soundId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLooping(long soundId, boolean looping) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPitch(long soundId, float pitch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVolume(long soundId, float volume) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPan(long soundId, float pan, float volume) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPriority(long soundId, int priority) {
		// TODO Auto-generated method stub
		
	}

}
