import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:DadosNotas.db");

            // Exemplo 1 Insert
            String sqlInsert1 = "insert into NotasAlunos(Nome_Aluno, Trabalho1, Prova1, Trabalho2, Prova2) values(?, ?, ?, ?, ?)";

            try(
                PreparedStatement pstat = conn.prepareStatement(sqlInsert1)) {

                pstat.setString(1,"Carlos Eduardo Santos");
                pstat.setDouble(2,10.00);
                pstat.setDouble(3,8.00);
                pstat.setDouble(4,9.00);
                pstat.setDouble(5,8.00);

                pstat.execute();

            } catch (SQLException e){
                e.printStackTrace();
            }

            // Exemplo 2 Insert
            String sqlInsert2 = "insert into NotasAlunos(Nome_Aluno) values(?)";

            try(
                PreparedStatement pstat = conn.prepareStatement(sqlInsert2)) {

                pstat.setString(1,"Douglas Teixeira");

                pstat.execute();

            } catch (SQLException e){
                e.printStackTrace();
            }

            // Exemplo 1 Update
            String sqlUpdate1 = "update NotasAlunos set MediaBimestre = ? where Nome_Aluno = ?;)";

            try(
                PreparedStatement pstat = conn.prepareStatement(sqlUpdate1)) {

                pstat.setDouble(1,8.75);
                pstat.setString(2,"Carlos Eduardo Santos");

                pstat.execute();

            } catch (SQLException e){
                e.printStackTrace();
            }

            // Exemplo 2 Update
            String sqlUpdate2 = "update NotasAlunos set Trabalho1 = ?, Prova1 = ?, Trabalho2 = ?, Prova2 = ?, MediaBimestre = ? where Nome_Aluno = ?;)";

            try(
                PreparedStatement pstat = conn.prepareStatement(sqlUpdate2)) {

                pstat.setDouble(1,7.00);
                pstat.setDouble(2,8.00);
                pstat.setDouble(3,8.00);
                pstat.setDouble(4,6.00);
                pstat.setDouble(5,7.25);
                pstat.setString(6,"Douglas Teixeira");

                pstat.execute();

            } catch (SQLException e){
                e.printStackTrace();
            }

            // Exemplo 1 Delete
            String sqlDelete = "delete from NotasAlunos where Nome_Aluno = ?";

            try(
                PreparedStatement pstat = conn.prepareStatement(sqlDelete)) {

                pstat.setString(1,"Douglas Teixeira");

                pstat.execute();

            } catch (SQLException e){
                e.printStackTrace();
            }

            // Exemplo 1 Select
            String sql = "select Nome_Aluno, Trabalho1, Prova1, Trabalho2, Prova2, MediaBimestre from NotasAlunos order by Nome_Aluno";

            try(
                PreparedStatement pstat = conn.prepareStatement(sql)) {

                ResultSet resultSet = pstat.executeQuery();

                while(resultSet.next()){
                    System.out.println("________________");
                    imprimeResultado(resultSet);

                }

            } catch (SQLException e){
                e.printStackTrace();
            }

            // Exemplo 2 Select
            String select2 = "select Nome_Aluno, Trabalho1, Prova1, Trabalho2, Prova2, MediaBimestre from NotasAlunos where Nome_Aluno = ?";

            try(
                PreparedStatement pstat = conn.prepareStatement(select2)) {

                pstat.setString(1,"Carlos Eduardo Santos");

                ResultSet resultSet = pstat.executeQuery();
                if(resultSet.next()){
                    imprimeResultado(resultSet);

                } else {
                    System.out.println("Aluno não encontrado!");
                }

            } catch (SQLException e){
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void imprimeResultado(ResultSet resultSet) throws SQLException {
        String nome = resultSet.getString(1);
        double trabalho1 = resultSet.getDouble(2);
        double prova1 = resultSet.getDouble(3);
        double trabalho2 = resultSet.getDouble(4);
        double prova2 = resultSet.getDouble(5);
        double media = resultSet.getDouble(6);

        System.out.println("Nome do Aluno: " + nome);
        System.out.println("Nota do Aluno Trabalho 1: " + trabalho1);
        System.out.println("Nota do Aluno Prova 1: " + prova1);
        System.out.println("Nota do Aluno Trabalho 2: " + trabalho2);
        System.out.println("Nota do Aluno Prova 2: " + prova2);
        System.out.println("Média Bimestral do Aluno: " + media);
    }
}
