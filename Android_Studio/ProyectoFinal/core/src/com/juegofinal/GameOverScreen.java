package com.juegofinal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameOverScreen extends BaseScreen{

    private Stage stage;
    private Skin skin;
    private Image gameOver;
    private TextButton reintentar, menu;

    public GameOverScreen(MainGame game) {
        super(game);

        stage = new Stage(new FitViewport(640, 360));
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        gameOver = new Image(game.getManager().get("gameover.png", Texture.class));
        reintentar = new TextButton("Retry", skin);
        menu = new TextButton("Menu", skin);

        reintentar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.gameScreen);
            }
        });

        menu.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.menuScreen);
            }
        });

        gameOver.setPosition(320 - gameOver.getWidth() / 2, 320 - gameOver.getHeight());
        reintentar.setSize(200, 100);
        reintentar.setPosition(60, 50);
        menu.setSize(200, 80);
        menu.setPosition(380, 50);
        stage.addActor(reintentar);
        stage.addActor(menu);
        stage.addActor(gameOver);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}