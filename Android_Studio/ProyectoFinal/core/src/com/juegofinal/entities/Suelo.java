package com.juegofinal.entities;

import static com.juegofinal.Constantes.PIXEL_EN_METROS;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Suelo extends Actor {

    private Texture floor, overFloor;
    private World world;
    private Body body, leftBody;
    private Fixture fixture, leftFixture;

    //La x es donde esta el borde izquierdo del suelo en metros
    //La y es donde esta el borde superior del suelo en metros
    //width es la anchura del suelo en metros

    public Suelo(World world, Texture floor, Texture overFloor, float x, float width, float y){
        this.world = world;
        this.floor = floor;
        this.overFloor = overFloor;

        //Coloco el suelo en la posicion que le corresponde
        BodyDef def = new BodyDef();
        def.position.set(x + width / 2, y - 0.5f);
        body = world.createBody(def);

        //Le doy forma a la caja
        PolygonShape box = new PolygonShape();
        box.setAsBox(width / 2,0.5f);
        fixture = body.createFixture(box, 1);
        fixture.setUserData("suelo");
        box.dispose();

        BodyDef leftDef = new BodyDef();
        leftDef.position.set(x, y - 0.55f);
        leftBody = world.createBody(leftDef);

        PolygonShape leftBox = new PolygonShape();
        leftBox.setAsBox(0.02f,  0.45f);
        leftFixture = leftBody.createFixture(leftBox, 1);
        leftFixture.setUserData("pincho");
        leftBox.dispose();

        setSize(width * PIXEL_EN_METROS, PIXEL_EN_METROS);
        setPosition(x * PIXEL_EN_METROS, (y - 1) * PIXEL_EN_METROS);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(floor, getX(), getY(), getWidth(), getHeight());
        batch.draw(overFloor, getX(), getY() + 0.9f * getHeight(), getWidth(), 0.1f * getHeight());
    }

    //Desacoplar el objeto del mundo
    public void detach(){
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }
}
