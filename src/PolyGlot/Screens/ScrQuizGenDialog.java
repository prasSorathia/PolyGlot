/*
 * Copyright (c) 2016, draque.thompson
 * All rights reserved.
 *
 * Licensed under: Creative Commons Attribution-NonCommercial 4.0 International Public License
 *  See LICENSE.TXT included with this code to read the full license agreement.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package PolyGlot.Screens;

import PolyGlot.CustomControls.InfoBox;
import PolyGlot.CustomControls.PFrame;
import PolyGlot.CustomControls.PTextField;
import PolyGlot.DictCore;
import PolyGlot.Nodes.ConWord;
import PolyGlot.Nodes.TypeNode;
import PolyGlot.QuizEngine.Quiz;
import PolyGlot.QuizEngine.QuizFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;

/**
 *
 * @author draque.thompson
 */
public class ScrQuizGenDialog extends PFrame {

    /**
     * Creates new form scrQuizGenDialog
     * @param _core
     */
    public ScrQuizGenDialog(DictCore _core) {
        core = _core;
        initComponents();        
        chkLocalQuiz.setText(core.localLabel() + " Equivalent");
        chkConlangQuiz.setText(core.conLabel() + " Equivalent");
        populateDropdowns();
    }
    
    private void populateDropdowns() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("-- Part of Speech --");
        for (TypeNode curNode : core.getTypes().getNodes()) {
            model.addElement(curNode);
        }
        
        cmbFilterType.setModel(model);
    }

    private void takeQuiz() {
        ConWord filter = new ConWord();
        QuizFactory factory = new QuizFactory(core);
        int numQuestions;
        
        try {
            numQuestions = Integer.parseInt(txtNumQuestions.getText());
        } catch (Exception e) {
            InfoBox.error("Integer Value Required", "Number of questions must be an integer value.", this);
            return;
        }
        
        filter.setValue(txtFilterConWord.getText());
        filter.setLocalWord(txtFilterLocalWord.getText());
        filter.setPronunciation(txtFilterProc.getText());
        if (cmbFilterType.getSelectedItem() instanceof TypeNode) {
            filter.setWordTypeId(((TypeNode)cmbFilterType.getSelectedItem()).getId());
        }
        
        try {
            Quiz genQuiz = factory.generateLexicalQuiz(numQuestions, 
                    chkConlangQuiz.isSelected(), 
                    chkLocalQuiz.isSelected(), 
                    chkTypeQuiz.isSelected(), 
                    chkProcQuiz.isSelected(), 
                    chkDefQuiz.isSelected(), 
                    chkClassQuiz.isSelected(), 
                    filter);
            
            ScrQuizScreen.run(genQuiz, core);
            dispose();
        } catch (Exception e) {
            //e.printStackTrace();
            InfoBox.error("Quiz Generation Error", "Unable to generate quiz: " + e.getLocalizedMessage(), this);
        }
    }
    
    private void clearFilter() {
        txtFilterConWord.setText("");
        txtFilterLocalWord.setText("");
        txtFilterProc.setText("");
        cmbFilterType.setSelectedIndex(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnQuiz = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtFilterConWord = new PTextField(core, false, "-- " + core.conLabel() + " Filter --");
        txtFilterLocalWord = new PTextField(core, true, "-- " + core.localLabel() + " Filter --");
        cmbFilterType = new javax.swing.JComboBox<>();
        txtFilterProc = new PTextField(core, true, "-- Pronunciation Filter --");
        btnClearFilter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumQuestions = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        chkDefQuiz = new javax.swing.JCheckBox();
        chkProcQuiz = new javax.swing.JCheckBox();
        chkClassQuiz = new javax.swing.JCheckBox();
        chkTypeQuiz = new javax.swing.JCheckBox();
        chkLocalQuiz = new javax.swing.JCheckBox();
        chkConlangQuiz = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnQuiz.setText("Take Quiz");
        btnQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuizActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtFilterConWord.setToolTipText("Filter by conword here");

        txtFilterLocalWord.setToolTipText("Filter by local word here");

        cmbFilterType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbFilterType.setToolTipText("Filter by part of speech here");

        txtFilterProc.setToolTipText("Filter by pronunciation here");

        btnClearFilter.setText("Clear Filter");
        btnClearFilter.setToolTipText("Clear the filter");
        btnClearFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFilterActionPerformed(evt);
            }
        });

        jLabel1.setText("Vocabulary Filter");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbFilterType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFilterLocalWord, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(txtFilterConWord)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addComponent(btnClearFilter))
                    .addComponent(txtFilterProc))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilterConWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFilterProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFilterLocalWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFilterType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearFilter))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Quiz Length");

        txtNumQuestions.setText("10");
        txtNumQuestions.setToolTipText("Number of questions in quiz (defaults to 10)");

        jPanel3.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
        );

        jLabel3.setText("Quiz On:");

        chkDefQuiz.setText("Definition");
        chkDefQuiz.setToolTipText("Definitions of conlang words");

        chkProcQuiz.setText("Pronunciation");
        chkProcQuiz.setToolTipText("Pronunciation of conlang words");

        chkClassQuiz.setText("Word Class");
        chkClassQuiz.setToolTipText("Classes of words (such as male/female)");
        chkClassQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkClassQuizActionPerformed(evt);
            }
        });

        chkTypeQuiz.setText("Part of Speech");
        chkTypeQuiz.setToolTipText("Part of speech for words");
        chkTypeQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTypeQuizActionPerformed(evt);
            }
        });

        chkLocalQuiz.setText("-UPDATE VIA CODE-");
        chkLocalQuiz.setToolTipText("Conlang equivlent of local language words");

        chkConlangQuiz.setText("-UPDATE VIA CODE-");
        chkConlangQuiz.setToolTipText("The conlang equivalent of local language words");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkLocalQuiz)
                            .addComponent(chkTypeQuiz)
                            .addComponent(chkClassQuiz)
                            .addComponent(chkProcQuiz)
                            .addComponent(chkDefQuiz)
                            .addComponent(chkConlangQuiz))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkLocalQuiz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkTypeQuiz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkClassQuiz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkProcQuiz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkDefQuiz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkConlangQuiz)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Vocab Quiz", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuiz)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuiz)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuizActionPerformed
        takeQuiz();
    }//GEN-LAST:event_btnQuizActionPerformed

    private void chkClassQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkClassQuizActionPerformed
        // do not allow self to be checked if no classes exist
        if (core.getWordPropertiesCollection().getAllWordProperties().isEmpty()
                && chkClassQuiz.isSelected()) {
            InfoBox.warning("No Classes Exist", "No word classes exist.", this);
            chkClassQuiz.setSelected(false);
        }            
    }//GEN-LAST:event_chkClassQuizActionPerformed

    private void btnClearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFilterActionPerformed
        clearFilter();
    }//GEN-LAST:event_btnClearFilterActionPerformed

    private void chkTypeQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTypeQuizActionPerformed
        // do not allow self to be checked if no PoS exist
        if (core.getTypes().getNodes().isEmpty()
                && chkTypeQuiz.isSelected()) {
            InfoBox.warning("No PoS Exist", "No parts of speech exist.", this);
            chkTypeQuiz.setSelected(false);
        }
    }//GEN-LAST:event_chkTypeQuizActionPerformed

    /**
     * @param core
     * @return 
     */
    public static ScrQuizGenDialog run(final DictCore core) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScrQuizGenDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        ScrQuizGenDialog s = new ScrQuizGenDialog(core);
        s.setVisible(true);
        return s;
    }
    @Override
    public void updateAllValues(DictCore _core) {
        // does nothing for this window
    }

    @Override
    public boolean thisOrChildrenFocused() {
        return this.isFocused();
    }

    @Override
    public void addBindingToComponent(JComponent c) {
        // no bindings to add to this window at this time.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClearFilter;
    private javax.swing.JButton btnQuiz;
    private javax.swing.JCheckBox chkClassQuiz;
    private javax.swing.JCheckBox chkConlangQuiz;
    private javax.swing.JCheckBox chkDefQuiz;
    private javax.swing.JCheckBox chkLocalQuiz;
    private javax.swing.JCheckBox chkProcQuiz;
    private javax.swing.JCheckBox chkTypeQuiz;
    private javax.swing.JComboBox<String> cmbFilterType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtFilterConWord;
    private javax.swing.JTextField txtFilterLocalWord;
    private javax.swing.JTextField txtFilterProc;
    private javax.swing.JTextField txtNumQuestions;
    // End of variables declaration//GEN-END:variables
}
