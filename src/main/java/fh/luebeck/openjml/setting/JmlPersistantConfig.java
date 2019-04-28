package fh.luebeck.openjml.setting;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*

 */
@State(
        name = "OpenJMLConfig",
        storages = @Storage("OpenJmlConfiguragtion.xml")
)
public class JmlPersistantConfig implements PersistentStateComponent<JmlPersistantConfig> {


    public String pathToOJml;
    public Boolean useCustomSolver;
    public String selectedSolver;
    public String pathToCustomSolver;
    public Boolean useClasspath;
    public Boolean useSourcepath;

    public JmlPersistantConfig() {
        this.setDefaultValues();
    }

    @Nullable
    public static JmlPersistantConfig getInstance() {
        return ServiceManager.getService(JmlPersistantConfig.class);
    }

    public void setDefaultValues() {
        this.pathToOJml = "";
        this.useCustomSolver = false;
        this.useClasspath = false;
        this.useSourcepath = false;
        this.pathToCustomSolver = "";
        this.selectedSolver = "";
    }

    @Nullable
    @Override
    public JmlPersistantConfig getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull JmlPersistantConfig state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public String getPathToOJml() {
        return pathToOJml;
    }

    public void setPathToOJml(String pathToOJml) {
        this.pathToOJml = pathToOJml;
    }

    public Boolean isUseClasspath() {
        return useClasspath;
    }

    public Boolean isUseSourcepath() {
        return useSourcepath;
    }

    public void setUseClasspath(Boolean useClasspath) {
        this.useClasspath = useClasspath;
    }

    public Boolean isUseCustomSolver() {
        return useCustomSolver;
    }

    public void setUseCustomSolver(Boolean useCustomSolver) {
        this.useCustomSolver = useCustomSolver;
    }

    public String getSelectedSolver() {
        return selectedSolver;
    }

    public void setUseSourcepath(Boolean useSourcepath) {
        this.useSourcepath = useSourcepath;
    }

    public void setSelectedSolver(String selectedSolver) {
        this.selectedSolver = selectedSolver;
    }

    public String getPathToCustomSolver() {
        return pathToCustomSolver;
    }

    public void setPathToCustomSolver(String pathToCustomSolver) {
        this.pathToCustomSolver = pathToCustomSolver;
    }
}
