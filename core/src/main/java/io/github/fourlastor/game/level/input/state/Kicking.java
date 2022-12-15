package io.github.fourlastor.game.level.input.state;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import io.github.fourlastor.game.animation.data.AnimationData;
import io.github.fourlastor.game.animation.data.CharacterAnimationData;
import io.github.fourlastor.game.component.AnimationImageComponent;
import io.github.fourlastor.game.component.BodyComponent;
import io.github.fourlastor.game.component.PlayerComponent;
import io.github.fourlastor.game.level.PlayerAnimationsFactory;

import javax.inject.Inject;
import javax.inject.Named;

public class Kicking extends InputState {

    private final AnimationData animation;

    @Inject
    public Kicking(
            ComponentMapper<PlayerComponent> players,
            ComponentMapper<BodyComponent> bodies,
            ComponentMapper<AnimationImageComponent> images,
            @Named(PlayerAnimationsFactory.KARATENISSE) CharacterAnimationData animationData
    ) {
        super(players, bodies, images);
        this.animation = animationData.animations.get("attack_0");
    }

    @Override
    protected AnimationData animation() {
        return animation;
    }

    float timePassed = 0f;

    @Override
    public void enter(Entity entity) {
        super.enter(entity);
        timePassed = 0f;
    }

    @Override
    public void update(Entity entity) {
        super.update(entity);
        timePassed += Gdx.graphics.getDeltaTime();
        if (timePassed * 1000 >= animation.duration) {
            PlayerComponent player = players.get(entity);
            player.stateMachine.changeState(player.onGround);
        }
    }
}