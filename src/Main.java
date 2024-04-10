import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private ArrayList<Veiculo> veiculos = new ArrayList<>();
    private JFrame frame;
    private JTextArea textArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main() {
        initialize();
    }

    private void initialize() {
        // Criação do JFrame
        frame = new JFrame("Concessionária v0.01");
        // Definição do tamanho e posição da janela
        frame.setBounds(100, 100, 800, 600);
        // Definição do comportamento da janela ao fechar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Definição do layout da janela
        frame.getContentPane().setLayout(new BorderLayout());
    
        // Criação da área de texto onde serão exibidos os veículos
        textArea = new JTextArea(10, 30);
        // Adição de uma barra de rolagem à área de texto
        JScrollPane scrollPane = new JScrollPane(textArea);
        // Adição da área de texto ao conteúdo da janela
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    
        // Criação de um painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    
        // Criação do botão para adicionar veículos
        JButton btnAddCar = new JButton("Adicionar veículo");
        btnAddCar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Quando o botão é clicado, solicita as informações do veículo ao usuário
                String modelo = JOptionPane.showInputDialog(frame, "Digite o modelo do veículo:");
                String fabricante = JOptionPane.showInputDialog(frame, "Digite o fabricante do veículo:");
                String placa = JOptionPane.showInputDialog(frame, "Digite a placa do veículo:");
                String cor = JOptionPane.showInputDialog(frame, "Digite a cor do veículo:");
                boolean ipvaPago = JOptionPane.showConfirmDialog(frame, "O IPVA está pago?", "IPVA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                String condicao = JOptionPane.showInputDialog(frame, "Digite a condição do veículo:");
                String antigoDono = JOptionPane.showInputDialog(frame, "Digite o nome do antigo dono:");
    
                // Cria um novo veículo com as informações fornecidas e o adiciona à lista
                Veiculo veiculo = new Veiculo(modelo, fabricante, placa, cor, ipvaPago, condicao, antigoDono);
                veiculos.add(veiculo);
                // Atualiza o JTextArea para mostrar a lista atualizada de veículos
                updateTextArea();
            }
        });
        // Adiciona o botão ao JFrame
        buttonPanel.add(btnAddCar);
    
        // Criação do botão para editar veículos
        JButton btnEditCar = new JButton("Editar veículo");
        btnEditCar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Quando o botão é clicado, solicita a placa do veículo a ser editado
                String placa = JOptionPane.showInputDialog(frame, "Digite a placa do veículo que deseja editar:");
                // Procura o veículo na lista de veículos
                for (Veiculo veiculo : veiculos) {
                    // Se a placa do veículo corresponder à placa fornecida
                    if (veiculo.placa.equals(placa)) {
                        // Solicita as novas informações do veículo ao usuário
                        String modelo = JOptionPane.showInputDialog(frame, "Digite o novo modelo do veículo:", veiculo.modelo);
                        String fabricante = JOptionPane.showInputDialog(frame, "Digite o novo fabricante do veículo:", veiculo.fabricante);
                        String cor = JOptionPane.showInputDialog(frame, "Digite a nova cor do veículo:", veiculo.cor);
                        boolean ipvaPago = JOptionPane.showConfirmDialog(frame, "O IPVA está pago?", "IPVA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                        String condicao = JOptionPane.showInputDialog(frame, "Digite a nova condição do veículo:", veiculo.condicao);
                        String antigoDono = JOptionPane.showInputDialog(frame, "Digite o nome do novo antigo dono:", veiculo.antigoDono);
    
                        // Atualiza as informações do veículo
                        veiculo.modelo = modelo;
                        veiculo.fabricante = fabricante;
                        veiculo.cor = cor;
                        veiculo.ipvaPago = ipvaPago;
                        veiculo.condicao = condicao;
                        veiculo.antigoDono = antigoDono;
                        // Atualiza o JTextArea para mostrar a lista atualizada de veículos
                        updateTextArea();
                        // Interrompe a busca pelo veículo
                        break;
                    }
                }
            }
        });
        // Adiciona o botão ao JFrame
        buttonPanel.add(btnEditCar);
    
        // Criação do botão para excluir veículos
        JButton btnDeleteCar = new JButton("Excluir veículo");
        btnDeleteCar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Quando o botão é clicado, solicita a placa do veículo a ser excluído
                String placa = JOptionPane.showInputDialog(frame, "Digite a placa do veículo que deseja excluir:");
                // Remove o veículo da lista
                veiculos.removeIf(veiculo -> veiculo.placa.equals(placa));
                // Atualiza o JTextArea para mostrar a lista atualizada de veículos
                updateTextArea();
            }
        });
        // Adiciona o botão ao JFrame
        buttonPanel.add(btnDeleteCar);
    
        // Adição do painel de botões ao conteúdo da janela
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    
        // Definição da cor de fundo da janela
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
    
        // Definição do ícone da janela (substitua "icon.png" pelo caminho para o seu arquivo de ícone)
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
    }
    
    // Método para atualizar o JTextArea com a lista de veículos
    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        for (Veiculo veiculo : veiculos) {
            sb.append(veiculo).append("\n");
        }
        textArea.setText(sb.toString());
    }
}