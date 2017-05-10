package com.alexander.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;


public class main extends ApplicationAdapter {

	SpriteBatch batch;
	Enemy enemy;
	Ninja newNinja;
	OrthographicCamera camera;
	Bullet newBullet;

	@Override
	public void create() {
		batch = new SpriteBatch();
		newNinja = new Ninja();
		newBullet = new Bullet();
		enemy = new Enemy();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		while (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			newNinja.ninja.y -= 450 * Gdx.graphics.getDeltaTime();
			if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) break;
		}
		while (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			newNinja.ninja.y += 450 * Gdx.graphics.getDeltaTime();
			if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) ) break;
		}
		if (newNinja.ninja.y < 0) newNinja.ninja.y = 0;
		if (newNinja.ninja.y > 480 + 84) newNinja.ninja.y = 480 + 84;
		batch.draw(newNinja.getNinjaImage(), newNinja.ninja.x, newNinja.ninja.y);
		batch.end();

		batch.begin();
		for (Rectangle i : enemy.getEnemys()) {
			batch.draw(enemy.getEnemyTexture(), i.x, i.y);
		}
		batch.end();
		if (TimeUtils.nanoTime() - enemy.getLastEnemyTime() > 10000)
			enemy.SpawnEnemys();
		Iterator<Rectangle> enemyIter = enemy.getEnemys().iterator();
		while (enemyIter.hasNext()) {
			Rectangle enemy = enemyIter.next();
			enemy.x -= 200 * Gdx.graphics.getDeltaTime();
			if (enemy.x < 0 || enemy.overlaps(newNinja.getNinja()))
				enemyIter.remove();
		}

		batch.begin();
		for (Rectangle i : newBullet.getBullets()){
			batch.draw(newBullet.getBulletTexture(), i.x, i.y);
		}
		batch.end();

		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			Rectangle bullet = new Rectangle();
			bullet.x = newNinja.ninja.x;
			bullet.y = newNinja.ninja.y;
			bullet.width = 44;
			bullet.height = 44;
			newBullet.bullets.add(bullet);
		}

		Iterator<Rectangle> bulletIter = newBullet.getBullets().iterator();
		while (bulletIter.hasNext()){
			Rectangle bullet = bulletIter.next();
			bullet.x += 200 * Gdx.graphics.getDeltaTime();
			if (bullet.x > 800)
				bulletIter.remove();
		}
	}
	@Override
			public void dispose () {
			batch.dispose();
			newNinja.dispose();
			enemy.dispose();

		}
	}


