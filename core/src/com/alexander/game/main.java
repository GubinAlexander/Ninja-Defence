package com.alexander.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

public class main extends ApplicationAdapter {

	OrthographicCamera camera;
	SpriteBatch batch;

	Enemy enemy;
	Ninja ninja;

	@Override
	public void create () {
	ninja = new Ninja();
	ninja.create();
	}


	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ninja.render();




	}
	
	@Override
	public void dispose () {
		ninja.dispose();
		batch.dispose();
	}





}


