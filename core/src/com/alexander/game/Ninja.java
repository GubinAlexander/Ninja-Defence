package com.alexander.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Alexander on 10.03.17.
 */

public class Ninja {

    Vector3 touchPos;
    Texture ninjaImage;
    Rectangle ninja;

    public Ninja() {
        touchPos = new Vector3();
        ninjaImage = new Texture("Ninja.png");
        ninja = new Rectangle(touchPos.x,touchPos.y,ninjaImage.getWidth(),ninjaImage.getHeight());
        ninja.x = ((1000 - 940)) - 64 / 2;
        ninja.y = 200;
        ninja.width = 16;
        ninja.height = 32;
    }

    public Texture getNinjaImage() {
        return ninjaImage;
    }

    public void setNinjaImage(Texture ninjaImage) {
        this.ninjaImage = ninjaImage;
    }

    public Rectangle getNinja() {
        return ninja;
    }

    public void setNinja(Rectangle ninja) {
        this.ninja = ninja;
    }

    public Vector3 getTouchPos() {
        return touchPos;
    }

    public void setTouchPos(Vector3 touchPos) {
        this.touchPos = touchPos;
    }

    public void render() {



    }

    public void dispose(){
        ninjaImage.dispose();

    }
}





