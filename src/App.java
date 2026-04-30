//ORM: Object Relational Mapping. Mapeamento Objeto 
import javax.swing.JOptionPane;
public class App {
    public static void main(String[] args) {
        var menu = "1-Cadastrar\n2-Visualizar\n3-Atualizar\n4-Remover\n0-Sair";
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            try{
                switch (opcao) {
                    case 1:{
                    
                        var nome = JOptionPane.showInputDialog("Nome?");
                        var fone = JOptionPane.showInputDialog("Fone?");
                        var email = JOptionPane.showInputDialog("Email?");
                        var pessoa = 
                            Pessoa.builder()
                            .nome(nome)
                            .fone(fone)
                            .email(email)
                            .build();
                        var dao = new PessoaDAO();
                        dao.cadastrar(pessoa);
                        JOptionPane.showMessageDialog(null,"Cadastro OK");
                        break;
                    }
                    case 2:{
                        
                        break;
                    }
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Tente ");
            }

        } while (opcao != 0);
    }
}
