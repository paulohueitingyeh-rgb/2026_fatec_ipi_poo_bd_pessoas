//data acess object: objeto de acesso a dados
//jdbc: java DataBase Connectivity

import java.sql.Connection;
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

    public static List <Pessoa> Listar() throws Exception{
        //1- Construir uma lista de pessoas 
        List<Pessoa> pessoas = new ArrayList<>();
        //2- Definir o comando SQL
        var sql = "SELECT * FROM tb_pessoa";
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
            while(rs.next()){
                int codigo = rs.getInt("cod_pessoa");
                var nome = rs.getString("nome");
                var fone = rs.getString("fone");
                var email = rs.getString("email");
                var p = Pessoa.builder().codigo(codigo).nome(nome).fone(fone).email(email).build();
                pessoas.add(p);
            }
            return pessoas;
        }


    }

    public void atualizar(Pessoa p) throws Exception{
        //-1 definir o comando 
        var sql = "UPDATE tb_pessoa SET nome=?, fone=?, email=? WHERE cod_pessoa=?";
        //-2 estabelecer uma conexão com o banco 
        Connection conexao = ConnectionFactory.obterConexao();
        //-3 preparar o comando 
        PreparedStatement ps = conexao.prepareStatement(sql);
        //-4 substituir os eventuais placeholders
        ps.setString(1, p.getNome());
        ps.setString(2, p.getFone());
        ps.setString(3, p.getEmail());
        ps.setInt(4, p.getCodigo());
        //-5 executar o comando 
        ps.executeUpdate();
        //-6 fechar os recursos
        ps.close();
        conexao.close();
    }

    public void apagar(Pessoa p) throws Exception{
        var sql = "DELETE FROM tb_pessoa WHERE cod_pessoa=?";
        try(
            var conexao = ConnectionFactory.obterConexao();
            var ps = conexao.prepareStatement(sql);
        ){
            ps.setInt(1, p.getCodigo());
            ps.executeUpdate();
        }
    }
}
