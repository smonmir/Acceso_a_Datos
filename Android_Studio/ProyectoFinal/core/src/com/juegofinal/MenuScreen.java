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

public class MenuScreen extends BaseScreen{

    private Stage stage;
    private Skin skin;
    private Image logo;
    private TextButton jugar, credits;

    public MenuScreen(MainGame game) {
        super(game);

        stage = new Stage(new FitViewport(640, 360));
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        jugar = new TextButton("Jugar", skin);

        jugar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.gameScreen);
            }
        });

        jugar.setSize(200, 80);
        jugar.setPosition(230, 140);

        stage.addActor(jugar);
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
        skin.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.3f, 0.5f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

}
