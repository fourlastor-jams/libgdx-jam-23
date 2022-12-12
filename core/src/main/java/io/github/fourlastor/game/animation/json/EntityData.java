package io.github.fourlastor.game.animation.json;

import java.util.List;
import java.util.Map;

public class EntityData {

    public final List<Bone> bones;
    public final List<Slot> slots;

    public final Map<String, Skins> skins;

    public final Map<String, Animation> animations;

    public EntityData(List<Bone> bones, List<Slot> slots, Map<String, Skins> skins, Map<String, Animation> animations) {
        this.bones = bones;
        this.slots = slots;
        this.skins = skins;
        this.animations = animations;
    }

    @Override
    public String toString() {
        return "Animation{" +
                "bones=" + bones +
                ", slots=" + slots +
                ", skins=" + skins +
                '}';
    }
}
