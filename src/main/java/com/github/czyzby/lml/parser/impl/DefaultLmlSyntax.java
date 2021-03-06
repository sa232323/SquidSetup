package com.github.czyzby.lml.parser.impl;

import com.github.czyzby.lml.parser.impl.attribute.*;
import com.github.czyzby.lml.parser.impl.attribute.building.*;
import com.github.czyzby.lml.parser.impl.attribute.container.*;
import com.github.czyzby.lml.parser.impl.attribute.group.*;
import com.github.czyzby.lml.parser.impl.attribute.group.button.MaxCheckCountLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.group.button.MinCheckCountLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.group.button.UncheckLastLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.image.ImageAlignmentLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.image.ScalingLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.image.animated.*;
import com.github.czyzby.lml.parser.impl.attribute.input.*;
import com.github.czyzby.lml.parser.impl.attribute.label.*;
import com.github.czyzby.lml.parser.impl.attribute.layout.FillParentLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.layout.LayoutEnabledLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.layout.PackLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.list.*;
import com.github.czyzby.lml.parser.impl.attribute.listener.*;
import com.github.czyzby.lml.parser.impl.attribute.progress.AnimateDurationLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.progress.OnCompleteLmlAtrribute;
import com.github.czyzby.lml.parser.impl.attribute.scroll.*;
import com.github.czyzby.lml.parser.impl.attribute.select.SelectBoxSelectedLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.split.MaxSplitLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.split.MinSplitLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.split.SplitAmountLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.table.*;
import com.github.czyzby.lml.parser.impl.attribute.table.button.ButtonImageLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.table.button.ButtonProgrammaticChangeEventsLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.table.button.CheckedLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.table.button.TextButtonImageLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.table.cell.*;
import com.github.czyzby.lml.parser.impl.attribute.table.dialog.OnResultLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.table.tooltip.AlwaysLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.table.tooltip.InstantLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.table.tooltip.KeepTooltipLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.table.tooltip.TooltipIdsLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.table.window.*;
import com.github.czyzby.lml.parser.impl.attribute.touchpad.DeadZoneLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.touchpad.ResetOnTouchUpLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.tree.IconSpacingLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.tree.TreePaddingLmlAttribute;
import com.github.czyzby.lml.parser.impl.attribute.tree.YSpacingLmlAttribute;
import com.github.czyzby.lml.parser.impl.tag.actor.provider.*;
import com.github.czyzby.lml.parser.impl.tag.listener.provider.ChangeListenerLmlTagProvider;
import com.github.czyzby.lml.parser.impl.tag.listener.provider.ClickListenerLmlTagProvider;
import com.github.czyzby.lml.parser.impl.tag.listener.provider.InputListenerLmlTagProvider;
import com.github.czyzby.lml.parser.impl.tag.macro.provider.*;
import com.github.czyzby.lml.parser.tag.LmlAttribute;

/** Represents default LML syntax. This class can be overridden to change some parts of LML syntax; note that core LML
 * syntax structures change would basically require another parser implementation, but if all you need is to change
 * parenthesis type here and there, this can be easily achieved.
 *
 * @author MJ */
public class DefaultLmlSyntax extends EmptyLmlSyntax {
    /** Constructs a new instance of default syntax, with default tag and attributes registered. */
    public DefaultLmlSyntax() {
        registerTags();
        registerAttributes();
    }

    /** Warning: invoked by the constructor. Registers known default tags. Since providers registration might override
     * previous settings, this method - if overridden - should call super BEFORE registering new tags (or replacing the
     * old ones). By default, invokes {@link #registerActorTags()}, {@link #registerListenerTags()} and
     * {@link #registerMacroTags()}. */
    protected void registerTags() {
        registerActorTags();
        registerListenerTags();
        registerMacroTags();
    }

    /** Registers actor-based tags that create widgets.
     *
     * @see #registerTags() */
    protected void registerActorTags() {
        addTagProvider(new ActorLmlTagProvider(), "actor", "group");
        addTagProvider(new ActorStorageLmlTagProvider(), "actorStorage", "isolate");
        addTagProvider(new AnimatedImageLmlTagProvider(), "animatedImage");
        addTagProvider(new ButtonGroupLmlTagProvider(), "buttonGroup", "buttonTable");
        addTagProvider(new ButtonLmlTagProvider(), "button");
        addTagProvider(new CheckBoxLmlTagProvider(), "checkBox");
        addTagProvider(new ContainerLmlTagProvider(), "container");
        addTagProvider(new DialogLmlTagProvider(), "dialog");
        addTagProvider(new HorizontalGroupLmlTagProvider(), "horizontalGroup");
        addTagProvider(new ImageButtonLmlTagProvider(), "imageButton");
        addTagProvider(new ImageLmlTagProvider(), "image");
        addTagProvider(new ImageTextButtonLmlTagProvider(), "imageTextButton");
        addTagProvider(new LabelLmlTagProvider(), "label");
        addTagProvider(new ListLmlTagProvider(), "list");
        addTagProvider(new ProgressBarLmlTagProvider(), "progressBar");
        addTagProvider(new ScrollPaneLmlTagProvider(), "scrollPane");
        addTagProvider(new SelectBoxLmlTagProvider(), "selectBox");
        addTagProvider(new SliderLmlTagProvider(), "slider");
        addTagProvider(new SplitPaneLmlTagProvider(), "splitPane");
        addTagProvider(new StackLmlTagProvider(), "stack");
        addTagProvider(new TableLmlTagProvider(), "table");
        addTagProvider(new TextAreaLmlTagProvider(), "textArea");
        addTagProvider(new TextButtonLmlTagProvider(), "textButton");
        addTagProvider(new TextFieldLmlTagProvider(), "textField");
        addTagProvider(new TooltipLmlTagProvider(), "tooltip");
        addTagProvider(new TouchpadLmlTagProvider(), "touchpad");
        addTagProvider(new TreeLmlTagProvider(), "tree");
        addTagProvider(new VerticalGroupLmlTagProvider(), "verticalGroup");
        addTagProvider(new WindowLmlTagProvider(), "window");
    }

    /** Registers listener tags, which manage mock-up actors and allow to attach specialized listeners to other tags.
     *
     * @see #registerTags() */
    protected void registerListenerTags() {
        addTagProvider(new ChangeListenerLmlTagProvider(), "onChange", "changeListener");
        addTagProvider(new ClickListenerLmlTagProvider(), "onClick", "clickListener");
        addTagProvider(new InputListenerLmlTagProvider(), "onInput", "inputListener");
    }

    /** Registers macro tags that manipulate templates' structures.
     *
     * @see #registerTags() */
    protected void registerMacroTags() {
        addMacroTagProvider(new ActorLmlMacroTagProvider(), "actor");
        addMacroTagProvider(new AnyNotNullLmlMacroTagProvider(), "anyNotNull", "any");
        addMacroTagProvider(new ArgumentLmlMacroTagProvider(), "nls", "argument", "preference");
        addMacroTagProvider(new ArgumentReplacementLmlMacroTagProvider(), "replace", "replaceArguments", "noOp",
                "root");
        addMacroTagProvider(new AssignLmlMacroTagProvider(), "assign", "var", "val");
        addMacroTagProvider(new CalculationLmlMacroTagProvider(), "calculate", "calculation");
        addMacroTagProvider(new ChangeListenerLmlMacroTagProvider(), "onChange", "changeListener");
        addMacroTagProvider(new ClickListenerLmlMacroTagProvider(), "onClick", "clickListener");
        addMacroTagProvider(new CommentLmlMacroTagProvider(), "comment", "FIXME", "TODO");
        addMacroTagProvider(new ConditionalLmlMacroTagProvider(), "if", "test", "check");
        addMacroTagProvider(new EvaluateLmlMacroTagProvider(), "eval", "evaluate", "invoke");
        addMacroTagProvider(new ExceptionLmlMacroTagProvider(), "exception", "throw", "error");
        addMacroTagProvider(new ForEachLmlMacroTagProvider(), "forEach", "for", "each");
        addMacroTagProvider(new ImportAbsoluteLmlMacroTagProvider(), "absoluteImport");
        addMacroTagProvider(new ImportClasspathLmlMacroTagProvider(), "classpathImport");
        addMacroTagProvider(new ImportExternallLmlMacroTagProvider(), "externalImport");
        addMacroTagProvider(new ImportInternalLmlMacroTagProvider(), "import", "internalImport");
        addMacroTagProvider(new ImportLocalLmlMacroTagProvider(), "localImport");
        addMacroTagProvider(new InputListenerLmlMacroTagProvider(), "inputListener", "onInput");
        addMacroTagProvider(new LoggerDebugLmlMacroTagProvider(), "debug", "logDebug", "trace", "logTrace");
        addMacroTagProvider(new LoggerErrorLmlMacroTagProvider(), "logError");
        addMacroTagProvider(new LoggerInfoLmlMacroTagProvider(), "log", "logInfo", "info");
        addMacroTagProvider(new LoopLmlMacroTagProvider(), "loop", "times");
        addMacroTagProvider(new MetaLmlMacroTagProvider(), "macro");
        addMacroTagProvider(new NestedForEachLmlMacroTagProvider(), "forEachNested", "nested", "eachNested");
        addMacroTagProvider(new NewAttributeLmlMacroTagProvider(), "newAttribute", "attribute");
        addMacroTagProvider(new NewTagLmlMacroTagProvider(), "newTag", "tag");
        addMacroTagProvider(new NullCheckLmlMacroTagProvider(), "notNull", "ifNotNull", "exists");
        addMacroTagProvider(new RandomLmlMacroTagProvider(), "random");
        addMacroTagProvider(new StyleLmlMacroTagProvider(), "style");
        addMacroTagProvider(new StyleSheetImportLmlMacroTagProvider(), "importStyleSheet");
        addMacroTagProvider(new TableCellLmlMacroTagProvider(), "cell", "tableCell");
        addMacroTagProvider(new TableColumnLmlMacroTagProvider(), "column", "tableColumn");
        addMacroTagProvider(new TableRowLmlMacroTagProvider(), "row", "tableRow");
        addMacroTagProvider(new WhileLmlMacroTagProvider(), "while", "until");
    }

    /** Warning: invoked by the constructor. Registers known default attributes. Since processors registration might
     * override previous settings, this method - if overridden - should call super BEFORE registering new attributes (or
     * replacing the old ones). */
    protected void registerAttributes() {
        // Building attributes. Parsed before actor creation.
        registerBuildingAttributes();

        // Regular attributes. Parsed after the actor is constructed.
        registerCommonAttributes();
        registerListenerAttributes();

        registerAnimatedImageAttributes();
        registerButtonAttributes();
        registerButtonGroupAttributes();
        registerContainerAttributes();
        registerDialogAttributes();
        registerHorizontalGroupAttributes();
        registerImageAttributes();
        registerLabelAttributes();
        registerListAttributes();
        registerProgressBarAttributes();
        registerScrollBarAttributes();
        registerSplitPaneAttributes();
        registerSelectBoxAttributes();
        registerTableAttributes();
        registerTextFieldAttributes();
        registerTooltipAttributes();
        registerTouchpadAttributes();
        registerTreeAttributes();
        registerVerticalGroupAttributes();
        registerWindowAttributes();
    }

    /** Attributes used during widget creation. */
    protected void registerBuildingAttributes() {
        // Default LmlActorBuilder:
        addBuildingAttributeProcessor(new SkinLmlAttribute(), "skin");
        addBuildingAttributeProcessor(new StyleLmlAttribute(), "style", "class");
        addBuildingAttributeProcessor(new OnResultInitialLmlAttribute(), "result", "onResult");
        addBuildingAttributeProcessor(new ToButtonTableLmlAttribute(), "toButtonTable");
        addBuildingAttributeProcessor(new ToDialogTableLmlAttribute(), "toDialogTable");
        addBuildingAttributeProcessor(new ToTitleTableLmlAttribute(), "toTitleTable");
        // Text:
        addBuildingAttributeProcessor(new TextLmlAttribute(), "text", "value");
        // Aligned:
        addBuildingAttributeProcessor(new HorizontalLmlAttribute(), "horizontal");
        addBuildingAttributeProcessor(new VerticalLmlAttribute(), "vertical");
        // FloatRange:
        addBuildingAttributeProcessor(new RangeInitialValueLmlAttribute(), "value");
        addBuildingAttributeProcessor(new RangeMaxValueLmlAttribute(), "max");
        addBuildingAttributeProcessor(new RangeMinValueLmlAttribute(), "min");
        addBuildingAttributeProcessor(new RangeStepSizeLmlAttribute(), "stepSize", "step");
        // Tooltip:
        addBuildingAttributeProcessor(new TooltipManagerLmlAttribute(), "tooltipManager");
    }

    /** Attributes applied to all actors. */
    protected void registerCommonAttributes() {
        addAttributeProcessor(new ActionLmlAttribute(), "action", "onShow");
        addAttributeProcessor(new ColorAlphaLmlAttribute(), "alpha", "a"); // Actor
        addAttributeProcessor(new ColorBlueLmlAttribute(), "blue", "b");
        addAttributeProcessor(new ColorGreenLmlAttribute(), "green", "g");
        addAttributeProcessor(new ColorLmlAttribute(), "color");
        addAttributeProcessor(new ColorRedLmlAttribute(), "red", "r");
        addAttributeProcessor(new DebugLmlAttribute(), "debug");
        addAttributeProcessor(new IdLmlAttribute(), "id");
        addAttributeProcessor(new MultilineLmlAttribute(), "multiline");
        addAttributeProcessor(new OnChangeLmlAttribute(), "onChange", "change");
        addAttributeProcessor(new OnClickLmlAttribute(), "onClick", "click");
        addAttributeProcessor(new OnCloseLmlAttribute(), "onClose", "close", "onTagClose", "tagClose");
        addAttributeProcessor(new OnCreateLmlAttribute(), "onCreate", "create", "onInit", "init");
        addAttributeProcessor(new RotationLmlAttribute(), "rotation", "angle");
        addAttributeProcessor(new ScaleLmlAttribute(), "scale");
        addAttributeProcessor(new ScaleXLmlAttribute(), "scaleX");
        addAttributeProcessor(new ScaleYLmlAttribute(), "scaleY");
        addAttributeProcessor(new TooltipLmlAttribute(), "tooltip");
        addAttributeProcessor(new TouchableLmlAttribute(), "touchable");
        addAttributeProcessor(new TreeNodeLmlAttribute(), "node");
        addAttributeProcessor(new VisibleLmlAttribute(), "visible");
        addAttributeProcessor(new XLmlAttribute(), "x");
        addAttributeProcessor(new YLmlAttribute(), "y");

        addAttributeProcessor(new TransformLmlAttribute(), "transform"); // Group
        addAttributeProcessor(new DebugRecursivelyLmlAttribute(), "debugRecursively");

        // Since Layout is an interface and interfaces listing is not supported on GWT, widgets can be mapped only to
        // their superclasses. This requires Layout-based attributes to be registered to a class that can apply to any
        // Layout-implementing widget.
        addAttributeProcessor(new FillParentLmlAttribute(), "fillParent"); // Layout
        addAttributeProcessor(new LayoutEnabledLmlAttribute(), "layout", "layoutEnabled");
        addAttributeProcessor(new PackLmlAttribute(), "pack");

        // Same goes for Disableable. Fails if the widget does not implement the interface.
        addAttributeProcessor(new DisabledLmlAttribute(), "disabled", "disable"); // Disableable
    }

    /** Listener tags attributes. */
    protected void registerListenerAttributes() {
        addAttributeProcessor(new ConditionLmlAttribute(), "if");
        addAttributeProcessor(new KeepListenerLmlAttribute(), "keep");
        addAttributeProcessor(new ListenerIdsLmlAttribute(), "ids");
        // InputListener:
        addAttributeProcessor(new CombinedKeysLmlAttribute(), "combined");
        addAttributeProcessor(new ListenerKeysLmlAttribute(), "keys");
    }

    /** Button widget attributes. */
    protected void registerButtonAttributes() {
        // Button:
        addAttributeProcessor(new ButtonProgrammaticChangeEventsLmlAttribute(), "programmaticChangeEvents");
        addAttributeProcessor(new CheckedLmlAttribute(), "checked");
        // Extensions:
        addAttributeProcessor(new ButtonImageLmlAttribute(), "image", "icon"); // ImageButton
        addAttributeProcessor(new TextButtonImageLmlAttribute(), "image", "icon"); // ImageTextButton
    }

    /** AnimatedImage widget attributes. */
    protected void registerAnimatedImageAttributes() {
        addAttributeProcessor(new AnimationDelayLmlAttribute(), "delay");
        addAttributeProcessor(new AnimationMaxDelayLmlAttribute(), "maxDelay");
        addAttributeProcessor(new BackwardsLmlAttribute(), "backwards");
        addAttributeProcessor(new BouncingLmlAttribute(), "bounce", "bouncing");
        addAttributeProcessor(new CurrentFrameLmlAttribute(), "frame", "currentFrame");
        addAttributeProcessor(new FramesLmlAttribute(), "frames");
        addAttributeProcessor(new PlayOnceLmlAttribute(), "playOnce");
    }

    /** ButtonGroup (ButtonTable) attributes. */
    protected void registerButtonGroupAttributes() {
        addAttributeProcessor(new MaxCheckCountLmlAttribute(), "max", "maxCheckCount");
        addAttributeProcessor(new MinCheckCountLmlAttribute(), "min", "minCheckCount");
        addAttributeProcessor(new UncheckLastLmlAttribute(), "uncheckLast");
    }

    /** Container widget attributes. */
    protected void registerContainerAttributes() {
        addAttributeProcessor(new ContainerAdjustPaddingLmlAttribute(), "adjustPadding");
        addAttributeProcessor(new ContainerAlignLmlAttribute(), "align");
        addAttributeProcessor(new ContainerBackgroundLmlAttribute(), "bg", "background");
        addAttributeProcessor(new ContainerClipLmlAttribute(), "clip");
        addAttributeProcessor(new ContainerFillLmlAttribute(), "fill");
        addAttributeProcessor(new ContainerFillXLmlAttribute(), "fillX");
        addAttributeProcessor(new ContainerFillYLmlAttribute(), "fillY");
        addAttributeProcessor(new ContainerHeightLmlAttribute(), "height");
        addAttributeProcessor(new ContainerMaxHeightLmlAttribute(), "maxHeight");
        addAttributeProcessor(new ContainerMaxSizeLmlAttribute(), "maxSize");
        addAttributeProcessor(new ContainerMaxWidthLmlAttribute(), "maxWidth");
        addAttributeProcessor(new ContainerMinHeightLmlAttribute(), "minHeight");
        addAttributeProcessor(new ContainerMinSizeLmlAttribute(), "minSize");
        addAttributeProcessor(new ContainerMinWidthLmlAttribute(), "minWidth");
        addAttributeProcessor(new ContainerPrefHeightLmlAttribute(), "prefHeight");
        addAttributeProcessor(new ContainerPrefSizeLmlAttribute(), "prefSize");
        addAttributeProcessor(new ContainerPrefWidthLmlAttribute(), "prefWidth");
        addAttributeProcessor(new ContainerRoundLmlAttribute(), "round");
        addAttributeProcessor(new ContainerSizeLmlAttribute(), "size");
        addAttributeProcessor(new ContainerWidthLmlAttribute(), "width");
    }

    /** Dialog-related attributes. */
    protected void registerDialogAttributes() {
        // Dialog children attributes:
        addAttributeProcessor(new OnResultLmlAttribute(), "result", "onResult");
    }

    /** HorizontalGroup widget attributes. */
    protected void registerHorizontalGroupAttributes() {
        addAttributeProcessor(new HorizontalGroupAlignmentLmlAttribute(), "groupAlign");
        addAttributeProcessor(new HorizontalGroupFillLmlAttribute(), "groupFill");
        addAttributeProcessor(new HorizontalGroupPaddingBottomLmlAttribute(), "groupPadBottom");
        addAttributeProcessor(new HorizontalGroupPaddingLeftLmlAttribute(), "groupPadLeft");
        addAttributeProcessor(new HorizontalGroupPaddingLmlAttribute(), "groupPad", "padding");
        addAttributeProcessor(new HorizontalGroupPaddingRightLmlAttribute(), "groupPadRight");
        addAttributeProcessor(new HorizontalGroupPaddingTopLmlAttribute(), "groupPadTop");
        addAttributeProcessor(new HorizontalGroupReverseLmlAttribute(), "reverse");
        addAttributeProcessor(new HorizontalGroupSpacingLmlAttribute(), "groupSpace", "spacing");
    }

    /** Image widget attributes. */
    protected void registerImageAttributes() {
        addAttributeProcessor(new ImageAlignmentLmlAttribute(), "imageAlign");
        addAttributeProcessor(new ScalingLmlAttribute(), "scaling", "imageScaling");
    }

    /** Label widget attributes. */
    protected void registerLabelAttributes() {
        addAttributeProcessor(new EllipsisLmlAttribute(), "ellipsis");
        addAttributeProcessor(new LabelAlignmentLmlAttribute(), "labelAlign", "labelAlignment");
        addAttributeProcessor(new LineAlignmentLmlAttribute(), "lineAlign", "lineAlignment");
        addAttributeProcessor(new TextAlignmentLmlAttribute(), "textAlign", "textAlignment");
        addAttributeProcessor(new WrapLmlAttribute(), "wrap");
    }

    /** List widget attributes. */
    protected void registerListAttributes() {
        addAttributeProcessor(new MultipleLmlAttribute(), "multiple");
        addAttributeProcessor(new RangeSelectLmlAttribute(), "rangeSelect");
        addAttributeProcessor(new RequiredLmlAttribute(), "required");
        addAttributeProcessor(new SelectedLmlAttribute(), "selected", "select", "value");
        addAttributeProcessor(new SelectionDisabledLmlAttribute(), "disabled", "disable");
        addAttributeProcessor(new ToggleLmlAttribute(), "toggle");
    }

    /** ProgressBar widget attributes. */
    protected void registerProgressBarAttributes() {
        addAttributeProcessor(new AnimateDurationLmlAttribute(), "animate", "animateDuration", "animation");
        addAttributeProcessor(new OnCompleteLmlAtrribute(), "onComplete", "complete");
    }

    /** ScrollBar widget attributes. */
    protected void registerScrollBarAttributes() {
        addAttributeProcessor(new ScrollBarsOnTopLmlAttribute(), "barsOnTop", "scrollbarsOnTop");
        addAttributeProcessor(new ScrollBarsPositionsLmlAttribute(), "barsPositions", "scrollBarsPositions");
        addAttributeProcessor(new ScrollCancelTouchFocusLmlAttribute(), "cancelTouchFocus");
        addAttributeProcessor(new ScrollClampLmlAttribute(), "clamp");
        addAttributeProcessor(new ScrollDisabledLmlAttribute(), "disable", "disabled", "scrollingDisabled");
        addAttributeProcessor(new ScrollDisabledXLmlAttribute(), "disableX", "disabledX", "scrollingDisabledX");
        addAttributeProcessor(new ScrollDisabledYLmlAttribute(), "disableY", "disabledY", "scrollingDisabledY");
        addAttributeProcessor(new ScrollFadeBarsLmlAttribute(), "fadeBars", "fadeScrollbars");
        addAttributeProcessor(new ScrollFadeBarsSetupLmlAttribute(), "setupFadeScrollBars");
        addAttributeProcessor(new ScrollFlickLmlAttribute(), "flick", "flickScroll");
        addAttributeProcessor(new ScrollFlickTapSquareSizeLmlAttribute(), "flickScrollTapSquareSize", "tapSquareSize");
        addAttributeProcessor(new ScrollFlingTimeLmlAttribute(), "flingTime");
        addAttributeProcessor(new ScrollForceLmlAttribute(), "force", "forceScroll");
        addAttributeProcessor(new ScrollForceXLmlAttribute(), "forceX", "forceScrollX");
        addAttributeProcessor(new ScrollForceYLmlAttribute(), "forceY", "forceScrollY");
        addAttributeProcessor(new ScrollOverscrollLmlAttribute(), "overscroll");
        addAttributeProcessor(new ScrollOverscrollSetupLmlAttribute(), "setupOverscroll");
        addAttributeProcessor(new ScrollOverscrollXLmlAttribute(), "overscrollX");
        addAttributeProcessor(new ScrollOverscrollYLmlAttribute(), "overscrollY");
        addAttributeProcessor(new ScrollPercentLmlAttribute(), "scrollPercent", "percent");
        addAttributeProcessor(new ScrollPercentXLmlAttribute(), "scrollPercentX", "percentX");
        addAttributeProcessor(new ScrollPercentYLmlAttribute(), "scrollPercentY", "percentY");
        addAttributeProcessor(new ScrollVariableSizeKnobsLmlAttribute(), "variableSizeKnobs");
        addAttributeProcessor(new ScrollSmoothLmlAttribute(), "smooth", "smoothScrolling");
        addAttributeProcessor(new ScrollVelocityLmlAttribute(), "velocity");
        addAttributeProcessor(new ScrollVelocityXLmlAttribute(), "velocityX");
        addAttributeProcessor(new ScrollVelocityYLmlAttribute(), "velocityY");
    }

    /** SelectBox widget attributes. */
    protected void registerSelectBoxAttributes() {
        addAttributeProcessor(new SelectBoxSelectedLmlAttribute(), "selected", "select", "value");
    }

    /** SplitPane widget attributes. */
    protected void registerSplitPaneAttributes() {
        addAttributeProcessor(new MaxSplitLmlAttribute(), "max", "maxSplit", "maxSplitAmount");
        addAttributeProcessor(new MinSplitLmlAttribute(), "min", "minSplit", "minSplitAmount");
        addAttributeProcessor(new SplitAmountLmlAttribute(), "split", "splitAmount", "value");
    }

    /** Table widget attributes. */
    protected void registerTableAttributes() {
        addAttributeProcessor(new OneColumnLmlAttribute(), "oneColumn");
        addAttributeProcessor(new TableAlignLmlAttribute(), "tableAlign");
        addAttributeProcessor(new TableBackgroundLmlAttribute(), "bg", "background");
        addAttributeProcessor(new TablePadBottomLmlAttribute(), "tablePadBottom");
        addAttributeProcessor(new TablePadLeftLmlAttribute(), "tablePadLeft");
        addAttributeProcessor(new TablePadLmlAttribute(), "tablePad");
        addAttributeProcessor(new TablePadRightLmlAttribute(), "tablePadRight");
        addAttributeProcessor(new TablePadTopLmlAttribute(), "tablePadTop");
        addAttributeProcessor(new TableRoundLmlAttribute(), "round");
        registerCellAttributes();
    }

    /** Attributes available to children tags of a Table parent. */
    protected void registerCellAttributes() {
        addCellAttributeProcessor(new CellAlignLmlAttribute(), "align");
        addCellAttributeProcessor(new CellColspanLmlAttribute(), "colspan");
        addCellAttributeProcessor(new CellExpandLmlAttribute(), "expand");
        addCellAttributeProcessor(new CellExpandXLmlAttribute(), "expandX");
        addCellAttributeProcessor(new CellExpandYLmlAttribute(), "expandY");
        addCellAttributeProcessor(new CellFillLmlAttribute(), "fill");
        addCellAttributeProcessor(new CellFillXLmlAttribute(), "fillX");
        addCellAttributeProcessor(new CellFillYLmlAttribute(), "fillY");
        addCellAttributeProcessor(new CellGrowLmlAttribute(), "grow");
        addCellAttributeProcessor(new CellGrowXLmlAttribute(), "growX");
        addCellAttributeProcessor(new CellGrowYLmlAttribute(), "growY");
        addCellAttributeProcessor(new CellHeightLmlAttribute(), "height");
        addCellAttributeProcessor(new CellMaxHeightLmlAttribute(), "maxHeight");
        addCellAttributeProcessor(new CellMaxSizeLmlAttribute(), "maxSize");
        addCellAttributeProcessor(new CellMaxWidthLmlAttribute(), "maxWidth");
        addCellAttributeProcessor(new CellMinHeightLmlAttribute(), "minHeight");
        addCellAttributeProcessor(new CellMinSizeLmlAttribute(), "minSize");
        addCellAttributeProcessor(new CellMinWidthLmlAttribute(), "minWidth");
        addCellAttributeProcessor(new CellPadBottomLmlAttribute(), "padBottom");
        addCellAttributeProcessor(new CellPadLeftLmlAttribute(), "padLeft");
        addCellAttributeProcessor(new CellPadLmlAttribute(), "pad");
        addCellAttributeProcessor(new CellPadRightLmlAttribute(), "padRight");
        addCellAttributeProcessor(new CellPadTopLmlAttribute(), "padTop");
        addCellAttributeProcessor(new CellPrefHeightLmlAttribute(), "prefHeight");
        addCellAttributeProcessor(new CellPrefSizeLmlAttribute(), "prefSize");
        addCellAttributeProcessor(new CellPrefWidthLmlAttribute(), "prefWidth");
        addCellAttributeProcessor(new CellSizeLmlAttribute(), "size");
        addCellAttributeProcessor(new CellSpaceBottomLmlAttribute(), "spaceBottom");
        addCellAttributeProcessor(new CellSpaceLeftLmlAttribute(), "spaceLeft");
        addCellAttributeProcessor(new CellSpaceLmlAttribute(), "space");
        addCellAttributeProcessor(new CellSpaceRightLmlAttribute(), "spaceRight");
        addCellAttributeProcessor(new CellSpaceTopLmlAttribute(), "spaceTop");
        addCellAttributeProcessor(new CellUniformLmlAttribute(), "uniform");
        addCellAttributeProcessor(new CellUniformXLmlAttribute(), "uniformX");
        addCellAttributeProcessor(new CellUniformYLmlAttribute(), "uniformY");
        addCellAttributeProcessor(new CellWidthLmlAttribute(), "width");
        addAttributeProcessor(new RowLmlAttribute(), "row"); // Row attribute is not available for default cell.
    }

    /** @param cellAttribute will be registered using {@link #addAttributeProcessor(LmlAttribute, String...)}.
     * @param names will be used to register cell attribute. Same names with "default" prefix will be used for Table's
     *            default cell. */
    protected void addCellAttributeProcessor(final AbstractCellLmlAttribute cellAttribute, final String... names) {
        addAttributeProcessor(cellAttribute, names);
        // Registering table's default cell attribute - using same names with "default" prefix:
        for (int index = 0, length = names.length; index < length; index++) {
            names[index] = "default" + names[index];
        }
        addAttributeProcessor(new TableCellDefaultsLmlAttribute(cellAttribute), names);
    }

    /** TextField widget attributes. */
    protected void registerTextFieldAttributes() {
        addAttributeProcessor(new BlinkTimeLmlAttribute(), "blink", "blinkTime");
        addAttributeProcessor(new CursorLmlAttribute(), "cursor", "cursorPosition");
        addAttributeProcessor(new DigitsOnlyLmlAttribute(), "digitsOnly", "numeric");
        addAttributeProcessor(new InputAlignLmlAttribute(), "textAlign", "inputAlign", "textAlignment");
        addAttributeProcessor(new MaxLengthLmlAttribute(), "max", "maxLength");
        addAttributeProcessor(new MessageLmlAttribute(), "message", "messageText");
        addAttributeProcessor(new PasswordCharacterLmlAttribute(), "passwordCharacter", "passwordChar");
        addAttributeProcessor(new PasswordModeLmlAttribute(), "passwordMode", "password");
        addAttributeProcessor(new SelectAllLmlAttribute(), "selectAll");
        addAttributeProcessor(new TextFieldFilterLmlAttribute(), "filter", "textFilter", "textFieldFilter");
        addAttributeProcessor(new TextFieldListenerLmlAttribute(), "listener", "textListener", "textFieldListener");
        addAttributeProcessor(new PrefRowsLmlAttribute(), "prefRows", "prefRowsAmount"); // TextArea.
    }

    /** Tooltip listener attributes. */
    protected void registerTooltipAttributes() {
        addAttributeProcessor(new AlwaysLmlAttribute(), "always");
        addAttributeProcessor(new InstantLmlAttribute(), "instant");
        addAttributeProcessor(new KeepTooltipLmlAttribute(), "keep");
        addAttributeProcessor(new TooltipIdsLmlAttribute(), "ids");
    }

    /** Touchpad widget attributes. */
    protected void registerTouchpadAttributes() {
        addAttributeProcessor(new DeadZoneLmlAttribute(), "deadzone", "deadzoneRadius");
        addAttributeProcessor(new ResetOnTouchUpLmlAttribute(), "resetOnTouchUp");
    }

    /** Tree widget attributes. */
    protected void registerTreeAttributes() {
        addAttributeProcessor(new IconSpacingLmlAttribute(), "iconSpacing", "iconSpace");
        addAttributeProcessor(new TreePaddingLmlAttribute(), "padding", "treePad");
        addAttributeProcessor(new YSpacingLmlAttribute(), "ySpacing", "ySpace");
    }

    /** VerticalGroup widget attributes. */
    protected void registerVerticalGroupAttributes() {
        addAttributeProcessor(new VerticalGroupAlignmentLmlAttribute(), "groupAlign");
        addAttributeProcessor(new VerticalGroupFillLmlAttribute(), "groupFill");
        addAttributeProcessor(new VerticalGroupPaddingBottomLmlAttribute(), "groupPadBottom");
        addAttributeProcessor(new VerticalGroupPaddingLeftLmlAttribute(), "groupPadLeft");
        addAttributeProcessor(new VerticalGroupPaddingLmlAttribute(), "groupPad", "padding");
        addAttributeProcessor(new VerticalGroupPaddingRightLmlAttribute(), "groupPadRight");
        addAttributeProcessor(new VerticalGroupPaddingTopLmlAttribute(), "groupPadTop");
        addAttributeProcessor(new VerticalGroupReverseLmlAttribute(), "reverse");
        addAttributeProcessor(new VerticalGroupSpacingLmlAttribute(), "groupSpace", "spacing");
    }

    /** Window widget attributes. */
    protected void registerWindowAttributes() {
        addAttributeProcessor(new KeepWithinStageLmlAttribute(), "keepWithinStage", "keepWithin");
        addAttributeProcessor(new ModalLmlAttribute(), "modal");
        addAttributeProcessor(new MovableLmlAttribute(), "movable");
        addAttributeProcessor(new ResizeableLmlAttribute(), "resizeable", "resizable");
        addAttributeProcessor(new ResizeBorderLmlAttribute(), "resizeBorder", "border");
        addAttributeProcessor(new TitleAlignmentLmlAttribute(), "titleAlign", "titleAlignment");
        addAttributeProcessor(new TitleLmlAttribute(), "title");
    }
}
