package com.LaserLight.fccs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	OrthographicCamera camera;
	Sprite sprite;

	
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(1,h/w);
		batch = new SpriteBatch();
		img= new Texture("fondoProyecto.jpg");
		img.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		TextureRegion region = new TextureRegion(img,0,0,1920,1200);
		sprite = new Sprite(region);
		sprite.setSize(1f,
				1f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth() / 2,
				sprite.getHeight() / 2);
		sprite.setPosition(-sprite.getWidth() / 2,
				-sprite.getHeight() / 2);


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
}
