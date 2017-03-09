package com.alexander.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Alexander on 01.03.17.
 */

public class Enemy
{

    Texture enemyImage;

    Array<Rectangle> enemys;

    private long _lastEnemyTime;

    public void SpawnEnemys(){
        Rectangle enemys = new Rectangle();
    }

    public void create() {
        enemyImage = new Texture("Enemy.png");

        enemys = new Array<Rectangle>();

    }

    public  void render(){
    }

    public void dispose(){
        enemyImage.dispose();
    }
}

