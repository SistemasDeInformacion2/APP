package GUI;

import javax.swing.*;
import javax.swing.GroupLayout.*;

public class SprintGUI extends javax.swing.JFrame 
{
    public SprintGUI() {
        initComponents();
        this.setTitle("Sprint");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
                    
    private void initComponents() 
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        paneles = new javax.swing.JTabbedPane();
        taskboard = new javax.swing.JPanel();
        sprint = new javax.swing.JPanel();
        charts = new javax.swing.JPanel();
        backlog = new javax.swing.JPanel();
        sprintBacklog = new javax.swing.JPanel();
        usuarios = new javax.swing.JPanel();
        scrollHistorias = new javax.swing.JScrollPane();
        panelHistorias = new javax.swing.JPanel();
        
        numeroHistorias = 10;
        userHistories = new JPanel[numeroHistorias];
        userHistLay = new GroupLayout[numeroHistorias];
                
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout taskboardLayout = new javax.swing.GroupLayout(taskboard);
        taskboard.setLayout(taskboardLayout);
        taskboardLayout.setHorizontalGroup(
            taskboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        taskboardLayout.setVerticalGroup(
            taskboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        paneles.addTab("TaskBoard", taskboard);
      
        for(int h = 0; h<numeroHistorias; h++){
            
            historia = new javax.swing.JPanel();
            tituloHistoria = new javax.swing.JTextField();
            etComplejidad = new javax.swing.JLabel();
            etImportancia = new javax.swing.JLabel();
            valorImportancia = new javax.swing.JTextField();
            valorComplejidad = new javax.swing.JTextField();
            scrollHistory = new javax.swing.JScrollPane();
            userHistory = new javax.swing.JTextArea();
        
            historia.setBackground(java.awt.Color.gray);
            historia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            
            tituloHistoria.setEditable(false);
            tituloHistoria.setBackground(historia.getBackground());
            tituloHistoria.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
            tituloHistoria.setText("Historia");
            tituloHistoria.setBorder(null);
            tituloHistoria.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tituloHistoriaActionPerformed(evt);
                }
            });

            userHistory.setEditable(false);
            userHistory.setBackground(historia.getBackground());
            userHistory.setColumns(20);
            userHistory.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
            userHistory.setLineWrap(true);
            userHistory.setRows(5);
            userHistory.setText("Aqui va la historia");
            userHistory.setWrapStyleWord(true);
            userHistory.setBorder(null);
            scrollHistory.setViewportView(userHistory);
        
            etComplejidad.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
            etComplejidad.setText("Complejidad");

            etImportancia.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
            etImportancia.setText("Importancia");

            valorImportancia.setEditable(false);
            valorImportancia.setBackground(historia.getBackground());
            valorImportancia.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
            valorImportancia.setText("100");
            valorImportancia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            valorImportancia.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    valorImportanciaActionPerformed(evt);
                }
            });

            valorComplejidad.setEditable(false);
            valorComplejidad.setBackground(historia.getBackground());
            valorComplejidad.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
            valorComplejidad.setText("10");
            valorComplejidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            valorComplejidad.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    valorComplejidadActionPerformed(evt);
                }
            });
            userHistories[h] = historia;
            
            javax.swing.GroupLayout historiaLayout = new javax.swing.GroupLayout(userHistories[h]);
            userHistories[h].setLayout(historiaLayout);
            historiaLayout.setHorizontalGroup(
                historiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(historiaLayout.createSequentialGroup()
                    .addComponent(scrollHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(historiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(historiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(historiaLayout.createSequentialGroup()
                                .addGroup(historiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etComplejidad, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etImportancia, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historiaLayout.createSequentialGroup()
                                .addComponent(valorComplejidad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historiaLayout.createSequentialGroup()
                            .addComponent(valorImportancia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30))))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historiaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tituloHistoria, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                    .addContainerGap())
            );
            historiaLayout.setVerticalGroup(
                historiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(historiaLayout.createSequentialGroup()
                    .addComponent(tituloHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(historiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(historiaLayout.createSequentialGroup()
                            .addComponent(etComplejidad)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(valorComplejidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etImportancia)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(valorImportancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(scrollHistory))
                    .addContainerGap())
            );
            
            userHistLay[h] = historiaLayout;
        }
        
        javax.swing.GroupLayout panelHistoriasLayout = new javax.swing.GroupLayout(panelHistorias);
        panelHistorias.setLayout(panelHistoriasLayout);
        
        
        ParallelGroup aux = panelHistoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        for(int ha=0; ha<numeroHistorias; ha++){
            aux.addComponent(userHistories[ha],javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        }
        SequentialGroup aux2 = panelHistoriasLayout.createSequentialGroup().addContainerGap();
        for(int h2=0; h2<numeroHistorias; h2++){
            aux2.addComponent(userHistories[h2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED);
        }
        
        panelHistoriasLayout.setHorizontalGroup(
            panelHistoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aux)
                .addContainerGap())
        );
        panelHistoriasLayout.setVerticalGroup(
            panelHistoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aux2)
        );

        scrollHistorias.setViewportView(panelHistorias);

        javax.swing.GroupLayout backlogLayout = new javax.swing.GroupLayout(backlog);
        backlog.setLayout(backlogLayout);
        backlogLayout.setHorizontalGroup(
            backlogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollHistorias, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        backlogLayout.setVerticalGroup(
            backlogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollHistorias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        paneles.addTab("Sprint Backlog", backlog);
        
        javax.swing.GroupLayout chartsLayout = new javax.swing.GroupLayout(charts);
        charts.setLayout(chartsLayout);
        chartsLayout.setHorizontalGroup(
            chartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        chartsLayout.setVerticalGroup(
            chartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        paneles.addTab("Burndown Chart", charts);
    
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneles)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneles)
        );

        pack();
    }// </editor-fold>                        

    private void tituloHistoriaActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void valorImportanciaActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void valorComplejidadActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    // Variables declaration - do not modify
    private javax.swing.JPanel sprintBacklog;
    private javax.swing.JPanel usuarios;
    private javax.swing.JPanel backlog;
    private javax.swing.JPanel charts;
    private javax.swing.JLabel etComplejidad;
    private javax.swing.JLabel etImportancia;
    private javax.swing.JPanel historia;
    private javax.swing.JPanel panelHistorias;
    private javax.swing.JTabbedPane paneles;
    private javax.swing.JScrollPane scrollHistorias;
    private javax.swing.JScrollPane scrollHistory;
    private javax.swing.JPanel sprint;
    private javax.swing.JPanel taskboard;
    private javax.swing.JTextField tituloHistoria;
    private javax.swing.JTextArea userHistory;
    private javax.swing.JTextField valorComplejidad;
    private javax.swing.JTextField valorImportancia;
    private JPanel[] userHistories;
    private GroupLayout[] userHistLay;
    private int numeroHistorias;
    // End of variables declaration                   
}
