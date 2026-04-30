//data acess object: objeto de acesso a dados
//jdbc: java DataBase Connectivity
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
        // exercício de IA 
        //faça com JDBC
public class PessoaDAO {

    public void cadastrar(Pessoa p) throws Exception{
        // ? = placeholders
        //1- Definir o SQL
        var sql = "INSERT INTO tb_pessoa (nome, fone, email) VALUES (?, ?, ?)";
        //2- Estabelecer uma conexão com o SGBD
        var conexao = ConnectionFactory.obterConexao();
        //3- Preparar o comando 
        PreparedStatement ps = conexao.prepareStatement(sql);
        //4- Substituir os eventuais placeholders
        ps.setString(1, p.getNome());
        ps.setString(2, p.getFone());
        ps.setString(3, p.getEmail());
        //5- Executar o comando 
        ps.execute();
        ps.close();
        conexao.close();
    }

    public List <Pessoa> Listar() throws Exception{
        //1- Construir uma lista de pessoas 
        List<Pessoa> pessoas = new ArrayList<>();
        //2- Definir o comando SQL
        var sql = "SELECT * FROM tb_pessoas";
        //3- Estabelecer uma conexão com o banco
        //4- Preparar comando
        //try-with-resorces


        //5- Substituir os eventuais placeholders

        //6- Executar o comando 
        try(// faz o close outomaticamante
            var conexao = ConnectionFactory.obterConexao();
            var ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
        //7- Tratar o resultado
        rs.next();
        int codigo = rs.getInt("cod_pessoa");
        var nome = rs.getString(" nome");
        var fone = rs.getString("fone");
        var email = rs.getString("email");
        var pessoa = 
            Pessoa.builder()
            .codigo(codigo)
            .nome(nome)
            .fone(fone)
            .email(email)
            .build();
        pessoas.add(pessoa);
        }


    }
}
