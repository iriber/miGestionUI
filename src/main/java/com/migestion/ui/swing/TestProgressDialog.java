package com.migestion.ui.swing;

import java.awt.EventQueue;

import javax.swing.SwingWorker;
import javax.swing.UIManager;

import com.migestion.swing.view.dialogs.ProgressDialog;
import com.migestion.ui.swing.i18n.I18nMessages;

public class TestProgressDialog {

    public static void main(String[] args) {
        new TestProgressDialog();
    }

    public TestProgressDialog() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                SwingWorker worker = new SwingWorker() {
                    @Override
                    protected Object doInBackground() throws Exception {
                        for (int index = 0; index < 100; index++) {
                            Thread.sleep(50);
                            setProgress(index);
                        }
                        return null;
                    }

                };

                ProgressDialog.showProgress(null, worker, I18nMessages.TITULO_MAIN,  "Inicializando el sistema", "Espere unos minutos",null);

                System.exit(0);

            }

        });
    }
//
//    public static class ProgressDialog extends JDialog {
//
//        private JLabel message;
//        private JLabel subMessage;
//        private JProgressBar progressBar;
//
//        public ProgressDialog(Component parent, SwingWorker worker) {
//
//            super(parent == null ? null : SwingUtilities.getWindowAncestor(parent));
//            setModal(true);
//
//            ((JComponent)getContentPane()).setBorder(new EmptyBorder(8, 8, 8, 8));
//
//            message = new JLabel("Doing important stuff");
//            subMessage = new JLabel("Go make you're self a cup of coffee...");
//            progressBar = new JProgressBar();
//
//            setLayout(new GridBagLayout());
//            GridBagConstraints gbc = new GridBagConstraints();
//            gbc.insets = new Insets(2, 2, 2, 2);
//            gbc.gridx = 0;
//            gbc.gridy = 0;
//            gbc.anchor = GridBagConstraints.WEST;
//            add(message, gbc);
//
//            gbc.gridy++;
//            add(subMessage, gbc);
//
//            gbc.gridy++;
//            gbc.weightx = 1;
//            gbc.fill = GridBagConstraints.HORIZONTAL;
//            add(progressBar, gbc);
//
//            pack();
//
//            worker.addPropertyChangeListener(new PropertyChangeHandler());
//            switch (worker.getState()) {
//                case PENDING:
//                    worker.execute();
//                    break;
//            }
//
//        }
//
//        public static void showProgress(Component parent, SwingWorker worker) {
//
//            ProgressDialog dialog = new ProgressDialog(parent, worker);
//            dialog.setLocationRelativeTo(parent);
//            dialog.setVisible(true);
//
//        }
//
//        public class PropertyChangeHandler implements PropertyChangeListener {
//
//            public void propertyChange(PropertyChangeEvent evt) {
//                if (evt.getPropertyName().equals("state")) {
//                    SwingWorker.StateValue state = (SwingWorker.StateValue) evt.getNewValue();
//                    switch (state) {
//                        case DONE:
//                            dispose();
//                            break;
//                    }
//                } else if (evt.getPropertyName().equals("progress")) {
//                    progressBar.setValue((Integer)evt.getNewValue());
//                }
//            }
//
//        }
//
//    }

}