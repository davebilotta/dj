package com.davebilotta.dj;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class DJScreen implements Screen {

	public DJ game;
	OrthographicCamera cam;
	private int gridWidth;
	private int gridHeight;
	private Stage stage;
	
	public ArrayList<DJButton> buttons;
	
	public DJScreen(DJ game) {
		this.game = game;

		cam = new OrthographicCamera();
		cam.setToOrtho(false, this.game.WIDTH, this.game.HEIGHT);

		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		stage.clear();

		gridWidth = 9;
		gridHeight = 6;

		setStage();
	}

	@Override
	public void render(float delta) {
		stage.act(delta);
		stage.draw();
	}

	public void setStage() {
		buttons = new ArrayList<DJButton>();
		
		Table table = new Table();
        table.setFillParent(true);
		
		int w = this.game.buttonImageUp.getWidth();
		int h = this.game.buttonImageUp.getHeight();
		int id = 0;
		int spacerX = 10;
		int spacerY = 10;
		
		  for (int j = 0; j < gridHeight; j++) {
			  for (int i = 0; i < gridWidth; i++)
			  {
				  DJButton actor = new DJButton(id, ((i * w) + spacerX), ((j * h) + spacerY), w, h, this.game.buttonImageUp, this.game.buttonImageDown,this);
		  
				  table.add(actor).width(w).height(h).spaceRight(spacerX).spaceBottom(spacerY);
				  buttons.add(actor);
				
				  id++; 
				  }
			  table.row(); 
		  }
		 
		//table.debug();
		stage.addActor(table);

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
