package com.juegofinal.entities;

import static com.juegofinal.Constantes.PIXEL_EN_METROS;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.juegofinal.Constantes;

public class Jugador extends Actor {

    private Texture texture;
    private World world;
    private Body body;
    private Fixture fixture;
    private boolean vivo = true, saltando = false, debeSaltar = false;

    public Jugador(World world, Texture texture, Vector2 posicion){
        this.world = world;
        this.texture = texture;

        BodyDef def = new BodyDef();
        def.position.set(posicion);
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);

        PolygonShape box = new PolygonShape();
        box.setAsBox(0.5f, 0.5f);
        fixture = body.createFixture(box, 3);
        fixture.setUserData("jugador");
        box.dispose();

        setSize(PIXEL_EN_METROS, PIXEL_EN_METROS);
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public boolean isSaltando() {
        return saltando;
    }

    public void setSaltando(boolean saltando) {
        this.saltando = saltando;
    }

    public boolean isDebeSaltar() {
        return debeSaltar;
    }

    public void setDebeSaltar(boolean debeSaltar) {
        this.debeSaltar = debeSaltar;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition((body.getPosition().x - 0.5f) * PIXEL_EN_METROS, (body.getPosition().y - 0.5f) * PIXEL_EN_METROS);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        //Iniciar salto si se toca pantalla
        if(Gdx.input.justTouched()){
            saltar();
        }

        //Hacer avanzar al jugador si esta vivo
        if(vivo){
            float velocidadY = body.getLinearVelocity().y;
            body.setLinearVelocity(Constantes.VELOCIDAD_JUGADOR, velocidadY);
        }
        if(saltando){
            body.applyForceToCenter(0, -Constantes.IMPULSO_SALTO * 1.15f, true);
        }
    }

    public void saltar(){
        if(!saltando && vivo){
            saltando = true;
            Vector2 position = body.getPosition();
            body.applyLinearImpulse(0, Constantes.IMPULSO_SALTO, position.x, position.y, true);
        }
    }

    //Desacoplar el objeto del mundo
    public void detach(){
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

}
