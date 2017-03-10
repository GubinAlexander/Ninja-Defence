package com.alexander.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Alexander on 01.03.17.
 */

public class Bullet extends main
{
    Texture bulletImage;

    Array<Rectangle> bullet;

    private long _lastBulletTime;

    public void create() {
        bulletImage = new Texture("Bullet.png");
    }

    public void SpawnBullet() {
    }


    public void dispose() {
        bulletImage.dispose();
    }
}