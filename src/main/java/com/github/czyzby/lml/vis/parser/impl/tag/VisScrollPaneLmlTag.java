package com.github.czyzby.lml.vis.parser.impl.tag;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.github.czyzby.lml.parser.LmlParser;
import com.github.czyzby.lml.parser.impl.tag.actor.ScrollPaneLmlTag;
import com.github.czyzby.lml.parser.tag.LmlActorBuilder;
import com.github.czyzby.lml.parser.tag.LmlTag;
import com.kotcrab.vis.ui.widget.VisScrollPane;

/** Handles {@link VisScrollPane} actor. Can have a single child tag which will be set as scroll pane's managed widget.
 * Parses plain text between tags to a label and sets it as its managed widget. Mapped to "scrollPane", "visScrollPane".
 *
 * @author Kotcrab */
public class VisScrollPaneLmlTag extends ScrollPaneLmlTag {
    public VisScrollPaneLmlTag(final LmlParser parser, final LmlTag parentTag, final StringBuilder rawTagData) {
        super(parser, parentTag, rawTagData);
    }

    @Override
    protected Actor getNewInstanceOfActor(final LmlActorBuilder builder) {         
        VisScrollPane scrollPane = new VisScrollPane(null, builder.getStyleName());
        scrollPane.addListener(new InputListener(){
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                scrollPane.getStage().setScrollFocus(event.getListenerActor());
            }
        });
        return scrollPane;

    }
}
