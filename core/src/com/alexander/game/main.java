package com.alexander.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

import java.sql.Ref;
import java.util.Iterator;


public class main extends ApplicationAdapter {

	SpriteBatch batch;
	Enemy enemy;
	Ninja newNinja;
	OrthographicCamera camera;

	@Override
	public void create() {
		batch = new SpriteBatch();
		newNinja = new Ninja();
		enemy = new Enemy();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		camera.update();
		while (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			newNinja.ninja.y -= 350 * Gdx.graphics.getDeltaTime();
			if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) break;
		}
		while (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			newNinja.ninja.y += 350 * Gdx.graphics.getDeltaTime();
			if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) ) break;
		}
		if (newNinja.ninja.y < 0) newNinja.ninja.y = 0;
		if (newNinja.ninja.y > 480 + 84) newNinja.ninja.y = 480 + 84;

		batch.setProjectionMatrix(camera.combined);
		for (Rectangle i : enemy.getEnemys()) {
			batch.draw(enemy.getEnemyTexture(), i.x, i.y);
		}
		batch.draw(newNinja.getNinjaImage(), newNinja.ninja.x, newNinja.ninja.y);
		batch.end();

		if (TimeUtils.nanoTime() - enemy.getLastEnemyTime() > 100000000)
			enemy.SpawnEnemys();

		Iterator<Rectangle> iter = enemy.getEnemys().iterator();
		while (iter.hasNext()) {
			Rectangle enemy = iter.next();
			enemy.x -= 20 * Gdx.graphics.getDeltaTime();

			if (enemy.x < 0 || enemy.overlaps(newNinja.getNinja()))
				iter.remove();

		}
	}

		@Override
		public void dispose () {
			batch.dispose();
			newNinja.dispose();

			enemy.dispose();

		}
	}


