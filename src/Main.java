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
        frame = new JFrame("Concessionária v0.01");
        frame.setBounds(100, 100, 800, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        textArea = new JTextArea(10, 30);
        frame.getContentPane().add(textArea);

        JButton btnAddCar = new JButton("Adicionar veículo");
        btnAddCar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String modelo = JOptionPane.showInputDialog(frame, "Digite o modelo do veículo:");
                String fabricante = JOptionPane.showInputDialog(frame, "Digite o fabricante do veículo:");
                String placa = JOptionPane.showInputDialog(frame, "Digite a placa do veículo:");
                String cor = JOptionPane.showInputDialog(frame, "Digite a cor do veículo:");
                boolean ipvaPago = JOptionPane.showConfirmDialog(frame, "O IPVA está pago?", "IPVA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                String condicao = JOptionPane.showInputDialog(frame, "Digite a condição do veículo:");
                String antigoDono = JOptionPane.showInputDialog(frame, "Digite o nome do antigo dono:");

                Veiculo veiculo = new Veiculo(modelo, fabricante, placa, cor, ipvaPago, condicao, antigoDono);
                veiculos.add(veiculo);
                updateTextArea();
            }
        });
        frame.getContentPane().add(btnAddCar);

        JButton btnEditCar = new JButton("Editar veículo");
        btnEditCar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String placa = JOptionPane.showInputDialog(frame, "Digite a placa do veículo que deseja editar:");
                for (Veiculo veiculo : veiculos) {
                    if (veiculo.placa.equals(placa)) {
                        String modelo = JOptionPane.showInputDialog(frame, "Digite o novo modelo do veículo:", veiculo.modelo);
                        String fabricante = JOptionPane.showInputDialog(frame, "Digite o novo fabricante do veículo:", veiculo.fabricante);
                        String cor = JOptionPane.showInputDialog(frame, "Digite a nova cor do veículo:", veiculo.cor);
                        boolean ipvaPago = JOptionPane.showConfirmDialog(frame, "O IPVA está pago?", "IPVA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                        String condicao = JOptionPane.showInputDialog(frame, "Digite a nova condição do veículo:", veiculo.condicao);
                        String antigoDono = JOptionPane.showInputDialog(frame, "Digite o nome do novo antigo dono:", veiculo.antigoDono);

                        veiculo.modelo = modelo;
                        veiculo.fabricante = fabricante;
                        veiculo.cor = cor;
                        veiculo.ipvaPago = ipvaPago;
                        veiculo.condicao = condicao;
                        veiculo.antigoDono = antigoDono;
                        updateTextArea();
                        break;
                    }
                }
            }
        });
        frame.getContentPane().add(btnEditCar);

        JButton btnDeleteCar = new JButton("Excluir veículo");
        btnDeleteCar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String placa = JOptionPane.showInputDialog(frame, "Digite a placa do veículo que deseja excluir:");
                veiculos.removeIf(veiculo -> veiculo.placa.equals(placa));
                updateTextArea();
            }
        });
        frame.getContentPane().add(btnDeleteCar);
    }

    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        for (Veiculo veiculo : veiculos) {
            sb.append(veiculo).append("\n");
        }
        textArea.setText(sb.toString());
    }
}