package com.alexander.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Alexander on 01.03.17.
 */

public class Bullet {

    OrthographicCamera camera = new OrthographicCamera();
    Texture bulletTexture = new Texture("Thing.png");
    Array<Rectangle> bullets;

    public Array<Rectangle> getBullets() {
        return bullets;
    }

    public Texture getBulletTexture() {
        return bulletTexture;
    }

    public Bullet() {
        camera.setToOrtho(false, 800, 600);
        bullets = new Array<Rectangle>();
    }

    public void render() {}

    public void dispose() {}
}