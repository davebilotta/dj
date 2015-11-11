package com.davebilotta.dj;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class PlayButton extends Button {
	int id;
	private Sound sound;
	private boolean depressed;
	private Texture imageUp, imageDown;

	public PlayButton(final int id, int x, int y, int width, int height, Texture imageUp, Texture imageDown) { 
		this.id = id;
		this.sound = null;
		this.depressed = false;
		this.imageUp = imageUp;
		this.imageDown = imageDown;
		this.setName("button_" + id);
				
		this.setPosition(x, y);
		this.setWidth(width);
		this.setHeight(width);
		Utils.log("Creating button " + id + " at " + x + "," + y + ", button has width " + width + " and height " + height);
		
		this.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttons){
				System.out.println("Touched" + id);
				
				return true;
			}	
		});
		}
	
	public void playSound() {
		this.sound.play();
		Utils.log("Playing sound for " + this.id);
	}
	

	public void draw(Batch batch, float alpha){
		//Utils.log("Button " + id + " is at " + this.getX() + "," + this.getY() + ":" + this.imageDown.getWidth() + "," + this.imageDown.getHeight());
		
		if (this.depressed) {
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

	
}
