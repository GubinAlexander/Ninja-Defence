package com.alexander.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader;
import com.badlogic.gdx.graphics.glutils.IndexArray;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

/**
 * Created by Alexander on 01.03.17.
 */

public class Bullet extends main
{
    SpriteBatch batch;

    OrthographicCamera camera;

    Texture bulletImage;

    Array<Rectangle> bullets;

    long _lastBulletTime;

    public void Bullet(){
        batch =  new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        bulletImage =  new Texture("bullet.png");
    }

    public void SpawnBullet() {

        Rectangle bullet = new Rectangle();

        bullet.x = newNinja.ninja.x;
        bullet.y = newNinja.ninja.y;

        bullet.width = 64;
        bullet.height = 64;

        bullets.add(bullet);
    }

    public void render() {
        camera.update();
        batch.begin();
    }

    public void dispose() {
        bulletImage.dispose();

    }
}