package fh.luebeck.openjml.actions;

import com.intellij.execution.ExecutionException;
import com.intellij.ide.SaveAndSyncHandler;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.FileIndexFacade;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.vfs.VirtualFile;
import fh.luebeck.openjml.util.JmlRunUtil;
import com.intellij.mock.MockFileIndexFacade;

public class JmlRunAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        SaveAndSyncHandler.getInstance().saveProjectsAndDocuments();
        VirtualFile virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE);
        if(virtualFile != null) {
            String pathToJavaFile = virtualFile.getCanonicalPath();
            try {
                final Module module = FileIndexFacade.getInstance(e.getProject()).getModuleForFile(virtualFile);
                final String source = ProjectFileIndex.SERVICE.getInstance(e.getProject()).getSourceRootForFile(virtualFile).getCanonicalPath();
                JmlRunUtil.runOpenJml(e.getProject(), module, source, pathToJavaFile);
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void update(AnActionEvent e) {
        Project project = e.getProject();
        VirtualFile virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE);
        if (virtualFile != null && project != null) {
            e.getPresentation().setEnabled(virtualFile.getFileType() instanceof JavaFileType);
        } else {
            e.getPresentation().setEnabled(false);
        }
    }

}
