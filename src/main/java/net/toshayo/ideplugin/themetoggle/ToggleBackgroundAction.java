package net.toshayo.ideplugin.themetoggle;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.wm.impl.IdeBackgroundUtil;
import org.jetbrains.annotations.NotNull;

public class ToggleBackgroundAction extends AnAction {
    public static final String HIDDEN_IMAGE_KEY = ToggleBackgroundAction.class.getName() + "#hiddenBackgroundImage";

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        String prevValue = PropertiesComponent.getInstance().getValue(IdeBackgroundUtil.EDITOR_PROP);
        String nextValue = null;

        if(prevValue == null) {
            nextValue = PropertiesComponent.getInstance().getValue(HIDDEN_IMAGE_KEY);
        } else {
            PropertiesComponent.getInstance().setValue(HIDDEN_IMAGE_KEY, prevValue);
        }
        PropertiesComponent.getInstance().setValue(IdeBackgroundUtil.EDITOR_PROP, nextValue);
        PropertiesComponent.getInstance().setValue(IdeBackgroundUtil.FRAME_PROP, nextValue);
        IdeBackgroundUtil.repaintAllWindows();
    }
}
