/**
 * L2FProd.com Common Components 7.3 License.
 *
 * Copyright 2005-2007 L2FProd.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package libpadel;

import com.l2fprod.common.beans.editor.FilePropertyEditor;
import com.l2fprod.common.swing.UserPreferences;
import com.l2fprod.common.util.ResourceManager;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * FilePropertyEditor. <br>
 *  
 */
public class PaDELSaveFilePropertyEditor extends PaDELFilePropertyEditor {

  protected void selectFile() {
    ResourceManager rm = ResourceManager.all(FilePropertyEditor.class);

    JFileChooser chooser = UserPreferences.getDefaultFileChooser();
    chooser.setDialogTitle(rm.getString("FilePropertyEditor.dialogTitle"));
    chooser.setApproveButtonText(rm.getString("FilePropertyEditor.approveButtonText"));
    chooser.setApproveButtonMnemonic(rm.getChar("FilePropertyEditor.approveButtonMnemonic"));
    String oldFile = (String)getValue();
    File curFile = new File(oldFile);
    if (curFile != null)
    {
        chooser.setCurrentDirectory(curFile);
    }
    customizeFileChooser(chooser);
    
	if (JFileChooser.APPROVE_OPTION == chooser.showSaveDialog(editor)) {
        File f = new File(chooser.getSelectedFile().getAbsolutePath());
        if (f.exists())
        {
            int selection = JOptionPane.showConfirmDialog(null, "File exists. Overwrite file?", "File exists", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (selection == JOptionPane.YES_OPTION)
            {              
                String text = chooser.getSelectedFile().getAbsolutePath();
                textfield.setText(text);
                firePropertyChange(oldFile, text);
            }
        }
        else
        {
            String text = chooser.getSelectedFile().getAbsolutePath();
            textfield.setText(text);
            firePropertyChange(oldFile, text);
        }
    }
  }

}