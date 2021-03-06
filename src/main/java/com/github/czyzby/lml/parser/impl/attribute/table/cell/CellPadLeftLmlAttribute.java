package com.github.czyzby.lml.parser.impl.attribute.table.cell;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.github.czyzby.lml.parser.LmlParser;
import com.github.czyzby.lml.parser.tag.LmlTag;
import com.github.czyzby.lml.util.LmlUtilities;

/** See {@link Cell#padLeft(Value)}. See {@link LmlUtilities#parseHorizontalValue(LmlParser, LmlTag, Actor, String)} and
 * {@link LmlUtilities#parseVerticalValue(LmlParser, LmlTag, Actor, String)} for more info on value parsing. Mapped to
 * "padLeft".
 *
 * @author MJ */
public class CellPadLeftLmlAttribute extends AbstractCellLmlAttribute {
    @Override
    public void process(final LmlParser parser, final LmlTag tag, final Actor actor, final Cell<?> cell,
            final String rawAttributeData) {
        final Value horizontalValue = LmlUtilities.parseHorizontalValue(parser, tag.getParent(), actor,
                rawAttributeData);
        cell.padLeft(horizontalValue);
    }

    @Override
    protected void processForActor(final LmlParser parser, final LmlTag tag, final Actor actor,
            final String rawAttributeData) {
        // Parsed if actor is not in a cell:
        if (actor instanceof Table) {
            final Value horizontalValue = LmlUtilities.parseHorizontalValue(parser, tag.getParent(), actor,
                    rawAttributeData);
            ((Table) actor).padLeft(horizontalValue);
        } else if (actor instanceof VerticalGroup) {
            ((VerticalGroup) actor).padLeft(parser.parseFloat(rawAttributeData, actor));
        } else if (actor instanceof HorizontalGroup) {
            ((HorizontalGroup) actor).padLeft(parser.parseFloat(rawAttributeData, actor));
        } else if (actor instanceof Container<?>) {
            ((Container<?>) actor)
                    .padLeft(LmlUtilities.parseHorizontalValue(parser, tag.getParent(), actor, rawAttributeData));
        } else {
            // Exception:
            super.processForActor(parser, tag, actor, rawAttributeData);
        }
    }
}
