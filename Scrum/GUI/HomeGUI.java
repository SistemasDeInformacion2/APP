package GUI;

import javax.swing.GroupLayout.*;
import javax.swing.*;
import java.util.*;
import control.*;

public class HomeGUI extends javax.swing.JFrame 
{
    private int idProyecto;
    
    public HomeGUI( int idProyecto ) 
    {
        initComponents();
        this.setTitle("Scrum");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    private void initComponents() {

        paneles = new javax.swing.JTabbedPane();
        taskboard = new javax.swing.JPanel();
        sprint = new javax.swing.JPanel();
        sprintPanel = new javax.swing.JPanel();
        sprintLabel = new javax.swing.JLabel();
        boxSprint = new javax.swing.JComboBox<>();
        okSprint = new javax.swing.JButton();
        newSprint = new javax.swing.JButton();
        charts = new javax.swing.JPanel();
        backlog = new javax.swing.JPanel();
        sprintBacklog = new javax.swing.JPanel();
        usuarios = new javax.swing.JPanel();
        scrollHistorias = new javax.swing.JScrollPane();
        panelHistorias = new javax.swing.JPanel();
        newHistory = new javax.swing.JButton();
                
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
        
        
        
        Gestionar_Historias gesHis = new Gestionar_Historias();
        List<Historia_Usuario> listaHistorias = gesHis.getHistorias();
        Historia_Usuario historia_usuario;
        gesHis.close();
 
        numeroHistorias=listaHistorias.size();
        
        userHistories = new JPanel[numeroHistorias];
        userHistLay = new GroupLayout[numeroHistorias];
        
        for( int h=0; h<numeroHistorias; h++ )
        {
            historia_usuario = listaHistorias.get(h);
            
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
            tituloHistoria.setText( historia_usuario.getTitulo() );
            tituloHistoria.setBorder(null);

            userHistory.setEditable(false);
            userHistory.setBackground(historia.getBackground());
            userHistory.setColumns(20);
            userHistory.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
            userHistory.setLineWrap(true);
            userHistory.setRows(5);
            userHistory.setText( historia_usuario.getDescripcion() );
            userHistory.setWrapStyleWord(true);
            userHistory.setBorder(null);
            scrollHistory.setViewportView(userHistory);
        
            etComplejidad.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
            etComplejidad.setText( "Complejidad" );

            etImportancia.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
            etImportancia.setText( "Importancia" );

            valorImportancia.setEditable(false);
            valorImportancia.setBackground(historia.getBackground());
            valorImportancia.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
            valorImportancia.setText( ""+historia_usuario.getImportancia() );
            valorImportancia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

            valorComplejidad.setEditable(false);
            valorComplejidad.setBackground(historia.getBackground());
            valorComplejidad.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
            valorComplejidad.setText( ""+historia_usuario.getComplejidad() );
            valorComplejidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            
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

        newHistory.setText("Nueva Historia");
        newHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirHistoria(evt);
            }
        });
        javax.swing.GroupLayout panelHistoriasLayout = new javax.swing.GroupLayout(panelHistorias);
        panelHistorias.setLayout(panelHistoriasLayout);
        
        ParallelGroup aux = panelHistoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        for(int ha=0; ha<numeroHistorias; ha++)
        {
            aux.addComponent(userHistories[ha],javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        }
        
        SequentialGroup aux2 = panelHistoriasLayout.createSequentialGroup().addContainerGap();
        aux2.addComponent(newHistory).addGap(23, 23, 23);
        for(int h2=0; h2<numeroHistorias; h2++){
            aux2.addComponent(userHistories[h2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED);
        }
        

        panelHistoriasLayout.setHorizontalGroup(
            panelHistoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aux.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHistoriasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(newHistory)))
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

        paneles.addTab("Product Backlog", backlog);
        
        sprintPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        sprintLabel.setText("Seleccione el Sprint a trabajar:");

        boxSprint.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sprint 1", "Sprint 2", "Sprint 3", "Sprint 4" }));

        okSprint.setText("OK");
        okSprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarSprint(evt);
            }
        });
        
        newSprint.setText("Nuevo Sprint");
        newSprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoSprint(evt);
            }
        });

        javax.swing.GroupLayout sprintPanelLayout = new javax.swing.GroupLayout(sprintPanel);
        sprintPanel.setLayout(sprintPanelLayout);
        sprintPanelLayout.setHorizontalGroup(
            sprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sprintPanelLayout.createSequentialGroup()
                .addGroup(sprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sprintPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(sprintLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sprintPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(newSprint)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sprintPanelLayout.createSequentialGroup()
                .addGap(0, 104, Short.MAX_VALUE)
                .addGroup(sprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sprintPanelLayout.createSequentialGroup()
                        .addComponent(boxSprint, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sprintPanelLayout.createSequentialGroup()
                        .addComponent(okSprint, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182))))
        );
        sprintPanelLayout.setVerticalGroup(
            sprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sprintPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(sprintLabel)
                .addGap(24, 24, 24)
                .addComponent(boxSprint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okSprint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(newSprint)
                .addContainerGap())
        );
        
        javax.swing.GroupLayout sprintLayout = new javax.swing.GroupLayout(sprint);
        sprint.setLayout(sprintLayout);
        sprintLayout.setHorizontalGroup(
            sprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sprintLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(sprintPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        sprintLayout.setVerticalGroup(
            sprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sprintLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(sprintPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        paneles.addTab("Sprint", sprint);

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

        paneles.addTab("Charts", charts);
    
        javax.swing.GroupLayout usuariosLayout = new javax.swing.GroupLayout(usuarios);
        usuarios.setLayout(usuariosLayout);
        usuariosLayout.setHorizontalGroup(
            usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        usuariosLayout.setVerticalGroup(
            usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        paneles.addTab("Team", usuarios);

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
    }                      

    private void anadirHistoria(java.awt.event.ActionEvent evt) 
    {                                           
        addHistoryGUI nueva_ventana_historia = new addHistoryGUI( this );
    }
    
    private void seleccionarSprint(java.awt.event.ActionEvent evt) 
    {                                         
        SprintGUI sprint = new SprintGUI();
    }
    
    private void nuevoSprint(java.awt.event.ActionEvent evt) 
    {                                           
        Nuevo_Sprint_GUI nuevoSprint = new Nuevo_Sprint_GUI();
    }         
    
    public int getIdProyecto()
    {
        return idProyecto;
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
    private javax.swing.JLabel sprintLabel;
    private javax.swing.JPanel sprintPanel;
    private javax.swing.JPanel sprint;
    private javax.swing.JPanel taskboard;
    private javax.swing.JTextField tituloHistoria;
    private javax.swing.JTextArea userHistory;
    private javax.swing.JTextField valorComplejidad;
    private javax.swing.JTextField valorImportancia;
    private javax.swing.JButton newHistory;
    private javax.swing.JButton newSprint;
    private javax.swing.JButton okSprint;
    private JPanel[] userHistories;
    private GroupLayout[] userHistLay;
    private javax.swing.JComboBox<String> boxSprint;
    private int numeroHistorias;
    // End of variables declaration                   
}
