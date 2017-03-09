package com.alexander.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MyGdxGame extends ApplicationAdapter {
	OrthographicCamera camera;

	SpriteBatch batch;

	Texture ninjaImage;

	Rectangle Ninja;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800,480);

		batch = new SpriteBatch();

		ninjaImage = new Texture("Ninja.png");

		Ninja = new Rectangle();
		Ninja.x = 800 / 2 - 64 / 2;
		Ninja.y = 20;
		Ninja.width = 64;
		Ninja.height = 64;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(ninjaImage, Ninja.x, Ninja.x);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		ninjaImage.dispose();
	}
}
