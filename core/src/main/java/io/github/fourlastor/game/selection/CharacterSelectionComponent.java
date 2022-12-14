package io.github.fourlastor.game.selection;

import dagger.Subcomponent;
import io.github.fourlastor.game.di.ScreenScoped;
import io.github.fourlastor.game.route.RouterModule;

@ScreenScoped
@Subcomponent(modules = {RouterModule.class})
public interface CharacterSelectionComponent {

    @ScreenScoped
    CharacterSelectionScreen screen();

    @Subcomponent.Builder
    interface Builder {

        Builder router(RouterModule routerModule);

        CharacterSelectionComponent build();
    }
}
