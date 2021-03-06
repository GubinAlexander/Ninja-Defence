package com.alexander.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Alexander on 24.04.17.
 */

public class MoveAnimation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    public MoveAnimation(TextureRegion region, int frameCount, float cycleTime){
        frames = new Array<TextureRegion>();
        int frameHeight = region.getRegionHeight() / frameCount;
        for (int i = 0; i < frameCount; i++){
            frames.add(new TextureRegion(region, 0, i*frameHeight, region.getRegionWidth(), frameHeight));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }
    public void update(float dt){
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if (frame >= frameCount)
            frame = 0;
    }
    public TextureRegion getFrame(){
        return frames.get(frame);
    }
}