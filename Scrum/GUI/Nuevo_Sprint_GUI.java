package GUI;

import java.awt.Choice;
import java.sql.*;
import java.util.*;
import control.*;

public class Nuevo_Sprint_GUI extends javax.swing.JFrame 
{
    Connection con;
    
    public Nuevo_Sprint_GUI() 
    {
        con = new ConexionDB().conexion();
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() 
    {
        label1 = new java.awt.Label();
        nuevoSprintDialog = new javax.swing.JDialog();
        nuevoSprintRes = new java.awt.Label();
        choiceMesesIn = new java.awt.Choice();
        choiceAnhosIn = new java.awt.Choice();
        choiceDiasIn = new java.awt.Choice();
        choiceAnhosF = new java.awt.Choice();
        choiceMesesF = new java.awt.Choice();
        choiceDiasF = new java.awt.Choice();
        anho_label = new java.awt.Label();
        mesLabel = new java.awt.Label();
        diaLabel1 = new java.awt.Label();
        diaLabel = new java.awt.Label();
        mesLabel1 = new java.awt.Label();
        anho_label1 = new java.awt.Label();
        choiceProductOwner = new java.awt.Choice();
        choiceTeam = new java.awt.Choice();
        productOwnerLabel = new javax.swing.JLabel();
        teamLabel = new javax.swing.JLabel();
        fechaIniLabel = new javax.swing.JLabel();
        fechaFinLabel = new javax.swing.JLabel();
        Crear_button = new javax.swing.JButton();
        Cancelar_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        choicePlanning = new java.awt.Choice();

        label1.setText("label1");

        nuevoSprintDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        nuevoSprintDialog.setLocationByPlatform(true);
        nuevoSprintDialog.setMinimumSize(new java.awt.Dimension(346, 100));
        nuevoSprintDialog.setResizable(false);

        nuevoSprintRes.setAlignment(java.awt.Label.CENTER);

        javax.swing.GroupLayout nuevoSprintDialogLayout = new javax.swing.GroupLayout(nuevoSprintDialog.getContentPane());
        nuevoSprintDialog.getContentPane().setLayout(nuevoSprintDialogLayout);
        nuevoSprintDialogLayout.setHorizontalGroup(
            nuevoSprintDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoSprintDialogLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(nuevoSprintRes, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        nuevoSprintDialogLayout.setVerticalGroup(
            nuevoSprintDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoSprintDialogLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(nuevoSprintRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);

        llenarMeses(choiceMesesIn);

        llenarAnhos(choiceAnhosIn);

        if(choiceDiasIn.isVisible()){
            llenarDias(choiceDiasIn, choiceMesesIn, choiceAnhosIn);
        }

        llenarAnhos(choiceAnhosF);

        llenarMeses(choiceMesesF);

        llenarDias(choiceDiasF, choiceMesesF, choiceAnhosF);

        anho_label.setText("Año:");

        mesLabel.setText("Mes:");

        diaLabel1.setText("Dia:");

        diaLabel.setText("Dia:");

        mesLabel1.setText("Mes");

        anho_label1.setText("Año:");

        productOwnerLabel.setText("Product  Owner:");
        productOwnerLabel.setToolTipText("");

        teamLabel.setText("Team #:");

        fechaIniLabel.setText("Fecha de inicio:");

        fechaFinLabel.setText("Fecha de Finalizacion:");

        Crear_button.setText("Crear Sprint");
        Crear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Crear_buttonActionPerformed(evt);
            }
        });

        Cancelar_button.setText("Cancelar");
        Cancelar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar_buttonActionPerformed(evt);
            }
        });

        jLabel1.setText("Planning:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaIniLabel)
                            .addComponent(fechaFinLabel)
                            .addComponent(productOwnerLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mesLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(teamLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(choiceMesesIn, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(choiceMesesF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diaLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choiceDiasIn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(choiceDiasF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(anho_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anho_label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(choiceAnhosF, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(choiceAnhosIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(choiceTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(choicePlanning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(11, 11, 11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Crear_button)
                                        .addGap(18, 18, 18)
                                        .addComponent(Cancelar_button))))
                            .addComponent(choiceProductOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choiceAnhosIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choiceDiasIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choiceMesesIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anho_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaIniLabel))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choiceMesesF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choiceDiasF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choiceAnhosF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anho_label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaFinLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(choiceProductOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productOwnerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choiceTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teamLabel)
                    .addComponent(jLabel1)
                    .addComponent(choicePlanning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Crear_button)
                    .addComponent(Cancelar_button))
                .addGap(20, 20, 20))
        );

        anho_label.getAccessibleContext().setAccessibleName("Año");

        pack();
    }

    private void Cancelar_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        this.dispose();
    }

    private void Crear_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        /*GestionarSprint sprint = new GestionarSprint();
        
        if( sprint.addSprint( choiceDiasIn.getSelectedItem(), choiceMesesIn.getSelectedItem(), choiceAnhosIn.getSelectedItem(), choiceDiasF.getSelectedItem(), choiceMesesF.getSelectedItem(), choiceAnhosF.getSelectedItem(), Integer.parseInt( choiceProductOwner.getSelectedItem() ), Integer.parseInt( choiceTeam.getSelectedItem() ), Integer.parseInt( choicePlanning.getSelectedItem() ) ) )
        {
            nuevoSprintRes.setText("Nuevo Sprint Creado!");
            nuevoSprintDialog.setVisible(true);
            this.dispose();
        }
        else
        {
            nuevoSprintRes.setText("Sprint no creado");
            nuevoSprintDialog.setVisible(true);
        }*/
    }
    
    private void llenarMeses(Choice c)
    {
        c.add("Enero");
        c.add("Febrero");
        c.add("Marzo");
        c.add("Abril");
        c.add("Mayo");
        c.add("Junio");
        c.add("Julio");
        c.add("Agosto");
        c.add("Septiembre");
        c.add("Octubre");
        c.add("Noviembre");
        c.add("Diciembre");
    }
    
    private void llenarAnhos(Choice c)
    {
        for( int i=2016; i<2030 ; i++ )
            c.add( Integer.toString(i) );
    }
    
    public void llenarDias(Choice c, Choice m, Choice y)
    {
        if(m.getSelectedItem().equals("Abril")||m.getSelectedItem().equals("Junio")||m.getSelectedItem().equals("Septiembre")||m.getSelectedItem().equals("Noviembre") ){
            
            for(int i=1;i<=30;i++)
            {
                c.add(Integer.toString(i));
            }
        
        }
        
        else{
            if((m.getSelectedItem().equals("Febrero"))){
                
                if(Integer.parseInt(y.getSelectedItem())%4==0){
                    for(int i=1;i<=29;i++){
                    c.add(Integer.toString(i));
                    }
                 
                }
                else{
                    for(int i=1;i<=28;i++){
                    c.add(Integer.toString(i));
                    }
                }
                
            }
            else{
                for(int i=1;i<=31;i++){
                    c.add(Integer.toString(i));
                    }
            }
        }
    }
    
    public void llenarProductOwner(Choice c)
    {
        c.add("1");
        
        try
        {
            Statement stmt = (Statement) con.createStatement();
            String query, query2;
            String dbPO;
                
            query = "SELECT NOMBRE FROM MIEMBRO EQUIPO;";
            query2= "WHERE ROL_ID_ROL.MIEMBRO EQUIPO = ROL_ID_ROL.PRODUCT OWNER";
            stmt.executeQuery(query+query2);
            ResultSet rs = stmt.getResultSet();
                
            while( rs.next() )
            {
                dbPO = rs.getString("ID_PO");
                c.add(dbPO);
            }
        }
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }
    
    public void llenarTeam(Choice c)
    {
        c.add( "1" );
        try 
        {
            Statement stmt = (Statement) con.createStatement();
            String query;
            String dbTeam;
            query = "SELECT ID_STEAM FROM SCRUM TEAM;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
                
            while( rs.next() )
            {
                dbTeam = rs.getString("ID_STEAM");
                c.add(dbTeam);
            }
        }            
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }
    
     public void llenarPlanning(Choice c)
     {
        try 
        {
            Statement stmt = (Statement) con.createStatement();
            String query;
            String dbTeam;
            query = "SELECT ID_P FROM PLANNING;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
                
            while(rs.next())
            {
                dbTeam = rs.getString("ID_P");
                c.add(dbTeam);
            }
        }
        catch ( Exception e ) 
        {
            System.out.println( e );
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar_button;
    private javax.swing.JButton Crear_button;
    private java.awt.Label anho_label;
    private java.awt.Label anho_label1;
    private java.awt.Choice choiceAnhosF;
    private java.awt.Choice choiceAnhosIn;
    private java.awt.Choice choiceDiasF;
    private java.awt.Choice choiceDiasIn;
    private java.awt.Choice choiceMesesF;
    private java.awt.Choice choiceMesesIn;
    private java.awt.Choice choicePlanning;
    private java.awt.Choice choiceProductOwner;
    private java.awt.Choice choiceTeam;
    private java.awt.Label diaLabel;
    private java.awt.Label diaLabel1;
    private javax.swing.JLabel fechaFinLabel;
    private javax.swing.JLabel fechaIniLabel;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label1;
    private java.awt.Label mesLabel;
    private java.awt.Label mesLabel1;
    public static javax.swing.JDialog nuevoSprintDialog;
    public static java.awt.Label nuevoSprintRes;
    private javax.swing.JLabel productOwnerLabel;
    private javax.swing.JLabel teamLabel;
    // End of variables declaration//GEN-END:variables
}
