package com.davebilotta.dj;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DJ extends Game {
	SpriteBatch batch;
	OrthographicCamera cam;
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 786;
	Texture buttonImageUp, buttonImageDown, buttonImageDownLoop;
		
	public SoundManager sm;
	
	//@Override
	public void create () {
		/* Eventually move to Image class */
		buttonImageUp = new Texture(Gdx.files.internal("panel_beigeLight.png"));
		buttonImageDown = new Texture(Gdx.files.internal("panel_beige.png"));
		buttonImageDownLoop = new Texture(Gdx.files.internal("panel_blue.png"));
		
		batch = new SpriteBatch();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, WIDTH,HEIGHT);
		
		this.sm = new SoundManager();
		setScreen(new DJScreen(this));
		
	}

	//@Override
	public void render(float delta) {
	}
		
}
