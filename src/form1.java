import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import static java.lang.System.exit;

public class form1 extends JFrame {
    // Componentes
    JLabel lblTitulo, lblNome, lblMatricula, lblDadosCurso, lblRestriMedic;
    JTextField txtfNome, txtfMatricula;

    JRadioButton  rdbOp1, rdbOp2, rdbOp3 ,rdbSerie1, rdbSerie2, rdbSerie3;
    ButtonGroup rdbGpOpcoes = new ButtonGroup();
    ButtonGroup rdbGpSeries = new ButtonGroup();

    JList<String> jlPeriodo;
    String periodoArray[] = {"Matutino", "Vaspertino", "Noturno"};

    JTextArea txtaRetricMedic;
    JButton btnApresenDados, btnLimpar, btnSair;


    // Construtor
    public form1() {
        // Configurações da Janela
            super("Formulário escolar");
            Container tela = getContentPane();
            setLayout(null);
            setSize(550,500);
            setResizable(false);

        // Criando os elementos
            // JLabel
            lblNome = new JLabel("Nome: ");
            lblMatricula = new JLabel("Matrícula: ");
            lblDadosCurso = new JLabel("Informe os dados do seu curso: ");
            lblRestriMedic = new JLabel("Restrições Médicas: ");
            lblTitulo = new JLabel("Dados Cadastrais do Aluno ");

            // JTextField
            txtfNome = new JTextField();
            txtfMatricula = new JTextField();

            // RadioButton
            rdbOp1 = new JRadioButton("Etim");
            rdbOp2 = new JRadioButton("Mtec");
            rdbOp3 = new JRadioButton("Técnico");
            rdbSerie1 = new JRadioButton("1° série");
            rdbSerie2 = new JRadioButton("2° série");
            rdbSerie3 = new JRadioButton("3° série");
            rdbGpOpcoes.add(rdbOp1);
            rdbGpOpcoes.add(rdbOp2);
            rdbGpOpcoes.add(rdbOp3);
            rdbGpSeries.add(rdbSerie1);
            rdbGpSeries.add(rdbSerie2);
            rdbGpSeries.add(rdbSerie3);

            //Jlist + adicionando scroll
            jlPeriodo = new JList<>(periodoArray);
            jlPeriodo.setVisibleRowCount(3);
            jlPeriodo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jlPeriodo.setBounds(230, 170, 100, 40);


            JScrollPane painelRolagemPeriodo = new JScrollPane(jlPeriodo);
            painelRolagemPeriodo.setBounds(230, 170, 100, 40);

            //TextArea + adicionando scroll
            txtaRetricMedic = new JTextArea();
            JScrollPane painelRolagemRetricMedic = new JScrollPane(txtaRetricMedic);
            painelRolagemRetricMedic.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            painelRolagemRetricMedic.setBounds(200,260,250,120);

            // Button
            btnApresenDados = new JButton("Apresentar Dados");
            btnLimpar = new JButton("Limpar");
            btnSair = new JButton("Sair");


        // Posicionando os elementos
            lblTitulo.setBounds(115,15,300,30);
            lblNome.setBounds(20,60,100,30);
            txtfNome.setBounds(80,66,200,20);
            lblMatricula.setBounds(20,90,100,30);
            txtfMatricula.setBounds(80,96,100,20);
            lblDadosCurso.setBounds(20, 140,200,20);
            rdbOp1.setBounds(20,170,100,20);
            rdbOp2.setBounds(20,190,100,20);
            rdbOp3.setBounds(20,210,100,20);
            rdbSerie1.setBounds(120,170,100,20);
            rdbSerie2.setBounds(120,190,100,20);
            rdbSerie3.setBounds(120,210,100,20);
            lblRestriMedic.setBounds(20, 255, 140,20);
            btnApresenDados.setBounds(20,410,150,25);
            btnLimpar.setBounds(190,410,130,25);
            btnSair.setBounds(340,410,130,25);

        // Personalização + métodos
            // Persoalização do título
            Font font = new Font("Arial", Font.BOLD, 20);
            lblTitulo.setFont(font);

            // Limpar os campos
            btnLimpar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    txtfNome.setText("");
                    txtfMatricula.setText("");
                    rdbGpOpcoes.clearSelection();
                    rdbGpSeries.clearSelection();
                    txtaRetricMedic.setText("");
                    jlPeriodo.setSelectedIndex(0);
                }
            });

            // Sair
            btnSair.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    exit(0);
                }
            });

            // Checar dados
            btnApresenDados.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Criando variáveis
                    String nome = txtfNome.getText();
                    int matricula = Integer.parseInt(txtfMatricula.getText());
                    String periodo = jlPeriodo.getSelectedValue();
                    String restricMedic = txtaRetricMedic.getText();

                    String curso = "";
                    if(rdbOp1.isSelected()) {
                        curso = rdbOp1.getText();
                    }
                    else if(rdbOp2.isSelected()) {
                        curso = rdbOp2.getText();
                    }
                    else if(rdbOp3.isSelected()) {
                        curso = rdbOp3.getText();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Selecione pelo menos uma opção de curso!");
                    }

                    String serie = "";
                    if(rdbSerie1.isSelected()) {
                        serie = rdbSerie1.getText();
                    }
                    else if(rdbSerie2.isSelected()) {
                        serie = rdbSerie2.getText();
                    }
                    else if(rdbSerie3.isSelected()) {
                        serie = rdbSerie3.getText();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Selecione pelo menos uma opção de série!");
                    }

                    form2 formulario2 = new form2(nome, matricula, curso, serie, periodo, restricMedic);
                    formulario2.setVisible(true);
                    dispose();
                }
            });

        // Adicionar na tela
            tela.add(lblNome);
            tela.add(lblDadosCurso);
            tela.add(lblMatricula);
            tela.add(lblRestriMedic);
            tela.add(txtfMatricula);
            tela.add(txtfNome);
            tela.add(rdbOp1);
            tela.add(rdbOp2);
            tela.add(rdbOp3);
            tela.add(rdbSerie1);
            tela.add(rdbSerie2);
            tela.add(rdbSerie3);
            tela.add(lblTitulo);
            tela.add(painelRolagemPeriodo);
            tela.add(painelRolagemRetricMedic);
            tela.add(btnApresenDados);
            tela.add(btnLimpar);
            tela.add(btnSair);

            setVisible(true);
    }

    public static void main(String[] args) {
        form1 app = new form1();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
