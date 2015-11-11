package com.davebilotta.dj;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class DJButton extends Button {
	int id;
	private Sound sound;
	private boolean touched;
	private Texture imageUp, imageDown;
	private DJScreen screen;

	public DJButton(final int id, int x, int y, int width, int height, Texture imageUp, Texture imageDown, final DJScreen screen) { 
		this.id = id;
		this.screen = screen;
		this.sound = null;
		this.touched = false;
		this.imageUp = imageUp;
		this.imageDown = imageDown;
		this.setName("button_" + id);
				
		this.setPosition(x, y);
		this.setWidth(width);
		this.setHeight(width);
		
		this.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttons){
				screen.buttons.get(id).onButtonPress();
				return true;
			}});
		}
	
		public void draw(Batch batch, float alpha){
		
		if (this.touched) {
			batch.draw(this.imageDown,this.getX(),this.getY(),this.getWidth(), this.getHeight());
					}
		else {
			batch.draw(this.imageUp,this.getX(),this.getY(),this.getWidth(), this.getHeight());
		}
		
     }
 
	@Override
	public void act(float delta) {
		super.act(delta);
	}
	
	public void onButtonPress() {
		if (this.touched) {
			this.touched = false;
			this.screen.game.sm.playStop(this.id);
		}
		else {
			this.touched = true;
			this.screen.game.sm.playStart(this.id);
		}
	}
	
}
