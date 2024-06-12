import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

public class form1 extends JFrame {
    // Componentes
    JLabel lblTitulo, lblNome, lblMatricula, lblDadosCurso, lblRestriMedic;
    JTextField txtfNome, txtfMatricula;

    JRadioButton  rdbOp1, rdbOp2, rdbOp3 ,rdbSerie1, rdbSerie2, rdbSerie3;
    ButtonGroup rdbGp = new ButtonGroup();

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
            setSize(500,500);
            setResizable(false);

        // Criando os elementos
            // JLabel
            lblNome = new JLabel("Nome: ");
            lblMatricula = new JLabel("Matrícula");
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
            rdbGp.add(rdbOp1);
            rdbGp.add(rdbOp2);
            rdbGp.add(rdbOp3);
            rdbGp.add(rdbSerie1);
            rdbGp.add(rdbSerie2);
            rdbGp.add(rdbSerie3);

            //Jlist + adicionando scroll
            jlPeriodo = new JList<>(periodoArray);
            JScrollPane painelRolagemPeriodo = new JScrollPane(jlPeriodo);
            painelRolagemPeriodo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            painelRolagemPeriodo.setBounds(20, 220, 250, 100); // TEMP -> Ajustar ao tamanho do Jlist normal

            //TextArea + adicionando scroll
            txtaRetricMedic = new JTextArea(10,20);
            JScrollPane painelRolagemRetricMedic = new JScrollPane(txtaRetricMedic);
            painelRolagemRetricMedic.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            painelRolagemRetricMedic.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            // Button
            btnApresenDados = new JButton("Apresentar Dados");
            btnLimpar = new JButton("Limpar");
            btnSair = new JButton("Sair");


        // Posicionando os elementos
            lblTitulo.setBounds(150,15,200,30);


        // Adicionar na tela
            tela.add(lblNome);
            tela.add(lblDadosCurso);
            tela.add(lblMatricula);
            tela.add(lblRestriMedic);
            tela.add(txtaRetricMedic);
            tela.add(txtfMatricula);
            tela.add(txtfNome);
            tela.add(rdbOp1);
            tela.add(rdbOp2);
            tela.add(rdbOp3);
            tela.add(rdbSerie1);
            tela.add(rdbSerie2);
            tela.add(rdbSerie3);
            tela.add(jlPeriodo);
            tela.add(lblTitulo);
            tela.add(painelRolagemPeriodo);
            tela.add(painelRolagemRetricMedic);

            setVisible(true);
    }

    public static void main(String[] args) {
        form1 app = new form1();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
