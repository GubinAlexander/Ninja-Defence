package com.alexander.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

/**
 * Created by Alexander on 01.03.17.
 */

public class Enemy extends main
{

    Texture enemyImage;

    Array<Rectangle> enemys;

    long lastEnemyTime;

    public void create() {

        enemyImage = new Texture("Enemy.png");

        enemys = new Array<Rectangle>();
    }

    public Enemy(){


        SpawnEnemys();
    }

    public void SpawnEnemys(){
        Rectangle enemy = new Rectangle();

        enemy.x = MathUtils.random(0, 480 - 40);
        enemy.y = 800 - 64;

        enemy.width = 64;
        enemy.height = 64;

        enemys.add(enemy);

        lastEnemyTime = TimeUtils.nanoTime();
    }


    public  void render(){
        for (Rectangle enemy : enemys) {
            batch.begin();
            batch.draw(enemyImage, enemy.x, enemy.y);
            batch.end();
        }
        if (TimeUtils.nanoTime() - lastEnemyTime > 10000000) SpawnEnemys();
        Iterator<Rectangle> iter = enemys.iterator();
        while (iter.hasNext()){
            Rectangle enemy = iter.next();
            enemy.x -= 200 * Gdx.graphics.getDeltaTime();
            if (enemy.x - 64 < 0) iter.remove();
        }
    }


    public void dispose(){
    }
}

