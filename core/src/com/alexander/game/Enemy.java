package com.alexander.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

/**
 * Created by Alexander on 01.03.17.
 */

public class Enemy
{
    OrthographicCamera camera;
    SpriteBatch batch;
    Texture enemyImage;
    Array<Rectangle> enemys;
    long lastEnemyTime;

    public Enemy(){
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        enemyImage = new Texture("Enemy.png");

        enemys = new Array<Rectangle>();
    }

    public void SpawnEnemys(){
        Rectangle enemy = new Rectangle();

        enemy.y = MathUtils.random(0, 480 + 64);
        enemy.x = 800;

        enemy.width = 64;
        enemy.height = 64;

        enemys.add(enemy);

        lastEnemyTime = TimeUtils.nanoTime();
    }


    public  void render(){
        camera.update();

        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        for (Rectangle enemy : enemys) {
            batch.draw(enemyImage, enemy.x, enemy.y);
        }
        batch.end();

        if (TimeUtils.nanoTime() - lastEnemyTime > 10000000)
            SpawnEnemys();
        Iterator<Rectangle> iter = enemys.iterator();
        while (iter.hasNext()) {
            Rectangle enemy = iter.next();
            enemy.x -= 200 * Gdx.graphics.getDeltaTime();
            if (enemy.x - 64 < 0)
                iter.remove();
        }
    }


    public void dispose(){
    }
}

