import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
    private static String usuario = "postgres";
    private static String senha = "123456";
    private static String host = "localhost";
    private static String port = "5432";
    private static String db = "20261_fatec_ipi_poo_pessoas";

    public static Connection obterConexao(){

        // o que ele devolve ?enviar comando sql, estaticos.
        // try/catch
        try{
        var s = String.format("jdbc:postgresql://%s:%s/%s", host, port, db); 
        //host port banco os 3 S.
        Connection conexao = DriverManager.getConnection(s, usuario, senha);
        return conexao;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        // String de conexão
       
    } 
    public static void main(String[] args) {
        System.out.println(obterConexao());
    }
}
