package com.alexander.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by Alexander on 01.03.17.
 */

public class Enemy {

    OrthographicCamera camera;
    Texture EnemyTexture;
    Array<Rectangle> enemys;

    public Texture getEnemyTexture() {
        return EnemyTexture;
    }
    long lastEnemyTime;

    public long getLastEnemyTime() {
        return lastEnemyTime;
    }

    public Array<Rectangle> getEnemys() {
        return enemys;
    }

    public Enemy(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);
        EnemyTexture = new Texture("Enemy.png");
        enemys = new Array<Rectangle>();
    }

    public void SpawnEnemys(){
        Rectangle enemy = new Rectangle();
        enemy.y = MathUtils.random(0, 480 + 84);
        enemy.x = 800;
        enemy.width = 14;
        enemy.height = 32;
        enemys.add(enemy);
        lastEnemyTime = TimeUtils.nanoTime();
    }

    public  void render() {
    }

    public void dispose(){
    }
}

