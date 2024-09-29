package dev.mayaqq.estrogen.client.cosmetics.model.animation;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;
import java.util.Map;

public record AnimationDefinition(float seconds, boolean looping, Map<String, List<Animation>> animations) {

    public static final Codec<AnimationDefinition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        Codec.FLOAT.fieldOf("seconds").forGetter(AnimationDefinition::seconds),
        Codec.BOOL.fieldOf("looping").forGetter(AnimationDefinition::looping),
        Codec.unboundedMap(Codec.STRING, Animation.CODEC.listOf()).fieldOf("animations").forGetter(AnimationDefinition::animations)
    ).apply(instance, AnimationDefinition::new));

}
