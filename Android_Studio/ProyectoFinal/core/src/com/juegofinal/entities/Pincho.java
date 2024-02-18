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

public class Pincho extends Actor {

    private Texture texture;
    private World world;
    private Body body;
    private Fixture fixture;


    //La x es la posicion horizontal del centro del pincho en metros
    //La y es la posicion vertical de la base de los pinchos en metros

    public Pincho(World world, Texture texture, float x, float y){
        this.world = world;
        this.texture = texture;

        BodyDef def = new BodyDef();
        def.position.set(x, y + 0.5f);
        body = world.createBody(def);

        PolygonShape box = new PolygonShape();
        Vector2[] vertices = new Vector2[3]; //Crear un triangulo (3 vercites)
        vertices[0] = new Vector2(-0.5f, -0.5f);
        vertices[1] = new Vector2(0.5f, -0.5f);
        vertices[2] = new Vector2(0.5f, 0.5f);
        box.set(vertices);
        fixture = body.createFixture(box, 1);
        fixture.setUserData("pincho");
        box.dispose();

        setPosition((x - 0.5f) * PIXEL_EN_METROS, y * PIXEL_EN_METROS);
        setSize(PIXEL_EN_METROS, PIXEL_EN_METROS);
    }



    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    //Desacoplar el objeto del mundo
    public void detach(){
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }
}
