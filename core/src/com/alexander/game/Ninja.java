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

    OrthographicCamera camera;

    Texture ninjaImage;

    Rectangle Ninja;

    SpriteBatch batch;

    public void create() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        touchPos = new Vector3();

        ninjaImage = new Texture("Ninja.png");

        Ninja = new Rectangle();
        Ninja.x = ((800 - 740)) - 64 / 2;
        Ninja.y = 200;
        Ninja.width = 64;
        Ninja.height = 64;
    }

    public void render() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(ninjaImage, Ninja.x, Ninja.y);
        batch.end();

        if (Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            Ninja.y = touchPos.y - 64 / 2;
        }

        //if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){Ninja.y -= 500 * Gdx.graphics.getDeltaTime();

        //}
        //if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) Ninja.y += 500 * Gdx.graphics.getDeltaTime();


        while (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            Ninja.y -= 350 * Gdx.graphics.getDeltaTime();
            if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) break;
        }
        while (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            Ninja.y += 350 * Gdx.graphics.getDeltaTime();
            if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) ) break;
        }
        if (Ninja.y < 0) Ninja.y = 0;
        if (Ninja.y > 480 - 40) Ninja.y = 480 - 40;
    }



    public void dispose(){
        batch.dispose();
        ninjaImage.dispose();

    }
}




